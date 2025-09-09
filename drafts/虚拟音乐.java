package drafts;

import constant.GuitarTuning;
import model.*;;

public class 虚拟音乐 implements MusicDraft {

        public static final double GuitarChord_FRACTION = 1;

        public static final GuitarChord C_GuitarChord = GuitarChord.fromString("Cmajor",
                        GuitarChord_FRACTION, GuitarTuning.STANDARD_TUNING);

        public static final GuitarChord Em_GuitarChord = GuitarChord.fromString("Eminor",
                        GuitarChord_FRACTION, GuitarTuning.STANDARD_TUNING);
        public static final GuitarChord F_GuitarChord = GuitarChord.fromString("FMajor",
                        GuitarChord_FRACTION, GuitarTuning.STANDARD_TUNING);

        public static final GuitarChord G_GuitarChord = GuitarChord.fromString("Gminor",
                        GuitarChord_FRACTION, GuitarTuning.STANDARD_TUNING);

        public static final GuitarChord Am_GuitarChord = GuitarChord.fromString("Aminor",
                        GuitarChord_FRACTION, GuitarTuning.STANDARD_TUNING);

        public static final Lyric 第一句 = Lyric.fromPlayables(C_GuitarChord, Em_GuitarChord, F_GuitarChord,
                        G_GuitarChord);
        public static final Lyric 第二句 = Lyric.fromPlayables(Em_GuitarChord, Am_GuitarChord, F_GuitarChord,
                        C_GuitarChord);

        public Music getMusic(int pace, int velocity) {
                Music music = Music.fromLyrics(pace, 第一句, 第二句);
                music.setPlayableDuration();
                music.unifyVelocity(velocity);
                return music;
        }
}
