package leetcode.all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO Time
 */
public class No_1200_MinimumAbsoluteDifference {

  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    Arrays.sort(arr);
    int[] diff = new int[arr.length - 1];
    int minDiff = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length - 1; i++) {
      diff[i] = arr[i + 1] - arr[i];
      if (diff[i] < minDiff) {
        minDiff = diff[i];
      }
    }
    List<List<Integer>> ret = new ArrayList<>();
    for (int i = 0; i < arr.length - 1; i++) {
      if (diff[i] == minDiff) {
        List<Integer> pair = new ArrayList<>();
        pair.add(arr[i]);
        pair.add(arr[i + 1]);
        ret.add(pair);
      }
    }
    return ret;
  }

  /**
   * Runtime: 21 ms, faster than 61.88% of Java online submissions for Minimum Absolute Difference.
   *
   * Memory Usage: 51.8 MB, less than 100.00% of Java online submissions for Minimum Absolute
   * Difference.
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
//    String input = "";
//    String expect = "0";
//    String actual = func(input);
//
//    System.out.println(actual);
//    System.out.println(expect.equals(actual));
  }
}

