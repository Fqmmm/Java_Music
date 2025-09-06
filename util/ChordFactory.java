package util;

import model.Chord;
import model.Note;

/**
 * 一个静态的和弦库 (Chord Library)，提供了创建常见和弦的便捷工厂方法。
 * 所有和弦创建方法都提供了重载，以支持默认、指定乐器、指定乐器和音量等多种调用方式。
 */
public final class ChordFactory {

    private ChordFactory() {}

    // --- 和弦构成的基本音程 (Intervals in semitones) ---
    private static final int MINOR_THIRD = 3;
    private static final int MAJOR_THIRD = 4;
    private static final int PERFECT_FIFTH = 7;
    private static final int DIMINISHED_FIFTH = 6;
    private static final int AUGMENTED_FIFTH = 8;
    private static final int MINOR_SEVENTH = 10;
    private static final int MAJOR_SEVENTH = 11;

    // ======================================================================
    // |                         大三和弦 (Major Triad)                     |
    // ======================================================================
    public static Chord majorTriad(int rootScale, double fraction, int pace) {
        return Chord.fromNotes(pace,
            new Note(rootScale, fraction),
            new Note(rootScale + MAJOR_THIRD, fraction),
            new Note(rootScale + PERFECT_FIFTH, fraction)
        );
    }
    public static Chord majorTriad(int rootScale, double fraction, int pace, int instrument) {
        return Chord.fromNotes(pace,
            new Note(rootScale, fraction, instrument),
            new Note(rootScale + MAJOR_THIRD, fraction, instrument),
            new Note(rootScale + PERFECT_FIFTH, fraction, instrument)
        );
    }
    public static Chord majorTriad(int rootScale, double fraction, int pace, int instrument, int velocity) {
        return Chord.fromNotes(pace,
            new Note(rootScale, fraction, velocity, instrument),
            new Note(rootScale + MAJOR_THIRD, fraction, velocity, instrument),
            new Note(rootScale + PERFECT_FIFTH, fraction, velocity, instrument)
        );
    }

    // ======================================================================
    // |                         小三和弦 (Minor Triad)                     |
    // ======================================================================
    public static Chord minorTriad(int rootScale, double fraction, int pace) {
        return Chord.fromNotes(pace,
            new Note(rootScale, fraction),
            new Note(rootScale + MINOR_THIRD, fraction),
            new Note(rootScale + PERFECT_FIFTH, fraction)
        );
    }
    public static Chord minorTriad(int rootScale, double fraction, int pace, int instrument) {
        return Chord.fromNotes(pace,
            new Note(rootScale, fraction, instrument),
            new Note(rootScale + MINOR_THIRD, fraction, instrument),
            new Note(rootScale + PERFECT_FIFTH, fraction, instrument)
        );
    }
    public static Chord minorTriad(int rootScale, double fraction, int pace, int instrument, int velocity) {
        return Chord.fromNotes(pace,
            new Note(rootScale, fraction, velocity, instrument),
            new Note(rootScale + MINOR_THIRD, fraction, velocity, instrument),
            new Note(rootScale + PERFECT_FIFTH, fraction, velocity, instrument)
        );
    }

    // ======================================================================
    // |                         减三和弦 (Diminished Triad)                |
    // ======================================================================
    public static Chord diminishedTriad(int rootScale, double fraction, int pace) {
        return Chord.fromNotes(pace,
            new Note(rootScale, fraction),
            new Note(rootScale + MINOR_THIRD, fraction),
            new Note(rootScale + DIMINISHED_FIFTH, fraction)
        );
    }
    public static Chord diminishedTriad(int rootScale, double fraction, int pace, int instrument) {
        return Chord.fromNotes(pace,
            new Note(rootScale, fraction, instrument),
            new Note(rootScale + MINOR_THIRD, fraction, instrument),
            new Note(rootScale + DIMINISHED_FIFTH, fraction, instrument)
        );
    }
    public static Chord diminishedTriad(int rootScale, double fraction, int pace, int instrument, int velocity) {
        return Chord.fromNotes(pace,
            new Note(rootScale, fraction, velocity, instrument),
            new Note(rootScale + MINOR_THIRD, fraction, velocity, instrument),
            new Note(rootScale + DIMINISHED_FIFTH, fraction, velocity, instrument)
        );
    }
    
    // ======================================================================
    // |                         增三和弦 (Augmented Triad)                 |
    // ======================================================================
    public static Chord augmentedTriad(int rootScale, double fraction, int pace) {
        return Chord.fromNotes(pace,
            new Note(rootScale, fraction),
            new Note(rootScale + MAJOR_THIRD, fraction),
            new Note(rootScale + AUGMENTED_FIFTH, fraction)
        );
    }
    public static Chord augmentedTriad(int rootScale, double fraction, int pace, int instrument) {
        return Chord.fromNotes(pace,
            new Note(rootScale, fraction, instrument),
            new Note(rootScale + MAJOR_THIRD, fraction, instrument),
            new Note(rootScale + AUGMENTED_FIFTH, fraction, instrument)
        );
    }
    public static Chord augmentedTriad(int rootScale, double fraction, int pace, int instrument, int velocity) {
        return Chord.fromNotes(pace,
            new Note(rootScale, fraction, velocity, instrument),
            new Note(rootScale + MAJOR_THIRD, fraction, velocity, instrument),
            new Note(rootScale + AUGMENTED_FIFTH, fraction, velocity, instrument)
        );
    }

    // ======================================================================
    // |                         属七和弦 (Dominant 7th)                    |
    // ======================================================================
    public static Chord dominant7th(int rootScale, double fraction, int pace) {
        return Chord.fromNotes(pace,
            new Note(rootScale, fraction),
            new Note(rootScale + MAJOR_THIRD, fraction),
            new Note(rootScale + PERFECT_FIFTH, fraction),
            new Note(rootScale + MINOR_SEVENTH, fraction)
        );
    }
    public static Chord dominant7th(int rootScale, double fraction, int pace, int instrument) {
        return Chord.fromNotes(pace,
            new Note(rootScale, fraction, instrument),
            new Note(rootScale + MAJOR_THIRD, fraction, instrument),
            new Note(rootScale + PERFECT_FIFTH, fraction, instrument),
            new Note(rootScale + MINOR_SEVENTH, fraction, instrument)
        );
    }
    public static Chord dominant7th(int rootScale, double fraction, int pace, int instrument, int velocity) {
        return Chord.fromNotes(pace,
            new Note(rootScale, fraction, velocity, instrument),
            new Note(rootScale + MAJOR_THIRD, fraction, velocity, instrument),
            new Note(rootScale + PERFECT_FIFTH, fraction, velocity, instrument),
            new Note(rootScale + MINOR_SEVENTH, fraction, velocity, instrument)
        );
    }

    // ======================================================================
    // |                         大七和弦 (Major 7th)                       |
    // ======================================================================
    public static Chord major7th(int rootScale, double fraction, int pace) {
        return Chord.fromNotes(pace,
            new Note(rootScale, fraction),
            new Note(rootScale + MAJOR_THIRD, fraction),
            new Note(rootScale + PERFECT_FIFTH, fraction),
            new Note(rootScale + MAJOR_SEVENTH, fraction)
        );
    }
    public static Chord major7th(int rootScale, double fraction, int pace, int instrument) {
        return Chord.fromNotes(pace,
            new Note(rootScale, fraction, instrument),
            new Note(rootScale + MAJOR_THIRD, fraction, instrument),
            new Note(rootScale + PERFECT_FIFTH, fraction, instrument),
            new Note(rootScale + MAJOR_SEVENTH, fraction, instrument)
        );
    }
    public static Chord major7th(int rootScale, double fraction, int pace, int instrument, int velocity) {
        return Chord.fromNotes(pace,
            new Note(rootScale, fraction, velocity, instrument),
            new Note(rootScale + MAJOR_THIRD, fraction, velocity, instrument),
            new Note(rootScale + PERFECT_FIFTH, fraction, velocity, instrument),
            new Note(rootScale + MAJOR_SEVENTH, fraction, velocity, instrument)
        );
    }

    // ======================================================================
    // |                         小七和弦 (Minor 7th)                       |
    // ======================================================================
    public static Chord minor7th(int rootScale, double fraction, int pace) {
        return Chord.fromNotes(pace,
            new Note(rootScale, fraction),
            new Note(rootScale + MINOR_THIRD, fraction),
            new Note(rootScale + PERFECT_FIFTH, fraction),
            new Note(rootScale + MINOR_SEVENTH, fraction)
        );
    }
    public static Chord minor7th(int rootScale, double fraction, int pace, int instrument) {
        return Chord.fromNotes(pace,
            new Note(rootScale, fraction, instrument),
            new Note(rootScale + MINOR_THIRD, fraction, instrument),
            new Note(rootScale + PERFECT_FIFTH, fraction, instrument),
            new Note(rootScale + MINOR_SEVENTH, fraction, instrument)
        );
    }
    public static Chord minor7th(int rootScale, double fraction, int pace, int instrument, int velocity) {
        return Chord.fromNotes(pace,
            new Note(rootScale, fraction, velocity, instrument),
            new Note(rootScale + MINOR_THIRD, fraction, velocity, instrument),
            new Note(rootScale + PERFECT_FIFTH, fraction, velocity, instrument),
            new Note(rootScale + MINOR_SEVENTH, fraction, velocity, instrument)
        );
    }
}