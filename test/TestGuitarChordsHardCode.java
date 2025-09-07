package test;

import constant.GMInstruments;
import instruments.Guitar;

public class TestGuitarChordsHardCode {

    public static void main(String[] args) throws Exception {
        Guitar guitar = new Guitar(GMInstruments.GUITAR_ACOUSTIC_NYLON);
        
        // --- 测试 C Major (x32010) ---
        System.out.println("播放: C Major (使用标准指法 x32010)");
        
        guitar.reset(); // 清空指板，所有弦 fret = -1
        
        // guitarStrings 数组索引 0-5 对应 1-6 弦
        guitar.getGuitarStrings()[4].setFret(3); // 5弦3品
        guitar.getGuitarStrings()[3].setFret(2); // 4弦2品
        guitar.getGuitarStrings()[2].setFret(0); // ▼▼▼ 修正：明确设置 3弦 为 0品 (空弦) ▼▼▼
        guitar.getGuitarStrings()[1].setFret(1); // 2弦1品
        guitar.getGuitarStrings()[0].setFret(0); // ▼▼▼ 修正：明确设置 1弦 为 0品 (空弦) ▼▼▼
        
        // 6弦 (索引5) 的 fret 保持为 -1 (不按)

        // 从 5弦 (索引4) 开始扫到 1弦 (索引0)
        guitar.strum(5, 1, 2000, 100); 
        Thread.sleep(2500);

        // --- 测试 G Major (320003) ---
        System.out.println("播放: G Major (使用标准指法 320003)");

        guitar.reset(); // 再次清空指板
        
        guitar.getGuitarStrings()[5].setFret(3); // 6弦3品
        guitar.getGuitarStrings()[4].setFret(2); // 5弦2品
        guitar.getGuitarStrings()[3].setFret(0); // ▼▼▼ 修正：明确设置 4弦 为 0品 (空弦) ▼▼▼
        guitar.getGuitarStrings()[2].setFret(0); // ▼▼▼ 修正：明确设置 3弦 为 0品 (空弦) ▼▼▼
        guitar.getGuitarStrings()[1].setFret(0); // ▼▼▼ 修正：明确设置 2弦 为 0品 (空弦) ▼▼▼
        guitar.getGuitarStrings()[0].setFret(3); // 1弦3品

        // 从 6弦 (索引5) 开始扫到 1弦 (索引0)
        guitar.strum(6, 1, 2000, 100); 
        Thread.sleep(2500);
    }
}