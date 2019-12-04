package leetcode.easy;

import java.util.concurrent.atomic.AtomicLong;

/**
 * TODO Time
 */
public class No_0014_Longest_Common_Prefix {

  public static String longestCommonPrefix(String[] strs) {
    int minLen = Integer.MAX_VALUE;
    for (int i = 0; i < strs.length; i++) {
      if (minLen > strs[i].length()) {
        minLen = strs[i].length();
      }
    }
    StringBuilder a = new StringBuilder();
    for (int i = 0; i < minLen; i++) {
      char c = 0;
      boolean same = true;
      for (int j = 0; j < strs.length; j++) {
        if (c == 0) {
          c = strs[j].charAt(i);
        } else if (strs[j].charAt(i) != c) {
          same = false;
          break;
        }
      }
      if (!same) {
        break;
      }
      a.append(c);
    }
    return a.toString();
  }


  /**
   * Runtime:
   *
   * Memory Usage:
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
    String input[] = new String[]{"1","12","142"};
    String expect = "1";
    String actual = longestCommonPrefix(input);

    System.out.println(actual);
    System.out.println(expect.equals(actual));
  }
}

