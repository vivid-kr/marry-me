package leetcode.all;

import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0530_MinimumAbsoluteDifferenceinBST {

  int minDiff = Integer.MAX_VALUE;
  TreeNode prev = null;

  public int getMinimumDifference(TreeNode root) {
    inOrder(root);
    return minDiff;
  }

  private void inOrder(TreeNode root) {
    if (root == null) return;
    inOrder(root.left);
    if (prev != null) {
      minDiff = Math.min(root.val - prev.val, minDiff);
    }
    prev = root;
    inOrder(root.right);
  }

  /**
   * Runtime: 1 ms, faster than 97.64% of Java online submissions for Minimum Absolute Difference in BST.
   *
   * Memory Usage: 39.3 MB, less than 92.31% of Java online submissions for Minimum Absolute Difference in BST.
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
    No_0530_MinimumAbsoluteDifferenceinBST no = new No_0530_MinimumAbsoluteDifferenceinBST();
    System.out.println(no);
  }
}

