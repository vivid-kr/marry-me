package leetcode.medium;

/**
 * 2019-08-12 18:19:24
 */
public class No_0006_ZigZagConversion {

  public static String convert(String s, int numRows) {
    //INFO 注意标准的检错程序
    if (s == null || "".equals(s)) {
      return "";
    }
    // 第二次错误，比较关键，考虑边界条件：只有1行的时候，间隔不是1*2-2=0
    int interval = numRows == 1 ? 1 : numRows * 2 - 2;
    char[] ret = new char[s.length()];
    int charIdx = 0;
    for (int l = 0; l < numRows; l++) {
      for (int j = 0; ; j++) {
        int idx1 = interval * j + l;
        if (idx1 < s.length()) {
          ret[charIdx++] = s.charAt(idx1);
        } else {
          break;
        }
        if (l == 0 || l == numRows - 1) {
          // 第一次错误：continuou写成了break；是不执行下一段，而不是直接跳出循环
          continue;
        }
        int idx2 = interval * (j + 1) - l;
        if (idx2 < s.length()) {
          ret[charIdx++] = s.charAt(idx2);
        } else {
          break;
        }
      }
    }
    return new String(ret);
  }


  /**
   * Runtime: 2 ms, faster than 100.00%
   *
   * Memory Usage: 37.8 MB, less than 96.81%
   *
   * 2次调试错误，然后成功。质量不错。
   *
   * 错误：
   *
   * 1错：continuou错写成了break
   *
   * 2错：第二次错误，比较关键，考虑"边界条件"：只有1行的时候，间隔不是1*2-2=0
   *
   * 一句话反思：边界条件会引起异变。
   *
   * 新知识：char[] 转string。
   */
  public static void main(String[] args) {
    String expect = "PAHNAPLSIIGYIR";
    String actual = convert("PAYPALISHIRING", 3);
    System.out.println(actual);
    System.out.println(expect.equals(actual));
  }
}

