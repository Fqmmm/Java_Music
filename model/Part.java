package model;

import util.MusicalInstrument; // 假设您的乐器类都在 instrument 包下

/**
 * Part (声部) 类，用于将一个乐器 (MusicalInstrument)
 * 和它要演奏的乐谱 (Music) 绑定在一起。
 */
public class Part {
    private final MusicalInstrument instrument;
    private final Music music;

    public Part(MusicalInstrument instrument, Music music) {
        this.instrument = instrument;
        this.music = music;
    }

    public MusicalInstrument getInstrument() {
        return instrument;
    }

    public Music getMusic() {
        return music;
    }
}