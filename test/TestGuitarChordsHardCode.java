package test;
import constant.*;
import instruments.Guitar;

public class TestGuitarChordsHardCode {
    public static void main(String[] args) throws Exception {
        Guitar guitar = new Guitar(GMInstruments.GUITAR_ACOUSTIC_NYLON);
        
        // --- 测试 C Major ---
        System.out.println("播放: C Major (使用标准指法 x32010)");
        Thread.sleep(2500);
        guitar.reset();
        guitar.getGuitarStrings()[4].setFret(3); // 5弦3品
        guitar.getGuitarStrings()[3].setFret(2); // 4弦2品
        guitar.getGuitarStrings()[1].setFret(1); // 2弦1品
        // 3弦和1弦是0品，reset后已经是了
        // 6弦不弹，我们通过 strum 的起始点控制
        guitar.strum(4, 2000, 100); // 从5弦(索引4)开始扫
        Thread.sleep(2500);

        // --- 测试 G Major ---
        System.out.println("播放: G Major (使用标准指法 320003)");
        guitar.reset();
        guitar.getGuitarStrings()[5].setFret(3); // 6弦3品
        guitar.getGuitarStrings()[4].setFret(2); // 5弦2品
        guitar.getGuitarStrings()[0].setFret(3); // 1弦3品
        guitar.strum(5, 2000, 100); // 从6弦(索引5)开始扫
        Thread.sleep(2500);
    }
}