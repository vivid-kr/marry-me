package leetcode.medium;

import java.util.Arrays;

/**
 * TODO Time
 */
public class No_0034_FindFirstLastPosition {

  public static int searchInsert(int[] nums, float target) {
    int left = 0;
    int right = nums.length;
    if (right <= 0) {
      return -1;
    }
    int mid;
    int v;
    while (left < right) {
      mid = left + (right - left) / 2;
      v = nums[mid];
      if (v < target) {
        left = mid + 1;
      } else {
        right = mid;
      }

    }
    return left;
  }

  public static int[] searchRange(int[] nums, int target) {
    if (nums.length == 0) {
      return new int[]{-1, -1};
    }
    int leftIdx = searchInsert(nums, target - 0.5f);
    if (leftIdx == nums.length || (nums[leftIdx] != target)) {
      return new int[]{-1, -1};
    }
    int rightIdx = searchInsert(nums, target + 0.5f);
    return new int[]{leftIdx, rightIdx - 1};
  }

  /**
   * Runtime:
   *
   * Memory Usage:
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
    String expect = "[3, 4]";
    int[] actual = searchRange(new int[]{5,7,7,8,8,10}, 8);

    System.out.println(Arrays.toString(actual));
    System.out.println(expect.equals(Arrays.toString(actual)));
  }
}

