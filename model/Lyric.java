package model;
import java.util.ArrayList;
import java.util.Iterator;

public class Lyric implements Iterable<Note> {
    private ArrayList<Note> notes;
    private String words;   
    public Lyric(ArrayList<Note> notes) {
        this(notes, null);
    }

    public Lyric(ArrayList<Note> notes, String words) {
        this.notes = notes;
        this.words = words;
    }

    public static Lyric fromNotes(String words, Note... manyNotes) {
        Lyric lyric = new Lyric(new ArrayList<>(), words);
        for (Note note : manyNotes) {
            lyric.notes.add(note);
        }
        return lyric;
    };

    /**
     * 曲调一样，词不一样
     */
    public static Lyric fromLyricOfSameTone(String words, Lyric lyric) {
        return new Lyric(lyric.notes, words);
    }

    public void show() {
        if (this.words != null) {
            System.out.println(words);
        }
    }

    @Override
    public Iterator<Note> iterator() {
        return new LyricIterator();
    }

    private class LyricIterator implements Iterator<Note> {
        private int index;
        
        public LyricIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < notes.size();
        }

        @Override
        public Note next() {
            Note nextNote = notes.get(index);
            index++;
            return nextNote;
            
        }
    }
}
