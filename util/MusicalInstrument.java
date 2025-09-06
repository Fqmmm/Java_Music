package util;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

public class MusicalInstrument {
    protected Synthesizer synth; // 声音合成器
    protected MidiChannel[] channels; // 通道
    protected int instrumentID; // 用的什么乐器

    public MusicalInstrument(int id) throws Exception {
        this.synth = MidiSystem.getSynthesizer();
        synth.open();
        this.channels = synth.getChannels();
        this.instrumentID = id;
    }

    public void close() {
        if (synth != null && synth.isOpen()) {
            synth.close();
        }
    }
}
