package leetcode.hard;

import java.util.Arrays;

/**
 * TODO Time
 */
public class No_0045_JumpGameII {

  public int jump(int[] nums) {
    int[] minReaches = new int[nums.length];
    Arrays.fill(minReaches, Integer.MAX_VALUE);
    minReaches[0] = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
        minReaches[i + j] = Math.min(minReaches[i + j], minReaches[i] + 1);
      }
    }
    return minReaches[nums.length - 1];
  }

  /**
   * Runtime: 319 ms, faster than 8.35% of Java online submissions for Jump Game II.
   * Memory Usage: 41 MB, less than 44.23% of Java online submissions for Jump Game II.
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
   * 新知识：Arrays.fill
   */


  public static void main(String[] args) {
    No_0045_JumpGameII no = new No_0045_JumpGameII();

    System.out.println(no.jump(new int[]{2, 3, 1, 1, 4}));
  }
}

