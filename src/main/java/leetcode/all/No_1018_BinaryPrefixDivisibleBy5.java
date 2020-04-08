package leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Time
 */
public class No_1018_BinaryPrefixDivisibleBy5 {

  public static List<Boolean> prefixesDivBy5(int[] A) {
    List<Boolean> ret = new ArrayList<>();
    if (A.length == 0) {
      return ret;
    }
    int a = 0;
    for (int value : A) {
      a = ((a << 1) + value) % 5;
      ret.add(a == 0);
    }
    return ret;
  }

  /**
   * Runtime: 3 ms, faster than 95.75% of Java online submissions for Binary Prefix Divisible By 5.
   *
   * Memory Usage: 39.6 MB, less than 100.00% of Java online submissions for Binary Prefix Divisible By 5.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：越界！数组太长，则line 18 a越界了
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    List<Boolean> actual = prefixesDivBy5(new int[]{0, 1, 1});
    System.out.println(actual);
//    System.out.println(expect.equals(actual));
  }
}

