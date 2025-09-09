package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import constant.Settings;

/**
 * Chord 类代表一个和弦，即一组同时发声的音符。
 */
public class Chord implements Playable {
    
    protected List<Note> notes;
    protected double fraction;
    protected int duration; // Chord 自己持有统一的播放时长
    protected int velocity;

    /**
     * Chord 类的核心构造函数。
     * @param notes 组成和弦的音符列表
     */
    public Chord(List<Note> notes) {
        this(notes, shortestFraction(notes), Settings.velocity);
        
    }

    public Chord(List<Note> notes, double fraction) {
        this(notes, fraction, Settings.velocity);
    }

    public Chord(List<Note> notes, double fraction, int velocity) {
        this.notes = notes;
        this.fraction = fraction;
        this.velocity = velocity;
        this.duration = 0;      // 占位符
    }

    @Override
    public double fraction() {
        return this.fraction;
    }

    @Override
    public int velocity() {
        return this.velocity;
    }

    @Override
    public int duration() {
        return this.duration;
    }

    @Override
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
    
    @Override
    public void setDuration(int duration) {
        this.duration = duration;
        for (Note note : this.notes) {
            note.setDuration(duration);
        }
    }

    @Override
    public void setDurationFromPace(int pace) {
        this.setDuration((int) (this.fraction() * 60 / pace * 1000));
    }

    /**
     * 辅助方法：获取notes里fraction最小的一个
     * @param notes
     * @return 最小的fraction
     */
    private static double shortestFraction(List<Note> notes) {
        double shortestFraction = Double.POSITIVE_INFINITY;
        if (notes != null) {
            for (Note note : notes) {
                if (note != null && note.fraction() < shortestFraction) {
                    shortestFraction = note.fraction();
                }
            }
        }
        return shortestFraction;
    }

    /**
     * 便捷的静态工厂方法，用于从一系列 Note 中创建和弦。
     * @param newNotes 组成和弦的音符
     * @return 一个新的 Chord 对象
     */
    public static Chord fromNotes(Note... newNotes) {
        return new Chord(new ArrayList<>(Arrays.asList(newNotes)));
    }

    public static Chord fromNotes(double fraction, Note... newNotes) {
        return new Chord(new ArrayList<>(Arrays.asList(newNotes)), fraction);
    }
    
    /**
     * 返回一个和弦内音符的不可修改视图。
     */
    public List<Note> getNotes() {
        return this.notes;
    }
    
    /**
     * 创建并返回一个当前和弦经过移调（升/降调）后的新实例。
     * 这个方法是不可变的，它不会修改原始和弦。
     * @param value 需要提升的半音数量
     * @return 一个全新的、经过移调的 Chord 对象
     */
    @Override
    public Chord transposed(int value) {
        ArrayList<Note> transposedNotes = new ArrayList<>();
        for (Note note : this.notes) {
            transposedNotes.add(note.transposed(value));
        }
        return new Chord(transposedNotes, this.fraction, this.velocity);
    }

    public void showDebugInfo() {
        int i = 1;
        System.out.println("duration:" + duration);
        for (Note note : notes) {
            System.out.println("第" + i + "个Note");
            note.showDebugInfo();
            i++;
            System.out.println();
        }
    }

    @Override
    public Chord clone() {
        ArrayList<Note> newNotes = new ArrayList<>();
        for (Note note : notes) {
            newNotes.add(note);
        }
        return new Chord(newNotes, this.fraction, this.velocity);
    }
}