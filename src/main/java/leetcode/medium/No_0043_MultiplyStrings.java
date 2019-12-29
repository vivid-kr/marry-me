package leetcode.medium;

import java.util.List;

/**
 * TODO Time
 */
public class No_0043_MultiplyStrings {

  public static String multiply(String num1, String num2) {
    if ("0".equals(num1) || "0".equals(num2)) {
      return "0";
    }
    int l1 = num1.length() - 1;
    int l2 = num2.length() - 1;
    int[] ret = new int[num1.length() + num2.length() + 1];
    for (int i = 0; i < num1.length(); i++) {
      for (int j = 0; j < num2.length(); j++) {
        int m = (num1.charAt(l1 - i) - '0') * (num2.charAt(l2 - j) - '0');
        ret[i + j] += m % 10;
        ret[i + j + 1] += m / 10;
        int s = i + j;
        while (ret[s] > 9) {
          ret[s] -= 10;
          ret[s + 1]++;
        }
      }
    }
    int max = ret.length - 1;
    for (; max >= 0; max--) {
      if (ret[max] != 0) {
        break;
      }
    }
    StringBuilder r = new StringBuilder(max + 1);
    for (int i = max; i >= 0; i--) {
      r.append(ret[i]);
    }
    return r.toString();
  }

  /**
   * Runtime: 6 ms, faster than 32.53% of Java online submissions for Multiply Strings.
   *
   * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Multiply Strings.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：输入参数是12，解析的时候第0位时1，不是2，正好反过来了
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
//    System.out.println("0".equals(multiply("0","12")));
    System.out.println(multiply("23", "22"));
    System.out.println("132".equals(multiply("11", "12")));
  }
}

