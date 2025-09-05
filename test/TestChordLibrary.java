package test;

import util.ChordLibrary;
import model.MusicDraft;
import util.MusicPlayer;

/**
 * 用于测试 ChordLibrary 中各种和弦生成方法的程序。
 */
public class TestChordLibrary {

    public static void main(String[] args) {
        MusicPlayer player = null;
        try {
            player = new MusicPlayer();
            int pace = 100; // 测试用的速度
            double length = 1.0; // 每个和弦播放一拍
            
            // 使用 MusicDraft 接口中的常量，更具通用性
            int rootNoteC = MusicDraft.medium[1]; // 中央 C = 60
            int rootNoteG = MusicDraft.medium[5]; // G4 = 67
            
            System.out.println("--- 正在测试 ChordLibrary ---");

            // --- 测试三和弦 ---
            System.out.println("播放: C Major (C大三和弦)");
            player.playChord(ChordLibrary.majorTriad(rootNoteC, length, pace));
            Thread.sleep(1500); // 增加停顿以便听清楚

            System.out.println("播放: C Minor (C小三和弦)");
            player.playChord(ChordLibrary.minorTriad(rootNoteC, length, pace));
            Thread.sleep(1500);

            System.out.println("播放: C Diminished (C减三和弦)");
            player.playChord(ChordLibrary.diminishedTriad(rootNoteC, length, pace));
            Thread.sleep(1500);

            // --- 测试七和弦 ---
            System.out.println("播放: G Dominant 7th (G属七和弦)");
            player.playChord(ChordLibrary.dominant7th(rootNoteG, length, pace));
            Thread.sleep(1500);

            System.out.println("播放: G Major 7th (G大七和弦)");
            player.playChord(ChordLibrary.major7th(rootNoteG, length, pace));
            Thread.sleep(1500);

            System.out.println("播放: C Minor 7th (C小七和弦)");
            player.playChord(ChordLibrary.minor7th(rootNoteC, length, pace));
            Thread.sleep(1500);
            
            System.out.println("--- 测试结束 ---");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (player != null) {
                player.close();
            }
        }
    }
}
