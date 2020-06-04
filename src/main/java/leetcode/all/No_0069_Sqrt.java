package leetcode.easy;

/**
 * TODO Time
 */
public class No_0069_Sqrt {

  public int mySqrt(int x) {
    if (x < 0) {
      return -1;
    }
    if (x == 0) {
      return 0;
    }
    int l = 1;
    int r = Math.min(46340, x);
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (mid * mid > x) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l * l > x ? l - 1 : l;
  }

  /**
   * Runtime: Memory Usage:
   *
   * 3次调试错误，然后成功。下面的二分法更简洁
   *
   * 错误：
   *
   * 1错：0错误，审错题了
   *
   * 2错：5，发现了line 25这一行应该怎么写
   *
   * 3错：注意，任何情况下，整数乘法都要考虑越界
   *
   * 一句话反思：
   *
   * 新知识：
   */
  public int mySqrt2(int x) {
    int low = 1; // mid always >= 1
    int high = x;
    int answer = 0; // skip loop when high is 0
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (mid <= x / mid) {
        low = mid + 1;
        answer = mid;
      } else
        high = mid - 1;
    }
    return answer;
  }


  public static void main(String[] args) {
    No_0069_Sqrt no = new No_0069_Sqrt();
    System.out.println((int)(Math.sqrt(2147395599)) == no.mySqrt(2147395599));
    System.out.println(no.mySqrt(5));
    System.out.println(no.mySqrt(0));
    System.out.println(no.mySqrt(8));

  }
}

