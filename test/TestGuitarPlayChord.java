package test;

import constant.GMInstruments;
import model.Chord;
import drafts.MusicDraft;
import instruments.Guitar;
import util.ChordFactory;

public class TestGuitarPlayChord {
    public static void main(String[] args) {
         Guitar acousticGuitar = null;
        try {
            // --- 初始化 ---
            // 创建一个尼龙弦吉他实例，声音比较柔和
            acousticGuitar = new Guitar(GMInstruments.GUITAR_ACOUSTIC_NYLON);
            
            int pace = 80; // 较慢的速度，以便听清和弦
            double length = 2.0; // 每个和弦持续2拍
            
            System.out.println("--- 吉他和弦听力测试开始 ---");
            System.out.println("乐器: 尼龙弦吉他 | 速度: " + pace + " BPM | 每和弦持续: " + length + " 拍");

            // --- 1. 基础三和弦对比 (Major vs Minor) ---
            System.out.println("\n--- 测试1: 大调与小调的色彩对比 ---");

            Chord cMajor = ChordFactory.majorTriad(MusicDraft.medium[1], length, pace); // C Major
            System.out.println("  |> 正在播放: C Major (C-E-G)。听起来应该明亮、稳定。");
            acousticGuitar.playChord(cMajor);
            acousticGuitar.showDebugInfo();
            Thread.sleep(2500);

            Chord aMinor = ChordFactory.minorTriad(MusicDraft.low[6], length, pace); // A Minor
            System.out.println("  |> 正在播放: A Minor (A-C-E)。听起来应该略带忧郁、柔和。");
            acousticGuitar.playChord(aMinor);
            acousticGuitar.showDebugInfo();
            Thread.sleep(2500);

            Chord gMajor = ChordFactory.majorTriad(MusicDraft.low[5], length, pace); // G Major
            System.out.println("  |> 正在播放: G Major (G-B-D)。听起来也应该是明亮的，但整体音高比 C Major 低。");
            acousticGuitar.playChord(gMajor);
            acousticGuitar.showDebugInfo();
            Thread.sleep(2500);

            // --- 2. 根音变化测试 (Root Note Change) ---
            System.out.println("\n--- 测试2: 相同类型，不同根音的音高对比 ---");
            
            Chord fMajor = ChordFactory.majorTriad(MusicDraft.low[4], length, pace); // F Major
            System.out.println("  |> 正在播放: F Major (F-A-C)。听起来应该是明亮的，注意听它和 C Major 的音高差异。");
            acousticGuitar.playChord(fMajor);
            acousticGuitar.showDebugInfo();
            Thread.sleep(2500);

            System.out.println("  |> 再次播放: C Major (C-E-G)，对比一下。");
            acousticGuitar.playChord(cMajor);
            acousticGuitar.showDebugInfo();
            Thread.sleep(2500);

            // --- 3. 复杂七和弦对比 (7th Chords) ---
            System.out.println("\n--- 测试3: 不同色彩的七和弦对比 ---");

            Chord gDominant7 = ChordFactory.dominant7th(MusicDraft.low[5], length, pace); // G7
            System.out.println("  |> 正在播放: G Dominant 7th (G-B-D-F)。听起来应该有些“紧张”，有一种想要进行到 C 和弦的倾向。");
            acousticGuitar.playChord(gDominant7);
            acousticGuitar.showDebugInfo();
            Thread.sleep(2500);

            Chord cMajor7 = ChordFactory.major7th(MusicDraft.medium[1], length, pace); // Cmaj7
            System.out.println("  |> 正在播放: C Major 7th (C-E-G-B)。听起来应该非常华丽、柔和，带有些许爵士色彩。");
            acousticGuitar.playChord(cMajor7);
            acousticGuitar.showDebugInfo();
            Thread.sleep(2500);
            
            // --- 4. 移调功能验证 (Transposing) ---
            System.out.println("\n--- 测试4: 验证移调功能 ---");

            Chord eMinor = ChordFactory.minorTriad(MusicDraft.medium[3], length, pace); // E Minor
            System.out.println("  |> 首先播放: E Minor (E-G-B)，一个忧郁的小三和弦。");
            acousticGuitar.playChord(eMinor);
            acousticGuitar.showDebugInfo();
            Thread.sleep(2500);

            // 将 E Minor 向上移动3个半音，它应该会变成 G Minor
            Chord gMinor = eMinor.transposed(3);
            System.out.println("  |> 现在播放移调后的和弦 (G Minor, G-Bb-D)。听起来也应该是忧郁的，但整体音高更高了。");
            acousticGuitar.playChord(gMinor);
            acousticGuitar.showDebugInfo();
            Thread.sleep(2500);

            System.out.println("\n--- 所有测试已完成 ---");

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
