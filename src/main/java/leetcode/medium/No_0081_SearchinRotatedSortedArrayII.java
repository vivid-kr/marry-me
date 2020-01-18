package leetcode.medium;

/**
 * TODO Time
 */
public class No_0081_SearchinRotatedSortedArrayII {

  public boolean search(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] == target) {
        return true;
      } else if (nums[start] == nums[mid]) {
        start++;
      } else if (nums[end] == nums[mid]) {
        end--;
      } else if (nums[start] <= target && target <= nums[mid]) // case 1
      {
        end = mid;
      } else if (nums[mid] < target && target <= nums[end]) // case 2
      {
        start = mid + 1;
      } else if (nums[start] > nums[mid]) // case 2 is false, so target in this range
      {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return false;
  }


  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted
   * Array II.
   *
   * Memory Usage: 38.5 MB, less than 90.14% of Java online submissions for Search in Rotated Sorted
   * Array II.
   *
   * 多次调试错误，然后成功。
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
    No_0081_SearchinRotatedSortedArrayII no = new No_0081_SearchinRotatedSortedArrayII();

    System.out.println(no.search(new int[]{3, 1}, 1));
    System.out.println(no.search(new int[]{1, 1, 1, 3, 1}, 3));
  }
}

