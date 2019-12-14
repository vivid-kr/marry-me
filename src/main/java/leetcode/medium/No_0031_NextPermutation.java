package leetcode.medium;

import java.util.Arrays;

/**
 * TODO Time
 */
public class No_0031_NextPermutation {

  public static void nextPermutation(int[] nums) {
    if (nums.length == 0) {
      return;
    }
    //reversed digits
    int revMax = nums.length - 2;
    while (revMax >= 0 && nums[revMax] >= nums[revMax + 1]) {
      revMax--;
    }
    if (revMax == -1) {
      reverse(nums, 0, nums.length - 1);
      return;
    }
    //find next
    int larger = nums.length - 1;
    while (nums[larger] <= nums[revMax]) {
      larger--;
    }
    swap(nums, revMax, larger);
    reverse(nums, revMax + 1, nums.length - 1);

  }

  public static void reverse(int[] nums, int a, int b) {
    //reverse
    for (int i = a; i <= (a + b) / 2; i++) {
      swap(nums, i, a + b - i);
    }
  }

  public static void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }


  /**
   * Runtime: 1 ms, faster than 90.63% of Java online submissions for Next Permutation.
   *
   * Memory Usage: 43.3 MB, less than 9.00% of Java online submissions for Next Permutation.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：revMax的计算错位了。
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
    int[] input = new int[]{3, 2, 1};
    String expect = "[1, 2, 3]";
    nextPermutation(input);
    System.out.println(Arrays.toString(input));
    System.out.println(expect.equals(Arrays.toString(input)));
  }
}

