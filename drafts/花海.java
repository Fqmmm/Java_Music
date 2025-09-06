package drafts;


import model.Lyric;
import model.Music;
import model.MusicDraft;
import model.Note;

/**
 * 《花海》的乐谱。只包含一段主歌+一段副歌。
 */
public class 花海 implements MusicDraft {

    // 你编写的所有 Lyric 数组都保留在这里，无需任何改动
    // ... (前奏, 静止了所有的花开, 等等... 代码过长，此处省略)
    public static final Lyric 前奏 = Lyric.fromNotes(
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
        Note.emptyNote(2)
    );

    public static final Lyric 静止了所有的花开 = Lyric.fromNotes("静止了所有的花开",
        Note.quarterNote(medium[1]),
        Note.dottedNote0_75(medium[3]),
        Note.fullNote(medium[3]),
        Note.emptyNote(1),

        Note.halfNote(medium[3]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[1]),
        Note.fullNote(medium[2]),
        Note.dottedNote1_5(medium[3]),
        Note.emptyNote(1)
    );

    public static final Lyric 遥远了清晰了爱 = Lyric.fromNotes("遥远了清晰了爱",
        Note.quarterNote(medium[1]),
        Note.dottedNote0_75(medium[3]),
        Note.fullNote(medium[3]),
        Note.emptyNote(1),
        Note.halfNote(medium[4]),
        Note.halfNote(medium[3]),
        Note.fullNote(medium[5]),
        Note.fullNote(medium[1]),
        Note.emptyNote(2)
    );

    public static final Lyric 天郁闷爱却很喜欢 = Lyric.fromNotes("天郁闷爱却很喜欢",
        Note.quarterNote(medium[1]),
        Note.dottedNote0_75(medium[4]),
        Note.fullNote(medium[4]),
        Note.emptyNote(1),

        Note.halfNote(medium[4]),
        Note.halfNote(medium[3]),
        Note.halfNote(medium[1]),
        Note.fullNote(low[5]),
        Note.dottedNote1_5(medium[3]),
        Note.emptyNote(1)
    );

    public static final Lyric 那时候我不懂这叫爱 = Lyric.fromNotes("那时候我不懂这叫爱",
        Note.quarterNote(medium[1]),
        Note.dottedNote0_75(medium[3]),
        Note.fullNote(medium[2]),

        Note.quarterNote(medium[1]),
        Note.dottedNote0_75(medium[3]),
        Note.fullNote(medium[2]),

        Note.quarterNote(medium[1]),
        Note.dottedNote0_75(medium[3]),
        Note.fullNote(medium[2]),

        Note.emptyNote(2)
    );

    public static final Lyric 你喜欢站在那窗台 = Lyric.fromNotes("你喜欢站在那窗台",
        Note.quarterNote(medium[1]),
        Note.dottedNote0_75(medium[3]),
        Note.fullNote(medium[3]),
        Note.emptyNote(1),

        Note.halfNote(medium[3]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[1]),
        Note.fullNote(medium[2]),
        Note.dottedNote1_5(medium[5]),
        Note.emptyNote(1)
    );

    public static final Lyric 你好久都没再来 = Lyric.fromNotes("你好久都没再来",
        Note.quarterNote(medium[1]),
        Note.dottedNote0_75(medium[3]),
        Note.fullNote(medium[3]),
        Note.emptyNote(1),
        
        Note.halfNote(medium[4]),
        Note.halfNote(medium[3]),
        Note.halfNote(medium[5]),
        Note.halfNote(medium[1]),
        Note.emptyNote(2)
    );

    public static final Lyric 彩色的时间染上空白 = Lyric.fromNotes("彩色的时间染上空白",
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
        Note.emptyNote(1)
    );

    public static final Lyric 是你流的泪晕开 = Lyric.fromNotes("是你流的泪晕开",
        Note.halfNote(medium[5]),
        Note.halfNote(medium[4]),
        Note.halfNote(medium[4]),
        Note.halfNote(medium[1]),
        Note.halfNote(medium[1]),
        Note.halfNote(low[7]),
        Note.halfNote(low[7]),
        Note.dottedNote1_5(medium[1]),
        Note.emptyNote(1)
    );

    public static final Lyric 不要你离开 = Lyric.fromNotes("不要你离开",
        Note.halfNote(medium[1]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[3]),
        Note.quarterNote(medium[5]),
        new Note(medium[5], 1.25),
        Note.emptyNote(1)
    );

    public static final Lyric 距离隔不开 = Lyric.fromNotes("距离隔不开", 
        Note.halfNote(medium[3]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[1]),
        Note.quarterNote(medium[2]),
        new Note(medium[3], 1.25),
        Note.emptyNote(1)
    );

    public static final Lyric 思念变成海 = Lyric.fromNotes("思念变成海",
        Note.halfNote(medium[1]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[3]),
        Note.quarterNote(medium[7]),
        new Note(high[1], 1.75)
    );

    public static final Lyric 在窗外进不来 = Lyric.fromNotes("在窗外进不来",
        Note.halfNote(high[1]),
        Note.halfNote(high[1]),
        Note.halfNote(medium[7]),
        Note.halfNote(medium[6]),
        Note.quarterNote(medium[7]),
        Note.halfNote(medium[6]),
        Note.dottedNote0_75(medium[5]),
        // new Note(medium[6], 1.25),
        Note.emptyNote(1)
    );

    public static final Lyric 原谅说太快 = Lyric.fromLyricOfSameTone("原谅说太快", 不要你离开);

    public static final Lyric 爱成了阻碍 = Lyric.fromNotes("爱成了阻碍",
        Note.halfNote(medium[3]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[1]),
        Note.quarterNote(medium[2]),
        new Note(medium[1], 1.25),
        Note.emptyNote(1)
    );

    public static final Lyric 手中的风筝放太快回不来 = Lyric.fromNotes("手中的风筝放太快回不来",
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
        Note.emptyNote(1)
    );

    public static final Lyric 欠你的宠爱 = Lyric.fromLyricOfSameTone("欠你的宠爱", 思念变成海);
    public static final Lyric 我在等待重来 = Lyric.fromLyricOfSameTone("我在等待重来", 在窗外进不来);
    public static final Lyric 天空仍灿烂 = Lyric.fromLyricOfSameTone("天空仍灿烂", 不要你离开);
    public static final Lyric 它爱着大海 = Lyric.fromLyricOfSameTone("它爱着大海", 爱成了阻碍);

    public static final Lyric 情歌被打败 = Lyric.fromNotes("情歌被打败",
        Note.halfNote(medium[1]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[3]),
        Note.quarterNote(medium[5]),
        new Note(medium[1], 1.25),
        Note.emptyNote(1)
    );

    public static final Lyric 爱已不存在 = Lyric.fromNotes("爱已不存在",
        Note.halfNote(medium[1]),
        Note.halfNote(low[7]),
        Note.halfNote(low[6]),
        Note.quarterNote(low[7]),
        new Note(medium[1], 1.25)
    );

    public static final Lyric 结尾空三拍 = Lyric.fromNotes(
        Note.emptyNote(3)
    );
    public static final Lyric 回忆划不开 = 距离隔不开;
    
    public Music getMusic(int pace, int velocity) {
        // 定义整首歌曲的结构，按照播放顺序排列
        Music music = Music.fromLyrics(pace,
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

        if (velocity >= 0) {
            music.unifyVelocity(velocity);
        }

        music.setTitle(this.getClass().getSimpleName());    // 歌名默认为类名
        return music;
    }
}