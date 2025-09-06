package util;

import java.util.List;
import javax.sound.midi.*;
import model.*;

/**
 * 音乐播放器
 */
public class ScalePlayer {
    private Synthesizer synth; // 声音合成器
    private MidiChannel[] channels; // 通道
    private int instrumentID; // 用的什么乐器

    public ScalePlayer(int id) throws Exception {
        this.synth = MidiSystem.getSynthesizer();
        synth.open();
        this.channels = synth.getChannels();
        this.instrumentID = id;
    }

    public void playNote(Note note) {
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
            Thread.sleep(note.duration());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (note.scale() > 0) {
            channel.noteOff(note.scale());
        }
    }

    public void playLyric(Lyric lyric) {
        lyric.show();
        for (Note note : lyric) {
            playNote(note);
        }
    }

    public void playMusic(Music music) {
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

    public void playMultipleMusic(Music... musics) {
        // 为每一首音乐创建一个线程
        Thread[] threads = new Thread[musics.length];
        for (int i = 0; i < musics.length; i++) {
            final Music music = musics[i];
            threads[i] = new Thread(() -> playMusic(music));
            threads[i].start();
        }

        // 等待所有线程执行完毕
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 播放单个和弦 (最终修正版)
     * 1. 修正了通道分配逻辑，避免使用打击乐通道 9。
     * 2. 在改变乐器后增加微小延迟，提高播放成功率。
     * 
     * @param chord 要播放的和弦
     */
    public void playChord(Chord chord) {
        if (chord == null || chord.getNotes().isEmpty()) {
            return;
        }

        List<Note> notes = chord.getNotes();
        int channelIndex = instrumentID % 16;
        MidiChannel channel = channels[channelIndex];

        try {
            // --- 2. 设置乐器并短暂等待 ---
            channel.programChange(instrumentID);
            Thread.sleep(10); // 关键：给合成器一点时间加载乐器，增加鲁棒性

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 同时开启所有音符
        for (Note note : notes) {
            if (note.scale() > 0) {
                channel.noteOn(note.scale(), note.velocity());
            }
        }

        try {
            Thread.sleep(chord.getDuration());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 同时关闭所有音符 (必须在同一个通道上)
        for (Note note : notes) {
            if (note.scale() > 0) {
                channel.noteOff(note.scale());
            }
        }
    }

    public void close() {
        if (synth != null && synth.isOpen()) {
            synth.close();
        }
    }
}