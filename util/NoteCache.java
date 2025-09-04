package util;

import java.util.HashMap;
import java.util.Map;
import model.Note; // 假设 Note 在 model 包下

public final class NoteCache {

    private static final Map<String, Note> cache = new HashMap<>();

    private NoteCache() {}

    /**
     * 根据音符属性，生成一个唯一的字符串 Key。
     * 这是一个很好的封装，符合 DRY 原则。
     */
    private static String getKey(int scale, double fraction, int velocity, int instrument) {
        return "s" + scale + "f" + fraction + "v" + velocity + "i" + instrument;
    }

    public static Note getNote(int scale, double fraction, int velocity, int instrument) {
        // 1. 调用封装好的方法创建 Key
        String key = getKey(scale, fraction, velocity, instrument);
        
        // 2. 使用 computeIfAbsent 实现缓存逻辑
        return cache.computeIfAbsent(key, _ -> new Note(scale, fraction, velocity, instrument));
    }
}