package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO Time
 */
public class No_0040_CombinationSumII {

  public static void combine(int target, int pos, List<List<Integer>> ret,
      int[] uniCands, int[] uniMax, int uniLen, int[] uniUsed) {
    if (pos == uniLen || target <= 0) {
      if (target == 0) {
        List<Integer> p = new ArrayList<>();
        for (int i = 0; i < pos; i++) {
          for (int j = 0; j < uniUsed[i]; j++) {
            p.add(uniCands[i]);
          }
        }
        ret.add(p);
      }
      return;
    }
    for (int i = 0; i <= uniMax[pos]; i++) {
      uniUsed[pos] = i;
      combine(target - i * uniCands[pos], pos + 1, ret,
          uniCands, uniMax, uniLen, uniUsed);
    }
  }

  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    int uniLen = 0;
    int[] uniCands = new int[candidates.length];
    int[] uniMax = new int[candidates.length];
    int[] uniUsed = new int[candidates.length];
    for (int candidate : candidates) {
      if (uniLen == 0 || candidate != uniCands[uniLen - 1]) {
        uniCands[uniLen] = candidate;
        uniMax[uniLen++] = 1;
      } else {
        uniMax[uniLen - 1]++;
      }
    }
    List<List<Integer>> ret = new ArrayList<>();
    combine(target, 0, ret, uniCands, uniMax, uniLen, uniUsed);
    return ret;
  }

  /**
   * Runtime: 4 ms, faster than 65.74% of Java online submissions for Combination Sum II.
   *
   * Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Combination Sum II.
   *
   * 2次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：line 28, uniCands[pos]错写成了uniCands[i]。
   *
   * 2错：line 26，注意是<= uniMax! 第i个数有N个，则uniMax[i]=N，可以取到N个，所以是<=。
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    int[] input = {10, 1, 2, 7, 6, 1, 5};
    List<List<Integer>> actual = combinationSum2(input, 8);
    String expect = "[[2, 6], [1, 7], [1, 2, 5], [1, 1, 6]]";

    System.out.println(actual);
    System.out.println(expect.equals(actual));
  }
}

