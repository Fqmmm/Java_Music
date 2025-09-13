package util;

import constant.Settings;
import drafts.MusicDraft;
import model.Chord;
import model.Note;

/**
 * 一个静态的和弦库 (Chord Library)，提供了创建常见和弦的便捷工厂方法。
 * 所有和弦创建方法都提供了重载，以支持默认、指定乐器、指定乐器和音量等多种调用方式。
 */
public final class ChordFactory {

    private ChordFactory() {
    }

    // --- 和弦构成的基本音程 (Intervals in semitones) ---
    private static final int MINOR_THIRD = 3; // 小三度
    private static final int MAJOR_THIRD = 4; // 大三度
    private static final int PERFECT_FIFTH = 7; // 纯五度
    private static final int DIMINISHED_FIFTH = 6; // 减五度
    private static final int MINOR_SIXTH = 8; // 小六度
    private static final int MINOR_SEVENTH = 10; // 小七度
    private static final int MAJOR_SEVENTH = 11; // 大七度

    // ======================================================================
    // | 大三和弦 (Major Triad) |
    // ======================================================================
    public static Chord majorTriad(int rootScale, double fraction) {
        return Chord.fromNotes(fraction,
                new Note(rootScale, fraction),
                new Note(rootScale + MAJOR_THIRD, fraction),
                new Note(rootScale + PERFECT_FIFTH, fraction));
    }

    public static Chord majorTriad(int rootScale, double fraction, int velocity) {
        return Chord.fromNotes(fraction,
                new Note(rootScale, fraction, velocity),
                new Note(rootScale + MAJOR_THIRD, fraction, velocity),
                new Note(rootScale + PERFECT_FIFTH, fraction, velocity));
    }

    // ======================================================================
    // | 小三和弦 (Minor Triad) |
    // ======================================================================
    public static Chord minorTriad(int rootScale, double fraction) {
        return Chord.fromNotes(fraction,
                new Note(rootScale, fraction),
                new Note(rootScale + MINOR_THIRD, fraction),
                new Note(rootScale + PERFECT_FIFTH, fraction));
    }

    public static Chord minorTriad(int rootScale, double fraction, int velocity) {
        return Chord.fromNotes(fraction,
                new Note(rootScale, fraction, velocity),
                new Note(rootScale + MINOR_THIRD, fraction, velocity),
                new Note(rootScale + PERFECT_FIFTH, fraction, velocity));
    }

    // ======================================================================
    // | 减三和弦 (Diminished Triad) |
    // ======================================================================
    public static Chord diminishedTriad(int rootScale, double fraction) {
        return Chord.fromNotes(fraction,
                new Note(rootScale, fraction),
                new Note(rootScale + MINOR_THIRD, fraction),
                new Note(rootScale + DIMINISHED_FIFTH, fraction));
    }

    public static Chord diminishedTriad(int rootScale, double fraction, int velocity) {
        return Chord.fromNotes(fraction,
                new Note(rootScale, fraction, velocity),
                new Note(rootScale + MINOR_THIRD, fraction, velocity),
                new Note(rootScale + DIMINISHED_FIFTH, fraction, velocity));
    }

    // ======================================================================
    // | 增三和弦 (Augmented Triad) |
    // ======================================================================
    public static Chord augmentedTriad(int rootScale, double fraction) {
        return Chord.fromNotes(fraction,
                new Note(rootScale, fraction),
                new Note(rootScale + MAJOR_THIRD, fraction),
                new Note(rootScale + MINOR_SIXTH, fraction));
    }

    public static Chord augmentedTriad(int rootScale, double fraction, int velocity) {
        return Chord.fromNotes(fraction,
                new Note(rootScale, fraction, velocity),
                new Note(rootScale + MAJOR_THIRD, fraction, velocity),
                new Note(rootScale + MINOR_SIXTH, fraction, velocity));
    }

    // ======================================================================
    // | 属七和弦 (Dominant 7th) |
    // ======================================================================
    public static Chord dominant7th(int rootScale, double fraction) {
        return Chord.fromNotes(fraction,
                new Note(rootScale, fraction),
                new Note(rootScale + MAJOR_THIRD, fraction),
                new Note(rootScale + PERFECT_FIFTH, fraction),
                new Note(rootScale + MINOR_SEVENTH, fraction));
    }

    public static Chord dominant7th(int rootScale, double fraction, int velocity) {
        return Chord.fromNotes(fraction,
                new Note(rootScale, fraction, velocity),
                new Note(rootScale + MAJOR_THIRD, fraction, velocity),
                new Note(rootScale + PERFECT_FIFTH, fraction, velocity),
                new Note(rootScale + MINOR_SEVENTH, fraction, velocity));
    }

    // ======================================================================
    // | 大七和弦 (Major 7th) |
    // ======================================================================
    public static Chord major7th(int rootScale, double fraction) {
        return Chord.fromNotes(fraction,
                new Note(rootScale, fraction),
                new Note(rootScale + MAJOR_THIRD, fraction),
                new Note(rootScale + PERFECT_FIFTH, fraction),
                new Note(rootScale + MAJOR_SEVENTH, fraction));
    }

    public static Chord major7th(int rootScale, double fraction, int velocity) {
        return Chord.fromNotes(fraction,
                new Note(rootScale, fraction, velocity),
                new Note(rootScale + MAJOR_THIRD, fraction, velocity),
                new Note(rootScale + PERFECT_FIFTH, fraction, velocity),
                new Note(rootScale + MAJOR_SEVENTH, fraction, velocity));
    }

    // ======================================================================
    // | 小七和弦 (Minor 7th) |
    // ======================================================================
    public static Chord minor7th(int rootScale, double fraction) {
        return Chord.fromNotes(fraction,
                new Note(rootScale, fraction),
                new Note(rootScale + MINOR_THIRD, fraction),
                new Note(rootScale + PERFECT_FIFTH, fraction),
                new Note(rootScale + MINOR_SEVENTH, fraction));
    }

    public static Chord minor7th(int rootScale, double fraction, int velocity) {
        return Chord.fromNotes(fraction,
                new Note(rootScale, fraction, velocity),
                new Note(rootScale + MINOR_THIRD, fraction, velocity),
                new Note(rootScale + PERFECT_FIFTH, fraction, velocity),
                new Note(rootScale + MINOR_SEVENTH, fraction, velocity));
    }

    // ======================================================================
    // | C大调音阶常用和弦 (C major diatonic chords) |
    // ======================================================================

    public static Chord C(double fraction, int velocity) {
        return majorTriad(MusicDraft.medium[1], fraction, velocity);
    }

    public static Chord C(double fraction) {
        return C(fraction, Settings.velocity);
    }

    public static Chord Dm(double fraction, int velocity) {
        return minorTriad(MusicDraft.medium[2], fraction, velocity);
    }

    public static Chord Dm(double fraction) {
        return Dm(fraction, Settings.velocity);
    }

    public static Chord Em(double fraction, int velocity) {
        return minorTriad(MusicDraft.medium[3], fraction, velocity);
    }

    public static Chord Em(double fraction) {
        return Em(fraction, Settings.velocity);
    }

    public static Chord F(double fraction, int velocity) {
        return majorTriad(MusicDraft.medium[4], fraction, velocity);
    }

    public static Chord F(double fraction) {
        return F(fraction, Settings.velocity);
    }

    public static Chord G(double fraction, int velocity) {
        return majorTriad(MusicDraft.medium[5], fraction, velocity);
    }

    public static Chord G(double fraction) {
        return G(fraction, Settings.velocity);
    }

    public static Chord Am(double fraction, int velocity) {
        return minorTriad(MusicDraft.medium[6], fraction, velocity);
    }

    public static Chord Am(double fraction) {
        return Am(fraction, Settings.velocity);
    }

    public static Chord Bdim(double fraction, int velocity) {
        return diminishedTriad(MusicDraft.medium[7], fraction, velocity);
    }

    public static Chord Bdim(double fraction) {
        return Bdim(fraction, Settings.velocity);
    }
}