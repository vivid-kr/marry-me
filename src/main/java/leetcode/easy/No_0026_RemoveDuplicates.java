package leetcode.easy;

import com.sun.tools.javac.util.Assert;
import java.util.Arrays;

/**
 * TODO Time
 */
public class No_0026_RemoveDuplicates {

  public static int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 1) {
      return 1;
    }
    int seenIdx = 0;
    int i;
    for (i = 1; i < nums.length; i++) {
      while (nums[i] == nums[seenIdx]) {
        i++;
        if (i == nums.length) {
          return seenIdx + 1;
        }
      }
      seenIdx++;
      nums[seenIdx] = nums[i];
    }
    return seenIdx + 1;
  }

  /**
   * Runtime: 1 ms, faster than 97.48% of Java online submissions for Remove Duplicates from Sorted
   * Array. Memory Usage: 39.4 MB, less than 99.47% of Java online submissions for Remove Duplicates
   * from Sorted Array.
   *
   * 2次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：line 10 返回值错误，line 24没返回值错误，基本错误
   *
   * 2错：比较蠢的错误：line 15原来写成了 while(i < nums.length && nums[i] == nums[seenIdx]) 但是，i== length
   * 跳出来之后，异常的i会进入正常的赋值line 22. 愚蠢的错误。
   *
   * 一句话反思：
   *
   * 新知识：
   */

  public static void main(String[] args) {
    int input[] = {0,0,1,1,1,2,2,3,3,4};
    int expect1 = 5;
    int[] expect2 = {0, 1, 2, 3, 4};
    int actual = removeDuplicates(input);
    Assert.check(expect1 == actual);
    for (int i = 0; i < expect2.length; i++)
      Assert.check(expect2[i] == input[i]);
    System.out.println(expect1);
    System.out.println(Arrays.toString(expect2));

  }
}

