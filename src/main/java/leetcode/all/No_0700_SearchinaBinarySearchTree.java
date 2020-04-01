package leetcode.all;

import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0700_SearchinaBinarySearchTree {


  public TreeNode searchBST(TreeNode root, int val) {
    while (root != null && root.val != val) {
      root = val < root.val ? root.left : root.right;
    }
    return root;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in a Binary Search
   * Tree.
   *
   * Memory Usage: 38.8 MB, less than 100.00% of Java online submissions for Search in a Binary
   * Search Tree.
   *
   * 次调试错误，然后成功。太简单，没意思。直接写一下答案
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
    No_0700_SearchinaBinarySearchTree no = new No_0700_SearchinaBinarySearchTree();

    System.out.println(no);
  }
}

