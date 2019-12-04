package leetcode.easy;

/**
 * TODO Time
 */
public class No_0013_RomantoInteger {

  public static int romanToInt(String s) {
    int[] map = new int[256];
    map['I'] = 1;
    map['V'] = 5;
    map['X'] = 10;
    map['L'] = 50;
    map['C'] = 100;
    map['D'] = 500;
    map['M'] = 1000;

    int ret = 0, pre = 1;
    for (int i = s.length() - 1; i >= 0; --i) {
      int cur = map[s.charAt(i)];
      if (cur < pre) {
        ret -= cur;
      } else {
        pre = cur;
        ret += cur;
      }
    }
    return ret;
  }

  /**
   * Runtime: 3 ms, faster than 100.00% of Java online submissions for Roman to Integer.
   *
   * Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for Roman to Integer.
   *
   * 次调试错误，然后成功。自己实现的是C++版本。
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
    int actual = romanToInt("III");
    System.out.println(actual);
  }
}

