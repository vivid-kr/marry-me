package leetcode.easy;

/**
 * TODO Time
 */
public class No_0035_SearchInsertPosition {

  public static int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length;
    if (right <= 0) {
      return -1;
    }
    int mid;
    int v;
    while (left < right) {
      mid = (left + right) >> 1;
      v = nums[mid];
      if (v == target) {
        return mid;
      } else if (v < target) {
        left = mid + 1;
      } else {
        right = mid;
      }

    }
    return left;
  }

  /**
   * Runtime: 0 ms, faster than 100.00%.
   *
   * Memory Usage: 43.9 MB, less than 95.74%.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：line 10写成了length+1，其实应该是length
   *    *
   * 1错：
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：这个二分查找非常不错，代码简洁，cover各种情况
   */


  public static void main(String[] args) {
    int[] input = {1, 3, 5, 6};
    int expect = 0;
    int actual = searchInsert(input, 0);

    System.out.println(actual);
    System.out.println(actual == expect);
  }
}

