package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ArpeggioPattern {

    private final List<ArpeggioEvent> events;

    public ArpeggioPattern(List<ArpeggioEvent> events) {
        this.events = List.copyOf(events);
    }

    public List<ArpeggioEvent> getEvents() {
        return events;
    }

    /**
     * 【最终修正版】从 DSL 字符串创建琶音模式。
     * 采用更稳健的两阶段解析策略。
     */
    public static ArpeggioPattern fromString(String patternString, double defaultFraction) {
        List<ArpeggioEvent> events = new ArrayList<>();
        
        // 阶段 1: 将字符串切分成 "节奏块" 和 "普通动作块"
        // 正则表达式匹配: 一个中括号包裹的所有内容，或者连续的非中括号非空格字符
        Pattern mainPattern = Pattern.compile("\\[[^\\]]+\\]|[^\\s\\[\\]]+");
        Matcher mainMatcher = mainPattern.matcher(patternString);

        while (mainMatcher.find()) {
            String block = mainMatcher.group();
            
            if (block.startsWith("[")) {
                // --- 处理节奏块, e.g., "[3(12)]" ---
                String content = block.substring(1, block.length() - 1); // 提取 "3(12)"
                int bracketCount = 1;
                // 处理双中括号
                if (content.startsWith("[")) {
                    bracketCount = 2;
                    content = content.substring(1, content.length() - 1);
                }
                
                double blockFraction = defaultFraction / Math.pow(2, bracketCount);
                List<String> tokens = tokenize(content); // 切分内部动作
                double eventFraction = blockFraction / tokens.size(); // 平分时长

                for (String token : tokens) {
                    try {
                        events.add(parseToken(token, eventFraction));
                    } catch (IllegalArgumentException e) {
                        System.err.println("错误 (节奏块内): " + e.getMessage() + " 在 '" + block + "'");
                    }
                }

            } else {
                // --- 处理普通动作块, e.g., "TS" ---
                List<String> tokens = tokenize(block); // "TS" -> ["T", "S"]
                for (String token : tokens) {
                    try {
                        events.add(parseToken(token, defaultFraction)); // 使用默认时长
                    } catch (IllegalArgumentException e) {
                        System.err.println("错误 (普通块内): " + e.getMessage() + " 在 '" + block + "'");
                    }
                }
            }
        }
        return new ArpeggioPattern(events);
    }

    /**
     * 辅助方法：将 "T(12)S" 这样的字符串切分成 ["T", "(12)", "S"]
     */
    private static List<String> tokenize(String content) {
        List<String> tokens = new ArrayList<>();
        // 正则表达式匹配: S, s, T, -, 数字, 或 (...)
        Pattern tokenPattern = Pattern.compile("[SsT-]|\\d|\\([^)]+\\)");
        Matcher matcher = tokenPattern.matcher(content);
        while (matcher.find()) {
            tokens.add(matcher.group());
        }
        return tokens;
    }
    
    /**
     * 【保持不变】这个 parseToken 方法的逻辑是正确的。
     */
    private static ArpeggioEvent parseToken(String token, double fraction) {
        // (这里的代码和我们上一版最终重构的 parseToken 完全一样)
        if (token == null || token.isEmpty()) throw new IllegalArgumentException("动作单元不能为空。");
        switch (token) {
            case "T": return new ArpeggioEvent(ArpeggioEvent.EventType.PLUCK, List.of(0), fraction);
            case "S": return new ArpeggioEvent(ArpeggioEvent.EventType.STRUM_DOWN, List.of(6, 1), fraction);
            case "s": return new ArpeggioEvent(ArpeggioEvent.EventType.STRUM_UP, List.of(1, 6), fraction);
            case "-": return new ArpeggioEvent(ArpeggioEvent.EventType.REST, null, fraction);
        }
        if (token.matches("\\d")) {
            return new ArpeggioEvent(ArpeggioEvent.EventType.PLUCK, List.of(Integer.parseInt(token)), fraction);
        }
        if (token.startsWith("(") && token.endsWith(")")) {
            String inner = token.substring(1, token.length() - 1);
            if (inner.isEmpty()) throw new IllegalArgumentException("括号内不能为空。");
            char firstChar = inner.charAt(0);
            if (firstChar == 'S' || firstChar == 's') {
                if (inner.length() != 3 || !Character.isDigit(inner.charAt(1)) || !Character.isDigit(inner.charAt(2))) {
                    throw new IllegalArgumentException("扫弦范围格式错误，应为 (Sxy) 或 (sxy)。");
                }
                List<Integer> range = List.of(Character.getNumericValue(inner.charAt(1)), Character.getNumericValue(inner.charAt(2)));
                return new ArpeggioEvent((firstChar == 'S') ? ArpeggioEvent.EventType.STRUM_DOWN : ArpeggioEvent.EventType.STRUM_UP, range, fraction);
            } else {
                HashSet<Integer> strings = new HashSet<>();
                for (char c : inner.toCharArray()) {
                    if (!Character.isDigit(c)) throw new IllegalArgumentException("同时拨弦的括号内只能包含数字。");
                    strings.add(Character.getNumericValue(c));
                }
                if (strings.isEmpty()) throw new IllegalArgumentException("同时拨弦括号内必须有数字。");
                return new ArpeggioEvent(ArpeggioEvent.EventType.PLUCK, new ArrayList<>(strings), fraction);
            }
        }
        throw new IllegalArgumentException("无法识别的动作单元格式: " + token);
    }
}