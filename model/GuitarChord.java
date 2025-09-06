package model;

import org.json.JSONArray;
import org.json.JSONObject; // 需要引入 JSON 库

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import constant.Settings;
import constant.GuitarTuning;

public final class GuitarChord extends Chord {
    
    // 吉他标准调弦 (从6弦到1弦)
    private static final int[] GUITAR_TUNING = GuitarTuning.STANDARD_TUNING;
    
    private final String fingering; // 指法，例如 "x32010"

    public GuitarChord(List<Note> notes, int pace, String fingering) {
        super(notes, pace);
        this.fingering = fingering;
    }

    public String getFingering() {
        return fingering;
    }

    /**
     * 从 chords-db 数据库中，根据名称加载一个吉他和弦。
     * @param name 和弦名称，格式为 "根音+后缀" (e.g., "Cmajor", "Dsus2", "A#minor")
     * @param pace 速度 (BPM)，用于计算和弦时长
     * @return 一个 GuitarChord 对象，如果找不到则返回 null
     */
    public static GuitarChord fromString(String name, int pace) {
        String root;
        String suffix;

        // 一个简单的解析逻辑
        if (name.length() > 1 && (name.charAt(1) == '#' || name.charAt(1) == 'b')) {
            root = name.substring(0, 2);
            suffix = name.substring(2);
        } else {
            root = name.substring(0, 1);
            suffix = name.substring(1);
        }

        String basePath = Settings.DBPath;
        String filePath = basePath + root + "/" + suffix + ".js";

        try {
            // 读取和清理文件
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // 移除 "export default " 和结尾的 ";"
            content = content.replace("export default ", "").trim();
            if (content.endsWith(";")) {
                content = content.substring(0, content.length() - 1);
            }

            // 解析json
            JSONObject chordData = new JSONObject(content);
            JSONArray positions = chordData.getJSONArray("positions");
            
            if (positions.length() == 0) {
                System.err.println("警告: 和弦 " + name + " 没有找到任何指法位置。");
                return null;
            }

            // 我们总是选择第一个、最常见的指法
            JSONObject firstPosition = positions.getJSONObject(0);
            String fingering = firstPosition.getString("frets");

            // 转换 fingering 为 Note
            List<Note> notes = fingeringToNotes(fingering);
            
            // --- 5. 创建并返回 GuitarChord 实例 ---
            return new GuitarChord(notes, pace, fingering);

        } catch (IOException e) {
            System.err.println("错误: 无法读取和弦文件: " + filePath + "。请检查路径和文件名。");
            return null;
        } catch (Exception e) {
            System.err.println("错误: 解析和弦 " + name + " 时出错: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 私有辅助方法：将 frets 字符串 ("x32010") 转换为 Note 列表。
     */
    private static List<Note> fingeringToNotes(String fingering) {
        ArrayList<Note> notes = new ArrayList<>();
        // fingering 字符串的顺序是从6弦到1弦
        for (int i = 0; i < fingering.length() && i < 6; i++) {
            char fretChar = fingering.charAt(i);
            
            if (fretChar == 'x' || fretChar == 'X') {
                continue; // 跳过不发声的弦
            }
            
            // 将字符转换为品格数 (支持16进制，如 'a' 代表10品)
            int fret = Integer.parseInt(String.valueOf(fretChar), 16);
            
            int baseScale = GUITAR_TUNING[i];
            int finalScale = baseScale + fret;
            
            // 注意：Note 的 fraction 在这里设为1.0作为占位符。
            // Chord 类的构造函数会根据 pace 重新计算并统一时长。
            notes.add(new Note(finalScale, 1.0));
        }
        return notes;
    }
}