package test;

import instruments.Guitar;
import model.ArpeggioPattern;
import model.GuitarChord;
import constant.GMInstruments;
import constant.GuitarTuning;

/**
 * 一个全面的测试脚本，用于验证增强版的 ArpeggioPattern 解析器和 Guitar 的 playArpeggio 方法。
 */
public class TestAdvancedArpeggio {

    public static void main(String[] args) {
        Guitar guitar = null;
        try {
            // --- 初始化 ---
            guitar = new Guitar(GMInstruments.GUITAR_ACOUSTIC_NYLON);
            int pace = 60;

            System.out.println("--- 吉他高级琶音模式 (DSL) 全面测试 ---");
            System.out.println("乐器: 尼龙弦吉他 | 速度: " + pace + " BPM");

            // --- 加载本次测试需要的所有和弦 ---
            GuitarChord cMajor = GuitarChord.fromString("Cmajor", pace, GuitarTuning.STANDARD_TUNING);
            GuitarChord gMajor = GuitarChord.fromString("Gmajor", pace, GuitarTuning.STANDARD_TUNING);
            GuitarChord aMinor = GuitarChord.fromString("Aminor", pace, GuitarTuning.STANDARD_TUNING);

            if (cMajor == null || gMajor == null || aMinor == null) {
                System.err.println("错误: 无法加载必要的和弦，测试中止。请检查数据库路径。");
                return;
            }

            // --- 1. 测试基础拨弦和 'T' (根音) ---
            System.out.println("\n--- 测试 1: 基础拨弦 ---");
            ArpeggioPattern basicPattern = ArpeggioPattern.fromString("T32123", 1); // 经典八分音符分解
            System.out.println("  |> 模式: 'T32123' (八分音符) @ C Major");
            guitar.playArpeggio(cMajor, basicPattern);
            Thread.sleep(1500);

            // --- 2. 测试节奏变化 ---
            System.out.println("\n--- 测试 2: 节奏变化 (中括号) ---");
            // T(八分) - 3(八分) - 21(平分一个八分，即两个十六分) - 3(八分)
            ArpeggioPattern rhythmPattern = ArpeggioPattern.fromString("T3[21]3", 0.5);
            System.out.println("  |> 模式: 'T3[21]3' (包含十六分音符) @ G Major");
            guitar.playArpeggio(gMajor, rhythmPattern);
            Thread.sleep(1500);
            
            // T(八分) - 3(八分) - 2(十六分) - 1(十六分)
            ArpeggioPattern rhythmPattern2 = ArpeggioPattern.fromString("T3[2][1]", 0.5);
            System.out.println("  |> 模式: 'T3[2][1]' (与上面节奏相同，写法不同)");
            guitar.playArpeggio(gMajor, rhythmPattern2);
            Thread.sleep(1500);

            // --- 3. 测试同时拨弦和去重 ---
            System.out.println("\n--- 测试 3: 同时拨弦 (小括号) ---");
            // T 和 (123) 同时拨，持续一个四分音符
            ArpeggioPattern pinchPattern = ArpeggioPattern.fromString("T(123)", 0.5); 
            System.out.println("  |> 模式: 'T(123)' (根音与高音三弦同时) @ A Minor");
            guitar.playArpeggio(aMinor, pinchPattern);
            Thread.sleep(1500);
            
            // 测试去重: (112) 应该和 (12) 效果一样
            ArpeggioPattern duplicatePinch = ArpeggioPattern.fromString("(112)", 0.5);
            System.out.println("  |> 模式: '(112)' (测试重复数字剔除) @ A Minor");
            guitar.playArpeggio(aMinor, duplicatePinch);
            Thread.sleep(1500);

            // --- 4. 测试扫弦和休止 ---
            System.out.println("\n--- 测试 4: 扫弦 (S, s) 与休止 (-) ---");
            // 下扫(四分) - 休止(四分) - 上拨(四分) - 休止(四分)
            ArpeggioPattern strumRestPattern = ArpeggioPattern.fromString("S-s-", 0.5);
            System.out.println("  |> 模式: 'S-s-' (经典的“咚-嗒”节奏) @ G Major");
            guitar.playArpeggio(gMajor, strumRestPattern);
            Thread.sleep(1500);
            
            // --- 5. 混合模式测试 ---
            System.out.println("\n--- 测试 5: 混合模式 ---");
            // T(八分) - 下扫(八分) - 3(十六分) - (12)拨弦(十六分)
            ArpeggioPattern complexPattern = ArpeggioPattern.fromString("TS[3][(12)]", 0.5);
            System.out.println("  |> 模式: 'TS[3(12)]' (复杂的混合技巧) @ C Major");
            guitar.playArpeggio(cMajor, complexPattern);

            System.out.println("\n\n--- 所有测试已完成 ---");

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
