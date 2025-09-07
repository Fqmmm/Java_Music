package model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 代表一个完整的右手分解型/琶音模式。
 * 它由一系列 ArpeggioEvent 组成，并能通过一个简单的字符串来构建。
 */
public final class ArpeggioPattern {

    private final List<ArpeggioEvent> events;

    public ArpeggioPattern(List<ArpeggioEvent> events) {
        this.events = List.copyOf(events);
    }

    public List<ArpeggioEvent> getEvents() {
        return events;
    }

    /**
     * 【核心】从一个简化的字符串创建琶音模式。
     * @param patternString 模式字符串。例如:
     *                      "T32123" -> T, 3, 2, 1, 2, 3
     *                      "T3(12)3" -> T, 3, (1和2弦同时), 3
     *                      未来可扩展节奏: "T/4 (123)/4 1/8 2/8 3/8" (暂未实现)
     * @param defaultFraction 每个动作的默认时值，例如 0.125 代表八分音符。
     * @return 一个新的 ArpeggioPattern 对象。
     */
    public static ArpeggioPattern fromString(String patternString, double defaultFraction) {
        List<ArpeggioEvent> events = new ArrayList<>();
        // 使用正则表达式来匹配 "T", 数字, 或 "(...)" 这样的组合
        Pattern pattern = Pattern.compile("T|\\d|\\([^)]+\\)");
        Matcher matcher = pattern.matcher(patternString);

        while (matcher.find()) {
            String token = matcher.group();
            List<Integer> stringsToPluck = new ArrayList<>();

            if (token.equals("T")) {
                stringsToPluck.add(0); // 0 作为 Thumb 的占位符
            } else if (token.startsWith("(")) {
                // 处理同时拨弦，例如 "(12)" 或 "(123)"
                String inner = token.substring(1, token.length() - 1);
                for (char c : inner.toCharArray()) {
                    stringsToPluck.add(Character.getNumericValue(c));
                }
            } else {
                // 处理单根弦
                stringsToPluck.add(Integer.parseInt(token));
            }
            
            events.add(new ArpeggioEvent(stringsToPluck, defaultFraction));
        }
        return new ArpeggioPattern(events);
    }
}