package leetcode.all;

/**
 * TODO Time
 */
public class No_0136_SingleNumber {

  public static int singleNumber(int[] nums) {
    int a = 0;
    for (int num : nums) {
      a ^= num;
    }
    return a;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Number.
   *
   * Memory Usage: 39 MB, less than 97.78% of Java online submissions for Single Number.
   *
   * 0次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：
   *
   * 2错：
   *
   * 一句话反思：异或
   *
   * 新知识：
   */


  public static void main(String[] args) {
    System.out.println(1 == singleNumber(new int[]{2, 2, 1}));

  }
}

