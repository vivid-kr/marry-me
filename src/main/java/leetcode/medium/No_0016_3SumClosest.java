package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * TODO Time
 */
public class No_0016_3SumClosest {

  public static int threeSumClosest(int[] nums, int target) {
    if (nums.length < 3) {
      return -1;
    }
    Arrays.sort(nums);
    int bestDiff = Integer.MAX_VALUE;
    int bestSum = Integer.MAX_VALUE;
    int currentSum = 0;
    for (int i = 0; i < nums.length - 2; i++) {
      currentSum = nums[i];
      for (int j = i + 1; j < nums.length - 1; j++) {
        currentSum += nums[j];
        for (int s = j + 1; s < nums.length; s++) {
          int sum = currentSum + nums[s];
          int diff = Math.abs(sum - target);
          if (diff < bestDiff) {
            bestDiff = diff;
            bestSum = sum;
          }
          if (sum >= target) {
            break;
          }
        }
        currentSum -= nums[j];
      }
    }
    return bestSum;
  }

  /**
   * Runtime: 35 ms, faster than 9.65% of Java online submissions for 3Sum Closest.
   *
   * Memory Usage: 36.8 MB, less than 100.00% of Java online submissions for 3Sum
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：line 30写成了return，以为一旦出现大于target，之后就永远大于target了。但是，第二个数字可能会重置到比较小！所以只能跳出当前的循环。
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    int actual = threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
    System.out.println(actual);
    System.out.println(2 == actual);

    int[] nums = new int[]{-2, -1, 1, 2};
    int odd = 65535;
    int hash = nums[0] + odd * (nums[1] + odd * (nums[2] + odd * (nums[3])));
    System.out.println(hash);
    nums = new int[]{-2, 0, 0, 2};
    hash = nums[0] + odd * (nums[1] + odd * (nums[2] + odd * (nums[3])));
    System.out.println(hash);
    nums = new int[]{-1, 0, 0, 1};
    hash = nums[0] + odd * (nums[1] + odd * (nums[2] + odd * (nums[3])));
    System.out.println(hash);
  }
}

