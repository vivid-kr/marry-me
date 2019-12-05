package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO Time
 */
public class No_0018_4Sum {

  public static List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> ret = new ArrayList<>();
    Set<Integer> existSum = new HashSet<>();
    if (nums.length < 4) {
      return ret;
    }
    int odd = 31;
    for (int i = 0; i < nums.length - 3; i++) {
      // int newTarget1 = target - nums[i];
      for (int j = i + 1; j < nums.length - 2; j++) {
        int newTarget2 = target - nums[i] - nums[j];
        int st = j + 1;
        int end = nums.length - 1;
        while (st < end) {
          int sum = nums[st] + nums[end];
          if (sum < newTarget2) {
            st++;
          } else if (sum > newTarget2) {
            end--;
          } else {
            int hash =
                nums[i] + 100 + odd * (nums[j] + 100 + odd * (nums[st] + 100 + odd * (nums[end]
                    + 100)));
            if (!existSum.contains(hash)) {
              List<Integer> a = new ArrayList<>();
              a.add(nums[i]);
              a.add(nums[j]);
              a.add(nums[st]);
              a.add(nums[end]);
              ret.add(a);
              existSum.add(hash);
            }
            st++;
          }
        }
      }
    }
    return ret;
  }

  /**
   * Runtime: 23 ms, faster than 61.90% of Java online submissions for 4Sum.
   *
   * Memory Usage: 39.3 MB, less than 81.16% of Java online submissions for 4Sum.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：hash函数，用odd = 65535，越界之后，居然碰撞了！
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    int[] input = {1, 0, -1, 0, -2, 2};
    String expect = "[[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]";
    List<List<Integer>> actual = fourSum(input, 0);

    System.out.println(actual);
    System.out.println(expect.equals(actual.toString()));
  }
}

