package drafts;
import model.Lyric;
import model.Music;
import model.MusicDraft;
import model.Note;

/**
 * 《王妃》的乐谱。只包含一段主歌+一段副歌。
 */
public class 王妃 implements MusicDraft {
    public static Lyric 摇晃的红酒杯 = Lyric.fromNotes("摇晃的红酒杯",
        Note.halfNote(medium[3]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[1]),
        Note.halfNote(medium[2]),
        Note.halfNote(low[6]),
        Note.fullNote(low[6])
    );

    public static Lyric 嘴唇像染着鲜血 = Lyric.fromNotes("嘴唇像染着鲜血",
        Note.halfNote(low[6]),
        Note.halfNote(medium[1]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[3]),
        Note.halfNote(medium[5]),
        Note.halfNote(medium[6]),
        // Note.halfNote(medium[7]),
        Note.fullNote(medium[2])
    );

    public static final Lyric 那不寻常的美 = Lyric.fromLyricOfSameTone("那不寻常的美", 摇晃的红酒杯);

    public static final Lyric 难赦免的罪 = Lyric.fromNotes("难赦免的罪",
        Note.halfNote(low[3]),
        Note.halfNote(low[3]),
        Note.halfNote(low[5]),
        Note.halfNote(low[6]),
        Note.fullNote(low[6])
    );

    public static final Lyric 谁忠心地跟随 = Lyric.fromLyricOfSameTone("谁忠心地跟随",摇晃的红酒杯);

    public static final Lyric 充其量当个侍卫 = Lyric.fromLyricOfSameTone("充其量当个侍卫", 嘴唇像染着鲜血);

    public static final Lyric 脚下踩着玫瑰 = Lyric.fromLyricOfSameTone("脚下踩着玫瑰", 那不寻常的美);

    public static final Lyric 回敬一个吻当安慰 = Lyric.fromNotes("回敬一个吻当安慰",
        Note.halfNote(low[3]),
        Note.halfNote(low[3]),
        Note.halfNote(low[5]),
        Note.halfNote(low[6]),
        Note.halfNote(low[6]),
        Note.halfNote(low[6]),

        Note.fullNote(medium[2]),
        Note.fullNote(medium[1])
    );

    public static final Lyric 可怜 = Lyric.fromNotes("可怜",
        Note.fullNote(medium[2]),
        Note.fullNote(medium[1])
    );

    public static final Lyric 像蠢动的音乐 = Lyric.fromLyricOfSameTone("像蠢动的音乐", 摇晃的红酒杯);

    public static final Lyric 教人们怎么成眠 = Lyric.fromLyricOfSameTone("教人们怎么成眠", 嘴唇像染着鲜血);

    public static final Lyric 不知名的香水 = Lyric.fromLyricOfSameTone("不知名的香水", 那不寻常的美);

    public static final Lyric 窒息的鬼魅 = Lyric.fromLyricOfSameTone("窒息的鬼魅", 难赦免的罪);

    public static final Lyric 锋利的高跟鞋 = Lyric.fromLyricOfSameTone("锋利的高跟鞋", 摇晃的红酒杯);

    public static final Lyric 让多少心肠破碎 = Lyric.fromLyricOfSameTone("让多少心肠破碎", 嘴唇像染着鲜血);

    public static final Lyric 弯刀一样的眉 = Lyric.fromLyricOfSameTone("弯刀一样的眉", 摇晃的红酒杯);

    public static final Lyric 捍卫你的秘密花园 = Lyric.fromLyricOfSameTone("捍卫你的秘密花园", 回敬一个吻当安慰);

    public static final Lyric 夜太美尽管再危险 = Lyric.fromNotes("夜太美尽管再危险",
        Note.fullNote(medium[3]),
        Note.fullNote(medium[5]),
        Note.fullNote(medium[6], 150, 80),
        Note.emptyNote(1),

        Note.halfNote(medium[3]),
        Note.halfNote(medium[5]),
        Note.halfNote(medium[6]),
        Note.fullNote(medium[2]),
        Note.dottedNote1_5(medium[1])
    );

    public static final Lyric 总有人黑着眼眶熬着夜 = Lyric.fromNotes("总有人黑着眼眶熬着夜",
        Note.halfNote(medium[3]),
        Note.halfNote(medium[5]),
        Note.halfNote(medium[6]),
        Note.fullNote(medium[2]),
        Note.halfNote(medium[1]),
        Note.halfNote(medium[1]),
        Note.halfNote(low[6]),

        new Note(medium[5], 2.0/3),
        new Note(medium[1], 2.0/3),
        new Note(medium[2], 2.0/3 + 1)
    );

    public static final Lyric 爱太美尽管再危险 = Lyric.fromNotes("爱太美尽管再危险",
        Note.fullNote(medium[3]),
        Note.fullNote(medium[5]),
        Note.fullNote(medium[6]),
        Note.emptyNote(1),

        Note.halfNote(high[1]),
        Note.halfNote(medium[7]),
        Note.halfNote(medium[6]),
        Note.fullNote(medium[2]),
        Note.fullNote(medium[1])
    );

    public static final Lyric 愿赔上了一切超支千年的泪 = Lyric.fromNotes("愿赔上了一切超支千年的泪",
        Note.halfNote(medium[3]),
        Note.halfNote(high[1]),
        Note.halfNote(medium[7]),
        Note.halfNote(medium[6]),
        Note.fullNote(medium[2]),
        Note.halfNote(medium[1]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[3]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[1]),
        Note.halfNote(low[6]),
        Note.dottedNote1_5(medium[1])
    );

    public static final Lyric 痛太美尽管再卑微 = Lyric.fromLyricOfSameTone("痛太美尽管再卑微", 夜太美尽管再危险);

    public static final Lyric 也想尝粉身碎骨的滋味 = Lyric.fromLyricOfSameTone("也想尝粉身碎骨的滋味", 总有人黑着眼眶熬着夜);

    public static final Lyric 你太美尽管再无言 = Lyric.fromNotes("你太美尽管再无言",
        Note.fullNote(medium[3]),
        Note.fullNote(medium[5]),
        Note.fullNote(medium[6]),
        Note.emptyNote(1),

        Note.halfNote(high[1]),
        Note.halfNote(medium[7]),
        Note.halfNote(medium[6]),
        Note.fullNote(medium[2]),
        Note.fullNote(medium[1])

        // Note.halfNote(medium[3]),
        // Note.halfNote(high[1]),
        // Note.halfNote(medium[7]),
        // Note.halfNote(medium[6]),
        // Note.fullNote(medium[2]),
        // Note.halfNote(medium[1]),
        // Note.halfNote(medium[2]),
        // Note.halfNote(medium[3]),
        // Note.halfNote(medium[2]),
        // Note.fullNote(medium[1]),
    );  

    public static final Lyric 我都想用石堆隔绝世界 = Lyric.fromNotes("我都想用石堆隔绝世界",
        Note.halfNote(medium[3]),
        Note.halfNote(high[1]),
        Note.halfNote(medium[7]),
        Note.halfNote(medium[6]),
        Note.fullNote(medium[2]),
        Note.halfNote(medium[1]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[3]),
        Note.halfNote(medium[2]),
        Note.fullNote(medium[1])
    );

    public static final Lyric 我的王妃我要霸占你的美 = Lyric.fromNotes("我的王妃我要霸占你的美",
        Note.fullNote(medium[2]),
        Note.halfNote(medium[1]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[3]),
        Note.halfNote(medium[2]),
        Note.halfNote(medium[1]),
        Note.halfNote(medium[1]),
        Note.halfNote(low[6]),

        Note.fullNote(medium[3]),
        Note.emptyNote(1),
        Note.fullNote(medium[2]),
        Note.emptyNote(1),
        Note.halfNote(medium[1]),
        Note.halfNote(low[6])
    );

    @Override
    public Music getMusic(int pace) {
        return getMusic(pace, -1);
    }

    @Override
    public Music getMusic(int pace, int instrument) {
        Music music = Music.fromLyrics(pace,
            空一拍,
            摇晃的红酒杯,
            空半拍,
            嘴唇像染着鲜血,
            那不寻常的美,
            空一拍,
            难赦免的罪,
            空半拍,

            谁忠心地跟随,
            空半拍,
            充其量当个侍卫,
            脚下踩着玫瑰,
            空一拍,
            回敬一个吻当安慰,
            空一拍,

            可怜,
            空两拍,

            像蠢动的音乐,
            空半拍,
            教人们怎么成眠,
            不知名的香水,
            空一拍,
            窒息的鬼魅,
            空半拍,

            锋利的高跟鞋,
            空半拍,
            让多少心肠破碎,
            弯刀一样的眉,
            空一拍,
            捍卫你的秘密花园,
            空两拍,

            夜太美尽管再危险,
            总有人黑着眼眶熬着夜,
            空一拍,

            爱太美尽管再危险,
            愿赔上了一切超支千年的泪,
            空一拍,

            痛太美尽管再卑微,
            也想尝粉身碎骨的滋味,
            空一拍,

            你太美尽管再无言,
            我都想用石堆隔绝世界,
            我的王妃我要霸占你的美,
            空一拍
        );

        // 设置乐器
        if (instrument >= 0) {
            music.unifyInstrument(instrument);
        }

        return music;
    }
}