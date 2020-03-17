package leetcode.all;

/**
 * TODO Time
 */
public class No_0367_ValidPerfectSquare {

  public boolean isPerfectSquare(int num) {
    int low = 1;
    int high = num;
    int answer = 0;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (mid <= num / mid) {
        low = mid + 1;
        answer = mid;
      } else
        high = mid - 1;
    }
    return answer * answer == num;
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



  public static void main(String[] args) {
    No_0367_ValidPerfectSquare no = new No_0367_ValidPerfectSquare();
    System.out.println(no.isPerfectSquare(2147395599));
    System.out.println(no.isPerfectSquare(4));
    System.out.println(no.isPerfectSquare(0));
    System.out.println(no.isPerfectSquare(8));

  }
}

