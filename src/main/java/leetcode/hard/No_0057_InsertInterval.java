package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO Time
 */
public class No_0057_InsertInterval {


  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> res = new ArrayList<>();
    if (intervals.length == 0) {
      res.add(newInterval);
      return res.toArray(intervals);
    }
    int i = 0;
    int k;
    for (; i < intervals.length && intervals[i][1] < newInterval[0]; i++) {
      res.add(intervals[i]);
    }
    if (i == intervals.length) {
      res.add(newInterval);
      return res.toArray(intervals);
    }
    k = i;
    for (; k < intervals.length && intervals[k][0] <= newInterval[1]; k++) {
      ;
    }
    if (k == i) {
      // 没有交叉的部分
      res.add(newInterval);
    } else {
      // inter[i] 到inter[k-1]有交叉
      res.add(new int[]{Math.min(intervals[i][0], newInterval[0]),
          Math.max(intervals[k - 1][1], newInterval[1])});
    }
    System.out.println(res);
    for (; k < intervals.length; k++) {
      res.add(intervals[k]);
    }
    return res.toArray(new int[res.size()][2]);
  }

  /**
   * Runtime: 4 ms, faster than 16.10% of Java online submissions for Insert Interval.
   *
   * Memory Usage: 39.5 MB, less than 90.63% of Java online submissions for Insert Interval.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：line 44，写成了return res.toArray(new newInterval)，以为随便用一个二维数组初始化，但结果是错误的
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    No_0057_InsertInterval no = new No_0057_InsertInterval();
    int[][] actual = no.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
    for (int[] ac : actual) {
      System.out.println(Arrays.toString(ac));
    }
    actual = no.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4, 8});
    for (int[] ac : actual) {
      System.out.println(Arrays.toString(ac));
    }
  }
}

