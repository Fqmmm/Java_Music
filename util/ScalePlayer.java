package util;

import java.util.List;
import javax.sound.midi.*;
import model.*;

/**
 * 音乐播放器
 */
public class ScalePlayer extends MusicalInstrument {

    public ScalePlayer(int id) throws Exception {
        super(id);
    }

    /**
     * 播放多声部音乐 (新版)。
     * @param parts 一个或多个 Part 对象，每个 Part 包含一个乐器和它要演奏的乐谱。
     */
    public static void playMultipleMusic(Part... parts) {
        if (parts == null || parts.length == 0) {
            return;
        }

        // 为每一个 "声部" (Part) 创建一个线程
        Thread[] threads = new Thread[parts.length];
        for (int i = 0; i < parts.length; i++) {
            final Part part = parts[i];
            
            // 创建一个新的线程，其任务是：使用指定的乐器来演奏指定的乐谱
            threads[i] = new Thread(() -> {
                MusicalInstrument instrument = part.getInstrument();
                Music music = part.getMusic();
                
                // 遍历乐谱中的每一个乐句
                for (Lyric lyric : music) {
                    // 调用乐器自己的 playLyric 方法来演奏
                    instrument.playLyric(lyric);
                }
            });
            threads[i].start(); // 启动线程
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
    @Override
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
}