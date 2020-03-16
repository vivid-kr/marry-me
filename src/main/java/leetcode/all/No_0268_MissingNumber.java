package leetcode.all;

/**
 * TODO Time
 */
public class No_0268_MissingNumber {

  public static int missingNumber(int[] nums) {
    int N = nums.length;
    int expect = N * (N + 1) / 2;
    int actual = 0;
    for (int num : nums) {
      actual += num;
    }
    return expect - actual;
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
    System.out.println(8==missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    System.out.println(2 == missingNumber(new int[]{3, 0, 1}));
  }
}

