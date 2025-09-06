package test;

import constant.GMInstruments;
import drafts.花海;
import model.Music;
import instruments.ScalePlayer;

public class TestTranspose {

    public static void main(String[] args) throws Exception {
        ScalePlayer player = new ScalePlayer(GMInstruments.PIANO_ACOUSTIC_GRAND);
        花海 花海draft = new 花海();
        Music 花海 = 花海draft.getMusic(80);
        花海.setSinger("周杰伦");
        player.playMusic(花海.transposed(3));
        player.close();
    }
}
