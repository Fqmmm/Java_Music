package drafts;

import constant.GMInstruments;
import model.Lyric;
import model.Music;
import model.MusicDraft;
import model.Note;

/**
 * 《你若三冬》的乐谱。只包含一段主歌+一段副歌。
 */
public class 你若三冬 implements MusicDraft {
    private static final int increment_scale = 8;
    private static final int CHORUS_INSTRUMENT = GMInstruments.LEAD_2_SAWTOOTH; // 新的写法，清晰明了！

    // --- 主歌部分的乐句定义保持不变 ---
    public static final Lyric 远方谁为了谁 = Lyric.fromNotes("远方谁为了谁",
        // ... (此处省略未改动的主歌部分)
        Note.halfNote(low[6]),
        Note.halfNote(medium[1]),
        Note.fullNote(medium[3]),
        Note.halfNote(medium[2]),
        Note.quarterNote(medium[1]),
        new Note(medium[3], 1.25)
    );

    public static final Lyric 一直望穿秋水 = Lyric.fromNotes("一直望穿秋水",
        Note.halfNote(medium[2]),
        Note.halfNote(medium[1]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[3]),
        Note.halfNote(medium[5]),
        Note.dottedNote1_5(medium[3]),
        Note.emptyNote(1)
    );

    public static final Lyric 是谁为谁月下贪杯 = Lyric.fromNotes("是谁为谁月下贪杯",
        Note.halfNote(high[1]),
        Note.halfNote(medium[7]),
        Note.halfNote(medium[5]),
        Note.halfNote(medium[3]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[1]),
        Note.halfNote(medium[3]),
        Note.dottedNote1_5(medium[3]),
        Note.emptyNote(3)
    );

    public static final Lyric 谁能看穿红尘放眼又有几人回 = Lyric.fromNotes("谁能看穿红尘放眼又有几人回",
        Note.halfNote(medium[6]),
        Note.halfNote(medium[5]),
        Note.halfNote(medium[6]),
        Note.halfNote(medium[7]),
        Note.halfNote(high[1]),
        Note.halfNote(medium[7]),
        Note.halfNote(medium[5]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[3]),
        Note.halfNote(medium[5]),
        Note.halfNote(medium[3]),
        Note.halfNote(medium[7]),
        Note.fullNote(medium[6]),
        Note.emptyNote(1)
    );

    public static final Lyric 落的念念不忘收尾 = Lyric.fromNotes("落的念念不忘收尾",
        Note.halfNote(medium[6]),
        Note.halfNote(medium[5]),
        Note.halfNote(medium[6]),
        Note.halfNote(high[1]),
        Note.halfNote(high[2]),
        Note.halfNote(high[1]),
        Note.halfNote(medium[7]),
        Note.dottedNote1_5(medium[6]),
        Note.emptyNote(2)
    );

    public static final Lyric 秋风吹叶相随 = Lyric.fromLyricOfSameTone("秋风吹叶相随", 远方谁为了谁);
    public static final Lyric 转眼即是纷飞 = Lyric.fromLyricOfSameTone("转眼即是纷飞", 一直望穿秋水);
    public static final Lyric 拥抱何必太过沉醉 = Lyric.fromNotes("拥抱何必太过沉醉",
        Note.halfNote(high[1]),
        Note.halfNote(medium[7]),
        Note.halfNote(medium[5]),
        Note.halfNote(medium[3]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[3]),
        Note.halfNote(medium[5]),
        Note.dottedNote1_5(medium[3]),
        Note.emptyNote(3)
    );
    public static final Lyric 聚散本来就是宿命写好的约会 = Lyric.fromLyricOfSameTone(
                                                "聚散本来就是宿命写好的约会", 谁能看穿红尘放眼又有几人回);
    public static final Lyric 怪我对你执迷不悔 = Lyric.fromLyricOfSameTone("怪我对你执迷不悔", 落的念念不忘收尾);


    // --- 副歌部分：直接在创建Note时指定乐器 ---

    public static final Lyric 你若三冬来换我一城雪白 = Lyric.fromNotes("你若三冬来换我一城雪白",
            new Note(medium[6] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[1] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[2] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[3] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[2] + increment_scale, 1.0, CHORUS_INSTRUMENT), // fullNote
            new Note(high[1] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(medium[7] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(medium[6] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(medium[7] + increment_scale, 1.0, CHORUS_INSTRUMENT), // fullNote
            new Note(medium[5] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(medium[6] + increment_scale, 2.0, CHORUS_INSTRUMENT)
    );

    public static final Lyric 漫天相思片片风中开 = Lyric.fromNotes("漫天相思片片风中开",
            new Note(medium[6] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[1] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[2] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[3] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[2] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[1] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[2] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[3] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[3] + increment_scale, 4.0, CHORUS_INSTRUMENT)
    );

    public static final Lyric 轻轻摇曳在天边划过的精彩 = Lyric.fromNotes("轻轻摇曳在天边划过的精彩",
            new Note(medium[6] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[1] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[2] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[3] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[2] + increment_scale, 1.0, CHORUS_INSTRUMENT), // fullNote
            new Note(high[1] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(medium[7] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(medium[6] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(medium[7] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(medium[6] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(medium[5] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(medium[3] + increment_scale, 2.0, CHORUS_INSTRUMENT)
    );

    public static final Lyric 化作眼泪哭着醒来 = Lyric.fromNotes("化作眼泪哭着醒来",
            new Note(medium[6] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(medium[5] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(medium[6] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[1] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[2] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[3] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(medium[5] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(medium[6] + increment_scale, 1.5, CHORUS_INSTRUMENT), // dottedNote1_5
            Note.emptyNote(3)
    );

    public static final Lyric 你若三冬来冰封一生所爱 = Lyric.fromLyricOfSameTone(
                        "你若三冬来冰封一生所爱", 你若三冬来换我一城雪白);

    public static final Lyric 梦过子时回首你不再 = Lyric.fromNotes("梦过子时回首你不再",
            new Note(medium[6] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[1] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[2] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[3] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[2] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[1] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(medium[6] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[3] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[3] + increment_scale, 1.0, CHORUS_INSTRUMENT), // fullNote
            Note.emptyNote(3)
    );

    public static final Lyric 每逢落叶过挥手南雁几排 = Lyric.fromNotes("每逢落叶过挥手南雁几排",
            new Note(medium[6] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[1] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[2] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[3] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[2] + increment_scale, 1.0, CHORUS_INSTRUMENT), // fullNote
            new Note(high[1] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[2] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[3] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[5] + increment_scale, 1.0, CHORUS_INSTRUMENT), // fullNote
            new Note(medium[5] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(medium[6] + increment_scale, 2.0, CHORUS_INSTRUMENT)
    );

    public static final Lyric 触景生情自古以来 = Lyric.fromLyricOfSameTone("触景生情自古以来", 化作眼泪哭着醒来);

    @Override
    public Music getMusic(int pace, int velocity) {
        Music music = Music.fromLyrics(pace,
            空一拍,
            远方谁为了谁, 一直望穿秋水, 是谁为谁月下贪杯,
            谁能看穿红尘放眼又有几人回, 落的念念不忘收尾,
            秋风吹叶相随, 转眼即是纷飞, 拥抱何必太过沉醉,
            聚散本来就是宿命写好的约会, 怪我对你执迷不悔,
            空一拍,
            你若三冬来换我一城雪白, 漫天相思片片风中开,
            轻轻摇曳在天边划过的精彩, 化作眼泪哭着醒来,
            你若三冬来冰封一生所爱, 梦过子时回首你不再,
            每逢落叶过挥手南雁几排, 触景生情自古以来
        );

        if (velocity >= 0) {
            music.unifyVelocity(velocity);
        }

        return music;
    }
}