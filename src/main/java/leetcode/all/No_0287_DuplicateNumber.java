package leetcode.all;

/**
 * TODO Time
 */
public class No_0287_DuplicateNumber {

  public static int findDuplicate(int[] nums) {
    //check not-null
    if (nums == null || nums.length == 0) {
      return -1;
    }
    //check range: [1, N]
    int N = nums.length - 1;
    for (int data : nums) {
      if (1 > data || data > N) {
        return -1;
      }
    }
    int l = 1;
    int r = N;
    int mid;
    int rightNum = 0;
    while (l < r) {
      mid = (l + r) / 2;
      for (int num : nums) {
        if (r >= num && num > mid) {
          rightNum++;
        }
      }
      // left or right? There is exactly one side, num > bound
      if (rightNum > r - mid) {
        l = mid + 1;
      } else {
        r = mid;
      }
      rightNum = 0;
    }
    return l;
  }

  /**
   * Runtime:
   *
   * Memory Usage:
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：没看到"数字可以重复多次"
   *
   * 2错：注意，mid = (l+r)/2，左边的区间一定要是[l,mid]，而不能是[l, mid]！因为mid可能等于l! 在这题里，看左边涉及+1，稍微麻烦一点，可以用右边
   *
   * 一句话反思：
   *
   * 新知识：
   */

  public static int findDuplicate2(int[] nums) {
    int slow = nums[0];
    int fast = nums[slow];
    while (slow != fast){
      slow = nums[slow];
      fast = nums[nums[fast]];
    }
    slow = 0;
    while (nums[slow] != nums[fast]){
      fast = nums[fast];
      slow = nums[slow];
    }
    return nums[slow];
  }


  public static void main(String[] args) {
    System.out.println(findDuplicate2(new int[]{3, 1, 3, 4, 2}));
//    System.out.println(2 == findDuplicate(new int[]{1, 3, 4, 2, 2}));
//    System.out.println(2 == findDuplicate(new int[]{2, 2, 2, 2, 2}));
  }
}

