package leetcode.medium;

/**
 * TODO Time
 */
public class No_0033_SearchRotatedSortedArray {

  public static int search(int[] nums, int target) {
    if (nums.length == 0) {
      return -1;
    }
    // find rotated point
    int left = 0;
    int right = nums.length - 1;
    int mid;
    while (left < right) {
      mid = left + (right - left) / 2;
      if (nums[left] < nums[mid]) {
        left = mid;
      } else {
        right = mid;
      }
    }
    System.out.println("rotate idx:" + left + ", first num: " + nums[left]);
    int ret1 = binarySearch(nums, 0, left, target);
    if (ret1 > -1) {
      return ret1;
    }
    return binarySearch(nums, left, nums.length, target);
  }

  public static int binarySearch(int[] nums, int a, int b, int target) {

    int left = a;
    int right = b;
    if (right < a) {
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
    return (left < nums.length && nums[left] == target) ? left : -1;
  }

  /**
   * Runtime: 3 ms, faster than 6.31% of Java online submissions for Search in Rotated Sorted
   * Array.
   *
   * Memory Usage: 37.9 MB, less than 47.17% of Java online submissions for Search in Rotated Sorted
   * Array.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：寻找rotate点出错了
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
    int[] input = {4, 5, 6, 7, 0, 1, 2};
    int expect = -1;
    int actual = search(input, 3);

    System.out.println(actual);
    System.out.println(expect == actual);
  }
}

