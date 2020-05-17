package leetcode.easy;

/**
 * TODO Time
 */
public class No_0038_CountandSay {

  public static String countAndSay(int n) {
    if (n < 1) {
      return null;
    }
    String s = "1";
    for (int i = 2; i <= n; i++) {
      StringBuilder sb = new StringBuilder();
      int count = 1;
      char lastChar = s.charAt(0);
      for (int j = 1; j < s.length(); j++) {
        char newChar = s.charAt(j);
        if (newChar == lastChar) {
          count++;
        } else {
          sb.append((char) ('0' + count));
          sb.append(lastChar);
          count = 1;
          lastChar = newChar;
        }
      }
      sb.append((char) ('0' + count));
      sb.append(lastChar);
      s = sb.toString();
    }
    return s;
  }

  /**
   * Runtime: 1 ms, faster than 99.67% of Java online submissions for Count and Say.
   *
   * Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Count and Say.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：StringBuilder同时可以接受int和char，('0'+count) 需要强制类型转换，但是我忘记括号，就成了(char)'0'，自然就对了
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
    for (int i = 1; i < 10; i++) {
      System.out.println(countAndSay(i));
    }
  }
}

