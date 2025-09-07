package model;

import java.util.List;

/**
 * 代表一次琶音/分解和弦中的拨弦动作。
 * 这是一个不可变的数据记录 (Record)。
 * @param stringsToPluck 要拨动的琴弦列表 (1-6)。我们用一个特殊值 0 来代表"T" (Thumb)，它将动态映射到和弦的最低音弦。
 * @param fraction 这个动作的节拍时值 (例如 0.125 代表一个八分音符)。
 */
public record ArpeggioEvent(List<Integer> stringsToPluck, double fraction) {}