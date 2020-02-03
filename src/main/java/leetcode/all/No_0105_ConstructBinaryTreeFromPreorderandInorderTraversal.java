package leetcode.all;

import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0105_ConstructBinaryTreeFromPreorderandInorderTraversal {

  private int preIdx = 0;
  private int inIdx = 0;

  public TreeNode subBuildTree(int[] preorder, int[] inorder, TreeNode parent) {
    if (preIdx == preorder.length) {
      return null;
    }
    TreeNode node = new TreeNode(preorder[preIdx++]);
    if (node.val != inorder[inIdx]) {
      node.left = subBuildTree(preorder, inorder, node);
    }
    inIdx++;
    if (parent == null || inorder[inIdx] != parent.val) {
      node.right = subBuildTree(preorder, inorder, parent);
    }
    return node;
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return subBuildTree(preorder, inorder, null);
  }

  /**
   * Runtime: 1 ms, faster than 100.00% of Java online submissions for Construct Binary Tree from
   * Preorder and Inorder Traversal.
   *
   * Memory Usage: 39.7 MB, less than 14.02% of Java online submissions for Construct Binary Tree
   * from Preorder and Inorder Traversal.
   *
   * 1次调试错误，然后成功。内存波动很大不用管。目前最好的内存方法我跑一下，比我的这个还大
   *
   * 递归的精髓题目，精彩
   *
   * 错误：
   *
   * 1错：一些笔误
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    No_0105_ConstructBinaryTreeFromPreorderandInorderTraversal no = new No_0105_ConstructBinaryTreeFromPreorderandInorderTraversal();

    System.out.println(no);
  }
}

