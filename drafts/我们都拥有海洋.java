package drafts;

import constant.GMInstruments;
import model.Lyric;
import model.Music;
import model.MusicDraft;
import model.Note;

/**
 * 《我们都拥有海洋》的乐谱集。
 * <p>
 * 这是一个容器类，它包含了两个独立的、实现了 MusicDraft 接口的内部静态类：
 * 1. 我们都拥有海洋.Melody  (主旋律)
 * 2. 我们都拥有海洋.Harmony (和声)
 * <p>
 * 使用方法:
 * MusicDraft melodyDraft = new 我们都拥有海洋.Melody();
 * Music melodyTrack = melodyDraft.getMusic(90);
 * <p>
 * MusicDraft harmonyDraft = new 我们都拥有海洋.Harmony();
 * Music harmonyTrack = harmonyDraft.getMusic(90);
 * <p>
 * player.playMultipleMusic(melodyTrack, harmonyTrack);
 */
public final class 我们都拥有海洋 {

    /** 私有构造函数，防止这个容器类被外部实例化。 */
    private 我们都拥有海洋() {}

    // ======================================================================
    // |                       主旋律 (Melody) 声部                       |
    // ======================================================================
    public static class Melody implements MusicDraft {
        
        // --- 主旋律乐句定义 (此处省略，与您提供的代码相同) ---
        public static final Lyric 如果这是再不返回的夏天 = Lyric.fromNotes("如果这是再不返回的夏天",
            Note.quarterNote(medium[2]), Note.quarterNote(medium[3]), Note.quarterNote(medium[3]), Note.quarterNote(medium[3]),
            Note.halfNote(medium[3]), Note.halfNote(medium[2]), Note.halfNote(medium[1]), Note.halfNote(medium[2]),
            Note.halfNote(medium[2]), Note.quarterNote(medium[3]), new Note(medium[3], 1.25)
        );
        public static final Lyric 好好地告别 = Lyric.fromNotes("好好地告别",
            Note.quarterNote(medium[2]), Note.quarterNote(medium[5]), Note.quarterNote(low[7]),
            Note.dottedNote0_75(medium[1]), Note.halfNote(low[6])
        );
        public static final Lyric 和重要的人说再见 = Lyric.fromNotes("和重要的人说再见",
            Note.quarterNote(medium[1]), Note.quarterNote(medium[5]), Note.quarterNote(low[7]),
            Note.dottedNote0_75(medium[1]), Note.quarterNote(medium[2]), Note.dottedNote0_75(medium[3]),
            Note.halfNote(medium[1]), Note.fullNote(low[7])
        );
        public static final Lyric 无关那些催人启程的祝愿 = Lyric.fromLyricOfSameTone("无关那些催人启程的祝愿", 如果这是再不返回的夏天);
        public static final Lyric 这世界太吵 = Lyric.fromLyricOfSameTone("这世界太吵", 好好地告别);
        public static final Lyric 不代表你的声音不珍贵 = Lyric.fromNotes("不代表你的声音不珍贵",
            Note.quarterNote(medium[1]), Note.quarterNote(medium[5]), Note.quarterNote(low[7]),
            Note.dottedNote0_75(medium[1]), Note.quarterNote(medium[2]), Note.dottedNote0_75(medium[3]),
            Note.halfNote(medium[1]), Note.halfNote(low[7]), Note.quarterNote(medium[1]), Note.dottedNote0_75(medium[2])
        );
        public static final Lyric 去哪 = Lyric.fromNotes("去哪", Note.halfNote(medium[5]), Note.fullNote(low[6]));
        public static final Lyric 如果 = Lyric.fromLyricOfSameTone("如果", 去哪);
        public static final Lyric 那我 = Lyric.fromLyricOfSameTone("那我", 去哪);
        public static final Lyric 跑的脚踝到底是为什么 = Lyric.fromNotes(
            Note.halfNote(low[6]), Note.halfNote(medium[2]), Note.quarterNote(medium[1]), Note.halfNote(low[7]),
            Note.quarterNote(low[7]), Note.quarterNote(medium[1]), Note.quarterNote(medium[2]),
            Note.dottedNote1_5(medium[2]), Note.quarterNote(medium[6]), new Note(medium[6], 1.25)
        );
        public static final Lyric 为剧烈的心动 = Lyric.fromNotes("为剧烈的心动",
            Note.dottedNote1_5(high[1]), Note.halfNote(medium[7]), Note.halfNote(medium[6]),
            Note.quarterNote(medium[5]), Note.halfNote(medium[5]), Note.dottedNote0_75(medium[4])
        );
        public static final Lyric 跑起来去见喜欢的我 = Lyric.fromNotes("跑起来去见喜欢的我",
            Note.quarterNote(medium[3]), Note.quarterNote(medium[3]), Note.quarterNote(medium[3]),
            Note.quarterNote(medium[3]), Note.fullNote(medium[3]), Note.halfNote(medium[2]),
            Note.quarterNote(medium[5]), Note.halfNote(medium[5]), Note.dottedNote0_75(medium[2])
        );
        public static final Lyric 兴趣使然的 = Lyric.fromNotes("兴趣使然的",
            Note.dottedNote1_5(high[1]), Note.halfNote(medium[7]), Note.halfNote(medium[6]),
            Note.quarterNote(medium[7]), new Note(high[1], 1.25)
        );
        public static final Lyric 怎么判断有用谁来规定无用 = Lyric.fromNotes("怎么判断有用谁来规定无用",
            Note.quarterNote(medium[5]), Note.quarterNote(medium[5]), Note.quarterNote(medium[5]),
            Note.quarterNote(medium[5]), Note.quarterNote(medium[5]), Note.quarterNote(high[1]),
            Note.emptyNote(0.25), Note.halfNote(medium[7]), Note.quarterNote(medium[7]),
            Note.quarterNote(medium[7]), Note.quarterNote(medium[7]), Note.quarterNote(high[1]), Note.quarterNote(high[2])
        );
        public static final Lyric 完美的旅程 = Lyric.fromNotes("完美的旅程",
            Note.dottedNote1_5(high[1]), Note.halfNote(medium[7]), Note.halfNote(medium[6]),
            Note.quarterNote(medium[5]), new Note(medium[5], 1.25)
        );
        public static final Lyric 为何每一站是一样的路牌 = Lyric.fromNotes("为何每一站是一样的路牌",
            Note.quarterNote(medium[3]), Note.quarterNote(medium[3]), Note.quarterNote(medium[3]),
            Note.quarterNote(medium[3]), Note.dottedNote0_75(medium[3]), Note.quarterNote(medium[1]),
            Note.halfNote(medium[2]), Note.quarterNote(medium[5]), Note.dottedNote0_75(medium[5]),
            Note.quarterNote(low[7]), Note.dottedNote0_75(medium[1])
        );
        public static final Lyric 石头 = Lyric.fromNotes("石头", Note.quarterNote(low[7]), Note.dottedNote0_75(medium[1]));
        public static final Lyric 所以没有悟空 = Lyric.fromNotes("所以没有悟空",
            Note.quarterNote(low[7]), Note.dottedNote0_75(medium[1]), Note.quarterNote(medium[2]),
            Note.dottedNote0_75(medium[3]), Note.quarterNote(medium[4]), Note.quarterNote(medium[5])
        );
        public static final Lyric 就让我自己走吧 = Lyric.fromNotes("就让我自己走吧",
            Note.quarterNote(medium[5]), Note.quarterNote(high[1]), Note.quarterNote(high[3]),
            Note.quarterNote(high[2]), Note.quarterNote(high[1]), Note.quarterNote(medium[7]), new Note(high[1], 1.25)
        );
        public static final Lyric 我的球鞋 = Lyric.fromNotes("我的球鞋",
            Note.quarterNote(high[2]), Note.halfNote(high[1]), Note.halfNote(medium[7]), new Note(high[1], 1.25)
        );
        public static final Lyric 我的暴雪 = Lyric.fromNotes("我的暴雪",
            Note.quarterNote(high[3]), Note.halfNote(high[2]), Note.halfNote(high[1]), new Note(high[1], 1.25)
        );
        public static final Lyric 要去见所有我喜欢的一切 = Lyric.fromNotes("要去见所有我喜欢的一切",
            Note.quarterNote(high[2]), Note.halfNote(high[1]), Note.dottedNote0_75(medium[7]),
            Note.quarterNote(high[2]), Note.quarterNote(high[2]), Note.quarterNote(high[2]),
            Note.quarterNote(high[2]), Note.quarterNote(high[4]), Note.quarterNote(high[3]),
            Note.quarterNote(high[2]), Note.quarterNote(high[1])
        );
        public static final Lyric 别对我说 = Lyric.fromNotes("别对我说",
            Note.quarterNote(high[2]), Note.halfNote(high[1]), Note.halfNote(medium[7]), new Note(high[2], 1.25)
        );
        public static final Lyric 去成为谁的模样 = Lyric.fromNotes("去成为谁的模样",
            Note.quarterNote(medium[7]), Note.quarterNote(high[1]), Note.quarterNote(high[2]),
            Note.quarterNote(high[1]), Note.quarterNote(high[2]), Note.quarterNote(high[3]), Note.quarterNote(high[3])
        );
        public static final Lyric 未来不在 = Lyric.fromNotes("未来不在",
            Note.quarterNote(high[1]), Note.quarterNote(medium[6]), Note.quarterNote(medium[7]), new Note(high[1], 1.25)
        );
        public static final Lyric 我本该拥有海洋 = Lyric.fromLyricOfSameTone("我本该拥有海洋", 就让我自己走吧);
        public static final Lyric 不管会遇见什么Hello = Lyric.fromNotes("不管会遇见什么Hello",
            Note.quarterNote(medium[5]), Note.quarterNote(high[1]), Note.quarterNote(high[3]),
            Note.quarterNote(high[2]), Note.quarterNote(high[1]), Note.quarterNote(medium[7]),
            Note.dottedNote0_75(high[1]), Note.quarterNote(high[2]), new Note(high[1], 1.25)
        );
        public static final Lyric 你可见过两片相同的树叶 = Lyric.fromLyricOfSameTone("你可见过两片相同的树叶", 如果这是再不返回的夏天);
        public static final Lyric 人不可复写 = Lyric.fromLyricOfSameTone("人不可复写", 好好地告别);
        public static final Lyric 生命是原创的情节 = Lyric.fromLyricOfSameTone("生命是原创的情节", 和重要的人说再见);
        public static final Lyric 去问明天渴望怎样一张脸 = Lyric.fromLyricOfSameTone("去问明天渴望怎样一张脸", 无关那些催人启程的祝愿);
        public static final Lyric 它说是少年 = Lyric.fromLyricOfSameTone("它说是少年", 这世界太吵);
        public static final Lyric 它说和我一样毫无经验 = Lyric.fromLyricOfSameTone("它说和我一样毫无经验", 不代表你的声音不珍贵);
        public static final Lyric 不懂 = Lyric.fromLyricOfSameTone("不懂", 如果);
        public static final Lyric 是否 = Lyric.fromLyricOfSameTone("是否", 不懂);
        public static final Lyric 多久 = Lyric.fromLyricOfSameTone("多久", 是否);
        public static final Lyric 去爱天空怎能害怕坠落 = Lyric.fromLyricOfSameTone("去爱天空怎能害怕坠落", 跑的脚踝到底是为什么);
        public static final Lyric 人生中的考场 = Lyric.fromLyricOfSameTone("人生中的考场", 为剧烈的心动);
        public static final Lyric 我会勇敢地给出回答 = Lyric.fromLyricOfSameTone("我会勇敢地给出回答", 跑起来去见喜欢的我);
        public static final Lyric 亲手署名吧 = Lyric.fromLyricOfSameTone("亲手署名吧", 兴趣使然的);
        public static final Lyric 有时也会考砸不抄谁的答案 = Lyric.fromLyricOfSameTone("有时也会考砸不抄谁的答案", 怎么判断有用谁来规定无用);
        public static final Lyric 挥手告别吧 = Lyric.fromLyricOfSameTone("挥手告别吧", 完美的旅程);
        public static final Lyric 记得二十岁流着泪的笑脸 = Lyric.fromLyricOfSameTone("记得二十岁流着泪的笑脸", 为何每一站是一样的路牌);
        public static final Lyric 卡关 = Lyric.fromLyricOfSameTone("卡关", 石头);
        public static final Lyric 借来加血加防 = Lyric.fromLyricOfSameTone("借来加血加防", 所以没有悟空);
        public static final Lyric 不管会遇见什么 = Lyric.fromLyricOfSameTone("不管会遇见什么", 就让我自己走吧);
        public static final Lyric 不管答案是什么Hello = Lyric.fromLyricOfSameTone("不管答案是什么Hello", 不管会遇见什么Hello);
        public static final Lyric 我们都拥有海洋收尾 = Lyric.fromNotes("我们都拥有海洋",
            Note.quarterNote(medium[5]), Note.emptyNote(0.25), Note.quarterNote(high[1]), Note.emptyNote(0.25),
            Note.quarterNote(high[3]), Note.emptyNote(0.25), Note.quarterNote(high[2]), Note.emptyNote(0.25),
            Note.quarterNote(high[1]), Note.emptyNote(0.25), Note.quarterNote(medium[7]), Note.emptyNote(0.5),
            new Note(high[1], 1.25)
        );

        @Override
        public Music getMusic(int pace) {
            // [修正] 明确默认乐器为钢琴 (Acoustic Grand Piano)
            return getMusic(pace, GMInstruments.PIANO_ACOUSTIC_GRAND);
        }
        
        @Override
        public Music getMusic(int pace, int instrument) {
            Music music = Music.fromLyrics(pace,
                // --- 歌曲结构 ---
                空四拍, 空一拍,
                如果这是再不返回的夏天, 空一拍, 好好地告别, 空两拍, 和重要的人说再见, 空两拍,
                无关那些催人启程的祝愿, 空一拍, 这世界太吵, 空两拍, 不代表你的声音不珍贵,
                去哪, 空两拍, 空半拍, 如果, 空两拍, 空半拍, 那我, 空半拍, 跑的脚踝到底是为什么, 空一拍,
                为剧烈的心动, 跑起来去见喜欢的我, 兴趣使然的, 怎么判断有用谁来规定无用, 空半拍,
                完美的旅程, 为何每一站是一样的路牌, 空一拍, 石头, 空一拍, 所以没有悟空, 空四分之一拍,
                就让我自己走吧, 空一拍, 空半拍, 我的球鞋, 空一拍, 空半拍, 我的暴雪, 空一拍, 空半拍, 要去见所有我喜欢的一切, 空四分之一拍,
                就让我自己走吧, 空半拍, 别对我说, 空一拍, 空四分之一拍, 去成为谁的模样, 空一拍, 未来不在.toEmptyWords(), 空四分之一拍, 我本该拥有海洋, 空一拍, 空四分之一拍, 我本该拥有海洋, 空一拍, 空四分之一拍, 就让我自己走吧, 空一拍, 空四分之一拍, 不管会遇见什么Hello, 空两拍,
                空一拍, 你可见过两片相同的树叶, 空一拍, 人不可复写, 空两拍, 生命是原创的情节, 空两拍,
                去问明天渴望怎样一张脸, 空一拍, 它说是少年, 空两拍, 它说和我一样毫无经验,
                不懂, 空两拍, 空半拍, 是否, 空两拍, 空半拍, 多久, 空半拍, 空四分之一拍, 去爱天空怎能害怕坠落.toEmptyWords(), 空一拍,
                人生中的考场, 我会勇敢地给出回答, 亲手署名吧, 有时也会考砸不抄谁的答案, 空半拍,
                挥手告别吧, 记得二十岁流着泪的笑脸, 空半拍, 卡关, 空半拍, 借来加血加防, 空四分之一拍,
                就让我自己走吧, 空一拍, 空半拍, 我的球鞋, 空一拍, 空半拍, 我的暴雪, 空一拍, 空半拍, 要去见所有我喜欢的一切, 空四分之一拍,
                就让我自己走吧, 空半拍, 别对我说, 空一拍, 空四分之一拍, 去成为谁的模样, 空一拍, 未来不在.toEmptyWords(), 空四分之一拍, 我本该拥有海洋, 空一拍, 空四分之一拍, 我本该拥有海洋, 空一拍, 空四分之一拍, 就让我自己走吧, 空一拍, 空四分之一拍, 不管会遇见什么, 空一拍, 空四分之一拍, 我本该拥有海洋, 空一拍, 空四分之一拍, 我本该拥有海洋, 空一拍, 空四分之一拍, 就让我自己走吧, 空一拍, 空四分之一拍, 不管答案是什么Hello,
                空四拍, 空四分之一拍, 我们都拥有海洋收尾, 空两拍, 空一拍
            );

            if (instrument >= 0) {
                music.unifyInstrument(instrument);
            }
            return music.clone();
        }
    }

    // ======================================================================
    // |                        和声 (Harmony) 声部                        |
    // ======================================================================
    public static class Harmony implements MusicDraft {

        // --- 和声乐句定义 (此处省略，与您提供的代码相同) ---
        public static final Lyric 让我选择 = Lyric.fromNotes("让我选择",
            Note.emptyNote(0.25), Note.quarterNote(low[6]), Note.quarterNote(medium[3]),
            Note.emptyNote(0.5), Note.quarterNote(low[6]), Note.quarterNote(medium[2])
        );
        public static final Lyric 长奔跑的脚踝到底是为什么 = Lyric.fromNotes("长奔跑的脚踝到底是为什么",
            Note.quarterNote(low[6]), Note.quarterNote(medium[3]), Note.emptyNote(0.5), Note.halfNote(low[6]),
            Note.halfNote(medium[2]), Note.quarterNote(medium[1]), Note.halfNote(low[7]), Note.quarterNote(low[7]),
            Note.quarterNote(medium[1]), Note.quarterNote(medium[2]), Note.dottedNote1_5(medium[2]),
            Note.quarterNote(medium[1] + 1), new Note(medium[3], 1.25)
        );
        public static final Lyric 只有岸没有海 = Lyric.fromNotes("只有岸没有海",
            Note.quarterNote(low[6]), Note.quarterNote(medium[3]), Note.emptyNote(0.5),
            Note.quarterNote(medium[5]), Note.dottedNote0_75(medium[2]),
            Note.quarterNote(medium[3]), Note.quarterNote(medium[2])
        );
        public static final Lyric 没有悟空 = Lyric.fromNotes("没有悟空",
            Note.quarterNote(medium[2]), Note.dottedNote0_75(medium[3]),
            Note.quarterNote(medium[4]), Note.quarterNote(medium[5])
        );
        public static final Lyric 石头 = Lyric.fromNotes("石头", Note.quarterNote(low[7]), Note.dottedNote0_75(medium[1]));
        public static final Lyric 没有 = Lyric.fromLyricOfSameTone("没有", 石头);
        public static final Lyric 所以 = Lyric.fromLyricOfSameTone("所以", 石头);
        public static final Lyric 穿着球鞋 = Lyric.fromNotes("穿着球鞋",
            Note.halfNote(medium[1]), Note.emptyNote(0.5), Note.halfNote(medium[2]), Note.emptyNote(0.5),
            Note.halfNote(medium[3]), Note.emptyNote(0.5), Note.halfNote(medium[5]), Note.emptyNote(0.5)
        );
        public static final Lyric 迎着暴雪 = Lyric.fromLyricOfSameTone("迎着暴雪", 穿着球鞋);
        public static final Lyric 朝着山野 = Lyric.fromLyricOfSameTone("朝着山野", 穿着球鞋);
        public static final Lyric 所有我喜欢的一切 = Lyric.fromNotes(
            Note.quarterNote(medium[5]), Note.quarterNote(medium[5]), Note.quarterNote(medium[5]),
            Note.quarterNote(medium[5]), Note.quarterNote(medium[6]), Note.quarterNote(medium[5]),
            Note.quarterNote(medium[4]), Note.quarterNote(medium[3])
        );
        public static final Lyric 哪一代 = Lyric.fromNotes("哪一代", Note.quarterNote(medium[3]), Note.quarterNote(medium[5]), new Note(medium[5], 1.25));
        public static final Lyric 什么浪 = Lyric.fromNotes("什么浪", Note.quarterNote(medium[3]), Note.quarterNote(medium[4]), new Note(medium[5], 1.25));
        public static final Lyric 都不是 = Lyric.fromLyricOfSameTone("都不是", 什么浪);
        public static final Lyric 我的模样 = Lyric.fromNotes("我的模样", Note.quarterNote(medium[6]), Note.quarterNote(medium[7]), Note.quarterNote(high[1]), Note.quarterNote(high[1]));
        public static final Lyric 未来不在沙滩上 = Lyric.fromNotes("未来不在沙滩上",
            Note.quarterNote(medium[5]), Note.quarterNote(medium[3]), Note.quarterNote(medium[4]),
            Note.halfNote(medium[5]), Note.quarterNote(medium[3]), Note.quarterNote(medium[4]), new Note(medium[5], 1.25)
        );
        public static final Lyric 孤岛极光 = Lyric.fromLyricOfSameTone("孤岛极光", 穿着球鞋);
        public static final Lyric 虚拟城邦 = Lyric.fromLyricOfSameTone("虚拟城邦", 穿着球鞋);
        public static final Lyric 星球流浪 = Lyric.fromLyricOfSameTone("星球流浪", 穿着球鞋);
        public static final Lyric HelloHelloHello = Lyric.fromNotes("HelloHelloHello",
            Note.quarterNote(medium[4]), Note.dottedNote0_75(medium[3]),
            Note.quarterNote(medium[6]), Note.dottedNote0_75(medium[5]),
            Note.quarterNote(high[2]), new Note(high[1], 1.25)
        );
        public static final Lyric 唔 = Lyric.fromNotes("唔", Note.fullNote(medium[1]), Note.fullNote(medium[3]));
        public static final Lyric 天高地厚 = Lyric.fromLyricOfSameTone("天高地厚", 让我选择);
        public static final Lyric 是短暂的自由 = Lyric.fromLyricOfSameTone("是短暂的自由", 只有岸没有海);
        public static final Lyric 像风筝去爱天空怎能害怕坠落 = Lyric.fromLyricOfSameTone("像风筝去爱天空怎能害怕坠落", 长奔跑的脚踝到底是为什么);
        public static final Lyric 前路 = Lyric.fromLyricOfSameTone("前路", 所以);
        public static final Lyric 借来 = Lyric.fromLyricOfSameTone("借来", 所以);
        public static final Lyric 加血加防 = Lyric.fromLyricOfSameTone("加血加防", 没有悟空);
        public static final Lyric 我将走向 = Lyric.fromLyricOfSameTone("我将走向", 穿着球鞋);
        public static final Lyric 无垠远方 = Lyric.fromLyricOfSameTone("无垠远方", 穿着球鞋);
        public static final Lyric 我不遗忘 = Lyric.fromLyricOfSameTone("我不遗忘", 穿着球鞋);
        
        @Override
        public Music getMusic(int pace) {
            // [修正] 明确默认乐器为弦乐 (String Ensemble 1)
            return getMusic(pace, GMInstruments.ENSEMBLE_STRING_1);
        }
        
        @Override
        public Music getMusic(int pace, int instrument) {
            Music music = Music.fromLyrics(pace,
                // --- 歌曲结构 ---
                空四拍, 空四拍, 空四拍, 空四拍, 空四拍, 空四拍, 空四拍, 空四拍, 空四拍,
                空半拍, 让我选择, 空两拍, 空半拍, 只有岸没有海, 空一拍, 空半拍, 长奔跑的脚踝到底是为什么, 空一拍,
                Melody.为剧烈的心动.toEmptyWords(), Melody.跑起来去见喜欢的我.toEmptyWords(), 空四拍,
                Melody.怎么判断有用谁来规定无用.toEmptyWords(), 空半拍,
                Melody.完美的旅程.toEmptyWords(), Melody.为何每一站是一样的路牌,
                没有, 空一拍, 所以, 空一拍, 没有悟空.toEmptyWords(), 空两拍,
                穿着球鞋, 迎着暴雪, 朝着山野, 所有我喜欢的一切, 空两拍,
                空四分之一拍, 哪一代, 空四分之一拍, 什么浪, 空四分之一拍, 都不是, 我的模样, 空一拍, 未来不在沙滩上, 空一拍, 孤岛极光, 虚拟城邦, 星球流浪, 空半拍, HelloHelloHello,
                空四拍, 空四拍, 空一拍, 空四分之一拍, 唔, Melody.生命是原创的情节.toEmptyWords(), 空两拍,
                Melody.去问明天渴望怎样一张脸.toEmptyWords(), 空一拍, Melody.它说是少年.toEmptyWords(), 空两拍,
                Melody.它说和我一样毫无经验.toEmptyWords(), 空半拍, 空半拍,
                天高地厚, 空两拍, 空半拍, 是短暂的自由, 空一拍, 空半拍, 像风筝去爱天空怎能害怕坠落, 空一拍,
                Melody.人生中的考场.toEmptyWords(), Melody.我会勇敢地给出回答.toEmptyWords(),
                Melody.亲手署名吧.toEmptyWords(), Melody.有时也会考砸不抄谁的答案.toEmptyWords(), 空半拍,
                Melody.挥手告别吧.toEmptyWords(), Melody.记得二十岁流着泪的笑脸.toEmptyWords(),
                前路, 空半拍, 借来, 空一拍, 加血加防.toEmptyWords(), 空两拍,
                穿着球鞋, 迎着暴雪, 朝着山野, 所有我喜欢的一切, 空两拍,
                空四分之一拍, 哪一代, 空四分之一拍, 什么浪, 空四分之一拍, 都不是, 我的模样, 空一拍, 未来不在沙滩上, 空半拍,
                孤岛极光, 虚拟城邦, 星球流浪, 我将走向, 无垠远方, 我不遗忘, 我的模样, 空一拍, HelloHelloHello
            );

            if (instrument >= 0) {
                music.unifyInstrument(instrument);
            }
            return music.clone();
        }
    }
}