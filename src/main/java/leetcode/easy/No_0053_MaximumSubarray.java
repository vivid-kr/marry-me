package leetcode.easy;

/**
 * TODO Time
 */
public class No_0053_MaximumSubarray {

  public int maxSubArray(int[] nums) {
    int sum = nums[0];
    int maxSum = sum;
    for (int i = 1; i < nums.length; i++) {
      if (sum < 0) {
        sum = 0;
      }
      sum += nums[i];
      if (sum > maxSum) {
        maxSum = sum;
      }
    }
    return maxSum;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Subarray.
   *
   * Memory Usage: 37.1 MB, less than 99.53% of Java online submissions for Maximum Subarray.
   *
   * 0次调试错误，然后成功。虽然是easy，但是思路还是挺精辟的。如果当前sum小于0，来了新的值，可以直接扔掉sum了
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
    No_0053_MaximumSubarray no = new No_0053_MaximumSubarray();

    System.out.println(no.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }
}

