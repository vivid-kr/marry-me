package leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Time
 */
public class No_0119_PascalTriangleII {

  public List<Integer> getRow(int rowIndex) {
    List<Integer> list = new ArrayList<Integer>();
    if (rowIndex < 0) {
      return list;
    }

    for (int i = 0; i < rowIndex + 1; i++) {
      list.add(0, 1);
      for (int j = 1; j < list.size() - 1; j++) {
        list.set(j, list.get(j) + list.get(j + 1));
      }
    }
    return list;
  }

  /**
   * Runtime: 1 ms, faster than 90.32% of Java online submissions for Pascal's Triangle II.
   *
   * Memory Usage: 33.6 MB, less than 6.17% of Java online submissions for Pascal's Triangle II.
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
    No_0119_PascalTriangleII no = new No_0119_PascalTriangleII();

    System.out.println(no);
  }
}

