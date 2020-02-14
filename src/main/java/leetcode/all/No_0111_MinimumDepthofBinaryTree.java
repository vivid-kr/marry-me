package leetcode.all;

import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0111_MinimumDepthofBinaryTree {

  private int minDepth = Integer.MAX_VALUE;

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    subLevelOrder(root, 1);
    return minDepth;
  }

  private void subLevelOrder(TreeNode root, int level) {
    if (root.left == null && root.right == null) {
      if (minDepth > level) {
        minDepth = level;
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
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Depth of Binary
   * Tree.
   *
   * Memory Usage: 38.9 MB, less than 98.44% of Java online submissions for Minimum Depth of Binary
   * Tree.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：理解错题意了，最短路径的终点要求是"leaf"，即左右节点都是null
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    No_0111_MinimumDepthofBinaryTree no = new No_0111_MinimumDepthofBinaryTree();

    System.out.println(no.minDepth(TreeNode.construct("[1,2]")));
  }
}

