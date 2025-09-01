
public interface MusicDraft {
    public static final int[] low = {0, 48, 50, 52, 53, 55, 57, 59};
    public static final int[] medium = {0, 60, 62, 64, 65, 67, 69, 71};
    public static final int[] high = {0, 72, 74, 76, 77, 79, 81, 83};

    // public static final Note[] 空四拍 = Note.emptyNoteList(4);
    // public static final Note[] 空两拍 = Note.emptyNoteList(2);
    // public static final Note[] 空一拍 = Note.emptyNoteList(1);
    // public static final Note[] 空半拍 = Note.emptyNoteList(0.5);
    // public static final Note[] 空四分之一拍 = Note.emptyNoteList(0.25);

    public static final Lyric 空四拍 = Lyric.fromNotes(null, new Note(0, 4));
    public static final Lyric 空两拍 = Lyric.fromNotes(null, new Note(0, 2));
    public static final Lyric 空一拍 = Lyric.fromNotes(null, new Note(0, 1));
    public static final Lyric 空半拍 = Lyric.fromNotes(null, new Note(0, 0.5));
    public static final Lyric 空四分之一拍 = Lyric.fromNotes(null, new Note(0, 0.25));

    Music getMusic(int pace);
}
