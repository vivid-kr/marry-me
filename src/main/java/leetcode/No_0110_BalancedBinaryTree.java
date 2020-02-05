package leetcode.all;

import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0110_BalancedBinaryTree {

  public boolean isBalanced(TreeNode root) {
    return depth(root) >= 0;
  }

  int depth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int l, r;
    if ((l = depth(root.left)) < 0) {
      return -1;
    }
    if ((r = depth(root.right)) < 0) {
      return -1;
    }
    if (Math.abs(l - r) > 1) {
      return -1;
    }
    return Math.max(l, r) + 1;
  }

  /**
   * Runtime: 1 ms, faster than 99.60% of Java online submissions for Balanced Binary Tree.
   *
   * Memory Usage: 38.5 MB, less than 89.82% of Java online submissions for Balanced Binary Tree.
   *
   * 1次调试错误，然后成功。
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
    No_0110_BalancedBinaryTree no = new No_0110_BalancedBinaryTree();

    System.out.println(no);
  }
}

