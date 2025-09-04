package util;

import java.util.HashMap;
import java.util.Map;
import model.Note; // 假设您的 Note 类在 model 包下

/**
 * Note 对象的缓存类 (Flyweight 工厂)，带有统计功能。
 */
public final class NoteCache {

    private static final Map<String, Note> cache = new HashMap<>();
    
    // --- 新增：统计变量 ---
    private static int hitCount = 0;
    private static int missCount = 0;

    private NoteCache() {}

    private static String getKey(int scale, double fraction, int velocity, int instrument) {
        return "s" + scale + "f" + fraction + "v" + velocity + "i" + instrument;
    }

    public static Note getNote(int scale, double fraction, int velocity, int instrument) {
        String key = getKey(scale, fraction, velocity, instrument);
        
        Note note = cache.get(key);
        
        if (note == null) {
            // --- 缓存未命中 (Cache Miss) ---
            missCount++; // 增加未命中计数
            note = new Note(scale, fraction, velocity, instrument);
            cache.put(key, note);
        } else {
            // --- 缓存命中 (Cache Hit) ---
            hitCount++; // 增加命中计数
        }
        
        return note;
    }

    public static int getHitCount() {
        return hitCount;
    }

    public static int getMissCount() {
        return missCount;
    }

    public static int getCacheSize() {
        return cache.size();
    }
    
    public static void printStats() {
        System.out.println("--- NoteCache 统计信息 ---");
        System.out.println("缓存大小 (Cache Size): " + getCacheSize());
        System.out.println("缓存命中 (Hits)    : " + getHitCount());
        System.out.println("缓存未命中 (Misses): " + getMissCount());
        System.out.println("--------------------------");
    }
    
    public static void resetStats() {
        cache.clear();
        hitCount = 0;
        missCount = 0;
    }
}