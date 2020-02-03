package leetcode.all;

import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0104_MaximumDepthofBinaryTree {

  private int maxDepth = 0;

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    subLevelOrder(root, 1);
    return maxDepth;
  }

  private void subLevelOrder(TreeNode root, int level) {
    if (root.left == null && root.right == null) {
      if (maxDepth < level) {
        maxDepth = level;
      }
      return;
    }
    if (root.left != null) {
      subLevelOrder(root.left, level + 1);
    }
    if (root.right != null) {
      subLevelOrder(root.right, level + 1);
    }
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
   *
   * Memory Usage: 38.8 MB, less than 94.62% of Java online submissions for Maximum Depth of Binary Tree.
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
    No_0104_MaximumDepthofBinaryTree no = new No_0104_MaximumDepthofBinaryTree();

    System.out.println(no.maxDepth(TreeNode.construct("[1,2]")));
  }
}

