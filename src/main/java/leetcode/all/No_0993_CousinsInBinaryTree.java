package leetcode.all;

import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0993_CousinsInBinaryTree {

  private TreeNode xParent;
  private int xLevel;
  private TreeNode yParent;
  private int yLevel;

  public boolean isCousins(TreeNode root, int x, int y) {
    subLevelOrder(root, null, 0, x, y);
    return xParent != yParent && xLevel == yLevel;
  }

  private void subLevelOrder(TreeNode root, TreeNode parent, int level, final int x, final int y) {
    if (root == null) {
      return;
    }
    if(root.val == x){
      xParent = parent;
      xLevel = level;
    }
    else if(root.val == y){
      yParent = parent;
      yLevel = level;
    }
    subLevelOrder(root.left, root, level + 1, x, y);
    subLevelOrder(root.right, root, level + 1, x, y);
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Cousins in Binary Tree.
   *
   * Memory Usage: 34.7 MB, less than 100.00% of Java online submissions for Cousins in Binary Tree.
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
    No_0993_CousinsInBinaryTree no = new No_0993_CousinsInBinaryTree();

    System.out.println(no);
  }
}

