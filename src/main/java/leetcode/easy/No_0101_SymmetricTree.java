package leetcode.easy;

import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0101_SymmetricTree {

  private boolean isSame(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null)
      return true;
    if (t1 == null || t2 == null)
      return false;
    return t1.val == t2.val && isSame(t1.left, t2.right) && isSame(t1.right, t2.left);
  }

  public boolean isSymmetric(TreeNode root) {
    return root == null || isSame(root.left, root.right);
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree.
   *
   * Memory Usage: 38.3 MB, less than 63.94% of Java online submissions for Symmetric Tree.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：line 15 忘记了val == val这一条
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    No_0101_SymmetricTree no = new No_0101_SymmetricTree();

    System.out.println(no.isSymmetric(TreeNode.construct("[1,2,3]")));
  }
}

