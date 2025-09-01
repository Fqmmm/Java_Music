import java.util.ArrayList;
import java.util.Iterator;

public class Music implements Iterable<Lyric> {
    private ArrayList<Lyric> lyrics;
    private int pace;

    public Music(ArrayList<Lyric> lyrics, int pace) {
        this.lyrics = lyrics;
        this.pace = pace;
        this.setNoteDuration();     // 设置每个音符的时长
    }

    public static Music fromLyrics(int pace, Lyric... manyLyrics) {
        Music music = new Music(new ArrayList<>(), pace);
        for (Lyric lyric : manyLyrics) {
            music.lyrics.add(lyric);
        }
        music.setNoteDuration();    //  在这里设置每个音符的时长
        return music;
    }

    // 设置每个音符的时长
    public void setNoteDuration() {
        for (Lyric lyric : this.lyrics) {
            for (Note note : lyric) {
                note.setDuration((int) (note.fraction() * 60 / this.pace * 1000));
            }
        }
    }

    // 统一乐器
    public void unifyInstrument(int instrument) {
        for (Lyric lyric : lyrics) {
            for (Note note : lyric) {
                note.setInstrument(instrument);
            }
        }
    }
    
    public Iterator<Lyric> iterator() {
        return new MusicIterator();
    }

    private class MusicIterator implements Iterator<Lyric> {
        private int index;

        public MusicIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < lyrics.size();
        }

        @Override
        public Lyric next() {
            Lyric nextLyric = lyrics.get(index);
            index++;
            return nextLyric;
        }
        
    }

    public void show() {
        for (Lyric lyric : lyrics) {
            lyric.show();
        }
    }
} 
