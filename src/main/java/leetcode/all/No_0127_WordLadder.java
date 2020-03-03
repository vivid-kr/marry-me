package leetcode.all;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO Time
 */
public class No_0127_WordLadder {

  public int ladderLength(String start, String end, List<String> dict) {
    Set<String> ddict = new HashSet<>(dict);
    if (!ddict.contains(end)) {
      return 0;
    }
    Set<String> set1 = new HashSet<>();
    Set<String> set2 = new HashSet<>();

    set1.add(start);
    set2.add(end);

    return helper(ddict, set1, set2, 1);
  }

  int helper(Set<String> dict, Set<String> set1, Set<String> set2, int level) {
    if (set1.isEmpty()) {
      return 0;
    }

    if (set1.size() > set2.size()) {
      return helper(dict, set2, set1, level);
    }

    // remove words from both ends
    for (String word : set1) {
      dict.remove(word);
    }
    for (String word : set2) {
      dict.remove(word);
    }

    // the set for next level
    Set<String> set = new HashSet<>();

    // for each string in the current level
    for (String str : set1) {
      for (int i = 0; i < str.length(); i++) {
        char[] chars = str.toCharArray();

        // change letter at every position
        for (char ch = 'a'; ch <= 'z'; ch++) {
          chars[i] = ch;
          String word = new String(chars);

          // found the word in other end(set)
          if (set2.contains(word)) {
            return level + 1;
          }

          // if not, add to the next level
          if (dict.contains(word)) {
            set.add(word);
          }
        }
      }
    }

    return helper(dict, set2, set, level + 1);
  }

  /**
   * Runtime: 10 ms, faster than 98.98% of Java online submissions for Word Ladder.
   *
   * Memory Usage: 38.9 MB, less than 97.08% of Java online submissions for Word Ladder.
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
    No_0127_WordLadder no = new No_0127_WordLadder();
    String beginWord = "hit";
    String endWord = "cog";
    List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
    System.out.println(no.ladderLength(beginWord, endWord, wordList));
  }
}

