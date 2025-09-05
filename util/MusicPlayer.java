package util;
import java.util.List;

import javax.sound.midi.*;

import model.Chord;
import model.Lyric;
import model.Music;
import model.Note;

/**
 * 音乐播放器
 */
public class MusicPlayer {
    private Synthesizer synth;      // 声音合成器
    private MidiChannel[] channels; // 通道

    public MusicPlayer() throws Exception {
        this.synth = MidiSystem.getSynthesizer();
        synth.open();
        this.channels = synth.getChannels();
    }

    public void playNote(Note note) {
        // 为不同的乐器分配不同的通道
        MidiChannel channel = channels[(int)note.instrument() % 16]; 
        
        // 设置乐器
        channel.programChange((int)note.instrument());

        // scale为0代表休止符，不发声
        if (note.scale() > 0) {
            // 开始发声
            channel.noteOn(note.scale(), note.velocity());
        }

        try {
            // 等待音符的持续时间
            Thread.sleep(note.duration());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (note.scale() > 0) {
            // 停止发声
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
     * 播放单个和弦。
     * @param chord 要播放的和弦
     */
    public void playChord(Chord chord) {
        List<Note> notes = chord.getNotes();
        if (notes == null || notes.isEmpty()) {
            return; // 如果是空和弦，直接返回
        }

        // --- 步骤 1: 同时开启所有音符 ---
        for (Note note : notes) {
            // scale 为 0 代表休止符，不发声
            if (note.scale() > 0) {
                MidiChannel channel = channels[(int)note.instrument() % 16];
                channel.programChange((int)note.instrument());
                channel.noteOn(note.scale(), note.velocity());
            }
        }

        // --- 步骤 2: 计算并等待持续时间 ---
        // 和弦的持续时间通常由其中最短的音符决定。
        // 我们需要找到最短的 duration。
        int shortestDuration = Integer.MAX_VALUE;
        for (Note note : notes) {
            if (note.duration() < shortestDuration) {
                shortestDuration = note.duration();
            }
        }
        // 如果没有找到有效时长（比如都是休止符），则不等待
        if (shortestDuration == Integer.MAX_VALUE) {
            shortestDuration = 0;
        }

        try {
            Thread.sleep(shortestDuration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // --- 步骤 3: 同时关闭所有音符 ---
        for (Note note : notes) {
            if (note.scale() > 0) {
                MidiChannel channel = channels[(int)note.instrument() % 16];
                channel.noteOff(note.scale());
            }
        }
    }
    
    /**
     * 关闭合成器释放资源
     */
    public void close() {
        if (synth != null && synth.isOpen()) {
            synth.close();
        }
    }
}