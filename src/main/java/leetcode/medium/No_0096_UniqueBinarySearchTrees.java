package leetcode.medium;

/**
 * TODO Time
 */
public class No_0096_UniqueBinarySearchTrees {

  public int numTrees(int n) {
    if (n <= 2) {
      return n;
    }
    int[] uniqs = new int[n + 1];
    uniqs[0] = 1;
    uniqs[1] = 1;
    uniqs[2] = 2;
    for (int i = 3; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        uniqs[i] += uniqs[j - 1] * uniqs[i - j];
      }
    }
    return uniqs[n];
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
   *
   * Memory Usage: 32.8 MB, less than 5.55% of Java online submissions for Unique Binary Search
   * Trees.
   *
   * 0次调试错误，然后成功。其实可以更快，不过不用了，已经0ms了
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
    No_0096_UniqueBinarySearchTrees no = new No_0096_UniqueBinarySearchTrees();

    System.out.println(no.numTrees(3));
    System.out.println(no.numTrees(15));
  }
}

