package leetcode.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import sun.jvm.hotspot.ui.action.FindAction;

/**
 * TODO Time
 */
public class No_0126_WordLadderII {

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> res = new ArrayList<>();
    // java cannot modify char in String directly, get their char array to avoid array allocation
    char[] begin = beginWord.toCharArray();
    char[] end = endWord.toCharArray();
    Map<char[], String> wordMap = new HashMap<>();
    char[] endWordInList = null;
    int len = begin.length;
    for (String p : wordList) {
      char[] wordArray = p.toCharArray();
      if (endWordInList == null) {
        int i;
        for (i = 0; i < len; i++) {
          if (wordArray[i] != end[i]) {
            break;
          }
        }
        if (i == len) {
          endWordInList = wordArray;
        }
      }
      wordMap.put(wordArray, p);
    }
    if (endWordInList == null) {
      return res;
    }
    Set<char[]> wordSet = wordMap.keySet();

    Map<char[], List<char[]>> nodeNeighbors = new HashMap<>();
    Map<char[], Integer> nodeDistances = new HashMap<>();
    bfs(begin, wordSet, nodeNeighbors, nodeDistances, endWordInList);
    if (!nodeDistances.containsKey(endWordInList)) {
      return res;
    }
    ArrayList<String> solution = new ArrayList<>(nodeDistances.get(endWordInList) + 1);
    wordMap.put(begin, beginWord);
    dfs(begin, wordMap, nodeNeighbors, nodeDistances, endWordInList, solution, res, 0);
    return res;
  }

  private void dfs(char[] word,
      Map<char[], String> wordMap, Map<char[], List<char[]>> nodeNeighbors,
      Map<char[], Integer> nodeDistances, char[] endWordInList,
      List<String> solution, List<List<String>> res, int depth) {
    // 忘记了这一行！
    solution.add(wordMap.get(word));
    if (word == endWordInList) {
      List<String> r = new ArrayList<>(solution);
      res.add(r);
    } else {
      List<char[]> neighbors = nodeNeighbors.get(word);
      if (neighbors != null) {
        for (char[] neighbor : neighbors) {
          if (nodeDistances.get(neighbor) == depth + 1) {
            dfs(neighbor, wordMap, nodeNeighbors, nodeDistances, endWordInList, solution,
                res, depth + 1);
          }
        }
      }
    }
    solution.remove(depth);
  }

  private void bfs(char[] begin, Set<char[]> wordSet,
      Map<char[], List<char[]>> nodeNeighbors,
      Map<char[], Integer> nodeDistances, char[] endWordInList) {

    Queue<char[]> queue = new LinkedList<>();
    int len = begin.length;
    nodeDistances.put(begin, 0);
    queue.offer(begin);
    boolean foundEnd = false;
    int nextDistance = 0;
    while (!queue.isEmpty()) {
      int count = queue.size();
      nextDistance++;
      for (int i = 0; i < count; i++) {
        char[] cur = queue.poll();
        List<char[]> neighborsResult = getNeighbors(cur, wordSet, len);
        for (char[] nei : neighborsResult) {
          if (!nodeDistances.containsKey(nei)) {
            nodeDistances.put(nei, nextDistance);
            // compare char array
            if (nei == endWordInList) {
              foundEnd = true;
            } else {
              queue.offer(nei);
            }
          }
        }
        nodeNeighbors.put(cur, neighborsResult);
      }
      if (foundEnd) {
        break;
      }
    }
  }

  private List<char[]> getNeighbors(char[] cur, Set<char[]> wordSet,
      int len) {
    List<char[]> neighborsResult = new ArrayList<>();

    int diffCount;
    for (char[] word : wordSet) {
      diffCount = 0;
      for (int i = 0; i < len; i++) {
        if (cur[i] != word[i]) {
          diffCount++;
          if (diffCount == 2) {
            break;
          }
        }
      }
      if (diffCount == 1) {
        neighborsResult.add(word);
      }
    }
    return neighborsResult;
  }


  /**
   * Runtime:
   *
   * Memory Usage:
   *
   * Runtime: 872 ms, faster than 10.68% of Java online submissions for Word Ladder II.
   *
   * Memory Usage: 40.8 MB, less than 92.45% of Java online submissions for Word Ladder II.
   *
   * 次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：
   *
   * 2错：
   *
   * 一句话反思：没想到这么慢，可能是getNeighbors太耗时间了
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
    System.out.println((new No_0126_WordLadderII()).findLadders(beginWord, endWord, wordList));

    beginWord = "hit";
    endWord = "cog";
    wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

    System.out.println((new No_0126_WordLadderII()).findLadders(beginWord, endWord, wordList));

    beginWord = "hit";
    endWord = "cog";
    wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
    System.out.println((new No_0126_WordLadderII()).findLadders(beginWord, endWord, wordList));
  }
}

