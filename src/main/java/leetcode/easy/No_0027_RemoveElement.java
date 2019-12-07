package leetcode.easy;

/**
 * TODO Time
 */
public class No_0027_RemoveElement {

  public static int removeElement(int[] nums, int val) {
    int moveIdx = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[moveIdx] = nums[i];
        moveIdx++;
      }
    }
    return moveIdx;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
   *
   * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Remove Element.
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
    int[] input = {3, 2, 2, 3};

    int expect = 2;
    int actual = removeElement(input, 3);

    System.out.println(actual);
    System.out.println(expect == actual);
  }
}

