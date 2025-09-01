
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 你若三冬 implements MusicDraft {
    private static final int increment_scale = 8;
    private static final int CHORUS_INSTRUMENT = GMInstruments.LEAD_2_SAWTOOTH; // 新的写法，清晰明了！

    // --- 主歌部分的乐句定义保持不变 ---
    public static final Note[] 远方谁为了谁 = {
        // ... (此处省略未改动的主歌部分)
        Note.halfNote(low[6]),
        Note.halfNote(medium[1]),
        Note.fullNote(medium[3]),
        Note.halfNote(medium[2]),
        Note.quarterNote(medium[1]),
        new Note(medium[3], 1.25),
    };

    public static final Note[] 一直望穿秋水 = {
        Note.halfNote(medium[2]),
        Note.halfNote(medium[1]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[3]),
        Note.halfNote(medium[5]),
        Note.dottedNote1_5(medium[3]),
        Note.emptyNote(1),
    };

    public static final Note[] 是谁为谁月下贪杯 = {
        Note.halfNote(high[1]),
        Note.halfNote(medium[7]),
        Note.halfNote(medium[5]),
        Note.halfNote(medium[3]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[1]),
        Note.halfNote(medium[3]),
        Note.dottedNote1_5(medium[3]),
        Note.emptyNote(3),
    };

    public static final Note[] 谁能看穿红尘放眼又有几人回 = {
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
        Note.emptyNote(1),
    };

    public static final Note[] 落的念念不忘收尾 = {
        Note.halfNote(medium[6]),
        Note.halfNote(medium[5]),
        Note.halfNote(medium[6]),
        Note.halfNote(high[1]),
        Note.halfNote(high[2]),
        Note.halfNote(high[1]),
        Note.halfNote(medium[7]),
        Note.dottedNote1_5(medium[6]),
        Note.emptyNote(2),
    };

    public static final Note[] 秋风吹叶相随 = 远方谁为了谁;
    public static final Note[] 转眼即是纷飞 = 一直望穿秋水;
    public static final Note[] 拥抱何必太过沉醉 = {
        Note.halfNote(high[1]),
        Note.halfNote(medium[7]),
        Note.halfNote(medium[5]),
        Note.halfNote(medium[3]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[3]),
        Note.halfNote(medium[5]),
        Note.dottedNote1_5(medium[3]),
        Note.emptyNote(3),
    };
    public static final Note[] 聚散本来就是宿命写好的约会 = 谁能看穿红尘放眼又有几人回;
    public static final Note[] 怪我对你执迷不悔 = 落的念念不忘收尾;


    // --- 副歌部分：直接在创建Note时指定乐器 ---

    public static final Note[] 你若三冬来换我一城雪白 = {
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
    };

    public static final Note[] 漫天相思片片风中开 = {
            new Note(medium[6] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[1] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[2] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[3] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[2] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[1] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[2] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[3] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[3] + increment_scale, 4.0, CHORUS_INSTRUMENT)
    };

    public static final Note[] 轻轻摇曳在天边划过的精彩 = {
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
            new Note(medium[3] + increment_scale, 2.0, CHORUS_INSTRUMENT),
    };

    public static final Note[] 化作眼泪哭着醒来 = {
            new Note(medium[6] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(medium[5] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(medium[6] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[1] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[2] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[3] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(medium[5] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(medium[6] + increment_scale, 1.5, CHORUS_INSTRUMENT), // dottedNote1_5
            Note.emptyNote(3)
    };

    public static final Note[] 你若三冬来冰封一生所爱 = 你若三冬来换我一城雪白;

    public static final Note[] 梦过子时回首你不再 = {
            new Note(medium[6] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[1] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[2] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[3] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[2] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[1] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(medium[6] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[3] + increment_scale, 0.5, CHORUS_INSTRUMENT),
            new Note(high[3] + increment_scale, 1.0, CHORUS_INSTRUMENT), // fullNote
            Note.emptyNote(3),
    };

    public static final Note[] 每逢落叶过挥手南雁几排 = {
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
            new Note(medium[6] + increment_scale, 2.0, CHORUS_INSTRUMENT),
    };

    public static final Note[] 触景生情自古以来 = 化作眼泪哭着醒来;

    /**
     * 工厂方法：现在恢复了简洁的形式，只负责组装
     * @param pace 歌曲的速度 (BPM)
     * @return 一个可播放的 Music 对象
     */
    public Music getMusic(int pace) {
        List<Note[]> songStructure = Arrays.asList(
            远方谁为了谁, 一直望穿秋水, 是谁为谁月下贪杯,
            谁能看穿红尘放眼又有几人回, 落的念念不忘收尾,
            秋风吹叶相随, 转眼即是纷飞, 拥抱何必太过沉醉,
            聚散本来就是宿命写好的约会, 怪我对你执迷不悔,
            Note.emptyNoteList(1),
            你若三冬来换我一城雪白, 漫天相思片片风中开,
            轻轻摇曳在天边划过的精彩, 化作眼泪哭着醒来,
            你若三冬来冰封一生所爱, 梦过子时回首你不再,
            每逢落叶过挥手南雁几排, 触景生情自古以来
        );

        ArrayList<Lyric> lyrics = new ArrayList<>();
        for (Note[] phrase : songStructure) {
            ArrayList<Note> noteList = new ArrayList<>(Arrays.asList(phrase));
            lyrics.add(new Lyric(noteList));
        }

        return new Music(lyrics, pace);
    }
}