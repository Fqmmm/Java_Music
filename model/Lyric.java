package model;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 歌词类
 * 包含：这句歌词的音符和歌词本身（字符串）
 */
public class Lyric implements Iterable<Note>, Cloneable {
    private ArrayList<Note> notes;
    private String words;   
    public Lyric(ArrayList<Note> notes) {
        this(notes, null);
    }

    public Lyric(ArrayList<Note> notes, String words) {
        this.notes = notes;
        this.words = words;
    }

    public void unifyInstrument(int instrument) {
        for (Note note : this) {
            note.setInstrument(instrument);
        }
    }

    public void unifyVelocity(int velocity) {
        for (Note note : this) {
            note.setVelocity(velocity);
        }
    }
    
    public static Lyric fromNotes(String words, Note... manyNotes) {
        Lyric lyric = new Lyric(new ArrayList<>(), words);
        for (Note note : manyNotes) {
            lyric.notes.add(note);
        }
        return lyric;
    };

    public static Lyric fromNotes(Note... manyNotes) {
        return fromNotes(null, manyNotes);
    }

    /**
     * 曲调一样，词不一样
     */
    public static Lyric fromLyricOfSameTone(String words, Lyric lyric) {
        return new Lyric(lyric.notes, words);
    }

    public static Lyric fromLyricOfSameTone(Lyric lyric) {
        return new Lyric(lyric.notes);
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

    @Override
    public Lyric clone() {
        try {
            Lyric clonedLyric = (Lyric) super.clone();
            
            // 深拷贝 notes 列表
            clonedLyric.notes = new ArrayList<>();
            for (Note note : this.notes) {
                clonedLyric.notes.add(note.clone());
            }

            return clonedLyric;
        } catch (CloneNotSupportedException e) {
            // 这不应该发生，因为我们实现了 Cloneable
            throw new AssertionError();
        }
    }

    /**
     * 为了防止和声重复播放主旋律的歌词，设计了一个函数，把一句歌词的音符保留，歌词拿掉。
     * @return  旋律相同、没有词的歌词
     */
    public Lyric toEmptyWords() {
        return new Lyric(this.notes);
    }
}
