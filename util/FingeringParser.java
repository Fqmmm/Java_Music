package util;

import java.util.ArrayList;
import java.util.List;
import model.Note;

/**
 * 解析指法用的
 */
public class FingeringParser {
    public static List<Note> fingeringToNotes(String fingering, int[] tuning) {
        ArrayList<Note> notes = new ArrayList<>();
        // fingering 字符串的顺序是从6弦到1弦
        for (int i = 0; i < fingering.length() && i < 6; i++) {
            char fretChar = fingering.charAt(i);
            
            if (fretChar == 'x' || fretChar == 'X') {
                continue; // 跳过不发声的弦
            }
            
            // 将字符转换为品格数 (支持16进制，如 'a' 代表10品)
            int fret = Integer.parseInt(String.valueOf(fretChar), 16);
            
            int baseScale = tuning[i];
            int finalScale = baseScale + fret;
            
            // 注意：Note 的 fraction 在这里设为1.0作为占位符。
            // Chord 类的构造函数会根据 pace 重新计算并统一时长。
            notes.add(new Note(finalScale, 1.0));
        }
        return notes;
    }
}
