package drafts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.GMInstruments;
import model.Lyric;
import model.Music;
import model.MusicDraft;
import model.Note;

/**
 * 《我们都拥有海洋》的乐谱集。
 * 
 * 这是一个容器类，它包含了两个独立的、实现了 MusicDraft 接口的内部静态类：
 * 1. 我们都拥有海洋.Melody  (主旋律)
 * 2. 我们都拥有海洋.Harmony (和声)
 * 
 * 使用方法:
 * MusicDraft melodyDraft = new 我们都拥有海洋.Melody();
 * Music melodyTrack = melodyDraft.getMusic(90);
 * 
 * MusicDraft harmonyDraft = new 我们都拥有海洋.Harmony();
 * Music harmonyTrack = harmonyDraft.getMusic(90);
 * 
 * player.playMultipleMusic(melodyTrack, harmonyTrack);
 */
public final class 我们都拥有海洋 {

    /** 私有构造函数，防止这个容器类被外部实例化。 */
    private 我们都拥有海洋() {}

    // ======================================================================
    // |                       主旋律 (Melody) 声部                       |
    // ======================================================================
    public static class Melody implements MusicDraft {
        
        // --- 主旋律乐句定义 ---
        public static final Note[] 如果这是再不返回的夏天 = {
            Note.quarterNote(medium[2]), Note.quarterNote(medium[3]), Note.quarterNote(medium[3]), Note.quarterNote(medium[3]),
            Note.halfNote(medium[3]), Note.halfNote(medium[2]), Note.halfNote(medium[1]), Note.halfNote(medium[2]),
            Note.halfNote(medium[2]), Note.quarterNote(medium[3]), new Note(medium[3], 1.25),
        };
        public static final Note[] 好好地告别 = {
            Note.quarterNote(medium[2]), Note.quarterNote(medium[5]), Note.quarterNote(low[7]),
            Note.dottedNote0_75(medium[1]), Note.halfNote(low[6]),
        };
        public static final Note[] 和重要的人说再见 = {
            Note.quarterNote(medium[1]), Note.quarterNote(medium[5]), Note.quarterNote(low[7]),
            Note.dottedNote0_75(medium[1]), Note.quarterNote(medium[2]), Note.dottedNote0_75(medium[3]),
            Note.halfNote(medium[1]), Note.fullNote(low[7]),
        };
        public static final Note[] 无关那些催人启程的祝愿 = 如果这是再不返回的夏天;
        public static final Note[] 这世界太吵 = 好好地告别;
        public static final Note[] 不代表你的声音不珍贵 = {
            Note.quarterNote(medium[1]), Note.quarterNote(medium[5]), Note.quarterNote(low[7]),
            Note.dottedNote0_75(medium[1]), Note.quarterNote(medium[2]), Note.dottedNote0_75(medium[3]),
            Note.halfNote(medium[1]), Note.halfNote(low[7]), Note.quarterNote(medium[1]), Note.dottedNote0_75(medium[2]),
        };
        public static final Note[] 去哪 = { Note.halfNote(medium[5]), Note.fullNote(low[6]), };
        public static final Note[] 如果 = 去哪;
        public static final Note[] 那我 = 去哪;
        public static final Note[] 跑的脚踝到底是为什么 = {
            Note.halfNote(low[6]), Note.halfNote(medium[2]), Note.quarterNote(medium[1]), Note.halfNote(low[7]),
            Note.quarterNote(low[7]), Note.quarterNote(medium[1]), Note.quarterNote(medium[2]),
            Note.dottedNote1_5(medium[2]), Note.quarterNote(medium[6]), new Note(medium[6], 1.25),
        };
        public static final Note[] 为剧烈的心动 = {
            Note.dottedNote1_5(high[1]), Note.halfNote(medium[7]), Note.halfNote(medium[6]),
            Note.quarterNote(medium[5]), Note.halfNote(medium[5]), Note.dottedNote0_75(medium[4]),
        };
        public static final Note[] 跑起来去见喜欢的我 = {
            Note.quarterNote(medium[3]), Note.quarterNote(medium[3]), Note.quarterNote(medium[3]),
            Note.quarterNote(medium[3]), Note.fullNote(medium[3]), Note.halfNote(medium[2]),
            Note.quarterNote(medium[5]), Note.halfNote(medium[5]), Note.dottedNote0_75(medium[2]),
        };
        public static final Note[] 兴趣使然的 = {
            Note.dottedNote1_5(high[1]), Note.halfNote(medium[7]), Note.halfNote(medium[6]),
            Note.quarterNote(medium[7]), new Note(high[1], 1.25),
        };
        public static final Note[] 怎么判断有用谁来规定无用 = {
            Note.quarterNote(medium[5]), Note.quarterNote(medium[5]), Note.quarterNote(medium[5]),
            Note.quarterNote(medium[5]), Note.quarterNote(medium[5]), Note.quarterNote(high[1]),
            Note.emptyNote(0.25), Note.halfNote(medium[7]), Note.quarterNote(medium[7]),
            Note.quarterNote(medium[7]), Note.quarterNote(medium[7]), Note.quarterNote(high[1]), Note.quarterNote(high[2]),
        };
        public static final Note[] 完美的旅程 = {
            Note.dottedNote1_5(high[1]), Note.halfNote(medium[7]), Note.halfNote(medium[6]),
            Note.quarterNote(medium[5]), new Note(medium[5], 1.25),
        };
        public static final Note[] 为何每一站是一样的路牌 = {
            Note.quarterNote(medium[3]), Note.quarterNote(medium[3]), Note.quarterNote(medium[3]),
            Note.quarterNote(medium[3]), Note.dottedNote0_75(medium[3]), Note.quarterNote(medium[1]),
            Note.halfNote(medium[2]), Note.quarterNote(medium[5]), Note.dottedNote0_75(medium[5]),
            Note.quarterNote(low[7]), Note.dottedNote0_75(medium[1]),
        };
        public static final Note[] 石头 = { Note.quarterNote(low[7]), Note.dottedNote0_75(medium[1]) };
        public static final Note[] 所以没有悟空 = {
            Note.quarterNote(low[7]), Note.dottedNote0_75(medium[1]), Note.quarterNote(medium[2]),
            Note.dottedNote0_75(medium[3]), Note.quarterNote(medium[4]), Note.quarterNote(medium[5]),
        };
        public static final Note[] 就让我自己走吧 = {
            Note.quarterNote(medium[5]), Note.quarterNote(high[1]), Note.quarterNote(high[3]),
            Note.quarterNote(high[2]), Note.quarterNote(high[1]), Note.quarterNote(medium[7]), new Note(high[1], 1.25),
        };
        public static final Note[] 我的球鞋 = {
            Note.quarterNote(high[2]), Note.halfNote(high[1]), Note.halfNote(medium[7]), new Note(high[1], 1.25),
        };
        public static final Note[] 我的暴雪 = {
            Note.quarterNote(high[3]), Note.halfNote(high[2]), Note.halfNote(high[1]), new Note(high[1], 1.25),
        };
        public static final Note[] 要去见所有我喜欢的一切 = {
            Note.quarterNote(high[2]), Note.halfNote(high[1]), Note.dottedNote0_75(medium[7]),
            Note.quarterNote(high[2]), Note.quarterNote(high[2]), Note.quarterNote(high[2]),
            Note.quarterNote(high[2]), Note.quarterNote(high[4]), Note.quarterNote(high[3]),
            Note.quarterNote(high[2]), Note.quarterNote(high[1]),
        };
        public static final Note[] 别对我说 = {
            Note.quarterNote(high[2]), Note.halfNote(high[1]), Note.halfNote(medium[7]), new Note(high[2], 1.25),
        };
        public static final Note[] 去成为谁的模样 = {
            Note.quarterNote(medium[7]), Note.quarterNote(high[1]), Note.quarterNote(high[2]),
            Note.quarterNote(high[1]), Note.quarterNote(high[2]), Note.quarterNote(high[3]), Note.quarterNote(high[3]),
        };
        public static final Note[] 未来不在 = {
            Note.quarterNote(high[1]), Note.quarterNote(medium[6]), Note.quarterNote(medium[7]), new Note(high[1], 1.25),
        };
        public static final Note[] 我本该拥有海洋 = 就让我自己走吧;
        public static final Note[] 不管会遇见什么Hello = {
            Note.quarterNote(medium[5]), Note.quarterNote(high[1]), Note.quarterNote(high[3]),
            Note.quarterNote(high[2]), Note.quarterNote(high[1]), Note.quarterNote(medium[7]),
            Note.dottedNote0_75(high[1]), Note.quarterNote(high[2]), new Note(high[1], 1.25),
        };
        public static final Note[] 你可见过两片相同的树叶 = 如果这是再不返回的夏天;
        public static final Note[] 人不可复写 = 好好地告别;
        public static final Note[] 生命是原创的情节 = 和重要的人说再见;
        public static final Note[] 去问明天渴望怎样一张脸 = 无关那些催人启程的祝愿;
        public static final Note[] 它说是少年 = 这世界太吵;
        public static final Note[] 它说和我一样毫无经验 = 不代表你的声音不珍贵;
        public static final Note[] 不懂 = 如果;
        public static final Note[] 是否 = 不懂;
        public static final Note[] 多久 = 是否;
        public static final Note[] 去爱天空怎能害怕坠落 = 跑的脚踝到底是为什么;
        public static final Note[] 人生中的考场 = 为剧烈的心动;
        public static final Note[] 我会勇敢地给出回答 = 跑起来去见喜欢的我;
        public static final Note[] 亲手署名吧 = 兴趣使然的;
        public static final Note[] 有时也会考砸不抄谁的答案 = 怎么判断有用谁来规定无用;
        public static final Note[] 挥手告别吧 = 完美的旅程;
        public static final Note[] 记得二十岁流着泪的笑脸 = 为何每一站是一样的路牌;
        public static final Note[] 卡关 = 石头;
        public static final Note[] 借来加血加防 = 所以没有悟空;
        public static final Note[] 不管会遇见什么 = 就让我自己走吧;
        public static final Note[] 不管答案是什么Hello = 不管会遇见什么Hello;
        public static final Note[] 我们都拥有海洋收尾 = {
            Note.quarterNote(medium[5]), Note.emptyNote(0.25), Note.quarterNote(high[1]), Note.emptyNote(0.25),
            Note.quarterNote(high[3]), Note.emptyNote(0.25), Note.quarterNote(high[2]), Note.emptyNote(0.25),
            Note.quarterNote(high[1]), Note.emptyNote(0.25), Note.quarterNote(medium[7]), Note.emptyNote(0.5),
            new Note(high[1], 1.25),
        };

        @Override
        public Music getMusic(int pace) {
            return getMusic(pace, GMInstruments.PIANO_ACOUSTIC_GRAND); // 主旋律默认使用钢琴
        }
        
        public Music getMusic(int pace, int instrument) {
            List<Note[]> melodyStructure = Arrays.asList(
                Note.emptyNoteList(5),
                如果这是再不返回的夏天, Note.emptyNoteList(1), 好好地告别, Note.emptyNoteList(2), 和重要的人说再见, Note.emptyNoteList(2),
                无关那些催人启程的祝愿, Note.emptyNoteList(1), 这世界太吵, Note.emptyNoteList(2), 不代表你的声音不珍贵,
                去哪, Note.emptyNoteList(2.5), 如果, Note.emptyNoteList(2.5), 那我, Note.emptyNoteList(0.5), 跑的脚踝到底是为什么, Note.emptyNoteList(1),
                为剧烈的心动, 跑起来去见喜欢的我, 兴趣使然的, 怎么判断有用谁来规定无用, Note.emptyNoteList(0.5),
                完美的旅程, 为何每一站是一样的路牌, Note.emptyNoteList(1), 石头, Note.emptyNoteList(1), 所以没有悟空, Note.emptyNoteList(0.25),
                就让我自己走吧, Note.emptyNoteList(1.5), 我的球鞋, Note.emptyNoteList(1.5), 我的暴雪, Note.emptyNoteList(1.5), 要去见所有我喜欢的一切, Note.emptyNoteList(0.25),
                就让我自己走吧, Note.emptyNoteList(0.5), 别对我说, Note.emptyNoteList(1.25), 去成为谁的模样, Note.emptyNoteList(1), 未来不在, Note.emptyNoteList(0.25), 我本该拥有海洋, Note.emptyNoteList(1.25), 我本该拥有海洋, Note.emptyNoteList(1.25), 就让我自己走吧, Note.emptyNoteList(1.25), 不管会遇见什么Hello, Note.emptyNoteList(2),
                Note.emptyNoteList(1), 你可见过两片相同的树叶, Note.emptyNoteList(1), 人不可复写, Note.emptyNoteList(2), 生命是原创的情节, Note.emptyNoteList(2),
                去问明天渴望怎样一张脸, Note.emptyNoteList(1), 它说是少年, Note.emptyNoteList(2), 它说和我一样毫无经验,
                不懂, Note.emptyNoteList(2.5), 是否, Note.emptyNoteList(2.5), 多久, Note.emptyNoteList(0.75), 去爱天空怎能害怕坠落, Note.emptyNoteList(1),
                人生中的考场, 我会勇敢地给出回答, 亲手署名吧, 有时也会考砸不抄谁的答案, Note.emptyNoteList(0.5),
                挥手告别吧, 记得二十岁流着泪的笑脸, Note.emptyNoteList(0.5), 卡关, Note.emptyNoteList(0.5), 借来加血加防, Note.emptyNoteList(0.25),
                就让我自己走吧, Note.emptyNoteList(1.5), 我的球鞋, Note.emptyNoteList(1.5), 我的暴雪, Note.emptyNoteList(1.5), 要去见所有我喜欢的一切, Note.emptyNoteList(0.25),
                就让我自己走吧, Note.emptyNoteList(0.5), 别对我说, Note.emptyNoteList(1.25), 去成为谁的模样, Note.emptyNoteList(1), 未来不在, Note.emptyNoteList(0.25), 我本该拥有海洋, Note.emptyNoteList(1.25), 我本该拥有海洋, Note.emptyNoteList(1.25), 就让我自己走吧, Note.emptyNoteList(1.25), 不管会遇见什么, Note.emptyNoteList(1.25), 我本该拥有海洋, Note.emptyNoteList(1.25), 我本该拥有海洋, Note.emptyNoteList(1.25), 就让我自己走吧, Note.emptyNoteList(1.25), 不管答案是什么Hello,
                Note.emptyNoteList(4.25), 我们都拥有海洋收尾, Note.emptyNoteList(3)
            );
            return buildMusicTrack(melodyStructure, pace, instrument);
        }
    }

    // ======================================================================
    // |                        和声 (Harmony) 声部                        |
    // ======================================================================
    public static class Harmony implements MusicDraft {

        // --- 和声乐句定义 ---
        public static final Note[] 让我选择 = {
            Note.emptyNote(0.25), Note.quarterNote(low[6]), Note.quarterNote(medium[3]),
            Note.emptyNote(0.5), Note.quarterNote(low[6]), Note.quarterNote(medium[2]),
        };
        public static final Note[] 长奔跑的脚踝到底是为什么 = {
            Note.quarterNote(low[6]), Note.quarterNote(medium[3]), Note.emptyNote(0.5), Note.halfNote(low[6]),
            Note.halfNote(medium[2]), Note.quarterNote(medium[1]), Note.halfNote(low[7]), Note.quarterNote(low[7]),
            Note.quarterNote(medium[1]), Note.quarterNote(medium[2]), Note.dottedNote1_5(medium[2]),
            Note.quarterNote(medium[1] + 1), new Note(medium[3], 1.25),
        };
        public static final Note[] 只有岸没有海 = {
            Note.quarterNote(low[6]), Note.quarterNote(medium[3]), Note.emptyNote(0.5),
            Note.quarterNote(medium[5]), Note.dottedNote0_75(medium[2]),
            Note.quarterNote(medium[3]), Note.quarterNote(medium[2]),
        };
        public static final Note[] 没有悟空 = {
            Note.quarterNote(medium[2]), Note.dottedNote0_75(medium[3]),
            Note.quarterNote(medium[4]), Note.quarterNote(medium[5]),
        };
        public static final Note[] 石头 = { Note.quarterNote(low[7]), Note.dottedNote0_75(medium[1]) };
        public static final Note[] 没有 = 石头;
        public static final Note[] 所以 = 石头;
        public static final Note[] 穿着球鞋 = {
            Note.halfNote(medium[1]), Note.emptyNote(0.5), Note.halfNote(medium[2]), Note.emptyNote(0.5),
            Note.halfNote(medium[3]), Note.emptyNote(0.5), Note.halfNote(medium[5]), Note.emptyNote(0.5),
        };
        public static final Note[] 迎着暴雪 = 穿着球鞋;
        public static final Note[] 朝着山野 = 穿着球鞋;
        public static final Note[] 所有我喜欢的一切 = {
            Note.quarterNote(medium[5]), Note.quarterNote(medium[5]), Note.quarterNote(medium[5]),
            Note.quarterNote(medium[5]), Note.quarterNote(medium[6]), Note.quarterNote(medium[5]),
            Note.quarterNote(medium[4]), Note.quarterNote(medium[3]),
        };
        public static final Note[] 哪一代 = { Note.quarterNote(medium[3]), Note.quarterNote(medium[5]), new Note(medium[5], 1.25) };
        public static final Note[] 什么浪 = { Note.quarterNote(medium[3]), Note.quarterNote(medium[4]), new Note(medium[5], 1.25) };
        public static final Note[] 都不是 = 什么浪;
        public static final Note[] 我的模样 = { Note.quarterNote(medium[6]), Note.quarterNote(medium[7]), Note.quarterNote(high[1]), Note.quarterNote(high[1]) };
        public static final Note[] 未来不在沙滩上 = {
            Note.quarterNote(medium[5]), Note.quarterNote(medium[3]), Note.quarterNote(medium[4]),
            Note.halfNote(medium[5]), Note.quarterNote(medium[3]), Note.quarterNote(medium[4]), new Note(medium[5], 1.25),
        };
        public static final Note[] 孤岛极光 = 穿着球鞋;
        public static final Note[] 虚拟城邦 = 穿着球鞋;
        public static final Note[] 星球流浪 = 穿着球鞋;
        public static final Note[] HelloHelloHello = {
            Note.quarterNote(medium[4]), Note.dottedNote0_75(medium[3]),
            Note.quarterNote(medium[6]), Note.dottedNote0_75(medium[5]),
            Note.quarterNote(high[2]), new Note(high[1], 1.25)
        };
        public static final Note[] 唔 = { Note.fullNote(medium[1]), Note.fullNote(medium[3]), };
        public static final Note[] 天高地厚 = 让我选择;
        public static final Note[] 是短暂的自由 = 只有岸没有海;
        public static final Note[] 像风筝去爱天空怎能害怕坠落 = {
            Note.quarterNote(low[6]), Note.quarterNote(medium[3]), Note.emptyNote(0.5), Note.halfNote(low[6]),
            Note.halfNote(medium[2]), Note.quarterNote(medium[1]), Note.halfNote(low[7]), Note.quarterNote(low[7]),
            Note.quarterNote(medium[1]), Note.quarterNote(medium[2]), Note.dottedNote1_5(medium[2]),
            Note.quarterNote(medium[1] + 1), new Note(medium[3], 1.25),
        };
        public static final Note[] 前路 = 所以;
        public static final Note[] 借来 = 所以;
        public static final Note[] 加血加防 = 没有悟空;
        public static final Note[] 我将走向 = 穿着球鞋;
        public static final Note[] 无垠远方 = 穿着球鞋;
        public static final Note[] 我不遗忘 = 穿着球鞋;

        @Override
        public Music getMusic(int pace) {
            return getMusic(pace, GMInstruments.ENSEMBLE_STRING_1); // 和声默认使用弦乐
        }
        
        public Music getMusic(int pace, int instrument) {
            List<Note[]> harmonyStructure = Arrays.asList(
                Note.emptyNoteList(4), Note.emptyNoteList(8*4), Note.emptyNoteList(0.5), 让我选择, Note.emptyNoteList(2), Note.emptyNoteList(0.5), 只有岸没有海, Note.emptyNoteList(1), Note.emptyNoteList(0.5), 长奔跑的脚踝到底是为什么, Note.emptyNoteList(1),
                Melody.为剧烈的心动, Melody.跑起来去见喜欢的我, Note.emptyNoteList(4), Melody.怎么判断有用谁来规定无用, Note.emptyNoteList(0.5),
                Melody.完美的旅程, Melody.为何每一站是一样的路牌, 没有, Note.emptyNoteList(1), 所以, Note.emptyNoteList(1), 没有悟空, Note.emptyNoteList(2),
                穿着球鞋, 迎着暴雪, 朝着山野, 所有我喜欢的一切, Note.emptyNoteList(2),
                Note.emptyNoteList(0.25), 哪一代, Note.emptyNoteList(0.25), 什么浪, Note.emptyNoteList(0.25), 都不是, 我的模样, Note.emptyNoteList(1), 未来不在沙滩上, Note.emptyNoteList(1), 孤岛极光, 虚拟城邦, 星球流浪, Note.emptyNoteList(0.5), HelloHelloHello,
                Note.emptyNoteList(8), Note.emptyNoteList(1), Note.emptyNoteList(0.25), 唔, Melody.生命是原创的情节, Note.emptyNoteList(2), Melody.去问明天渴望怎样一张脸, Note.emptyNoteList(1), Melody.它说是少年, Note.emptyNoteList(2), Melody.它说和我一样毫无经验, Note.emptyNoteList(0.5), Note.emptyNoteList(0.5),
                天高地厚, Note.emptyNoteList(2), Note.emptyNoteList(0.5), 是短暂的自由, Note.emptyNoteList(1.5), 像风筝去爱天空怎能害怕坠落, Note.emptyNoteList(1),
                Melody.人生中的考场, Melody.我会勇敢地给出回答, Melody.亲手署名吧, Melody.有时也会考砸不抄谁的答案, Note.emptyNoteList(0.5),
                Melody.挥手告别吧, Melody.记得二十岁流着泪的笑脸, 前路, Note.emptyNoteList(0.5), 借来, Note.emptyNoteList(1), 加血加防, Note.emptyNoteList(2),
                穿着球鞋, 迎着暴雪, 朝着山野, 所有我喜欢的一切, Note.emptyNoteList(2),
                Note.emptyNoteList(0.25), 哪一代, Note.emptyNoteList(0.25), 什么浪, Note.emptyNoteList(0.25), 都不是, 我的模样, Note.emptyNoteList(1), 未来不在沙滩上, Note.emptyNoteList(0.5),
                孤岛极光, 虚拟城邦, 星球流浪, 我将走向, 无垠远方, 我不遗忘, 我的模样, Note.emptyNoteList(1), HelloHelloHello
            );
            return buildMusicTrack(harmonyStructure, pace, instrument);
        }
    }

    // ======================================================================
    // |                     私有辅助方法 (Private Helper)                  |
    // ======================================================================
    
    /**
     * 根据乐句结构、速度和乐器构建一个Music对象。
     * 这个方法被 Melody 和 Harmony 内部类共享。
     */
    private static Music buildMusicTrack(List<Note[]> structure, int pace, int instrument) {
        ArrayList<Note> allNotes = new ArrayList<>();
        
        for (Note[] phrase : structure) {
            for (Note note : phrase) {
                // 创建一个全新的Note对象，为其赋予指定的乐器
                allNotes.add(new Note(note.scale(), note.fraction(), note.velocity(), instrument));
            }
        }

        // 为了简化，我们将整个音轨看作一个大的Lyric
        ArrayList<Lyric> lyrics = new ArrayList<>();
        lyrics.add(new Lyric(allNotes));
        
        return new Music(lyrics, pace);
    }
}
