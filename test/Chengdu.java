package test;

import instruments.Guitar;
import model.ArpeggioPattern;
import model.GuitarChord;
import constant.GMInstruments;
import constant.GuitarTuning;

/**
 * 一个完整的集成测试程序，用于演奏赵雷的《成都》。
 * 它将组合使用 GuitarChord, ArpeggioPattern, 和 Guitar 类来完成整首歌曲的伴奏。
 */
public class Chengdu {

    public static void main(String[] args) {
        Guitar guitar = null;
        try {
            // --- 1. 初始化 ---
            // 使用钢弦民谣吉他，音色更符合原曲
            guitar = new Guitar(GMInstruments.GUITAR_ACOUSTIC_NYLON);
            // 原曲速度大约在 70 BPM 左右，比较舒缓
            int pace = 70;

            System.out.println("--- 准备演奏 赵雷 -《成都》 ---");
            System.out.println("乐器:  吉他 | 速度: " + pace + " BPM");
            
            // --- 2. 定义右手分解模式 ---
            // 模式: T32123，每个动作为四分音符 (时值 0.25)
            ArpeggioPattern chengduPattern = ArpeggioPattern.fromString("T32123", 0.5);
            System.out.println("使用的右手分解型: T 3 (12) 3");

            // --- 3. 从数据库加载本曲需要的所有和弦 ---
            System.out.println("正在加载和弦...");
            GuitarChord C  = GuitarChord.fromString("Cmajor", pace, GuitarTuning.STANDARD_TUNING);
            GuitarChord Em = GuitarChord.fromString("Eminor", pace, GuitarTuning.STANDARD_TUNING);
            GuitarChord F  = GuitarChord.fromString("Fmajor", pace, GuitarTuning.STANDARD_TUNING);
            GuitarChord G  = GuitarChord.fromString("Gmajor", pace, GuitarTuning.STANDARD_TUNING);
            GuitarChord Am = GuitarChord.fromString("Aminor", pace, GuitarTuning.STANDARD_TUNING);
            
            // 安全检查，确保所有和弦都已成功加载
            if (C == null || Em == null || F == null || G == null || Am == null) {
                System.err.println("错误: 加载和弦失败，请检查数据库路径和文件名。测试中止。");
                return;
            }
            System.out.println("和弦加载完毕！");
            
            // --- 4. 定义歌曲结构 ---
            GuitarChord[] verse1 = { C, Em, F, G };
            GuitarChord[] verse2 = { C, Em, F, G };
            GuitarChord[] chorus = { Em, Am, F, C, Em, Am, G, C };

            // --- 5. 开始演奏 ---
            System.out.println("\n--- 演奏开始 ---");
            
            System.out.println("\n[第一段主歌]");
            playSection(guitar, verse1, chengduPattern);
            
            System.out.println("\n[第二段主歌]");
            playSection(guitar, verse2, chengduPattern);
            
            System.out.println("\n[副歌]");
            playSection(guitar, chorus, chengduPattern);

            System.out.println("\n--- 演奏结束 ---");

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    /**
     * 辅助方法，用于演奏一个完整的乐段 (Section)。
     * @param guitar 吉他实例
     * @param section 要演奏的和弦数组
     * @param pattern 要使用的右手分解模式
     */
    private static void playSection(Guitar guitar, GuitarChord[] section, ArpeggioPattern pattern) throws Exception {
        if (guitar == null || section == null || pattern == null) return;
        
        // 遍历乐段中的每一个和弦
        for (GuitarChord chord : section) {
            if (chord != null) {
                // 打印当前正在演奏的和弦，便于调试
                System.out.println("  |> Playing Chord: " + chord.getFingering());
                // 使用 guitar 的 playArpeggio 方法来演奏
                guitar.playArpeggio(chord, pattern);
            }
        }
    }
}