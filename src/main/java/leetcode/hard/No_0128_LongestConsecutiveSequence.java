package leetcode.hard;

import java.util.Arrays;
import java.util.Vector;

/**
 * TODO Time
 */
public class No_0128_LongestConsecutiveSequence {

  public int longestConsecutive(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    Arrays.sort(nums);
    int prev = nums[0];
    int maxLen = 1;
    int conLen = 1;
    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];
      if (num > prev + 1) {
        // break
        if (conLen > maxLen) {
          maxLen = conLen;
        }
        conLen = 1;
      } else if (num == prev + 1) {
        conLen++;
      }
      prev = num;
    }
    return Math.max(conLen, maxLen);
  }

  /**
   * 真有你的，直接用桶排序？然后累加。
   * 这个方法非常冒险，不值得推荐，因为数组长度是10^4，但是值域范围是10^9
   *
   * 复杂度是固定的O(3*n)
   * @param nums
   * @return
   */
  public int longestConsecutive2(int[] nums) {
    if (nums.length <= 0) {
      return 0;
    }
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int n : nums) {
      max = Math.max(max, n);
      min = Math.min(min, n);
    }
    int[] dic = new int[max - min + 1];
    for (int n : nums) {
      dic[n - min] = 1;
    }
    int res = 0;
    int currentRes = 0;
    for (int i = 0; i < max - min + 1; i++) {
      if (dic[i] == 1) {
        currentRes++;
        res = Math.max(res, currentRes);
      } else {
        currentRes = 0;
      }
    }
    return res;
  }


  /**
   * Runtime: 2 ms, faster than 99.59% of Java online submissions for Longest Consecutive Sequence.
   *
   * Memory Usage: 39.1 MB, less than 65.97% of Java online submissions for Longest Consecutive
   * Sequence.
   *
   * logN的复杂度，结果快于99.59%，讽刺
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
    int[] input;
    input = new int[]{100, 4, 200, 1, 3, 2};
    System.out.println((new No_0128_LongestConsecutiveSequence()).longestConsecutive(input));

    input = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    System.out.println((new No_0128_LongestConsecutiveSequence()).longestConsecutive(input));
  }
}

