package test;

import drafts.虚拟音乐;
import instruments.Guitar;
import model.*;
public class Test虚拟音乐 {
    public static void main(String[] args) throws Exception {
        虚拟音乐 虚拟音乐 = new 虚拟音乐();
        Music music = 虚拟音乐.getMusic(100);

        Guitar guitar = new Guitar();
        
        for (Lyric lyric : music) {
            for (Playable chord : lyric) {
                GuitarChord gc = (GuitarChord)chord;
                guitar.playArpeggio(gc, ArpeggioPattern.fromString("T3(12)3", 0.5));
            }
        }
    }
}
