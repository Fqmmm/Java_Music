package test;

import model.Note;       // 引入 Note 类
import constant.Settings;   // 引入 Settings 类
import util.NoteCache; // 引入我们修改后的缓存类

/**
 * 用于测试 NoteCache 是否有效工作的程序。
 */
public class TestCache {

    public static void main(String[] args) {
        System.out.println("--- 开始测试 NoteCache ---");
        
        // 在测试开始前，重置统计数据以确保干净的环境
        NoteCache.resetStats();

        // --- 阶段1: 首次创建音符 ---
        System.out.println("\n阶段1: 首次创建三个不同的音符...");
        
        // 创建音符A (中央C，四分音符，使用默认乐器和音量)
        Note noteA1 = Note.quarterNote(60); 
        
        // 创建音符B (高音C，二分音符，使用默认乐器和音量)
        Note noteB1 = Note.halfNote(72);

        // 创建音符C (与A音高节拍相同，但乐器不同)
        Note noteC1 = Note.create(60, 0.25, Settings.velocity, 10); // 假设乐器10

        // 打印此时的统计信息
        NoteCache.printStats();
        System.out.println("预期: 3次未命中 (因为每个音符都是全新的)，0次命中，缓存大小为3。");

        // --- 阶段2: 重复请求已存在的音符 ---
        System.out.println("\n阶段2: 重复请求音符A和B，并请求一个新的音符D...");

        // 再次请求音符A
        Note noteA2 = Note.quarterNote(60);

        // 再次请求音符B
        Note noteB2 = Note.halfNote(72);

        // 创建一个全新的音符D
        Note noteD1 = Note.fullNote(65);
        
        // 打印此时的统计信息
        NoteCache.printStats();
        System.out.println("预期: 总共4次未命中 (A, B, C, D)，2次命中 (A2, B2)，缓存大小为4。");

        // --- 阶段3: 验证对象身份 ---
        System.out.println("\n阶段3: 验证从缓存中获取的音符是否为同一个对象...");
        
        // `==` 检查两个引用是否指向内存中的同一个对象。
        boolean isA_SameObject = (noteA1 == noteA2);
        boolean isB_SameObject = (noteB1 == noteB2);
        boolean isA_and_B_Different = (noteA1 != noteB1);
        boolean isA_and_C_Different = (noteA1 != noteC1);

        System.out.println("noteA1 和 noteA2 是同一个对象吗? -> " + isA_SameObject + " (预期: true)");
        System.out.println("noteB1 和 noteB2 是同一个对象吗? -> " + isB_SameObject + " (预期: true)");
        System.out.println("noteA1 和 noteB1 是不同对象吗? -> " + isA_and_B_Different + " (预期: true)");
        System.out.println("noteA1 和 noteC1 是不同对象吗? -> " + isA_and_C_Different + " (预期: true, 因为乐器不同)");

        System.out.println("\n--- 测试结束 ---");
    }
}