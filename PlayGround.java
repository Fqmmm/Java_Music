import drafts.*;

import model.GMInstruments;
import model.Music;
import model.MusicPlayer;

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

    public static void main(String[] args) {
        play你若三冬();
    }
}