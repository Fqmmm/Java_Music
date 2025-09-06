package test;

import model.GuitarChord;
import instruments.Guitar;
import constant.GMInstruments;
import constant.GuitarTuning;

/**
 * 一个增强版的吉他和弦数据库测试程序。
 * 用于全面验证从数据库加载的各种和弦类型的正确性。
 */
public class TestGuitarChordDB {

    public static void main(String[] args) {
        Guitar acousticGuitar = null;
        try {
            // --- 初始化 ---
            // 创建一个钢弦吉他实例，声音更明亮
            acousticGuitar = new Guitar(GMInstruments.GUITAR_ACOUSTIC_NYLON);
            int pace = 80; // 较慢的速度，以便听清和弦

            System.out.println("--- 吉他和弦数据库全面测试开始 ---");
            System.out.println("乐器: 钢弦吉他 | 速度: " + pace + " BPM");

            // --- 1. 基础开放和弦 (Open Chords) ---
            System.out.println("\n--- 测试1: 基础开放和弦 ---");
            playAndTestChord(acousticGuitar, "Gmajor", pace, "经典的 G 大调开放和弦 (320003)");
            playAndTestChord(acousticGuitar, "Cmajor", pace, "经典的 C 大调开放和弦 (x32010)");
            playAndTestChord(acousticGuitar, "Aminor", pace, "经典的 Am 小调开放和弦 (x02210)");
            playAndTestChord(acousticGuitar, "Eminor", pace, "经典的 Em 小调开放和弦 (022000)");

            // --- 2. 带有 'x' (静音弦) 的和弦 ---
            System.out.println("\n--- 测试2: 带有静音弦的和弦 ---");
            playAndTestChord(acousticGuitar, "Dmajor", pace, "D 大调和弦 (xx0232)，低音 E, A 弦不发声");
            playAndTestChord(acousticGuitar, "Dminor", pace, "Dm 小调和弦 (xx0231)，同样不弹低音弦");
            
            // --- 3. 七和弦 (7th Chords) ---
            System.out.println("\n--- 测试3: 各种色彩的七和弦 ---");
            playAndTestChord(acousticGuitar, "E7", pace, "E 属七和弦 (020100)，蓝调和摇滚中的常见和弦");
            playAndTestChord(acousticGuitar, "B7", pace, "B 属七和弦 (x21202)，一个稍微复杂但很重要的和弦");
            // 注意：chords-db 中可能没有 Cmaj7 的开放指法，我们来测试一个有的
            // 如果你的数据库中有 Gmajor7，可以用它
            // playAndTestChord(acousticGuitar, "Gmajor7", pace, "G 大七和弦，听起来应该非常柔和、华丽");

            // --- 4. 特色和弦 (Specialty Chords) ---
            System.out.println("\n--- 测试4: 特色和弦 ---");
            // 检查你的数据库中是否有 Dsus2 和 Dsus4
            // 路径：chords-db/src/db/guitar/chords/D/sus2.js
            playAndTestChord(acousticGuitar, "Dsus2", pace, "Dsus2 挂二和弦 (xx0230)，非常清新、开放的感觉");
            playAndTestChord(acousticGuitar, "Dsus4", pace, "Dsus4 挂四和弦 (xx0233)，有一种悬而未决、需要解决的感觉");

            // --- 5. 横按和弦 (Barre Chords) ---
            System.out.println("\n--- 测试5: 横按和弦 ---");
            playAndTestChord(acousticGuitar, "Fmajor", pace, "F 大调横按和弦 (133211)，所有弦都按住了");

            System.out.println("\n--- 所有测试已完成 ---");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 辅助方法，用于封装加载和播放和弦的重复逻辑。
     * @param guitar 吉他实例
     * @param chordName 和弦名称 (e.g., "Cmajor")
     * @param pace 速度
     * @param description 打印到控制台的描述信息
     */
    private static void playAndTestChord(Guitar guitar, String chordName, int pace, String description) throws InterruptedException {
        System.out.println("\n加载并播放: " + chordName);
        System.out.println("  |> " + description);
        
        GuitarChord chord = GuitarChord.fromString(chordName, pace, GuitarTuning.STANDARD_TUNING);
        
        if (chord != null) {
            System.out.println("  |> 成功！指法: " + chord.getFingering() + "。准备播放...");
            guitar.playChord(chord);
        } else {
            System.err.println("  |> 失败！未能在数据库中找到和弦: " + chordName);
        }
        Thread.sleep(2500); // 播放后停顿，以便听清楚
    }
}