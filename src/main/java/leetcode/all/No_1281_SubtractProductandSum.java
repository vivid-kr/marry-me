package leetcode.all;

/**
 * TODO Time
 */
public class No_1281_SubtractProductandSum {

  public int subtractProductAndSum(int n) {
    int prod = 1;
    int sum = 0;
    while (n > 0) {
      prod *= n % 10;
      sum += n % 10;
      n /= 10;
    }

    return prod - sum;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Subtract the Product and Sum
   * of Digits of an Integer.
   *
   * Memory Usage: 33.4 MB, less than 100.00% of Java online submissions for Subtract the Product
   * and Sum of Digits of an Integer.
   *
   * 过于简单 0次调试错误，然后成功。
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
    No_1281_SubtractProductandSum no = new No_1281_SubtractProductandSum();

    System.out.println(no);
  }
}

