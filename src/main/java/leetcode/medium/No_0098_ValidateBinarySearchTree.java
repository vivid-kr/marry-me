package leetcode.medium;

import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0098_ValidateBinarySearchTree {

  private TreeNode pre = null;

  private boolean walk(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (!walk(root.left)) {
      return false;
    }
    if (pre != null && pre.val >= root.val) {
      return false;
    }
    pre = root;
    return walk(root.right);
  }

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    return walk(root);
  }


  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
   *
   * Memory Usage: 39 MB, less than 81.40% of Java online submissions for Validate Binary Search
   * Tree.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：line 40 原来节点相等也算是错的
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */

  private static void test1() {
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    n1.left = n3;
    n3.right = n2;
    No_0098_ValidateBinarySearchTree no = new No_0098_ValidateBinarySearchTree();
    System.out.println(no.isValidBST(n1));

  }

  private static void test2() {
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    n3.left = n1;
    n3.right = n4;
    n4.left = n2;
    TreeNode root = n3;
    No_0098_ValidateBinarySearchTree no = new No_0098_ValidateBinarySearchTree();
    System.out.println(no.isValidBST(root));
  }

  public static void main(String[] args) {
    No_0098_ValidateBinarySearchTree no = new No_0098_ValidateBinarySearchTree();
    test1();
    test2();
  }
}

