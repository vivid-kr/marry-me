package leetcode.medium;


/**
 * 解法有问题，没有考虑边界情况，但是有可取之处，主要是越界的处理。我来改一下
 */
public class No_0008_StringtoInteger3 {

  public static boolean isSingleNumber(char c) {
    return c >= '0' && c <= '9';
  }

  public static boolean isSign(char c) {
    return c == '+' || c == '-';
  }

  public static int myAtoi(String str) {
    if ("".equals(str)) {
      return 0;
    }
    int sign = 1, base = 0, i = 0, n = str.length();
    while (i < n && str.charAt(i) == ' ') {
      i++;
    }
    //异常判断
    if ((i == n) ||
        (i + 1 == n && !isSingleNumber(str.charAt(i))) ||
        (isSign(str.charAt(i)) && !isSingleNumber(str.charAt(i + 1))) ||
        (!isSign(str.charAt(i)) && !isSingleNumber(str.charAt(i)))) {
      return 0;
    }

    if (isSign(str.charAt(i))) {
      sign = (str.charAt(i++) == '+') ? 1 : -1;
    }
    while (i < n && isSingleNumber(str.charAt(i))){
      if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE/10 && str.charAt(i) > '7'))
        return sign == 1? Integer.MAX_VALUE: Integer.MIN_VALUE;
      base = base * 10 + (str.charAt(i)-'0');
      i++;
    }

    return base * sign;
  }

  /**
   * Runtime: 1 ms, faster than 100.00%
   *
   * Memory Usage: 36 MB, less than 100.00%
   *
   * 1次调试错误，然后成功。慢
   *
   * 错误：
   *
   * 29行，最笨的办法最安全，多种情况都各自返回0，放到一起，就要仔细考虑。忘记29行要求 !isSign(str.charAt(i))
   *
   * 核心技巧：Integer.MAX_VALUE / 10
   *
   * 每次都×10，但需要预检测。2^31=2147483648 所以MAX = 2147483647， MIN = -2147483648
   *
   * 37行，进来之后意味着*10，如果 base > Integer.MAX_VALUE / 10，乘十肯定超，如果恰好相等，就看最后一位了
   *
   * 很凑巧，7是个正负两用的分割线。等于7的话，正负数不越界，大于7，正数越界了，触发条件返回MAX，负数不越界，但返回MIN也恰好正确（MIN = base*10+8再取负）
   */
  public static void main(String[] args) {
    int actual = myAtoi("2147483647");
    int expect = 42;
    System.out.println(actual);
    System.out.println(actual == expect);
  }
}

