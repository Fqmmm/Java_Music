import constant.GMInstruments;
import drafts.*;
import model.Music;
import model.Part;
import instruments.*;

public class PlayGround {
    
    public static void play王妃() {
        try {
            ScalePlayer player = new ScalePlayer(GMInstruments.BRASS_TRUMPET);
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
            ScalePlayer player = new ScalePlayer(GMInstruments.BRASS_TRUMPET);
            大东北我的家乡 dongbei = new 大东北我的家乡();
            Music dongbeiMusic = dongbei.getMusic(130);
            player.playMusic(dongbeiMusic);
            player.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void play花海() {
        try {
            ScalePlayer player = new ScalePlayer(GMInstruments.PIANO_ACOUSTIC_GRAND);
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
            ScalePlayer player = new ScalePlayer(GMInstruments.PIANO_ACOUSTIC_GRAND);
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
            ScalePlayer player1 = new ScalePlayer(GMInstruments.PIANO_ACOUSTIC_GRAND);
            ScalePlayer player2 = new ScalePlayer(GMInstruments.STRINGS_VIOLIN);

            我们都拥有海洋.Melody melodyDraft = new 我们都拥有海洋.Melody();
            我们都拥有海洋.Harmony harmonyDraft = new 我们都拥有海洋.Harmony();

            int pace = 71; 
            Music melody = melodyDraft.getMusic(pace, 100).transposed(3);
            Music harmony = harmonyDraft.getMusic(pace, 80).transposed(3);

            Part melodyPart = new Part(player1, melody);
            Part harmonyPart = new Part(player2, harmony);
            ScalePlayer.playMultipleMusic(melodyPart, harmonyPart);

            player1.close();
            player2.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        play我们都拥有海洋();
    }
}