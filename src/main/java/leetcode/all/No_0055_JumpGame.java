package leetcode.hard;

import java.util.Arrays;

/**
 * TODO Time
 */
public class No_0055_JumpGame {

  public boolean canJump(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return true;
    }
    int n = nums.length, furthest = 0;
    for (int i = 0; i < n - 1; i++) {
      furthest = Math.max(furthest, nums[i] + i);
      if (furthest >= nums.length - 1) {
        return true;
      }
      if (i == furthest) {
        return false;
      }
    }
    return false;
  }

  /**
   * Runtime: 1 ms, faster than 99.72% of Java online submissions for Jump Game.
   *
   * Memory Usage: 40.4 MB, less than 72.65% of Java online submissions for Jump Game.
   *
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
    No_0055_JumpGame no = new No_0055_JumpGame();

    System.out.println(no.canJump(new int[]{2, 3, 1, 1, 4}));
    System.out.println(no.canJump(new int[]{3, 2, 1, 0, 4}));
  }
}

