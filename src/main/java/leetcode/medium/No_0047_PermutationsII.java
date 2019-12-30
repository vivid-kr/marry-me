package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO 重复数字采用计数法，每一次的位置不能在上一个同一数字的前面，这样可以保证没有重复
 */
public class No_0047_PermutationsII {

  private static void perm(List<List<Integer>> ret, int P, int curLen, int pIdx, int startIdx,
      int[] array, int uniLen, int[] uniNums, int[] uniNumCounts) {
    if (P == uniLen) {
      List<Integer> t = new ArrayList<>(P);
      for (int a : array) {
        t.add(a);
      }
      ret.add(t);
    } else {
      for (int i = startIdx; i <= curLen; i++) {
        if (curLen - i >= 0) {
          System.arraycopy(array, i, array, i + 1, curLen - i);
        }
        array[i] = uniNums[P];
        if (pIdx < uniNumCounts[P] - 1) {
          perm(ret, P, curLen + 1, pIdx + 1, i + 1, array, uniLen, uniNums, uniNumCounts);
        } else {
          perm(ret, P + 1, curLen + 1, 0, 0, array, uniLen, uniNums, uniNumCounts);
        }
        try {
          System.arraycopy(array, i + 1, array, i, curLen - i);
        } catch (ArrayIndexOutOfBoundsException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> ret = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return ret;
    }
    Arrays.sort(nums);
    int[] uniNums = new int[nums.length];
    int[] uniNumCounts = new int[nums.length];
    uniNums[0] = nums[0];
    uniNumCounts[0] = 1;
    int uniLen = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == uniNums[uniLen]) {
        uniNumCounts[uniLen]++;
      } else {
        uniLen++;
        uniNums[uniLen] = nums[i];
        uniNumCounts[uniLen] = 1;
      }
    }
    uniLen++;
    int[] array = new int[nums.length];
    perm(ret, 0, 0, 0, 0, array, uniLen, uniNums, uniNumCounts);
    return ret;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Permutations.
   *
   * Memory Usage: 37.3 MB, less than 97.16% of Java online submissions for Permutations.
   *
   * 0次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：line 26, if (pIdx < uniNumCounts[P] - 1). 注意，这里是先执行整体位移，然后判断，这就意味着，当pIdx=count-1的时候就该结束了.
   * 例如，count =2,那么pIdx=0执行过一次，pIdx=1执行了第二次，此时来到了line 26，两次都已经执行完了，而pIdx=count-1=1，就该换第二种情况，P+1了
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    List<List<Integer>> actual = permuteUnique(new int[]{1, 1, 2});
    System.out.println(actual);
//    System.out.println(expect.equals(actual));
  }
}

