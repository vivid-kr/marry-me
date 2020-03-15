package leetcode.all;

import java.util.HashSet;

/**
 * TODO Time
 */
public class No_0217_ContainsDuplicate {

  public static boolean containsDuplicate(int[] nums) {
    if (nums.length == 0)
      return false;
    HashSet<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (set.contains(num))
        return true;
      else
        set.add(num);
    }
    return false;
  }

  /**
   * Runtime: Memory Usage:
   *
   * 0次调试错误，然后成功。
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
    boolean actual = containsDuplicate(new int[]{1,2,3,1});
    System.out.println(actual);
  }
}

