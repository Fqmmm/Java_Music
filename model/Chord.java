package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Chord 类代表一个和弦，即一组同时发声的音符。
 * 
 * 这是一个不可变 (Immutable) 类。一旦一个 Chord 对象被创建，它的内容就不会改变。
 * 它会在构造时，根据其内部音符的最短时值 (fraction) 和传入的速度 (pace)，
 * 计算并持有自己应该播放的持续时间 (duration)。
 */
public class Chord implements Cloneable {
    
    // 字段设为 final，确保和弦在创建后其内容不被改变。
    private final List<Note> notes;
    private final int duration; // Chord 自己持有统一的播放时长
    private final int pace;

    /**
     * Chord 类的核心构造函数。
     * @param notes 组成和弦的音符列表
     * @param pace  用于计算时长的速度 (BPM)
     */
    public Chord(List<Note> notes, int pace) {
        this.pace = pace;
        this.notes = notes;
        double shortestFraction = shortestFraction();
        
        // 根据最短时值和速度，计算并存储自己的 duration
        if (shortestFraction == Double.POSITIVE_INFINITY || shortestFraction <= 0) {
            this.duration = 0; // 如果没有有效音符或时值为0，则时长为0
        } else {
            this.duration = (int) (shortestFraction * 60.0 / pace * 1000);
        }

        for (Note note : notes) {
            note.setDuration(duration);
        }
    }

    private double shortestFraction() {
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
     * @param pace 速度 (BPM)
     * @param newNotes 组成和弦的音符
     * @return 一个新的 Chord 对象
     */
    public static Chord fromNotes(int pace, Note... newNotes) {
        return new Chord(new ArrayList<>(Arrays.asList(newNotes)), pace);
    }
    
    /**
     * 返回一个和弦内音符的不可修改视图。
     */
    public List<Note> getNotes() {
        return this.notes;
    }

    /**
     * 返回这个和弦应该播放的统一持续时间（毫秒）。
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * 创建并返回一个当前和弦经过移调（升/降调）后的新实例。
     * 这个方法是不可变的，它不会修改原始和弦。
     * @param value 需要提升的半音数量
     * @return 一个全新的、经过移调的 Chord 对象
     */
    public Chord transposed(int value) {
        ArrayList<Note> transposedNotes = new ArrayList<>();
        for (Note note : this.notes) {
            transposedNotes.add(note.transposed(value));
        }
        return new Chord(transposedNotes, this.pace);
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
        return new Chord(newNotes, pace);
    }
}