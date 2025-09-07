package test;

import instruments.Guitar;
import model.ArpeggioPattern;
import model.GuitarChord;
import constant.GMInstruments;
import constant.GuitarTuning;

/**
 * 一个更全面的吉他琶音功能测试脚本。
 * 它将使用一个经典的 G-C-D-G 和弦进行，并为其搭配多种不同的右手分解模式。
 */
public class TestFullArpeggio {

    public static void main(String[] args) {
        Guitar guitar = null;
        try {
            // --- 初始化 ---
            guitar = new Guitar(GMInstruments.GUITAR_ACOUSTIC_NYLON); // 钢弦吉他音色更适合民谣
            int pace = 60; // 设定一个标准的速度
            
            System.out.println("--- 吉他琶音模式全面测试 ---");
            System.out.println("乐器: 钢弦吉他 | 速度: " + pace + " BPM");
            System.out.println("和弦进行: G -> C -> D -> G\n");

            // --- 1. 加载本次测试需要的所有和弦 ---
            GuitarChord gMajor = GuitarChord.fromString("Gmajor", pace, GuitarTuning.STANDARD_TUNING);
            GuitarChord cMajor = GuitarChord.fromString("Cmajor", pace, GuitarTuning.STANDARD_TUNING);
            GuitarChord dMajor = GuitarChord.fromString("Dmajor", pace, GuitarTuning.STANDARD_TUNING);

            GuitarChord[] progression = {gMajor, cMajor, dMajor, gMajor};

            // --- 2. 定义几种不同的右手分解模式 ---
            
            // 模式A: 经典的交替低音分解 (Travis Picking)
            // T-3-2-3-T'-3-2-3 (T' 代表交替低音，我们用5弦代替)
            // 这里我们简化为 T-3-2-1-3-2-1
            ArpeggioPattern travisPicking = ArpeggioPattern.fromString("T3231323", 0.5);

            // 模式B: 三指法 (Three-Finger Style)
            // T-1-2-T-1-2...
            ArpeggioPattern threeFinger = ArpeggioPattern.fromString("T312", 0.5);
            
            // 模式C: 同时拨弦 (Pinching)
            // (T1)-2-3-2
            ArpeggioPattern pinching = ArpeggioPattern.fromString("T3(12)3", 0.5);
            
            // --- 3. 依次使用不同的模式来演奏整个和弦进行 ---

            System.out.println("--- 演奏1: 使用 'Travis Picking' 模式 ---");
            playProgressionWithPattern(guitar, progression, travisPicking);
            
            Thread.sleep(2000); // 乐段之间停顿

            System.out.println("\n--- 演奏2: 使用 'Three-Finger Style' 模式 ---");
            playProgressionWithPattern(guitar, progression, threeFinger);

            Thread.sleep(2000);

            System.out.println("\n--- 演奏3: 使用 'Pinching' 模式 ---");
            playProgressionWithPattern(guitar, progression, pinching);

            System.out.println("\n--- 所有测试已完成 ---");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 辅助方法：使用一个指定的琶音模式，来演奏一个完整的和弦进行。
     * @param guitar 吉他实例
     * @param progression 要演奏的和弦数组
     * @param pattern     要使用的右手分解模式
     */
    private static void playProgressionWithPattern(Guitar guitar, GuitarChord[] progression, ArpeggioPattern pattern) throws Exception {
        if (guitar == null || progression == null || pattern == null) return;
        
        // 遍历和弦进行中的每一个和弦
        for (GuitarChord chord : progression) {
            if (chord != null) {
                System.out.println("  |> 演奏 " + chord.getFingering() + " (" + chord.getNotes().get(0).scale() + "...)");
                // 使用 guitar 的 playArpeggio 方法来演奏
                guitar.playArpeggio(chord, pattern);
            }
        }
    }
}