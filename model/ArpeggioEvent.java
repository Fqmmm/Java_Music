package model;

import java.util.List;

/**
 * 代表一次右手动作。
 */
public final class ArpeggioEvent {

    public enum EventType {
        PLUCK,       // 拨弦 (单个或多个)
        STRUM_DOWN,  // 向下扫弦
        STRUM_UP,    // 向上扫弦
        REST         // 休止
    }

    private final EventType type;
    private final List<Integer> strings; // 对于 PLUCK 是要拨的弦; 对于 STRUM 是 [start, end]
    private final double fraction;

    public ArpeggioEvent(EventType type, List<Integer> strings, double fraction) {
        this.type = type;
        this.strings = (strings == null) ? List.of() : List.copyOf(strings);
        this.fraction = fraction;
    }
    
    // Getters
    public EventType getType() { return type; }
    public List<Integer> getStrings() { return strings; }
    public double getFraction() { return fraction; }
}