package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 歌词类
 */
public class Lyric implements Iterable<Playable>, Cloneable {
    private ArrayList<Playable> items;
    private String text;

    public Lyric(ArrayList<Playable> items) {
        this(items, null);
    }

    public Lyric(ArrayList<Playable> items, String text) {
        this.items = items;
        this.text = text;
    }

    // public void unifyInstrument(int instrument) {
    //     for (Playable note : this) {
    //         note.setInstrument(instrument);
    //     }
    // }

    public void unifyVelocity(int velocity) {
        for (Playable item : this) {
            item.setVelocity(velocity);
        }
    }

    /**
     * 创建并返回一个包含移调后所有音符的新乐句。
     * 
     * @param value 需要提升的半音数量
     * @return 一个全新的 Lyric 对象
     */
    public Lyric transposed(int value) {
        ArrayList<Playable> transposedPlayables = new ArrayList<>();
        for (Playable item : this) {
            transposedPlayables.add(item.transposed(value));
        }
        // 返回一个包含新音符列表的新 Lyric 实例
        return new Lyric(transposedPlayables, this.text);
    }

    public static Lyric fromPlayables(String text, Playable... manyPlayables) {
        Lyric lyric = new Lyric(new ArrayList<>(), text);
        for (Playable item : manyPlayables) {
            lyric.items.add(item);
        }
        return lyric;
    };

    public static Lyric fromPlayables(Playable... manyPlayables) {
        return fromPlayables(null, manyPlayables);
    }

    /**
     * 曲调一样，词不一样
     */
    public static Lyric fromLyricOfSameTone(String text, Lyric lyric) {
        return new Lyric(lyric.items, text);
    }

    public static Lyric fromLyricOfSameTone(Lyric lyric) {
        return new Lyric(lyric.items);
    }

    public void show() {
        if (this.text != null) {
            System.out.println(text);
        }
    }

    @Override
    public Iterator<Playable> iterator() {
        return new LyricIterator();
    }

    private class LyricIterator implements Iterator<Playable> {
        private int index;

        public LyricIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < items.size();
        }

        @Override
        public Playable next() {
            Playable nextPlayable = items.get(index);
            index++;
            return nextPlayable;

        }
    }

    @Override
    public Lyric clone() {
        try {
            Lyric clonedLyric = (Lyric) super.clone();

            // 深拷贝 notes 列表
            clonedLyric.items = new ArrayList<>();
            for (Playable note : this.items) {
                clonedLyric.items.add(note.clone());
            }

            return clonedLyric;
        } catch (CloneNotSupportedException e) {
            // 这不应该发生，因为我们实现了 Cloneable
            throw new AssertionError();
        }
    }

    /**
     * 为了防止和声重复播放主旋律的歌词，设计了一个函数，把一句歌词的音符保留，歌词拿掉。
     * 
     * @return 旋律相同、没有词的歌词
     */
    public Lyric toEmptyText() {
        return new Lyric(this.items);
    }
}
