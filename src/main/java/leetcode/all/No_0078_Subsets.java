package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO Time
 */
public class No_0078_Subsets {

  public static List<List<Integer>> subsets(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ret = new ArrayList<>();
    dfs(nums, 0, new ArrayList<>(), ret);
    return ret;
  }

  private static void dfs(int[] nums, int idx, List<Integer> path, List<List<Integer>> ret) {
    ret.add(path);
    for (int i = idx; i < nums.length; i++) {
      List<Integer> p = new ArrayList<>(path);
      p.add(nums[i]);
      dfs(nums, i + 1, p, ret);
    }
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Subsets.
   *
   * Memory Usage: 37.1 MB, less than 99.18% of Java online submissions for Subsets.
   *
   * 注意，这里能够简洁处理的原因是，集合不重复，意味着不回头。[1,2,3,4]，已经有了[1]时，选了2，再看3，4；选了3，不用再看2，否则就重复了
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
    List<List<Integer>> actual = subsets(new int[]{1, 2, 3});
    for (List<Integer> l : actual) {
      System.out.println(l);
    }
  }
}

