package leetcode.all;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * TODO Time
 */
public class No_0433_MinimumGeneticMutation {

  private char[] nucleobases = {'A', 'T', 'G', 'C'};

  public int minMutation(String start, String end, String[] bank) {
    Set<String> ddict = new HashSet<>(Arrays.asList(bank));
    if (!ddict.contains(end)) {
      return -1;
    }
    Set<String> set1 = new HashSet<>();
    Set<String> set2 = new HashSet<>();

    set1.add(start);
    set2.add(end);

    return helper(ddict, set1, set2, 0);
  }

  int helper(Set<String> dict, Set<String> set1, Set<String> set2, int level) {
    if (set1.isEmpty()) {
      return -1;
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
        for (char ch : nucleobases) {
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
   * Runtime: 1 ms, faster than 66.94% of Java online submissions for Minimum Genetic Mutation.
   *
   * Memory Usage: 34.2 MB, less than 100.00% of Java online submissions for Minimum Genetic Mutation.
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
    No_0433_MinimumGeneticMutation no = new No_0433_MinimumGeneticMutation();
    String beginWord = "AAAAACCC";
    String endWord = "AACCCCCC";
    String[] wordList = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
    System.out.println(no.minMutation(beginWord, endWord, wordList));
    beginWord = "AACCGGTA";
    endWord = "AACCGGTA";
    wordList = new String[]{"AACCGGTA"};
    System.out.println(no.minMutation(beginWord, endWord, wordList));
  }
}

