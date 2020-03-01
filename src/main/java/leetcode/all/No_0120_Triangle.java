package leetcode.all;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO Time
 */
public class No_0120_Triangle {

  public int minimumTotal(List<List<Integer>> triangle) {
    if(triangle.isEmpty())
      return 0;

    int height = triangle.size();
    List<Integer> lastSum = triangle.get(0);
    List<Integer> thisSum = new ArrayList<>();

    for (int h = 2; h <= height; h++) {
      List<Integer> lineData = triangle.get(h-1);
      thisSum.add(lineData.get(0) + lastSum.get(0));
      for (int i = 1; i < h - 1; i++) {
        thisSum.add(lineData.get(i) + Math.min(lastSum.get(i - 1), lastSum.get(i)));
      }
      thisSum.add(lineData.get(h - 1) + lastSum.get(h - 2));
      lastSum.clear();
      List<Integer> tmp = thisSum;
      thisSum = lastSum;
      lastSum = tmp;
    }
    return Collections.min(lastSum);
  }


  /**
   * Runtime: 3 ms, faster than 42.84% of Java online submissions for Triangle.
   *
   * Memory Usage: 36.7 MB, less than 95.92% of Java online submissions for Triangle.
   *
   * 次调试错误，然后成功。如果追求内存占用，可以直接在triangle上修改，追求速度，可以申请数组，取舍吧，区别不大
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
    No_0120_Triangle no = new No_0120_Triangle();

    System.out.println(no);
  }
}

