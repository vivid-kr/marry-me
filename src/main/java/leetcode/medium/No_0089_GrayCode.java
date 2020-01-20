package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO Time
 */
public class No_0089_GrayCode {

  public static List<Integer> grayCode(int n) {
    if (n == 0) {
      return new ArrayList<>(Arrays.asList(0));
    }
    List<Integer> res = new ArrayList<>(1 << n);
    res.add(0);
    for (int i = 1; i < (1 << n); i <<= 1) {
      for (int j = res.size() - 1; j >= 0; j--) {
        res.add(i | res.get(j));
      }
    }
    return res;
  }

  /**
   * 参考https://leetcode.com/problems/gray-code/discuss/30105/Iterative-5-lines-in-Java
   *
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Gray Code.
   *
   * Memory Usage: 34.1 MB, less than 8.00% of Java online submissions for Gray Code.
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
    List<Integer> actual = grayCode(3);
    System.out.println(actual);
  }
}

