package leetcode.all;

/**
 * TODO Time
 */
public class No_0639_DecodeWaysII {

  public int numDecodings(String s) {
    if ("".equals(s) || s.charAt(0) == '0') {
      return 0;
    }
    char[] chars = s.toCharArray();
    long[] decNums = new long[chars.length];
    decNums[0] = chars[0] == '*' ? 9 : 1;
    for (int i = 1; i < chars.length; i++) {
      if (chars[i] == '*') {
        decNums[i] = 9 * decNums[i - 1];
      } else if (chars[i] > '0') {
        decNums[i] = decNums[i - 1];
      }
      // 计算这两个数字最多多少种组合
      int comb = 0;
      if (chars[i - 1] == '*') {
        if (chars[i] == '*') {
          comb = 15;
        } else if (chars[i] <= '6') {
          comb = 2;
        } else {
          comb = 1;
        }
      } else if (chars[i - 1] == '1') {
        if (chars[i] == '*') {
          comb = 9;
        } else {
          comb = 1;
        }
      } else if (chars[i - 1] == '2') {
        if (chars[i] == '*') {
          comb = 6;
        } else if (chars[i] <= '6') {
          comb = 1;
        }
      }
      if (comb > 0) {
        if (i == 1) {
          decNums[i] += comb;
        } else {
          decNums[i] += comb * decNums[i - 2];
        }
      }
      decNums[i] %= 1000000007;
      if (decNums[i - 1] == 0 && decNums[i] == 0) {
        return 0;
      }
    }
    return (int) decNums[decNums.length - 1];
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
   * 1错：line 13的 long 的问题。10^9 + 7太大了
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    No_0639_DecodeWaysII no = new No_0639_DecodeWaysII();
    System.out.println(no.numDecodings("**********1111111111"));
//    System.out.println(no.numDecodings("*"));
//    System.out.println(no.numDecodings("1*"));
//    System.out.println(no.numDecodings("12"));
//    System.out.println(no.numDecodings("226"));
  }
}

