package drafts;
import model.Lyric;
import model.Music;
import model.MusicDraft;
import model.Note;

/**
 * 《大东北我的家乡》的乐谱。只包含前奏部分。
 */
public class 大东北我的家乡 implements MusicDraft {

    /**
     * 前奏部分 (共4行，16小节)。
     * 这是一个纯粹的乐谱定义，使用默认乐器。
     */
    public static final Lyric 前奏 = Lyric.fromNotes(
        Note.emptyNote(1),
        // --- 第1行 ---
        // | 6 6·5 63 5 |
        Note.fullNote(medium[6]), Note.dottedNote0_75(medium[6]), Note.quarterNote(medium[5]), Note.halfNote(medium[6]), Note.halfNote(medium[3]), Note.fullNote(medium[5]),
        // | 3·5 37 6 - |
        Note.dottedNote0_75(medium[3]), Note.quarterNote(medium[5]), Note.halfNote(medium[3]), Note.halfNote(medium[7]), new Note(medium[6], 2),
        // | 6 i·6 żi i6 |
        Note.fullNote(medium[6]), Note.dottedNote0_75(high[1]), Note.quarterNote(medium[6]), Note.halfNote(high[2]), Note.halfNote(high[1]), Note.halfNote(high[1]), Note.halfNote(medium[6]),
        // | 6·5 25 3 - |
        Note.dottedNote0_75(medium[6]), Note.quarterNote(medium[5]), Note.halfNote(medium[2]), Note.halfNote(medium[5]), new Note(medium[3], 2),

        // --- 第2行 ---
        // | 6·6 65 66i 65 |
        Note.dottedNote0_75(medium[6]), Note.quarterNote(medium[6]), Note.halfNote(medium[6]), Note.halfNote(medium[5]), Note.quarterNote(medium[6]), Note.quarterNote(medium[6]), Note.halfNote(high[1]), Note.halfNote(medium[6]), Note.halfNote(medium[5]),
        // | 332 153 2 - |
        Note.quarterNote(medium[3]), Note.quarterNote(medium[3]), Note.halfNote(medium[2]), Note.quarterNote(medium[1]), Note.quarterNote(medium[5]), Note.halfNote(medium[3]), new Note(medium[2], 2),
        // | 5·3 53 55 3i |
        Note.dottedNote0_75(medium[5]), Note.quarterNote(medium[3]), Note.halfNote(medium[5]), Note.halfNote(medium[3]), Note.halfNote(medium[5]), Note.halfNote(medium[5]), Note.halfNote(medium[3]), Note.halfNote(high[1]),
        // | 6 - - - |
        new Note(medium[6], 4),

        // --- 第3行 (重复第1行) ---
        Note.fullNote(medium[6]), Note.dottedNote0_75(medium[6]), Note.quarterNote(medium[5]), Note.halfNote(medium[6]), Note.halfNote(medium[3]), Note.fullNote(medium[5]),
        Note.dottedNote0_75(medium[3]), Note.quarterNote(medium[5]), Note.halfNote(medium[3]), Note.halfNote(medium[7]), new Note(medium[6], 2),
        Note.fullNote(medium[6]), Note.dottedNote0_75(high[1]), Note.quarterNote(medium[6]), Note.halfNote(high[2]), Note.halfNote(high[1]), Note.halfNote(high[1]), Note.halfNote(medium[6]),
        Note.dottedNote0_75(medium[6]), Note.quarterNote(medium[5]), Note.halfNote(medium[2]), Note.halfNote(medium[5]), new Note(medium[3], 2),

        // --- 第4行 (变奏) ---
        Note.dottedNote0_75(medium[6]), Note.quarterNote(medium[6]), Note.halfNote(medium[6]), Note.halfNote(medium[5]), Note.quarterNote(medium[6]), Note.quarterNote(medium[6]), Note.halfNote(high[1]), Note.halfNote(medium[6]), Note.halfNote(medium[5]),
        Note.quarterNote(medium[3]), Note.quarterNote(medium[3]), Note.halfNote(medium[5]), Note.quarterNote(medium[1]), Note.quarterNote(medium[5]), Note.halfNote(medium[3]), new Note(medium[2], 2),
        Note.dottedNote0_75(medium[5]), Note.quarterNote(medium[3]), Note.halfNote(medium[5]), Note.halfNote(medium[3]), Note.halfNote(medium[5]), Note.halfNote(medium[3]), Note.fullNote(medium[5]),
        Note.halfNote(medium[5]), Note.halfNote(medium[5]), Note.halfNote(medium[3]), Note.halfNote(high[1]), new Note(medium[6], 3)
    );

    @Override
    public Music getMusic(int pace, int instrument, int velocity) {
        Music music = Music.fromLyrics(pace, 前奏);

        // 设置音量
        if (velocity >= 0) {
            music.unifyVelocity(velocity);
        }
        return music;
    }
}