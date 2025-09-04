package test;

import drafts.花海;
import model.Music;
import util.MusicPlayer;

public class TestTranspose {

    public static void main(String[] args) throws Exception {
        MusicPlayer player = new MusicPlayer();
        花海 花海draft = new 花海();
        Music 花海 = 花海draft.getMusic(80);
        花海.setSinger("周杰伦");
        player.playMusic(花海.transposed(-1));
        player.close();
    }
}
