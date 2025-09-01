package model;
public class Note {
    
    private int scale;          // 音阶
    private double fraction;    // 占这一小节的几分之几
    private int duration;       // 持续时间（毫秒）
    private int velocity;       // 响度
    private int instrument;     // 乐器
        
    
    public Note(int scale, double fraction) {
        this(scale, fraction, Settings.velocity, Settings.instrument);
    }

    public Note(int scale, double fraction, int instrument) {
        this(scale, fraction, Settings.velocity, instrument);
    }

    public Note(int scale, double fraction, int velocity, int instrument) {
        this.scale = scale;
        this.fraction = fraction;
        // this.duration = (int) (fraction * 60 / Settings.pace * 1000);   // 毫秒
        this.velocity = velocity;
        this.instrument = instrument;
    }

    public int scale() {
        return scale;
    }

    public int duration() {
        return duration;
    }

    public int velocity() {
        return velocity;
    }

    public double fraction() {
        return fraction;
    }
    
    public double instrument() {
        return instrument;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setInstrument(int instrument) {
        this.instrument = instrument;
    }
    
    // 空节拍
    public static Note emptyNote(double fraction) {
        return new Note(0, fraction);
    }

    // 生成空节拍列表
    public static Note[] emptyNoteList(double fraction) {
        Note[] n = new Note[1];
        n[0] = emptyNote(fraction);
        return n;
    }

    // 1/4拍
    public static Note quarterNote(int scale, int velocity, int instrument) {
        return new Note(scale, 0.25, velocity, instrument);
    }

    // 1/4拍，但是音量和乐器取默认值
    public static Note quarterNote(int scale) {
        return new Note(scale, 0.25);
    }

    // 1/2拍
    public static Note halfNote(int scale, int velocity, int instrument) {
        return new Note(scale, 0.5, velocity, instrument);
    }

    // 1/2拍，但是音量和乐器取默认值
    public static Note halfNote(int scale) {
        return new Note(scale, 0.5);
    }

    // 1拍
    public static Note fullNote(int scale, int velocity, int instrument) {
        return new Note(scale, 1, velocity, instrument);
    }

    // 1拍，但是音量和乐器取默认值
    public static Note fullNote(int scale) {
        return new Note(scale, 1);
    }

    // 附点(dotted note)
    public static Note dottedNote0_75(int scale, int velocity, int instrument) {
        return new Note(scale, 0.75, velocity, instrument);
    }

    // 附点(dotted note)，但是音量和乐器取默认值
    public static Note dottedNote0_75(int scale) {
        return new Note(scale, 0.75);
    }

    // 附点(dotted note)
    public static Note dottedNote1_5(int scale, int velocity, int instrument) {
        return new Note(scale, 1.5, velocity, instrument);
    }

    // 附点(dotted note)，但是音量和乐器取默认值
    public static Note dottedNote1_5(int scale) {
        return new Note(scale, 1.5);
    }

}
