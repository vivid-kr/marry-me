package leetcode.medium;

import java.util.Arrays;

/**
 * TODO Time
 */
public class No_0075_SortColors {


  public static void sortColors(int[] nums) {
    int r = 0;
    int w = 0;
    int b = nums.length - 1;
    while (w <= b) {
      switch (nums[w]) {
        case 1:
          w++;
          break;
        case 0:
          nums[w] = nums[r];
          nums[r] = 0;
          r++;
          if (r - w == 1) {
            w++;
          }
          break;
        case 2:
          nums[w] = nums[b];
          nums[b] = 2;
          b--;
      }
    }
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
   *
   * Memory Usage: 35.1 MB, less than 99.21% of Java online submissions for Sort Colors.
   *
   *
   * 6次调试错误，然后成功。借鉴自他人
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
    int[] input = {2, 0, 2, 1, 1, 0};
    int[] expect = {0, 0, 1, 1, 2, 2};
    sortColors(input);

    System.out.println(Arrays.toString(input));
    System.out.println(Arrays.equals(input, expect));
  }
}

