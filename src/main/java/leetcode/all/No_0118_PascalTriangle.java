package leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Time
 */
public class No_0118_PascalTriangle {


  public List<List<Integer>> generate(int numRows)
  {
    List<List<Integer>> allrows = new ArrayList<List<Integer>>();
    ArrayList<Integer> row = new ArrayList<Integer>();
    for(int i=0;i<numRows;i++)
    {
      row.add(0, 1);
      for(int j=1;j<row.size()-1;j++)
        row.set(j, row.get(j)+row.get(j+1));
      allrows.add(new ArrayList<Integer>(row));
    }
    return allrows;

  }
  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle.
   *
   * Memory Usage: 33.8 MB, less than 7.23% of Java online submissions for Pascal's Triangle.
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
    No_0118_PascalTriangle no = new No_0118_PascalTriangle();

    System.out.println(no);
  }
}

