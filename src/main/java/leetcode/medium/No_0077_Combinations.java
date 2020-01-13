package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Time
 */
public class No_0077_Combinations {

  private List<List<Integer>> res;
  private int n;
  private int k;
  private int[] com;

  private void subCombine(int p, int stIdx) {
    if (p == k) {
      List<Integer> list = new ArrayList<>(k);
      for (int l : com) {
        list.add(l+1);
      }
      res.add(list);
      return;
    }
    for (int i = stIdx; i < n - (k - p)+1; i++) {
      com[p] = i;
      subCombine(p + 1, i + 1);
    }
  }

  public List<List<Integer>> combine(int n, int k) {
    int comNum = 1;
    for (int i = k + 1; i <= n; i++) {
      comNum *= i;
    }
    for (int i = 1; i <= k; i++) {
      comNum /= i;
    }
    this.n = n;
    this.k = k;
    this.com = new int[k];
    this.res = new ArrayList<>(comNum);
    subCombine(0, 0);
    return res;
  }
  /**
   * Runtime: 2 ms, faster than 97.08% of Java online submissions for Combinations.
   *
   * Memory Usage: 38.9 MB, less than 86.96% of Java online submissions for Combinations.
   *
   * 0次调试错误，然后成功。LeetCode的错误。line 42，直接申请comNum这么多的内存，以后就不用expand，但是会报告内占用太大。好蠢
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
  private static void test1(int n, int k) {
    No_0077_Combinations no = new No_0077_Combinations();
    List<List<Integer>> rres = no.combine(n, k);
    for (List<Integer> rre : rres) {
      System.out.println(rre);
    }
    System.out.println(rres.size());
  }

  public static void main(String[] args) {
    test1(13,3);
  }
}

