package model;

import org.json.JSONArray;
import org.json.JSONObject; // 需要引入 JSON 库

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import constant.Settings;
import util.FingeringParser;

public final class GuitarChord extends Chord {
    
    // 吉他标准调弦 (从6弦到1弦)
    //private static final int[] GUITAR_TUNING = GuitarTuning.STANDARD_TUNING;
    
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
     * @param tuning 调弦方式
     * @return 一个 GuitarChord 对象，如果找不到则返回 null
     */
    public static GuitarChord fromString(String name, int pace, int[] tuning) {
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
            List<Note> notes = FingeringParser.fingeringToNotes(fingering, tuning);
            
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
}