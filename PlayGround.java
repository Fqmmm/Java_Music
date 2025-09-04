import constant.GMInstruments;
import drafts.*;
import model.Music;
import util.MusicPlayer;

public class PlayGround {
    
    public static void play王妃() {
        try {
            MusicPlayer player = new MusicPlayer();
            王妃 wangfeiDraft = new 王妃();
            Music wangfeiMusic = wangfeiDraft.getMusic(128);
            player.playMusic(wangfeiMusic);
            player.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void play大东北我的家乡() {
        try {
            MusicPlayer player = new MusicPlayer();
            大东北我的家乡 dongbei = new 大东北我的家乡();
            Music dongbeiMusic = dongbei.getMusic(130, GMInstruments.LEAD_2_SAWTOOTH);
            player.playMusic(dongbeiMusic);
            player.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void play花海() {
        try {
            MusicPlayer player = new MusicPlayer();
            花海 花海draft = new 花海();
            Music 花海 = 花海draft.getMusic(80);
            花海.setSinger("周杰伦");
            player.playMusic(花海);
            player.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void play你若三冬() {
        try {
            MusicPlayer player = new MusicPlayer();
            你若三冬 winterDraft = new 你若三冬();
            Music winter = winterDraft.getMusic(120);
            player.playMusic(winter);
            player.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void play我们都拥有海洋() {
        try {
            // 1. 初始化播放器
            MusicPlayer player = new MusicPlayer();

            // 2. 创建主旋律和和声的 "乐谱草稿"
            我们都拥有海洋.Melody melodyDraft = new 我们都拥有海洋.Melody();
            我们都拥有海洋.Harmony harmonyDraft = new 我们都拥有海洋.Harmony();

            // 3. 设定歌曲速度 (BPM)，并根据草稿生成最终的 Music 对象
            // 必须保证主旋律与和声的速度一致
            int pace = 71; 
            Music melody = melodyDraft.getMusic(pace, 0);
            Music harmony = harmonyDraft.getMusic(pace, GMInstruments.STRINGS_VIOLIN, 60);

            // 4. 使用多音轨播放功能，同时播放主旋律与和声
            // System.out.println("正在播放：《我们都拥有海洋》...");
            player.playMultipleMusic(melody, harmony);

            // 5. 播放完毕后，关闭播放器并释放资源
            player.close();
            // System.out.println("播放结束。");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        play大东北我的家乡();
    }
}