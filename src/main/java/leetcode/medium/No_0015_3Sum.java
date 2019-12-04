package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO Time
 */
public class No_0015_3Sum {

  public List<Integer> getTriplet(int one, int two, int three){
    List<Integer> triplet = new ArrayList<Integer>(3);
    triplet.add(one);
    triplet.add(two);
    triplet.add(three);
    return triplet;
  }

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    Arrays.sort(nums);
    int l = nums.length;
    for (int i = 0; i < l-2; i++) {
      if (nums[i] > 0) {
        break;
      }
      //前两个一样的情况
      int t1 = nums[i];
      if (i < l-2 && t1 == nums[i+1]) {
        for (int j = i+2; j < l; j++) {
          if (t1 + t1 + nums[j] > 0){
            break;
          }
          if (t1 + t1 + nums[j] == 0){
            ret.add(getTriplet(t1, t1, nums[j]));
            break;
          }
        }
      }
      //过掉t
      while(i + 1 < l && nums[i+1] == t1)
        i++;
      t1 = nums[i];
      for (int j = i+1; j < l-1; j++) {
        int t2 = nums[j];
        if (t1 + t2 * 2 > 0) {
          break;
        }
        //考虑后两者相同
        if (j < l-1 && nums[j+1] == t2 && t1 + t2 * 2 == 0) {
          ret.add(getTriplet(t1, t2, t2));
        }
        //过掉t
        while(j+1 < l && nums[j+1] == t2)
          j++;
        for (int k = j+1; k < l; k++) {
          if (t1 + t2 + nums[k] > 0) {
            break;
          }
          if (t1 + t2 + nums[k] == 0) {
            ret.add(getTriplet(t1, t2, nums[k]));
            break;
          }
        }
      }
    }
    return ret;
  }


  /**
   * Runtime:
   *
   * Memory Usage:
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
    String input = "";
    String expect = "PAHNAPLSIIGYIR";
//    String actual = func(input);

//    System.out.println(actual);
//    System.out.println(expect.equals(actual));
  }
}

