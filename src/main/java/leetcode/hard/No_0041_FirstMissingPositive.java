package leetcode.hard;

/**
 * TODO Time
 */
public class No_0041_FirstMissingPositive {

  public static int firstMissingPositive(int[] nums) {
    int N = nums.length;
    int upBound = N + 2;
    // constrain the range into [0, N+1]
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        nums[i] = 0;
      } else if (nums[i] > N + 1) {
        nums[i] = N + 1;
      }
    }
    for (int i = 0; i < nums.length; i++) {
      int t = nums[i] >= upBound ? nums[i] - upBound : nums[i];
      if (t > 0 && t <= N && nums[t - 1] < upBound) {
        nums[t - 1] += upBound;
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < upBound) {
        return i + 1;
      }
    }
    return N + 1;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for First Missing Positive.
   *
   * Memory Usage: 35 MB, less than 100.00% of Java online submissions for First Missing Positive.
   *
   * 5次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：可能会有负数！负数+max之后，就不可预知了，要先把负数干掉,变成正数，然后才能通过+max的方法标出来谁被改过。 结合5错，把所有负数改为0即可
   *
   * 2错：为了避免0+max和max相同，无法区分原来是0还是max。所以upBound = max+1，这样只要">="upBound，就一定是改过的
   *
   * 3错：line 26: 还是边界问题。如果处理后的数<upBound，说明没改过
   *
   * 4错：没考虑重复值！所以line 33重复多加了几遍。解法：判断。
   *
   * 5错: 重要。极值。出现2^31之后，加减会越界。一个简单的办法是，凡是在-N, N之外的数都没有意义了，所以负数归0，正数上界控制在N+1。
   *
   * 一句话反思：原地标注法. 注意极端值
   *
   * 新知识：
   */


  public static void main(String[] args) {
    System.out.println(firstMissingPositive(new int[]{1, 2, 3, 10, 2147483647, 9}));
    System.out.println(2 == firstMissingPositive(new int[]{3, 3, 1, 4, 0}));
    System.out.println(2 == firstMissingPositive(new int[]{3, 4, -1, 1}));
    System.out.println(1 == firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    System.out.println(3 == firstMissingPositive(new int[]{1, 2, 0}));

  }
}

