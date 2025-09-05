package util;

import model.Chord;
import model.Note;

/**
 * 一个静态的和弦库 (Chord Library)，提供了创建常见和弦的便捷工厂方法。
 * 
 * 使用方法：
 * Chord cMajor = ChordLibrary.majorTriad(60, 0.25, 120); // 创建一个C大三和弦
 */
public final class ChordLibrary {

    /**
     * 私有构造函数，防止这个工具类被实例化。
     */
    private ChordLibrary() {}

    // --- 和弦构成的基本音程 (Intervals in semitones) ---
    private static final int MINOR_THIRD = 3;  // 小三度 (+3个半音)
    private static final int MAJOR_THIRD = 4;  // 大三度 (+4个半音)
    private static final int PERFECT_FIFTH = 7; // 纯五度 (+7个半音)
    private static final int DIMINISHED_FIFTH = 6; // 减五度 (+6个半音)
    private static final int AUGMENTED_FIFTH = 8; // 增五度 (+8个半音)
    private static final int MINOR_SEVENTH = 10; // 小七度 (+10个半音)
    private static final int MAJOR_SEVENTH = 11; // 大七度 (+11个半音)

    // ======================================================================
    // |                         三和弦 (Triads)                          |
    // ======================================================================

    /**
     * 构建一个大三和弦 (Major Triad)。
     * 构成：根音 + 大三度 + 纯五度 (e.g., C-E-G)
     * @param rootScale 根音的 MIDI 音阶
     * @param fraction  和弦的时值
     * @param pace      速度 (BPM)
     * @return 一个大三和弦 Chord 对象
     */
    public static Chord majorTriad(int rootScale, double fraction, int pace) {
        return Chord.fromNotes(pace,
            Note.create(rootScale, fraction),                   // 根音 (Root)
            Note.create(rootScale + MAJOR_THIRD, fraction),    // 三音 (Third)
            Note.create(rootScale + PERFECT_FIFTH, fraction)   // 五音 (Fifth)
        );
    }

    /**
     * 构建一个小三和弦 (Minor Triad)。
     * 构成：根音 + 小三度 + 纯五度 (e.g., C-Eb-G)
     */
    public static Chord minorTriad(int rootScale, double fraction, int pace) {
        return Chord.fromNotes(pace,
            Note.create(rootScale, fraction),
            Note.create(rootScale + MINOR_THIRD, fraction),
            Note.create(rootScale + PERFECT_FIFTH, fraction)
        );
    }

    /**
     * 构建一个减三和弦 (Diminished Triad)。
     * 构成：根音 + 小三度 + 减五度 (e.g., C-Eb-Gb)
     */
    public static Chord diminishedTriad(int rootScale, double fraction, int pace) {
        return Chord.fromNotes(pace,
            Note.create(rootScale, fraction),
            Note.create(rootScale + MINOR_THIRD, fraction),
            Note.create(rootScale + DIMINISHED_FIFTH, fraction)
        );
    }

    /**
     * 构建一个增三和弦 (Augmented Triad)。
     * 构成：根音 + 大三度 + 增五度 (e.g., C-E-G#)
     */
    public static Chord augmentedTriad(int rootScale, double fraction, int pace) {
        return Chord.fromNotes(pace,
            Note.create(rootScale, fraction),
            Note.create(rootScale + MAJOR_THIRD, fraction),
            Note.create(rootScale + AUGMENTED_FIFTH, fraction)
        );
    }

    // ======================================================================
    // |                         七和弦 (Seventh Chords)                      |
    // ======================================================================

    /**
     * 构建一个属七和弦 (Dominant 7th Chord)。
     * 构成：大三和弦 + 小七度 (e.g., C-E-G-Bb)
     */
    public static Chord dominant7th(int rootScale, double fraction, int pace) {
        return Chord.fromNotes(pace,
            Note.create(rootScale, fraction),
            Note.create(rootScale + MAJOR_THIRD, fraction),
            Note.create(rootScale + PERFECT_FIFTH, fraction),
            Note.create(rootScale + MINOR_SEVENTH, fraction)
        );
    }

    /**
     * 构建一个大七和弦 (Major 7th Chord)。
     * 构成：大三和弦 + 大七度 (e.g., C-E-G-B)
     */
    public static Chord major7th(int rootScale, double fraction, int pace) {
        return Chord.fromNotes(pace,
            Note.create(rootScale, fraction),
            Note.create(rootScale + MAJOR_THIRD, fraction),
            Note.create(rootScale + PERFECT_FIFTH, fraction),
            Note.create(rootScale + MAJOR_SEVENTH, fraction)
        );
    }

    /**
     * 构建一个小七和弦 (Minor 7th Chord)。
     * 构成：小三和弦 + 小七度 (e.g., C-Eb-G-Bb)
     */
    public static Chord minor7th(int rootScale, double fraction, int pace) {
        return Chord.fromNotes(pace,
            Note.create(rootScale, fraction),
            Note.create(rootScale + MINOR_THIRD, fraction),
            Note.create(rootScale + PERFECT_FIFTH, fraction),
            Note.create(rootScale + MINOR_SEVENTH, fraction)
        );
    }
}
