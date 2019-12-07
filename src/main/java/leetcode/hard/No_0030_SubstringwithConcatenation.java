package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * TODO Time
 */
public class No_0030_SubstringwithConcatenation {

  public static List<Integer> findSubstring(String s, String[] words) {
    List<Integer> indexes = new ArrayList<>();
    if ("".equals(s) || words.length == 0) {
      return indexes;
    }

    final Map<String, Integer> counts = new HashMap<>();
    // count the number of each word
    for (final String word : words) {
      counts.put(word, counts.getOrDefault(word, 0) + 1);
    }
    final int n = s.length();
    final int wordSize = words.length;
    final int wordLen = words[0].length();
    for (int i = 0; i < n - wordSize * wordLen + 1; i++) {
      final Map<String, Integer> seen = new HashMap<>();
      int j = 0;
      while (j < wordSize) {
        final String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
        if (counts.containsKey(word)) {
          seen.put(word, seen.getOrDefault(word, 0) + 1);
          if (seen.get(word) > counts.getOrDefault(word, 0)) {
            break;
          }
        } else {
          break;
        }
        j++;
      }
      if (j == wordSize) {
        indexes.add(i);
      }
    }
    return indexes;
  }

  /**
   * Runtime: 86 ms, faster than 52.47% of Java online submissions for Substring with Concatenation
   * of All Words.
   *
   * Memory Usage: 39.7 MB, less than 76.19% of Java online submissions for Substring with
   * Concatenation of All Words.
   *
   *
   * 次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    String input = "";
    String expect = "0";
    List<Integer> actual = findSubstring(input, null);

    System.out.println(actual);
    System.out.println(expect.equals(actual));
  }
}

