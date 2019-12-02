package leetcode.hard;

/**
 * TODO Time
 */
public class No_0004_MedianofTwoSortedArrays {

  /**
   * Runtime: 3 ms, faster than 36.94% of Java online submissions for Median of Two Sorted Arrays.
   *
   * Memory Usage: 46.8 MB, less than 90.97% of Java online submissions for Median of Two Sorted
   * Arrays.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：对于中间点，不应该是 (len1 + len2 + 1)/2，直接就是(len1 + len2)/2，推一下就知道。
   *
   * 一句话反思：将原本绕进去的思路转化为"求一个分界点"； 固定nums1, 则nums2的分界点也已经固定， 有了分界点概念后， 问题转化为：寻找合适的nums1分界点。
   *
   * 注意一点：一定要nums1比nums2短！因为所有的nums1分割点，都可以找到nums2的合理分割点，使得两者相加为HALF，
   * 但nums2的任意分割点，可能比HALF长了，nums1中找不到对应的分割点
   *
   * 新知识：思路转化
   */
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      int[] temp = nums1;
      nums1 = nums2;
      nums2 = temp;
    }
    final int HALF = (nums1.length + nums2.length) / 2;
    int idxL = 0;
    int idxR = nums1.length;
    int m1 = (idxL + idxR) / 2;
    int m2 = HALF - m1;
    while (true) {
      //max left
      int l1 = (m1 == 0) ? Integer.MIN_VALUE : nums1[m1 - 1];
      int l2 = (m2 == 0) ? Integer.MIN_VALUE : nums2[m2 - 1];
      int maxL = Math.max(l1, l2);
      //min right
      int r1 = (m1 == nums1.length) ? Integer.MAX_VALUE : nums1[m1];
      int r2 = (m2 == nums2.length) ? Integer.MAX_VALUE : nums2[m2];
      int minR = Math.min(r1, r2);
      if (maxL <= minR) {
        return (nums1.length + nums2.length) % 2 == 0 ? (maxL + minR) / 2.0 : minR;
      } else if (l1 > r2) {
        idxR = m1 - 1;
      } else if (r1 < l2) {
        idxL = m1 + 1;
      } else {
        break;
      }
      m1 = (idxL + idxR) / 2;
      m2 = HALF - m1;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 3};
    int[] nums2 = {2};
    double expect = 2;
    double actual = findMedianSortedArrays(nums1, nums2);

    System.out.println(actual);
    System.out.println(expect == actual);
  }
}

