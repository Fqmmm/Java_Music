package util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.sound.midi.MidiChannel;

import constant.GMInstruments;
import model.Chord;
import model.MusicDraft;
import model.Note;

public class Guitar extends MusicalInstrument {

    private GuitarString[] guitarStrings;

    public Guitar(int id) throws Exception {
        if (id < GMInstruments.GUITAR_ACOUSTIC_NYLON || id > GMInstruments.GUITAR_HARMONICS) {
            throw new Exception("id不在吉他的范围内");
        }

        super(id);
        this.initGuitarStrings();
    }

    private void initGuitarStrings() {
        this.guitarStrings = new GuitarString[6];
        this.guitarStrings[0] = new GuitarString(MusicDraft.high[3]);
        this.guitarStrings[1] = new GuitarString(MusicDraft.medium[7]);
        this.guitarStrings[2] = new GuitarString(MusicDraft.medium[5]);
        this.guitarStrings[3] = new GuitarString(MusicDraft.medium[2]);
        this.guitarStrings[4] = new GuitarString(MusicDraft.low[6]);
        this.guitarStrings[5] = new GuitarString(MusicDraft.low[3]);
    }

    /**
     * 松开所有弦
     */
    public void reset() throws Exception {
        for (GuitarString guitarString : guitarStrings) {
            guitarString.setFret(0);
        }
    }

    /**
     * 弹一根弦
     * 
     * @param stringID 第几根弦，从1开始计数
     * @param duration 弹多长时间（毫秒）
     * @param velocity 用多大的力弹
     */
    public void playSingleString(int stringID, int duration, int velocity) throws Exception {
        if (stringID < 1 || stringID > 6) {
            throw new Exception("没有这根弦");
        }

        int scale = guitarStrings[stringID - 1].getScale();
        int channelIndex = instrumentID % 16;
        MidiChannel channel = channels[channelIndex];
        channel.programChange(instrumentID);
        channel.noteOn(scale, velocity);

        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        channel.noteOff(scale);
    }

    @Override
    public void playChord(Chord chord) throws Exception {
        // 1. 重置所有琴弦状态，准备按新和弦
        reset();

        // 2. 根据和弦，计算并设置每根弦应该按的品格
        int rootStringIndex = pressChordFingering(chord);

        // 3. 执行扫弦
        strum(rootStringIndex, chord.getDuration(), 100);
    }

    /**
     * 核心算法(新版)：为和弦计算指法，优先为每个音符寻找品格最低的琴弦。
     * @param chord 要按的和弦
     * @return 根音所在的琴弦索引 (0-5)
     */
    private int pressChordFingering(Chord chord) throws Exception {
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
            for(int i = 5; i >= 0; i--) {
                if(isStringOccupied[i]) return i;
            }

        }

        return rootStringIndex;
    }

    /**
     * 执行扫弦动作
     * @param startStringIndex 从哪根弦开始扫 (0-5, 0是1弦, 5是6弦)
     * @param totalDuration    整个和弦的持续时间
     * @param velocity         力度
     */
    private void strum(int startStringIndex, int totalDuration, int velocity) throws InterruptedException {
        // 计算每根弦之间扫弦的微小延迟，模拟真实感
        // 假设扫弦动作占用总时长的 1/8，可以调整这个比例
        int strumDelay = Math.max(1, (int)(totalDuration * 0.125 / 6));

        MidiChannel channel = channels[instrumentID % 16];
        channel.programChange(instrumentID);

        // --- 步骤1: 快速依次开启琴弦发声 (noteOn) ---
        // 从低音弦扫到高音弦
        for (int i = startStringIndex; i >= 0; i--) {
            int scale = guitarStrings[i].getScale();
            if (scale > 0) { // 确保有音高
                channel.noteOn(scale, velocity);
                Thread.sleep(strumDelay); // 模拟扫弦的延迟
            }
        }
        
        // --- 步骤2: 等待和弦的主要持续时间 ---
        int remainingDuration = Math.max(0, totalDuration - (startStringIndex + 1) * strumDelay);
        Thread.sleep(remainingDuration);

        // --- 步骤3: 同时关闭所有发声的琴弦 (noteOff) ---
        for (int i = 0; i < guitarStrings.length; i++) {
            int scale = guitarStrings[i].getScale();
            // 只关闭那些被按响了的弦
            if (guitarStrings[i].fret > 0 || i <= startStringIndex) {
                 channel.noteOff(scale);
            }
        }
    }

    /**
     * 一根吉他弦。
     */
    private class GuitarString {
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
            if (fret > MAXFRET || fret < 0) {
                throw new Exception("品格数有误");
            }
            this.fret = fret;
        }
    }
}
