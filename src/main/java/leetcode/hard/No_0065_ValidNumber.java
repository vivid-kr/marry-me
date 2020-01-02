package leetcode.hard;

/**
 * TODO Time
 */
public class No_0065_ValidNumber {

  public static boolean isNumber(String s) {
    s = s.trim();

    boolean pointSeen = false;
    boolean eSeen = false;
    boolean numberSeen = false;
    boolean numberAfterE = true;
    for (int i = 0; i < s.length(); i++) {
      if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
        numberSeen = true;
        numberAfterE = true;
      } else if (s.charAt(i) == '.') {
        if (eSeen || pointSeen) {
          return false;
        }
        pointSeen = true;
      } else if (s.charAt(i) == 'e') {
        if (eSeen || !numberSeen) {
          return false;
        }
        numberAfterE = false;
        eSeen = true;
      } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
        if (i != 0 && s.charAt(i - 1) != 'e') {
          return false;
        }
      } else {
        return false;
      }
    }

    return numberSeen && numberAfterE;
  }

  /**
   * Most people say it's a bad problem for unclear description. So we jump it.
   *
   * Runtime: Memory Usage:
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
    System.out.println(isNumber(" 0.1 "));
  }
}

