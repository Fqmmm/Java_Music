package test;

import util.ChordLibrary;
import constant.GMInstruments; // 假设您的 GMInstruments 在 constant 包下
import model.MusicDraft;
import util.MusicPlayer;
import model.Chord;
/**
 * 用于全面测试 ChordLibrary 中所有重载方法的程序。
 * 它会依次演示每种和弦的默认、指定乐器、指定乐器和音量三种创建方式。
 */
public class TestChordLibrary {

    public static void main(String[] args) {
        MusicPlayer player = null;
        try {
            player = new MusicPlayer();
            // --- 全局测试参数 ---
            int pace = 100;
            double length = 2; // 每个和弦播放一拍
            int rootNoteC = MusicDraft.medium[1]; // 中央 C = 60
            int rootNoteG = MusicDraft.medium[5]; // G4 = 67

            System.out.println("--- 开始全面测试 ChordLibrary 的重载方法 ---");

            // --- 1. 测试大三和弦 (Major Triad) ---
            System.out.println("\n--- 测试 Major Triads ---");

            Chord 钢琴C = ChordLibrary.majorTriad(rootNoteC, length, pace);
            player.playChord(钢琴C);
            钢琴C.showDebugInfo();
            System.out.println("  |> 播放: C Major (默认乐器: 钢琴)");
            Thread.sleep(1500);

            Chord 钢弦吉他C = ChordLibrary.majorTriad(rootNoteC, length, pace, GMInstruments.GUITAR_ACOUSTIC_STEEL);
            player.playChord(钢弦吉他C);
            钢弦吉他C.showDebugInfo();
            System.out.println("  |> 播放: C Major (指定乐器: 钢弦吉他)");
            Thread.sleep(1500);

            Chord 小号C = ChordLibrary.majorTriad(rootNoteC, length, pace, GMInstruments.BRASS_TRUMPET, 127);
            player.playChord(小号C);
            小号C.showDebugInfo();
            System.out.println("  |> 播放: C Major (指定乐器: 小号, 音量: 127 - 最大)");
            Thread.sleep(1500);

            // --- 2. 测试小三和弦 (Minor Triad) ---
            System.out.println("\n--- 测试 Minor Triads ---");

            Chord 钢琴CMinor = ChordLibrary.minorTriad(rootNoteC, length, pace);
            player.playChord(钢琴CMinor);
            钢琴CMinor.showDebugInfo();
            System.out.println("  |> 播放: C Minor (默认乐器: 钢琴)");
            Thread.sleep(1500);

            Chord 小提琴CMinor = ChordLibrary.minorTriad(rootNoteC, length, pace, GMInstruments.STRINGS_VIOLIN);
            player.playChord(小提琴CMinor);
            System.out.println("  |> 播放: C Minor (指定乐器: 小提琴)");
            Thread.sleep(1500);

            player.playChord(ChordLibrary.minorTriad(rootNoteC, length, pace, GMInstruments.REED_CLARINET, 80));
            System.out.println("  |> 播放: C Minor (指定乐器: 单簧管, 音量: 80 - 柔和)");
            Thread.sleep(1500);

            // --- 3. 测试属七和弦 (Dominant 7th) ---
            System.out.println("\n--- 测试 Dominant 7th Chords ---");
            player.playChord(ChordLibrary.dominant7th(rootNoteG, length, pace));
            System.out.println("  |> 播放: G7 (默认乐器: 钢琴)");
            Thread.sleep(1500);

            player.playChord(ChordLibrary.dominant7th(rootNoteG, length, pace, GMInstruments.GUITAR_ELECTRIC_JAZZ));
            System.out.println("  |> 播放: G7 (指定乐器: 爵士电吉他)");
            Thread.sleep(1500);
            
            player.playChord(ChordLibrary.dominant7th(rootNoteG, length, pace, GMInstruments.ORGAN_ROCK, 110));
            System.out.println("  |> 播放: G7 (指定乐器: 摇滚风琴, 音量: 110 - 响亮)");
            Thread.sleep(1500);

            System.out.println("\n--- 所有测试已完成 ---");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (player != null) {
                player.close();
            }
        }
    }
}