package constant;
/**
 * 通用MIDI (General MIDI - GM) 乐器列表。
 * 该列表提供了从 0 到 127 的标准乐器程序编号（Program Change Number）。
 *
 * 使用方法：在需要指定乐器的地方，使用 GMInstruments.乐器名 的方式代替数字。
 * 例如：GMInstruments.PIANO_ACOUSTIC_GRAND 代替 0。
 */
public final class GMInstruments {

    /**
     * 私有构造函数，防止该工具类被实例化。
     */
    private GMInstruments() {}

    // --- 钢琴 (Piano) ---
    public static final int PIANO_ACOUSTIC_GRAND = 0;
    public static final int PIANO_BRIGHT_ACOUSTIC = 1;
    public static final int PIANO_ELECTRIC_GRAND = 2;
    public static final int PIANO_HONKY_TONK = 3;
    public static final int PIANO_ELECTRIC_1 = 4; // Rhodes Piano
    public static final int PIANO_ELECTRIC_2 = 5; // Chorused Piano
    public static final int PIANO_HARPSICHORD = 6;
    public static final int PIANO_CLAVINET = 7;

    // --- 半音打击乐器 (Chromatic Percussion) ---
    public static final int PERCUSSION_CELESTA = 8;
    public static final int PERCUSSION_GLOCKENSPIEL = 9;
    public static final int PERCUSSION_MUSIC_BOX = 10;
    public static final int PERCUSSION_VIBRAPHONE = 11;
    public static final int PERCUSSION_MARIMBA = 12;
    public static final int PERCUSSION_XYLOPHONE = 13;
    public static final int PERCUSSION_TUBULAR_BELLS = 14;
    public static final int PERCUSSION_DULCIMER = 15;

    // --- 风琴 (Organ) ---
    public static final int ORGAN_DRAWBAR = 16;
    public static final int ORGAN_PERCUSSIVE = 17;
    public static final int ORGAN_ROCK = 18;
    public static final int ORGAN_CHURCH = 19;
    public static final int ORGAN_REED = 20;
    public static final int ORGAN_ACCORDION = 21;
    public static final int ORGAN_HARMONICA = 22;
    public static final int ORGAN_TANGO_ACCORDION = 23;

    // --- 吉他 (Guitar) ---
    public static final int GUITAR_ACOUSTIC_NYLON = 24;
    public static final int GUITAR_ACOUSTIC_STEEL = 25;
    public static final int GUITAR_ELECTRIC_JAZZ = 26;
    public static final int GUITAR_ELECTRIC_CLEAN = 27;
    public static final int GUITAR_ELECTRIC_MUTED = 28;
    public static final int GUITAR_OVERDRIVEN = 29;
    public static final int GUITAR_DISTORTION = 30;
    public static final int GUITAR_HARMONICS = 31;

    // --- 贝斯 (Bass) ---
    public static final int BASS_ACOUSTIC = 32;
    public static final int BASS_ELECTRIC_FINGER = 33;
    public static final int BASS_ELECTRIC_PICK = 34;
    public static final int BASS_FRETLESS = 35;
    public static final int BASS_SLAP_1 = 36;
    public static final int BASS_SLAP_2 = 37;
    public static final int BASS_SYNTH_1 = 38;
    public static final int BASS_SYNTH_2 = 39;

    // --- 弦乐 (Strings) ---
    public static final int STRINGS_VIOLIN = 40;
    public static final int STRINGS_VIOLA = 41;
    public static final int STRINGS_CELLO = 42;
    public static final int STRINGS_CONTRABASS = 43;
    public static final int STRINGS_TREMOLO = 44;
    public static final int STRINGS_PIZZICATO = 45;
    public static final int STRINGS_ORCHESTRAL_HARP = 46;
    public static final int STRINGS_TIMPANI = 47;

    // --- 合奏/合唱 (Ensemble) ---
    public static final int ENSEMBLE_STRING_1 = 48; // String Ensemble 1
    public static final int ENSEMBLE_STRING_2 = 49; // String Ensemble 2
    public static final int ENSEMBLE_SYNTH_STRINGS_1 = 50;
    public static final int ENSEMBLE_SYNTH_STRINGS_2 = 51;
    public static final int ENSEMBLE_CHOIR_AAHS = 52;
    public static final int ENSEMBLE_VOICE_OOHS = 53;
    public static final int ENSEMBLE_SYNTH_VOICE = 54;
    public static final int ENSEMBLE_ORCHESTRA_HIT = 55;

    // --- 铜管 (Brass) ---
    public static final int BRASS_TRUMPET = 56;
    public static final int BRASS_TROMBONE = 57;
    public static final int BRASS_TUBA = 58;
    public static final int BRASS_MUTED_TRUMPET = 59;
    public static final int BRASS_FRENCH_HORN = 60;
    public static final int BRASS_SECTION = 61;
    public static final int BRASS_SYNTH_1 = 62;
    public static final int BRASS_SYNTH_2 = 63;

    // --- 簧管 (Reed) ---
    public static final int REED_SOPRANO_SAX = 64;
    public static final int REED_ALTO_SAX = 65;
    public static final int REED_TENOR_SAX = 66;
    public static final int REED_BARITONE_SAX = 67;
    public static final int REED_OBOE = 68;
    public static final int REED_ENGLISH_HORN = 69;
    public static final int REED_BASSOON = 70;
    public static final int REED_CLARINET = 71;

    // --- 笛类 (Pipe) ---
    public static final int PIPE_PICCOLO = 72;
    public static final int PIPE_FLUTE = 73;
    public static final int PIPE_RECORDER = 74;
    public static final int PIPE_PAN_FLUTE = 75;
    public static final int PIPE_BLOWN_BOTTLE = 76;
    public static final int PIPE_SHAKUHACHI = 77;
    public static final int PIPE_WHISTLE = 78;
    public static final int PIPE_OCARINA = 79;

    // --- 合成主音 (Synth Lead) ---
    public static final int LEAD_1_SQUARE = 80;
    public static final int LEAD_2_SAWTOOTH = 81; // 这就是你想要的电音效果
    public static final int LEAD_3_CALLIOPE = 82;
    public static final int LEAD_4_CHIFF = 83;
    public static final int LEAD_5_CHARANG = 84;
    public static final int LEAD_6_VOICE = 85;
    public static final int LEAD_7_FIFTHS = 86;
    public static final int LEAD_8_BASS_LEAD = 87;

    // --- 合成音效 (Synth Pad) ---
    public static final int PAD_1_NEW_AGE = 88;
    public static final int PAD_2_WARM = 89;
    public static final int PAD_3_POLYSYNTH = 90;
    public static final int PAD_4_CHOIR = 91;
    public static final int PAD_5_BOWED = 92;
    public static final int PAD_6_METALLIC = 93;
    public static final int PAD_7_HALO = 94;
    public static final int PAD_8_SWEEP = 95;

    // --- 合成效果 (Synth Effects) ---
    public static final int FX_1_RAIN = 96;
    public static final int FX_2_SOUNDTRACK = 97;
    public static final int FX_3_CRYSTAL = 98;
    public static final int FX_4_ATMOSPHERE = 99;
    public static final int FX_5_BRIGHTNESS = 100;
    public static final int FX_6_GOBLINS = 101;
    public static final int FX_7_ECHOES = 102;
    public static final int FX_8_SCI_FI = 103;

    // --- 民族乐器 (Ethnic) ---
    public static final int ETHNIC_SITAR = 104;
    public static final int ETHNIC_BANJO = 105;
    public static final int ETHNIC_SHAMISEN = 106;
    public static final int ETHNIC_KOTO = 107;
    public static final int ETHNIC_KALIMBA = 108;
    public static final int ETHNIC_BAG_PIPE = 109;
    public static final int ETHNIC_FIDDLE = 110;
    public static final int ETHNIC_SHANAI = 111;

    // --- 打击乐器 (Percussive) ---
    public static final int PERCUSSIVE_TINKLE_BELL = 112;
    public static final int PERCUSSIVE_AGOGO = 113;
    public static final int PERCUSSIVE_STEEL_DRUMS = 114;
    public static final int PERCUSSIVE_WOODBLOCK = 115;
    public static final int PERCUSSIVE_TAIKO_DRUM = 116;
    public static final int PERCUSSIVE_MELODIC_TOM = 117;
    public static final int PERCUSSIVE_SYNTH_DRUM = 118;
    public static final int PERCUSSIVE_REVERSE_CYMBAL = 119;

    // --- 音效 (Sound Effects) ---
    public static final int SFX_GUITAR_FRET_NOISE = 120;
    public static final int SFX_BREATH_NOISE = 121;
    public static final int SFX_SEASHORE = 122;
    public static final int SFX_BIRD_TWEET = 123;
    public static final int SFX_TELEPHONE_RING = 124;
    public static final int SFX_HELICOPTER = 125;
    public static final int SFX_APPLAUSE = 126;
    public static final int SFX_GUNSHOT = 127;
}