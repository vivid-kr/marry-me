package leetcode.medium;

import sun.security.util.Length;

/**
 * TODO Time
 */
public class No_0091_DecodeWays {

  public int numDecodings(String s) {
    if ("".equals(s) || s.charAt(0) == '0') {
      return 0;
    }
    char[] chars = s.toCharArray();
    int[] decNums = new int[chars.length];
    decNums[0] = 1;
    for (int i = 1; i < chars.length; i++) {
      if (chars[i] > '0') {
        decNums[i] = decNums[i - 1];
      }
      if (chars[i - 1] == '1' || chars[i - 1] == '2' && chars[i] <= '6') {
        if(i == 1)
          decNums[i] += 1;
        else
          decNums[i] += decNums[i - 2];
      }
      if (decNums[i - 1] == 0 && decNums[i] == 0) {
        return 0;
      }
    }
    return decNums[decNums.length - 1];
  }

  /**
   * Runtime: 1 ms, faster than 98.50% of Java online submissions for Decode Ways.
   *
   * Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Decode Ways.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：27。注意，如果i==2,此时应该+1，而不是0，因为前两个char就形成了一种组合
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    No_0091_DecodeWays no = new No_0091_DecodeWays();

    System.out.println(no.numDecodings("12"));
    System.out.println(no.numDecodings("226"));
  }
}

