package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * TODO Time
 */
public class No_0056_MergeIntervals {

  public int[][] merge(int[][] intervals) {
    if (intervals.length < 2) {
      return intervals;
    }

    Arrays.sort(intervals, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        return a[0] - b[0];
      }
    });

    List<int[]> list = new ArrayList<>();

    int[] pre = intervals[0];

    for (int i = 1; i < intervals.length; i++) {
      int[] cur = intervals[i];
      if (pre[0] <= cur[0] && cur[0] <= pre[1]) {
        pre[1] = Math.max(pre[1], cur[1]);
      } else {
        list.add(pre);
        pre = cur;
      }
    }

    list.add(pre);
    int[][] res = new int[list.size()][2];

    return list.toArray(res);
  }

  /**
   * Runtime: 6 ms, faster than 89.00% of Java online submissions for Merge Intervals.
   *
   * Memory Usage: 37 MB, less than 100.00% of Java online submissions for Merge Intervals.
   *
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
    No_0056_MergeIntervals no = new No_0056_MergeIntervals();

    int[][] actual = no.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    int[][] expect = no.merge(new int[][]{{1, 6}, {8, 10}, {15, 18}});
    System.out.println(Arrays.deepEquals(actual, expect));
  }
}

