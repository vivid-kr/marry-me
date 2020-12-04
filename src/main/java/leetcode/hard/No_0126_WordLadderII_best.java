package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * TODO Time
 */
public class No_0126_WordLadderII_best {

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> result = new ArrayList<>();
    Set<String> dict = new HashSet<>(wordList);
    if (!dict.contains(endWord)) {
      return result;
    }

    Map<String, List<String>> map = new HashMap<>();

    // 67ms - 84%
    //Set<String> set = new HashSet<>(Arrays.asList(beginWord));
    //searchMap(set, endWord, dict, map);

    // 11ms - 100%
    Set<String> set1 = new HashSet<>(Arrays.asList(beginWord));
    Set<String> set2 = new HashSet<>(Arrays.asList(endWord));
    if (!searchMap(set1, set2, dict, map, true)) {
      return result;
    }

    List<String> list = new ArrayList<>();
    list.add(beginWord);
    searchLadders(beginWord, endWord, list, map, result);
    return result;
  }

  // search from both beginWord and endWord
  private boolean searchMap(Set<String> set1, Set<String> set2, Set<String> dict,
      Map<String, List<String>> map, boolean forward) {
    if (set1.size() > set2.size()) {
      return searchMap(set2, set1, dict, map, !forward);
    }
    if (set1.isEmpty()) {
      return false;
    }

    Set<String> newSet = new HashSet<>();
    boolean found = false;
    dict.removeAll(set1);
    for (String curr : set1) {
      char[] arr = curr.toCharArray();
      for (int j = 0; j < arr.length; j++) {
        char tmp = arr[j];
        for (char c = 'a'; c <= 'z'; c++) {
          if (c == tmp) {
            continue;
          }
          arr[j] = c;
          String next = new String(arr);
          if (!dict.contains(next)) {
            continue;
          }
          newSet.add(next);
          String key = forward ? curr : next;
          String val = forward ? next : curr;
          // 在双向search中，可能是1个key找多个neighbor，也可能是一个neighbor找多个key（顺序不同），所以这里处理成putIfAbsent
          map.putIfAbsent(key, new ArrayList<>());
          map.get(key).add(val);
          if (set2.contains(next)) {
            found = true;
          }
        }
        arr[j] = tmp;
      }
    }
    if (found) {
      return true;
    }
    return searchMap(newSet, set2, dict, map, forward);
  }

  private void searchLadders(String curr, String target, List<String> list,
      Map<String, List<String>> map, List<List<String>> result) {
    // 这里没有用distance，居然也很快！
    // 不过双向search不方便记录distance的
    if (curr.equals(target)) {
      result.add(new ArrayList<>(list));
      return;
    }
    if (!map.containsKey(curr)) {
      return;
    }
    for (String next : map.get(curr)) {
      list.add(next);
      searchLadders(next, target, list, map, result);
      list.remove(list.size() - 1);
    }
  }

  /**
   * 这是最好的解法，研究一下。
   *
   *
   * Runtime: 13 ms, faster than 98.66% of Java online submissions for Word Ladder II.
   *
   * Memory Usage: 40.4 MB, less than 95.36% of Java online submissions for Word Ladder II.
   *
   * 一句话反思：双向search，总是从最小的搜索空间开始找起，漂亮
   *
   * 新知识：
   */


  public static void main(String[] args) {

    String beginWord;
    String endWord;
    List<String> wordList;

    beginWord = "a";
    endWord = "c";
    wordList = Arrays.asList("a", "b", "c");
    System.out.println((new No_0126_WordLadderII_best()).findLadders(beginWord, endWord, wordList));

    beginWord = "hit";
    endWord = "cog";
    wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

    System.out.println((new No_0126_WordLadderII_best()).findLadders(beginWord, endWord, wordList));

    beginWord = "hit";
    endWord = "cog";
    wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
    System.out.println((new No_0126_WordLadderII_best()).findLadders(beginWord, endWord, wordList));
  }
}

