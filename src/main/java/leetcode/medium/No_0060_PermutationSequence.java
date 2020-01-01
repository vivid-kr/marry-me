package leetcode.medium;

/**
 * TODO Time
 */
public class No_0060_PermutationSequence {

  public String getPermutation(int n, int k) {
    k--;
    int[] used = new int[n];
    for (int i = 0; i < used.length; i++) {
      used[i] = i + 1;
    }
    char[] res = new char[n];
    int max = 1;
    int factorial = 1;
    while (factorial < k + 1) {
      max++;
      factorial *= max;
    }
    int i = 0;
    factorial /= max;
    for (; i < n - max; i++) {
      res[i] = (char) ('0' + used[i]);
      used[i] = -1;
    }
    for (int j = 0; j < max - 1; j++) {
      int idx = k / factorial;
      // find the idx-th unused number
      for (int l = i; l < n; l++) {
        if (used[l] != -1) {
          idx--;
        }
        if (idx < 0) {
          res[i + j] = (char) ('0' + used[l]);
          used[l] = -1;
          break;
        }
      }
      k = k % factorial;
      factorial /= (max - 1 - j);
    }
    for (int l = i; l < n; l++) {
      if (used[l] != -1) {
        res[n - 1] = (char) ('0' + used[l]);
      }
    }
    return new String(res);
  }

  /**
   * Runtime: 1 ms, faster than 99.97% of Java online submissions for Permutation Sequence.
   *
   * Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Permutation Sequence.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：注意，k应该是从0开始，而不是从1开始。否则除以阶乘再取余（line 28）就不对了
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    No_0060_PermutationSequence no = new No_0060_PermutationSequence();

    System.out.println(no.getPermutation(3, 3));
    System.out.println(no.getPermutation(4, 9));
  }
}

