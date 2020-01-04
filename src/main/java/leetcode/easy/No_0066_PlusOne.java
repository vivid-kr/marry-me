package leetcode.easy;

import java.util.Arrays;

/**
 * TODO Time
 */
public class No_0066_PlusOne {

  public static int[] plusOne(int[] digits) {
    if (digits.length == 1 && digits[0] == 0) {
      return new int[]{1};
    }
    boolean allNine = true;
    for (int digit : digits) {
      if (digit != 9) {
        allNine = false;
        break;
      }
    }
    if (allNine) {
      int[] ret = new int[digits.length + 1];
      ret[0] = 1;
      return ret;
    }
    int dLen = digits.length - 1;
    digits[dLen]++;
    while (digits[dLen] > 9) {
      digits[dLen] -= 10;
      digits[dLen - 1]++;
      dLen--;
    }
    return digits;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
   *
   * Memory Usage: 35.1 MB, less than 97.58% of Java online submissions for Plus One.
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
    System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
    System.out.println("[1, 2, 4]".equals(Arrays.toString(plusOne(new int[]{1, 2, 3}))));
  }
}

