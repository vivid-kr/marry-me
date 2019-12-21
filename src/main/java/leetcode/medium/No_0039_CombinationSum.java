package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO Time
 */
public class No_0039_CombinationSum {

  public static void combine(int[] candidates, int target, int pos, List<Integer> current,
      List<List<Integer>> ret) {
    if (target <= 0) {
      if (target == 0) {
        ret.add(current);
      }
      return;
    }
    for (int i = pos; i < candidates.length; i++) {
      List<Integer> p = new ArrayList<>(current);
      p.add(candidates[i]);
      combine(candidates, target - candidates[i], i, p, ret);
    }
  }

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ret = new ArrayList<>();
    combine(candidates, target, 0, new ArrayList<>(), ret);
    return ret;
  }

  /**
   * Runtime: 7 ms, faster than 19.95% of Java online submissions for Combination Sum.
   *
   * Memory Usage: 37 MB, less than 100.00% of Java online submissions for Combination Sum.
   *
   * 0次调试错误，然后成功。
   *
   *
   * 一句话反思：空间节省，时间比较慢
   *
   * 新知识：
   */


  public static void main(String[] args) {
    List<List<Integer>> actual = combinationSum(new int[]{2, 3}, 8);

    System.out.println(actual);
    System.out.println("[[2, 2, 2, 2], [2, 3, 3]]".equals(actual.toString()));

  }
}

