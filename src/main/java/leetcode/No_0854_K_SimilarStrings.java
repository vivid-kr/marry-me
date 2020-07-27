package leetcode.all;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * TODO Time
 */
public class No_0854_K_SimilarStrings {

  public static int kSimilarity(String A, String B) {
    Queue<String> q = new ArrayDeque<>();
    q.add(A);
    int cnt = 0;
    Set<String> seen = new HashSet<>();
    while (!q.isEmpty()) {
      int size = q.size();
      for (int k = 0; k < size; k++) {
        A = q.poll();
        if (A.equals(B)) {
          return cnt;
        }
        int i = 0;
        while (A.charAt(i) == B.charAt(i)) {
          i++;
        }
        for (int j = i + 1; j < B.length(); j++) {
          if (A.charAt(i) != B.charAt(j)) {
            continue;
          }
          String tmp = swap(i, j, A);
          if (seen.add(tmp)) {
            q.add(tmp);
          }
        }
      }
      cnt++;
    }
    return -1;
  }

  private static String swap(int i, int j, String s) {
    char[] chs = s.toCharArray();
    char tmp = chs[i];
    chs[i] = chs[j];
    chs[j] = tmp;
    return new String(chs);
  }

  /**
   * Runtime: 20 ms, faster than 81.44% of Java online submissions for K-Similar Strings.
   *
   * Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for K-Similar Strings.
   *
   * ~~次调试错误，然后成功。
   *
   * 参照discussion，需要复习
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
    System.out.println(2 == kSimilarity("abac", "baca"));
  }
}

