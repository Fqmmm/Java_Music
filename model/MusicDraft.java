package model;

/**
 * MusicDraft接口定义了写一个乐谱所需要的常量
 */
public interface MusicDraft {
    public static final int[] low = {0, 48, 50, 52, 53, 55, 57, 59};
    public static final int[] medium = {0, 60, 62, 64, 65, 67, 69, 71};
    public static final int[] high = {0, 72, 74, 76, 77, 79, 81, 83};

    public static final Lyric 空四拍 = Lyric.fromNotes(new Note(0, 4));
    public static final Lyric 空两拍 = Lyric.fromNotes(new Note(0, 2));
    public static final Lyric 空一拍 = Lyric.fromNotes(new Note(0, 1));
    public static final Lyric 空半拍 = Lyric.fromNotes(new Note(0, 0.5));
    public static final Lyric 空四分之一拍 = Lyric.fromNotes(new Note(0, 0.25));

    default Music getMusic(int pace) {
        return getMusic(pace, -1);
    }

    default Music getMusic(int pace, int instrument) {
        return getMusic(pace, instrument, -1);
    }

    Music getMusic(int pace, int instrument, int velocity);
}
