package leetcode.hard;

import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0099_RecoverBinarySearchTree {

  private TreeNode pre = null;

  private TreeNode errorFirst = null;

  private TreeNode errorSecond;

  private void walk(TreeNode root) {
    if (root == null) {
      return;
    }
    walk(root.left);
    if (pre != null && pre.val > root.val) {
      if (errorFirst == null) {
        errorFirst = pre;
      }
      errorSecond = root;
    }
    pre = root;
    walk(root.right);
  }

  public void recoverTree(TreeNode root) {
    if (root == null) {
      return;
    }
    walk(root);
    if (errorFirst != null) {
      int tmp = errorFirst.val;
      errorFirst.val = errorSecond.val;
      errorSecond.val = tmp;
    }
  }


  /**
   * <p>题目说只有一处交换，中序遍历会将节点从小到大遍历，那么一定存在两种情况之一：
   * 1. 相邻两节点互换，有一处"相邻节点大小错位" 2. 不相邻两节点互换，有两处"相邻节点大小错位"
   *
   * 第一次发现错位时候，记录两个节点。如果发现了第二处错位，说明是之前的"第一错"和当前的节点互换了位置，因此，更新"第二错节点"为当前节点
   * </p>
   *
   * Runtime: 2 ms, faster than 97.89% of Java online submissions for Recover Binary Search Tree.
   *
   * Memory Usage: 38.9 MB, less than 84.62% of Java online submissions for Recover Binary Search
   * Tree.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：line 49，当pre=null的时候自然要pre=root，但注意，进入right子节点之前，也要将pre更新为root
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
    No_0099_RecoverBinarySearchTree no = new No_0099_RecoverBinarySearchTree();
    no.recoverTree(n1);
    System.out.println(n1.printTree());
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
    No_0099_RecoverBinarySearchTree no = new No_0099_RecoverBinarySearchTree();
    no.recoverTree(root);
    System.out.println(root.printTree());
  }

  public static void main(String[] args) {
    No_0099_RecoverBinarySearchTree no = new No_0099_RecoverBinarySearchTree();
    test1();
    test2();
  }
}

