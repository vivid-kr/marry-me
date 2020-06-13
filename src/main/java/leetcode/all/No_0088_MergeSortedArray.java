package leetcode.easy;

import java.util.Arrays;

/**
 * TODO Time
 */
public class No_0088_MergeSortedArray {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int idx1 = m - 1;
    int idx2 = n - 1;
    int mIdx = m + n - 1;
    while (idx2 >= 0 && idx1 >= 0) {
      if (nums1[idx1] <= nums2[idx2]) {
        nums1[mIdx--] = nums2[idx2--];
      } else if (nums1[idx1] > nums2[idx2]) {
        nums1[mIdx--] = nums1[idx1--];
      }
    }
    if (idx1 == -1) {
      System.arraycopy(nums2, 0, nums1, 0, idx2 + 1);
    }
    if (idx2 == -1) {
      System.arraycopy(nums1, 0, nums1, 0, idx1 + 1);
    }
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
   * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Merge Sorted Array.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：注意，line 21,如果idx用完了，应该是-1，不是0！
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */
  private static void test1() {
    No_0088_MergeSortedArray no = new No_0088_MergeSortedArray();
    int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
    no.merge(nums1, 3, new int[]{2, 5, 6}, 3);
    System.out.println(Arrays.toString(nums1));
  }

  private static void test2() {
    No_0088_MergeSortedArray no = new No_0088_MergeSortedArray();
    int[] nums1 = new int[]{0};
    no.merge(nums1, 0, new int[]{1}, 1);
    System.out.println(Arrays.toString(nums1));
  }

  public static void main(String[] args) {
//    test1();
    test2();
  }
}

