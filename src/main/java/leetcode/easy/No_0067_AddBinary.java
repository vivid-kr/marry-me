package leetcode.easy;

/**
 * TODO Time
 */
public class No_0067_AddBinary {

  public static String addBinary(String a, String b) {
    if ("0".equals(a) && "0".equals(b)) {
      return "0";
    }
    final int l1 = a.length() - 1;
    final int l2 = b.length() - 1;
    int[] ret = new int[Math.max(a.length(), b.length()) + 1];
    for (int i = 0; i < ret.length; i++) {
      if (i <= l1) {
        ret[i] += a.charAt(l1 - i) - '0';
      }
      if (i <= l2) {
        ret[i] += b.charAt(l2 - i) - '0';
      }
      if (ret[i] > 1) {
        ret[i] -= 2;
        ret[i + 1]++;
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
   * Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Binary.
   *
   * Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Add Binary.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：忘记了0+0=0的情况
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    System.out.println(addBinary("11", "1"));
    System.out.println(addBinary("1010", "1011"));
  }
}

