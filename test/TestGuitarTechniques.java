package test;

import constant.GMInstruments;
import instruments.Guitar;
import model.GuitarChord;
import constant.GuitarTuning;

/**
 * 用于测试 Guitar 类高级演奏技巧的程序，
 * 包括 playSingleString (分解和弦) 和 strumBackward (反向扫弦)。
 */
public class TestGuitarTechniques {

    public static void main(String[] args) {
        Guitar acousticGuitar = null;
        try {
            int duration = 1000;
            // --- 初始化 ---
            acousticGuitar = new Guitar(GMInstruments.GUITAR_ACOUSTIC_NYLON);
            int pace = 90; // 设定一个适中的速度
            int defaultVelocity = 100; // 默认力度
            int accentVelocity = 120; // 重音力度

            System.out.println("--- 吉他高级演奏技巧测试开始 ---");
            System.out.println("乐器: 尼龙弦吉他 | 速度: " + pace + " BPM");

            // --- 1. 测试分解和弦 (Arpeggio) ---
            System.out.println("\n--- 测试1: 分解和弦 (Arpeggio) ---");
            System.out.println("  |> 将依次按下 C Major 和 G Major 和弦，并分别进行分解弹奏。");
            
            // 加载 C Major 和弦
            GuitarChord cMajor = GuitarChord.fromString("Cmajor", pace, GuitarTuning.STANDARD_TUNING);
            // 加载 G Major 和弦
            GuitarChord gMajor = GuitarChord.fromString("Gmajor", pace, GuitarTuning.STANDARD_TUNING);

            if (cMajor != null && gMajor != null) {
                // **演奏 C Major 分解**
                System.out.println("  |> 按下 C Major (x32010)，准备分解...");
                acousticGuitar.switchChordTo(cMajor); // 只按弦，不发声
                
                System.out.println("  |> 弹奏 C Major 分解 (654321 弦)...");
                acousticGuitar.playSingleString(6, duration, accentVelocity); // 根音重音
                Thread.sleep(1000);
                acousticGuitar.playSingleString(5, duration, defaultVelocity);
                Thread.sleep(1000);
                acousticGuitar.playSingleString(4, duration, defaultVelocity);
                Thread.sleep(1000);
                acousticGuitar.playSingleString(3, duration, defaultVelocity);
                Thread.sleep(1000);
                acousticGuitar.playSingleString(2, duration, defaultVelocity);
                Thread.sleep(1000);
                acousticGuitar.playSingleString(1, duration, defaultVelocity);
                
                Thread.sleep(1000); // 乐句之间停顿

                // **演奏 G Major 分解**
                System.out.println("  |> 按下 G Major (320003)，准备分解...");
                acousticGuitar.switchChordTo(gMajor);
                
                System.out.println("  |> 弹奏 G Major 分解 (6-5-4-3-2-1 弦)...");
                acousticGuitar.playSingleString(6, duration, accentVelocity); // 根音重音
                Thread.sleep(1000);
                acousticGuitar.playSingleString(5, duration, defaultVelocity);
                Thread.sleep(1000);
                acousticGuitar.playSingleString(4, duration, defaultVelocity);
                Thread.sleep(1000);
                acousticGuitar.playSingleString(3, duration, defaultVelocity);
                Thread.sleep(1000);
                acousticGuitar.playSingleString(2, duration, defaultVelocity);
                Thread.sleep(1000);
                acousticGuitar.playSingleString(1, duration, defaultVelocity);
                Thread.sleep(1000);
            }

            // --- 2. 测试正向与反向扫弦 (Strumming) ---
            System.out.println("\n--- 测试2: 正向与反向扫弦对比 ---");
            System.out.println("  |> 将按下 Am 和弦，并进行一次下拨和一次上拨。");

            GuitarChord aMinor = GuitarChord.fromString("Aminor", pace, GuitarTuning.STANDARD_TUNING);
            if (aMinor != null) {
                // **准备 Am 和弦**
                acousticGuitar.switchChordTo(aMinor);
                System.out.println("  |> 已按下 A Minor (x02210)。");

                // **正向扫弦 (下拨)**
                System.out.println("  |> 正在进行正向扫弦 (Downstroke)...");
                // 从5弦扫到1弦，持续1秒
                acousticGuitar.strum(5, 1, 1000, 110);
                
                Thread.sleep(1000);

                // **反向扫弦 (上拨)**
                System.out.println("  |> 正在进行反向扫弦 (Upstroke)...");
                // 从1弦扫到5弦，持续1秒，力度稍轻
                acousticGuitar.strumBackward(1, 5, 1000, 90);
            }
            
            System.out.println("\n--- 所有测试已完成 ---");

        } catch (Exception e) {
            e.printStackTrace();
        } 
        // Guitar 类目前没有需要关闭的资源
    }
}