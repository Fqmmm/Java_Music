package test;

import model.Chord;
import model.Note;
import util.MusicPlayer;

/**
 * 用于测试新版 Chord 类的程序。
 * 新版 Chord 类在构造时会自动处理时长统一。
 */
public class TestChord {

    public static void main(String[] args) {
        MusicPlayer player = null;
        try {
            Thread.sleep(2000);
            player = new MusicPlayer();
            // 设定一个统一的速度 (BPM)
            int pace = 120;
            System.out.println("--- 开始测试自统一时长的 Chord 类 ---");

            // --- 阶段1: 创建并播放 C 大三和弦 ---
            // 我们现在直接在 fromNotes 方法中传入 pace。
            // Chord 的构造函数会自动调用 unifyDuration，为所有音符设置正确的时长。
            System.out.println("\n正在播放: C 大三和弦 (四分音符)");
            Chord cMajor = Chord.fromNotes(pace,
                Note.quarterNote(60), // C4
                Note.quarterNote(64), // E4
                Note.quarterNote(67)  // G4
            );
            cMajor.showDebugInfo();
            player.playChord(cMajor);
            
            Thread.sleep(2000);

            // --- 阶段2: 创建并播放一个时长不统一的和弦 ---
            // 看看 unifyDuration 是否能正确处理
            System.out.println("正在播放: 时长不统一的和弦 (应以最短的四分音符为准)");
            Chord mixedChord = Chord.fromNotes(pace,
                Note.quarterNote(55), // G3, 四分音符 (最短)
                Note.halfNote(59),    // B3, 二分音符
                Note.fullNote(62)     // D4, 全音符
            );
            mixedChord.showDebugInfo();
            player.playChord(mixedChord);
            
            Thread.sleep(2000);

            // --- 阶段3: 测试移调功能 ---
            System.out.println("正在播放: C 大三和弦升调后的 D 大三和弦");
            // transposed 方法会返回一个新的 Chord 对象，
            // 这个新对象的构造函数同样会自动计算并设置新音符的时长。
            Chord dMajor = cMajor.transposed(2);
            dMajor.showDebugInfo();
            // 现在 dMajor 里的音符已经有了正确的 duration，可以直接播放！
            player.playChord(dMajor);

            System.out.println("\n--- 测试结束 ---");
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (player != null) {
                player.close();
            }
        }
    }
}