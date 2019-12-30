package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO Time
 */
public class No_0046_Permutations {

  private static void perm(int[] nums, List<List<Integer>> ret, int P, int[] array) {
    if (P == nums.length) {
      List<Integer> t = new ArrayList<>(P);
      for (int a : array) {
        t.add(a);
      }
      ret.add(t);
    } else {
      for (int i = 0; i <= P; i++) {
        System.arraycopy(array, i, array, i + 1, P - i);
        array[i] = nums[P];
        perm(nums, ret, P + 1, array);
        System.arraycopy(array, i + 1, array, i, P - i);
      }
    }
  }

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ret = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return ret;
    }
    int[] array = new int[nums.length];
    perm(nums, ret, 0, array);
    return ret;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Permutations.
   *
   * Memory Usage: 37.3 MB, less than 97.16% of Java online submissions for Permutations.
   *
   * 0次调试错误，然后成功。
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
    List<List<Integer>> actual = permute(new int[]{1, 2, 3});
    System.out.println(actual);
//    System.out.println(expect.equals(actual));
  }
}

