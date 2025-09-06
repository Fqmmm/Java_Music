package test;

import model.GuitarChord;
import instruments.Guitar;
import constant.GMInstruments;

public class TestGuitarChordDB {

    public static void main(String[] args) {
        Guitar guitar = null;
        try {
            guitar = new Guitar(GMInstruments.GUITAR_ACOUSTIC_NYLON);
            int pace = 80;

            System.out.println("--- 从数据库加载并测试吉他和弦 ---");

            // 1. 加载 C Major 和弦
            System.out.println("\n加载: Cmajor...");
            GuitarChord cMajor = GuitarChord.fromString("Cmajor", pace);
            if (cMajor != null) {
                System.out.println("  |> 成功！指法: " + cMajor.getFingering() + "。准备播放...");
                guitar.playChord(cMajor);
            }
            Thread.sleep(2000);

            // 2. 加载 A Minor 和弦
            System.out.println("\n加载: Aminor...");
            GuitarChord aMinor = GuitarChord.fromString("Aminor", pace);
            if (aMinor != null) {
                System.out.println("  |> 成功！指法: " + aMinor.getFingering() + "。准备播放...");
                guitar.playChord(aMinor);
            }
            Thread.sleep(2000);
            
            // 3. 加载一个带 # 号的和弦
            System.out.println("\n加载: C#major...");
            GuitarChord cSharpMajor = GuitarChord.fromString("C#major", pace);
            if (cSharpMajor != null) {
                System.out.println("  |> 成功！指法: " + cSharpMajor.getFingering() + "。准备播放...");
                guitar.playChord(cSharpMajor);
            }
            Thread.sleep(2000);

            System.out.println("\n--- 测试结束 ---");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}