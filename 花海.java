
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 花海 implements MusicDraft {

    // 你编写的所有 Note[] 数组都保留在这里，无需任何改动
    // ... (前奏, 静止了所有的花开, 等等... 代码过长，此处省略)
    public static final Note[] 前奏 = {
        Note.emptyNote(1),

        Note.halfNote(medium[1]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[3]),
        Note.quarterNote(medium[5]),
        new Note(medium[5], 1.25),
        Note.emptyNote(1),

        Note.halfNote(medium[3]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[1]),
        Note.quarterNote(medium[2]),
        new Note(medium[3], 1.25),
        Note.emptyNote(1),

        Note.halfNote(medium[1]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[3]),
        Note.quarterNote(high[1]),
        Note.halfNote(high[1]),

        Note.quarterNote(medium[7]),
        Note.fullNote(high[1]),
        Note.halfNote(high[1]),
        Note.halfNote(medium[7]),
        Note.quarterNote(high[1]),
        Note.dottedNote0_75(medium[7]),
        Note.quarterNote(medium[5]),
        Note.dottedNote0_75(medium[6]),
        Note.dottedNote1_5(medium[5]),

        Note.halfNote(medium[1]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[3]),
        Note.quarterNote(medium[5]),
        new Note(medium[5], 1.25),
        Note.emptyNote(1),

        Note.halfNote(medium[3]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[1]),
        Note.quarterNote(medium[2]),
        new Note(medium[1], 1.25),
        Note.emptyNote(1),

        Note.halfNote(medium[1]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[3]),
        Note.quarterNote(medium[5]),
        new Note(medium[1], 1.75),
        Note.halfNote(medium[1]),
        Note.halfNote(medium[1]),
        Note.halfNote(low[7]),
        Note.halfNote(low[6]),
        Note.halfNote(low[7]),
        Note.fullNote(medium[1]),
        Note.emptyNote(2),
    };

    public static final Note[] 静止了所有的花开 = {
        Note.quarterNote(medium[1]),
        Note.dottedNote0_75(medium[3]),
        Note.fullNote(medium[3]),
        Note.emptyNote(1),

        Note.halfNote(medium[3]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[1]),
        Note.fullNote(medium[2]),
        Note.dottedNote1_5(medium[3]),
        Note.emptyNote(1),
    };

    public static final Note[] 遥远了清晰了爱 = {
        Note.quarterNote(medium[1]),
        Note.dottedNote0_75(medium[3]),
        Note.fullNote(medium[3]),
        Note.emptyNote(1),
        Note.halfNote(medium[4]),
        Note.halfNote(medium[3]),
        Note.fullNote(medium[5]),
        Note.fullNote(medium[1]),
        Note.emptyNote(2),
    };

    public static final Note[] 天郁闷爱却很喜欢 = {
        Note.quarterNote(medium[1]),
        Note.dottedNote0_75(medium[4]),
        Note.fullNote(medium[4]),
        Note.emptyNote(1),

        Note.halfNote(medium[4]),
        Note.halfNote(medium[3]),
        Note.halfNote(medium[1]),
        Note.fullNote(low[5]),
        Note.dottedNote1_5(medium[3]),
        Note.emptyNote(1),
    };

    public static final Note[] 那时候我不懂这叫爱 = {
        Note.quarterNote(medium[1]),
        Note.dottedNote0_75(medium[3]),
        Note.fullNote(medium[2]),

        Note.quarterNote(medium[1]),
        Note.dottedNote0_75(medium[3]),
        Note.fullNote(medium[2]),

        Note.quarterNote(medium[1]),
        Note.dottedNote0_75(medium[3]),
        Note.fullNote(medium[2]),

        Note.emptyNote(2),
    };

    public static final Note[] 你喜欢站在那窗台 = {
        Note.quarterNote(medium[1]),
        Note.dottedNote0_75(medium[3]),
        Note.fullNote(medium[3]),
        Note.emptyNote(1),

        Note.halfNote(medium[3]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[1]),
        Note.fullNote(medium[2]),
        Note.dottedNote1_5(medium[5]),
        Note.emptyNote(1),
    };

    public static final Note[] 你好久都没再来 = {
        Note.quarterNote(medium[1]),
        Note.dottedNote0_75(medium[3]),
        Note.fullNote(medium[3]),
        Note.emptyNote(1),
        
        Note.halfNote(medium[4]),
        Note.halfNote(medium[3]),
        Note.halfNote(medium[5]),
        Note.halfNote(medium[1]),
        Note.emptyNote(2),
    };

    public static final Note[] 彩色的时间染上空白 = {
        Note.quarterNote(medium[1]),
        Note.dottedNote0_75(medium[4]),
        Note.fullNote(medium[4]),
        Note.emptyNote(1),

        Note.halfNote(medium[4]),
        Note.halfNote(medium[3]),
        Note.halfNote(medium[1]),
        Note.fullNote(medium[5]),
        Note.fullNote(medium[3]),
        Note.dottedNote1_5(high[1]),
        Note.emptyNote(1),
    };

    public static final Note[] 是你流的泪晕开 = {
        Note.halfNote(medium[5]),
        Note.halfNote(medium[4]),
        Note.halfNote(medium[4]),
        Note.halfNote(medium[1]),
        Note.halfNote(medium[1]),
        Note.halfNote(low[7]),
        Note.halfNote(low[7]),
        Note.dottedNote1_5(medium[1]),
        Note.emptyNote(1),
    };

    public static final Note[] 不要你离开 = {
        Note.halfNote(medium[1]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[3]),
        Note.quarterNote(medium[5]),
        new Note(medium[5], 1.25),
        Note.emptyNote(1),
    };

    public static final Note[] 距离隔不开 = {
        Note.halfNote(medium[3]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[1]),
        Note.quarterNote(medium[2]),
        new Note(medium[3], 1.25),
        Note.emptyNote(1),
    };

    public static final Note[] 思念变成海 = {
        Note.halfNote(medium[1]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[3]),
        Note.quarterNote(medium[7]),
        new Note(high[1], 1.75),
    };

    public static final Note[] 在窗外进不来 = {
        Note.halfNote(high[1]),
        Note.halfNote(high[1]),
        Note.halfNote(medium[7]),
        Note.halfNote(medium[6]),
        Note.quarterNote(medium[7]),
        Note.halfNote(medium[6]),
        Note.dottedNote0_75(medium[5]),
        // new Note(medium[6], 1.25),
        Note.emptyNote(1),
    };

    public static final Note[] 原谅说太快 = 不要你离开;

    public static final Note[] 爱成了阻碍 = {
        Note.halfNote(medium[3]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[1]),
        Note.quarterNote(medium[2]),
        new Note(medium[1], 1.25),
        Note.emptyNote(1),
    };

    public static final Note[] 手中的风筝放太快回不来 = {
        Note.halfNote(medium[1]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[3]),
        Note.halfNote(medium[5]),
        Note.halfNote(medium[5]),
        Note.halfNote(medium[4]),
        Note.halfNote(medium[4]),
        Note.halfNote(medium[3]),
        Note.fullNote(high[1]),
        Note.halfNote(medium[3]),
        Note.quarterNote(medium[2]),
        Note.quarterNote(medium[3]),
        Note.fullNote(medium[2]),
        Note.emptyNote(1),
    };

    public static final Note[] 欠你的宠爱 = 思念变成海;
    public static final Note[] 我在等待重来 = 在窗外进不来;
    public static final Note[] 天空仍灿烂 = 不要你离开;
    public static final Note[] 它爱着大海 = 爱成了阻碍;

    public static final Note[] 情歌被打败 = {
        Note.halfNote(medium[1]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[3]),
        Note.quarterNote(medium[5]),
        new Note(medium[1], 1.25),
        Note.emptyNote(1),
    };

    public static final Note[] 爱已不存在 = {
        Note.halfNote(medium[1]),
        Note.halfNote(low[7]),
        Note.halfNote(low[6]),
        Note.quarterNote(low[7]),
        new Note(medium[1], 1.25),
    };

    public static final Note[] 结尾空三拍 = {
        Note.emptyNote(3),
    };
    public static final Note[] 回忆划不开 = 距离隔不开;


    /**
     * 工厂方法：将所有乐句组装成一首完整的《花海》Music对象
     * @param pace 歌曲的速度 (BPM)
     * @return 一个可播放的 Music 对象
     */
    @Override
    public Music getMusic(int pace) {
        // 定义整首歌曲的结构，按照播放顺序排列
        List<Note[]> songStructure = Arrays.asList(
            前奏,
            静止了所有的花开,
            遥远了清晰了爱, // 你之前的版本漏掉了这一句，我已经加上了
            天郁闷爱却很喜欢,
            那时候我不懂这叫爱,

            你喜欢站在那窗台,
            你好久都没再来,
            彩色的时间染上空白,
            是你流的泪晕开,

            不要你离开,
            距离隔不开,
            思念变成海,
            在窗外进不来,

            原谅说太快,
            爱成了阻碍,
            手中的风筝放太快回不来,

            不要你离开,
            回忆划不开,
            欠你的宠爱,
            我在等待重来,

            天空仍灿烂,
            它爱着大海,
            情歌被打败,
            爱已不存在,

            结尾空三拍
        );

        // 创建一个用于存放所有Lyric对象的列表
        ArrayList<Lyric> lyrics = new ArrayList<>();

        // 遍历歌曲结构，将每个 Note[] 转换为 Lyric 对象
        for (Note[] noteArray : songStructure) {
            // 1. 将 Note[] 转换为 ArrayList<Note>
            ArrayList<Note> noteList = new ArrayList<>(Arrays.asList(noteArray));
            // 2. 使用 noteList 创建一个 Lyric 对象
            Lyric lyric = new Lyric(noteList);
            // 3. 将 Lyric 对象添加到列表中
            lyrics.add(lyric);
        }

        // 使用包含所有 Lyric 的列表和指定的速度，创建并返回最终的 Music 对象
        return new Music(lyrics, pace);
    }
}