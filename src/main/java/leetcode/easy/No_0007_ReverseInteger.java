package leetcode.easy;

/**
 * TODO Time
 */
public class No_0007_ReverseInteger {

  public static int reverse(int x) {
    int ret = 0;
    int posBy10 = Integer.MAX_VALUE / 10;
    int posRest = Integer.MAX_VALUE % 10;
    int negBy10 = Integer.MIN_VALUE / 10;
    int negRest = Integer.MIN_VALUE % 10;
    while (x != 0) {
      int last = x % 10;
      x /= 10;
      if (ret > posBy10 || (ret == posBy10 && last > posRest)) {
        return 0;
      }
      if (ret < negBy10 || (ret == negBy10 && last < negRest)) {
        return 0;
      }
      ret = ret * 10 + last;
    }
    return ret;
  }

  /**
   * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Integer.
   *
   * Memory Usage: 33.4 MB, less than 11.66% of Java online submissions for Reverse Integer.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：没理解什么叫"reverse"之后越界！
   *
   *
   * 一句话反思：输入是int，就不可能越界，但要注意返回结果！生成的返回结果可能会越界，导致返回了错的结果
   *
   * 新知识：正负数除法和取模：10/3 = 1, -10%3 = -1, 10/-3 = 1, -10/-3 = -1
   *
   * 除法不多说，模：先忽略负号，按照正数运算之后，被取模的数是正数结果就取正，反之取负
   */
  public static void main(String[] args) {
    int input = 1534236469;
    int expect = 0;
    System.out.println(expect == reverse(input));
  }
}

