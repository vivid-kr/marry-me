package leetcode.medium;

/**
 * TODO Time
 */
public class No_0080_Remove_Duplicates_from_Sorted_ArrayII {

  public int removeDuplicates(int[] nums) {
    if (nums.length <= 2) {
      return nums.length;
    }
    int seenIdx = 0;
    int i;
    for (i = 1; i < nums.length; i++) {
      int dupCount = 0;
      while (nums[i] == nums[seenIdx]) {
        if (dupCount < 1) {
          seenIdx++;
          nums[seenIdx] = nums[i];
          dupCount++;
        }
        i++;
        if (i == nums.length) {
          return seenIdx + 1;
        }
      }
      seenIdx++;
      nums[seenIdx] = nums[i];
    }
    return seenIdx + 1;
  }

  /**
   * Runtime: 1 ms, faster than 75.96% of Java online submissions for Remove Duplicates from Sorted
   * Array II.
   *
   * Memory Usage: 37.1 MB, less than 100.00% of Java online submissions for Remove Duplicates from
   * Sorted Array II.
   *
   * 1次调试错误，然后成功。
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
    No_0080_Remove_Duplicates_from_Sorted_ArrayII no = new No_0080_Remove_Duplicates_from_Sorted_ArrayII();

    System.out.println(no.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    System.out.println(no.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
  }
}

