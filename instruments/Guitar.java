package instruments;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.sound.midi.MidiChannel;

import constant.GMInstruments;
import constant.GuitarTuning;
import model.*;

public class Guitar extends MusicalInstrument {

    private GuitarString[] guitarStrings;
    private int[] tuning; // 调弦方式

    // --- 【新】定义一个枚举来表示扫弦方向 ---
    private enum StrumDirection {
        DOWN, // 向下扫 (从低音到高音)
        UP    // 向上扫 (从高音到低音)
    }

    public Guitar() throws Exception {
        this(GMInstruments.GUITAR_ACOUSTIC_NYLON, GuitarTuning.STANDARD_TUNING);
    }

    public Guitar(int id) throws Exception {
        this(id, GuitarTuning.STANDARD_TUNING);
    }

    public Guitar(int id, int[] tuning) throws Exception {
        if (id < GMInstruments.GUITAR_ACOUSTIC_NYLON || id > GMInstruments.GUITAR_HARMONICS) {
            throw new Exception("id不在吉他的范围内");
        }

        super(id);
        this.tuning = tuning;
        this.initGuitarStrings();
    }

    private void initGuitarStrings() {
        this.guitarStrings = new GuitarString[6];
        // 修正：确保琴弦和调音正确对应
        // guitarStrings[0] -> 1弦, tuning[5] -> 1弦音高
        // guitarStrings[5] -> 6弦, tuning[0] -> 6弦音高
        for (int i = 0; i < 6; i++) {
            this.guitarStrings[i] = new GuitarString(this.tuning[5 - i]);
        }
    }

    public GuitarString[] getGuitarStrings() {
        return guitarStrings;
    }

     /**
     * 【修正】松开所有弦，将它们的状态设为“不发声”。
     */
    public void reset() throws Exception {
        for (GuitarString guitarString : guitarStrings) {
            guitarString.setFret(-1); // 统一使用 -1 作为“不按/静音”的状态
        }
    }

    /**
     * 【修正】和弦转换：只按弦，不发声。
     */
    public void switchChordTo(Chord chord) throws Exception {
        reset(); // 切换前先将所有弦设为不发声
        if (chord instanceof GuitarChord) {
            pressFingering(((GuitarChord) chord).getFingering());
        } else {
            calculateFingering(chord);
        }
    }

    /**
     * 【修正】弹拨单根琴弦。
     */
    public void playSingleString(int stringIndex, int duration, int velocity) throws InterruptedException {
        if (stringIndex < 1 || stringIndex > 6) {
            System.err.println("错误: 琴弦号必须在 1-6 之间。");
            return;
        }
        GuitarString stringToPlay = guitarStrings[stringIndex - 1];

        // ▼▼▼ 关键修正：使用 shouldPlay() 来判断 ▼▼▼
        if (stringToPlay.isMute()) {
            Thread.sleep(duration);
            return;
        }

        int scale = stringToPlay.getScale();
        MidiChannel channel = channels[instrumentID % 16];
        channel.programChange(instrumentID);
        channel.controlChange(7, 127);
        
        channel.noteOn(scale, velocity);
        Thread.sleep(duration);
        channel.noteOff(scale);
    }

    /**
     * 【首选/高效方法】播放一个 GuitarChord。
     * 这个方法是专门为 GuitarChord 设计的，它直接使用对象自带的、
     * 从数据库加载的精确指法字符串，效率和准确性都最高。
     *
     * @param guitarChord 要播放的、包含精确指法的吉他和弦
     */
    public void playChord(GuitarChord guitarChord) {
        // 1. 安全性检查：确保传入的对象和其指法有效
        if (guitarChord == null || guitarChord.getFingering() == null || guitarChord.getFingering().isEmpty()) {
            System.err.println("警告: 尝试播放一个空的或没有指法的 GuitarChord。");
            return;
        }

        try {
            // 2. 重置吉他指板，清除上一个和弦的按法
            reset();

            // 3. 调用辅助方法，根据指法字符串 ("x32010") 来设置琴弦的品格
            // 这个方法会返回最低音弦的索引，作为扫弦的起点
            int startingStringIndex = pressFingering(guitarChord.getFingering());

            // 4. 执行扫弦动作
            // 使用和弦自带的持续时间，并设定一个适中的力度（如110）
            strum(startingStringIndex, 1, guitarChord.getDuration(), 110);

        } catch (Exception e) {
            System.err.println("播放 GuitarChord 时出错: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 辅助方法：根据指法字符串（如 "x32010"）来设置琴弦的品格。
     *
     * @param frets 指法字符串，顺序为 6弦 -> 1弦
     * @return 扫弦应该开始的琴弦索引 (0-5, 0是1弦, 5是6弦)。如果无可弹奏的弦，则返回 -1。
     */
    private int pressFingering(String frets) throws Exception {
        int lowestStringIndex = -1; // 用于记录最低音弦的索引

        // frets 字符串的长度通常是6，对应从6弦到1弦
        for (int i = 0; i < frets.length() && i < 6; i++) {
            char fretChar = frets.charAt(i);
            int fretValue = -1; // -1 是我们内部用来表示“不按”或“静音”的值

            if (fretChar != 'x' && fretChar != 'X') {
                // 将字符 '0'-'9', 'a'-'f' 转换为对应的品格数
                fretValue = Integer.parseInt(String.valueOf(fretChar), 16);
            }

            // guitarStrings 数组的索引是 0-5, 对应 1-6 弦
            // frets 字符串的索引 i 是 0-5, 对应 6-1 弦
            // 所以，frets 的第 i 个字符对应 guitarStrings[5 - i]
            guitarStrings[5 - i].setFret(fretValue);

            // 如果这根弦需要按 (fretValue != -1)，并且我们还没记录过最低音弦
            if (fretValue != -1 && lowestStringIndex == -1) {
                // 那么这就是扫弦的起点
                lowestStringIndex = 5 - i;
            }
        }
        return lowestStringIndex;
    }

    /**
     * 如果传入的不是GuitarChord，则自动计算应该按哪些弦
     * 
     * @param chord 要按的和弦
     */
    @Override
    public void playChord(Chord chord) throws Exception {
        // 1. 重置所有琴弦状态，准备按新和弦
        reset();

        // 2. 根据和弦，计算并设置每根弦应该按的品格
        int rootStringIndex = calculateFingering(chord);

        // 3. 执行扫弦
        strum(rootStringIndex, 1, chord.getDuration(), 100);
    }

    /**
     * 核心算法(新版)：为和弦计算指法，优先为每个音符寻找品格最低的琴弦。
     * 
     * @param chord 要按的和弦
     * @return 根音所在的琴弦索引 (0-5)
     */
    private int calculateFingering(Chord chord) throws Exception {
        List<Note> targetNotes = new ArrayList<>(chord.getNotes());
        // 将目标音符按音高升序排序，优先处理低音
        targetNotes.sort(Comparator.comparingInt(Note::scale));

        Note rootNote = targetNotes.get(0);
        int rootStringIndex = -1; // 初始为-1，表示还未找到

        boolean[] isStringOccupied = new boolean[6]; // 记录琴弦是否已被占用

        // 为每一个目标音符寻找最佳的琴弦和品格
        for (Note targetNote : targetNotes) {
            int bestStringIndex = -1;
            int lowestFret = Integer.MAX_VALUE;

            // 遍历所有琴弦，为当前音符寻找最佳位置
            for (int i = 0; i < 6; i++) {
                if (isStringOccupied[i]) {
                    continue; // 如果琴弦已被占用，则跳过
                }

                GuitarString currentString = guitarStrings[i];
                // 检查是否能在这根弦上弹出目标音符
                if (targetNote.scale() >= currentString.base) {
                    int fret = targetNote.scale() - currentString.base;
                    // 检查品格是否在有效范围内，并且是否是迄今为止找到的最低品格
                    if (fret <= GuitarString.MAXFRET && fret < lowestFret) {
                        lowestFret = fret;
                        bestStringIndex = i;
                    }
                }
            }

            // 如果为这个音符找到了一个有效的位置
            if (bestStringIndex != -1) {
                guitarStrings[bestStringIndex].setFret(lowestFret);
                isStringOccupied[bestStringIndex] = true; // 标记这根弦被占用了

                // 如果这个音是根音，记录下它所在的弦
                if (targetNote.scale() == rootNote.scale()) {
                    rootStringIndex = bestStringIndex;
                }
            }
            // 如果没找到，说明这个音符在这个指法中被忽略了（这在真实演奏中很常见）
        }

        // 如果根音因为某种原因没被分配（比如太高了），我们默认从6弦或5弦开始扫
        if (rootStringIndex == -1) {
            for (int i = 5; i >= 0; i--) {
                if (isStringOccupied[i])
                    return i;
            }

        }

        return rootStringIndex;
    }

    public void showDebugInfo() {
        for (int i = 0; i < guitarStrings.length; i++) {
            System.out.println(i + 1 + "弦");
            System.out.println(guitarStrings[i].fret + "品\n");
        }
    }

    /**
     * 【增强版】正向扫弦 (下拨)，从低音弦扫向高音弦。
     * @param startString 起始弦 (1-6)
     * @param endString   结束弦 (1-6)
     * @param duration    总持续时间 (毫秒)
     * @param velocity    力度
     */
    public void strum(int startString, int endString, int duration, int velocity) throws InterruptedException {
        _strum(startString, endString, duration, velocity, StrumDirection.DOWN);
    }
    
    /**
     * 【新功能】反向扫弦 (上拨)，从高音弦扫向低音弦。
     */
    public void strumBackward(int startString, int endString, int duration, int velocity) throws InterruptedException {
        _strum(startString, endString, duration, velocity, StrumDirection.UP);
    }

    // --- 【新】私有的、核心的扫弦方法 ---

    /**
     * 私有的核心扫弦实现，处理所有扫弦逻辑。
     */
    private void _strum(int string1, int string2, int totalDuration, int velocity, StrumDirection direction) throws InterruptedException {
        // 1. 参数预处理和校验
        // 将琴弦号(1-6)转换为数组索引(0-5)
        int idx1 = string1 - 1;
        int idx2 = string2 - 1;
        if (idx1 < 0 || idx1 > 5 || idx2 < 0 || idx2 > 5) {
            System.err.println("错误: 琴弦号必须在 1-6 之间。");
            return;
        }

        int startIdx = Math.min(idx1, idx2);
        int endIdx = Math.max(idx1, idx2);
        
        int numStringsToPlay = 0;
        for (int i = startIdx; i <= endIdx; i++) {
            if (guitarStrings[i].isPressed()) {
                numStringsToPlay++;
            }
        }
        if (numStringsToPlay == 0) return; // 没有按弦，直接返回

        // 2. 准备 MIDI 通道和计算延迟
        int strumDelay = Math.max(1, (int)(totalDuration * 0.125 / numStringsToPlay));
        MidiChannel channel = channels[instrumentID % 16];
        channel.programChange(instrumentID);
        channel.controlChange(7, 127);

        // 3. 根据方向，决定循环的起始、结束和步长
        int loopStart, loopEnd, step;
        if (direction == StrumDirection.DOWN) {
            // 下拨：从大索引(低音)到小索引(高音)
            loopStart = endIdx;
            loopEnd = startIdx;
            step = -1;
        } else { // StrumDirection.UP
            // 上拨：从小索引(高音)到大索引(低音)
            loopStart = startIdx;
            loopEnd = endIdx;
            step = 1;
        }

        // 4. 执行 noteOn 循环 (核心逻辑)
        for (int i = loopStart; (step > 0) ? i <= loopEnd : i >= loopEnd; i += step) {
            if (!guitarStrings[i].isMute()) {
                channel.noteOn(guitarStrings[i].getScale(), velocity);
                Thread.sleep(strumDelay);
            }
        }

        // 5. 等待剩余时间
        int remainingDuration = Math.max(0, totalDuration - numStringsToPlay * strumDelay);
        Thread.sleep(remainingDuration);

        // 6. 执行 noteOff (关闭所有在范围内的、被按下的弦)
        for (int i = startIdx; i <= endIdx; i++) {
            if (!guitarStrings[i].isMute()) {
                channel.noteOff(guitarStrings[i].getScale());
            }
        }
    }

    /**
     * 一根吉他弦。
     */
    public class GuitarString {
        private final int base; // 基准音
        private int fret; // 当前按在哪个品格上, 0代表空按
        private static final int MAXFRET = 21; // 最大品格数

        public GuitarString(int base) {
            this.base = base;
            this.fret = 0;
        }

        public int getScale() {
            return base + fret;
        }

        /**
         * 切换格子
         * 
         * @param fret 切换到第几格
         */
        public void setFret(int fret) throws Exception {
            if (fret > MAXFRET || fret < -1) {
                throw new Exception("品格数有误");
            }
            this.fret = fret;
        }

        /**
         * 这根弦是否被按住了
         */
        public boolean isPressed() {
            return this.fret != 0;
        }

        /**
         * 【新增/核心】判断这根弦是否应该发声。
         * 只要品格不是 -1 (静音)，它就应该发声。
         */
        public boolean isMute() {
            return this.fret == -1;
        }
    }
}
