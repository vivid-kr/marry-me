package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO Time
 */
public class No_0090_SubsetsII {

  public static List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ret = new ArrayList<>();
    dfs(nums, 0, new ArrayList<>(), ret);
    return ret;
  }

  private static void dfs(int[] nums, int idx, List<Integer> path, List<List<Integer>> ret) {
    ret.add(path);
    for (int i = idx; i < nums.length; i++) {
      if (i > idx && nums[i] == nums[i - 1]) {
        continue;
      }
      List<Integer> p = new ArrayList<>(path);
      p.add(nums[i]);
      dfs(nums, i + 1, p, ret);
    }
  }

  /**
   * Runtime: 1 ms, faster than 99.80% of Java online submissions for Subsets II.
   *
   * Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Subsets II.
   *
   * 有重复的情况下，注意line 22的 i> idx。即，每一重深度，都至少添加一个，同时跳过剩下的重复值。这也就使得，对于[1,1,1,2,3]，三个1会以不同数量加入到susbet，而不会彼此重复
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
    List<List<Integer>> actual = subsetsWithDup(new int[]{1, 1, 1, 2, 3});
    for (List<Integer> l : actual) {
      System.out.println(l);
    }
  }
}

