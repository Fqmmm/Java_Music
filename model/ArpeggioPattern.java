package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class ArpeggioPattern {

    private final List<ArpeggioEvent> events;

    public ArpeggioPattern(List<ArpeggioEvent> events) {
        this.events = List.copyOf(events);
    }

    public List<ArpeggioEvent> getEvents() {
        return events;
    }

    public static ArpeggioPattern fromString(String patternString, double defaultFraction) {
        List<ArpeggioEvent> events = new ArrayList<>();
        String cleanString = patternString.replaceAll("\\s", "");
        int index = 0;

        while (index < cleanString.length()) {
            char currentChar = cleanString.charAt(index);

            if (currentChar == '[') {
                // --- 处理节奏块 ---
                int bracketCount = 1;
                index++; // 跳过 '['
                if (index < cleanString.length() && cleanString.charAt(index) == '[') {
                    bracketCount++;
                    index++; // 跳过第二个 '['
                }

                int closingBracketIndex = findClosingBracket(cleanString, index, bracketCount);
                if (closingBracketIndex == -1) {
                    System.err.println("解析错误: 在 " + cleanString + " 中找不到匹配的中括号。");
                    break;
                }
                
                String content = cleanString.substring(index, closingBracketIndex);
                List<ArpeggioEvent> blockEvents = parseBlockContent(content, defaultFraction);
                
                if (blockEvents.isEmpty()) {
                    index = closingBracketIndex + bracketCount;
                    continue;
                }
                
                double blockFraction = defaultFraction / Math.pow(2, bracketCount);
                double eventFraction = blockFraction / blockEvents.size();

                for (ArpeggioEvent event : blockEvents) {
                    events.add(createEventCopyWithNewFraction(event, eventFraction));
                }

                index = closingBracketIndex + bracketCount;

            } else {
                // --- 处理普通动作 ---
                int nextIndex = findNextTokenEnd(cleanString, index);
                String token = cleanString.substring(index, nextIndex);
                try {
                    events.add(parseToken(token, defaultFraction));
                } catch (IllegalArgumentException e) {
                    System.err.println("解析错误: " + e.getMessage() + " 在 '" + token + "'");
                }
                index = nextIndex;
            }
        }
        return new ArpeggioPattern(events);
    }

    private static List<ArpeggioEvent> parseBlockContent(String content, double fraction) {
        List<ArpeggioEvent> blockEvents = new ArrayList<>();
        int index = 0;
        while(index < content.length()) {
            int nextIndex = findNextTokenEnd(content, index);
            String token = content.substring(index, nextIndex);
            try {
                 blockEvents.add(parseToken(token, fraction));
            } catch (IllegalArgumentException e) {
                 System.err.println("解析错误: " + e.getMessage() + " 在块内 '" + token + "'");
            }
            index = nextIndex;
        }
        return blockEvents;
    }
    
    private static int findNextTokenEnd(String str, int start) {
        if (start >= str.length()) return start;
        char firstChar = str.charAt(start);
        if (firstChar == '(') {
            int closingParen = str.indexOf(')', start);
            return (closingParen == -1) ? str.length() : closingParen + 1;
        }
        return start + 1;
    }
    
    private static int findClosingBracket(String str, int start, int count) {
        String closing = (count == 1) ? "]" : "]]";
        return str.indexOf(closing, start);
    }

    private static ArpeggioEvent createEventCopyWithNewFraction(ArpeggioEvent event, double newFraction) {
        return new ArpeggioEvent(event.getType(), event.getStrings(), newFraction);
    }
    
    private static ArpeggioEvent parseToken(String token, double fraction) {
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