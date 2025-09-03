package model;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 音乐类
 * 包含：这首歌所有的歌词、歌曲速度
 */
public class Music implements Iterable<Lyric>, Cloneable {
    private ArrayList<Lyric> lyrics;
    private int pace;
    private String title;   // 歌曲名
    private String singer;  // 歌手

    public Music(ArrayList<Lyric> lyrics, int pace) {
        this.lyrics = lyrics;
        this.pace = pace;
        this.setNoteDuration();     // 设置每个音符的时长
        // this.title = this.getClass().getName();     // 歌曲名默认为类名
        this.singer = null;
    }

    public String title() {
        return this.title;
    }

    public String singer() {
        return this.singer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSinger(String singer) {
        this.singer = singer;
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
    
    // 统一音量
    public void unifyVelocity(int velocity) {
        for (Lyric lyric : this) {
            for (Note note : lyric) {
                note.setVelocity(velocity);
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

    @Override
    public Music clone() {
        try {
            // 1. 调用 Object.clone() 创建一个浅拷贝。
            // 这会复制所有的基本类型字段（如此处的 pace）和对象引用。
            Music clonedMusic = (Music) super.clone();

            // 2. 为 lyrics 字段创建一个新的 ArrayList 实例，实现深拷贝。
            clonedMusic.lyrics = new ArrayList<>();

            // 3. 遍历原始列表中的每个 Lyric，克隆它们，并添加到新列表中。
            for (Lyric lyric : this.lyrics) {
                clonedMusic.lyrics.add(lyric.clone());
            }

            return clonedMusic;
        } catch (CloneNotSupportedException e) {
            // 这理论上不应该发生，因为 Music 类实现了 Cloneable 接口。
            // 使用 AssertionError 是一种常见的处理方式。
            throw new AssertionError();
        }
    }
} 
