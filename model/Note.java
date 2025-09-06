package model;

import java.util.Objects;

import constant.Settings;
import util.NoteCache;

/**
 * 音符类
 */
public class Note implements Cloneable {

    private int scale; // 音阶
    private double fraction; // 占这一小节的几分之几
    private int duration; // 持续时间（毫秒）
    private int velocity; // 响度
    private int instrument; // 乐器

    public Note(int scale, double fraction) {
        this(scale, fraction, Settings.velocity, Settings.instrument);
    }

    public Note(int scale, double fraction, int instrument) {
        this(scale, fraction, Settings.velocity, instrument);
    }

    public Note(int scale, double fraction, int velocity, int instrument) {
        this.scale = scale;
        this.fraction = fraction;
        // this.duration = (int) (fraction * 60 / Settings.pace * 1000); // 毫秒
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

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    /**
     * 创建并返回一个当前音符经过移调（升/降调）后的新实例。
     * 这个方法是不可变的，它不会修改原始音符。
     *
     * @param value 需要提升/降低（传入负数）的半音数量
     * @return 一个全新的、经过移调的 Note 对象
     */
    public Note transposed(int value) {
        // 如果是休止符，返回一个相同的休止符
        if (this.scale <= 0) {
            return this; // 或者 Note.create(0, this.fraction, ...);
        }

        int newScale = this.scale + value;

        // 边界检查
        if (newScale > 127)
            newScale = 127;
        if (newScale < 0)
            newScale = 0; // 如果降调太多，变成休止符

        // 通过工厂方法创建并返回一个全新的 Note 对象
        // 这会自动利用缓存，如果移调后的音符已存在，就会复用
        return Note.create(newScale, this.fraction, this.velocity, this.instrument);
    }

    // --- 核心修改：让所有创建Note的入口都通过NoteCache ---
    public static Note create(int scale, double fraction, int velocity, int instrument) {
        return NoteCache.getNote(scale, fraction, velocity, instrument);
    }

    public static Note create(int scale, double fraction, int instrument) {
        return NoteCache.getNote(scale, fraction, Settings.velocity, instrument);
    }

    public static Note create(int scale, double fraction) {
        return NoteCache.getNote(scale, fraction, Settings.velocity, Settings.instrument);
    }

    // 静态工厂方法现在调用 create 方法
    public static Note emptyNote(double fraction) {
        return create(0, fraction);
    }

    public static Note quarterNote(int scale) {
        return create(scale, 0.25);
    }

    public static Note quarterNote(int scale, int velocity, int instrument) {
        return create(scale, 0.25, velocity, instrument);
    }

    public static Note halfNote(int scale) {
        return create(scale, 0.5);
    }

    public static Note halfNote(int scale, int velocity, int instrument) {
        return create(scale, 0.5, velocity, instrument);
    }

    public static Note fullNote(int scale) {
        return create(scale, 1.0);
    }

    public static Note fullNote(int scale, int velocity, int instrument) {
        return create(scale, 1.0, velocity, instrument);
    }

    public static Note dottedNote0_75(int scale) {
        return create(scale, 0.75);
    }

    public static Note dottedNote0_75(int scale, int velocity, int instrument) {
        return create(scale, 0.75, velocity, instrument);
    }

    public static Note dottedNote1_5(int scale) {
        return create(scale, 1.5);
    }

    public static Note dottedNote1_5(int scale, int velocity, int instrument) {
        return create(scale, 1.5, velocity, instrument);
    }

    @Override
    public Note clone() {
        try {
            // 因为 Note 类的所有字段都是基本类型，
            // 所以 Object.clone() 执行的浅拷贝已经等同于深拷贝。
            return (Note) super.clone();
        } catch (CloneNotSupportedException e) {
            // 这不应该发生，因为我们实现了 Cloneable
            throw new AssertionError();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Note note = (Note) o;
        return scale == note.scale &&
                Double.compare(note.fraction, fraction) == 0 &&
                velocity == note.velocity &&
                instrument == note.instrument;
    }

    @Override
    public int hashCode() {
        // 使用 Objects.hash 来根据核心属性生成一个一致的哈希码
        return Objects.hash(scale, fraction, velocity, instrument);
    }

    public void showDebugInfo() {
        System.out.println("scale:" + scale);
        System.out.println("fraction" + fraction);
        System.out.println("duration" + duration);
        System.out.println("instrument" + instrument);
        System.out.println("velocity" + velocity);
    }

}
