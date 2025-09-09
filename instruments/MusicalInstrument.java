package instruments;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import model.*;

public abstract class MusicalInstrument {
    protected Synthesizer synth; // 声音合成器
    protected MidiChannel[] channels; // 通道
    protected int instrumentID; // 用的什么乐器

    public MusicalInstrument(int id) throws Exception {
        this.synth = MidiSystem.getSynthesizer();
        synth.open();
        this.channels = synth.getChannels();
        this.instrumentID = id;
    }

    public void play(Playable item) throws Exception {
        play(item, item.duration());
    }
    public void play(Playable item, int duration) throws Exception {
        if (item instanceof Note) {
            playNote((Note)item, duration);
        } else if (item instanceof Chord) {
            playChord((Chord)item, duration);
        } else {
            throw new Exception("fuck!");
        }
    }

    public void playNote(Note note) {
        playNote(note, note.duration());
    }

    public void playNote(Note note, int duration) {
        // 为不同的乐器分配不同的通道
        int channelIndex = instrumentID % 16;
        MidiChannel channel = channels[channelIndex];

        // 设置乐器
        channel.programChange(instrumentID);

        // scale为0代表休止符，不发声
        if (note.scale() > 0) {
            channel.noteOn(note.scale(), note.velocity());
        }

        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (note.scale() > 0) {
            channel.noteOff(note.scale());
        }
    }

    public void playLyric(Lyric lyric) throws Exception {
        lyric.show();
        for (Playable item : lyric) {
            play(item);
        }
    }

    public void playMusic(Music music) throws Exception {
        if (music.title() != null) {
            System.out.println("即将播放歌曲：" + music.title());
        }

        if (music.singer() != null) {
            System.out.println("歌手：" + music.singer());
        }

        for (Lyric lyric : music) {
            playLyric(lyric);
        }
    }

    abstract public void playChord(Chord chord) throws Exception;

    abstract public void playChord(Chord chord, int duration) throws Exception;

    public void close() {
        if (synth != null && synth.isOpen()) {
            synth.close();
        }
    }
}
