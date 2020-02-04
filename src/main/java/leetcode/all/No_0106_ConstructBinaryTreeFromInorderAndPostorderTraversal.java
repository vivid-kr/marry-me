package leetcode.all;

import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0106_ConstructBinaryTreeFromInorderAndPostorderTraversal {

  private int postIdx;
  private int inIdx;

  public TreeNode subBuildTree(int[] inorder, int[] postorder, TreeNode parent) {
    if (postIdx == -1) {
      return null;
    }
    TreeNode node = new TreeNode(postorder[postIdx--]);
    if (node.val != inorder[inIdx]) {
      node.right = subBuildTree(inorder, postorder, node);
    }
    inIdx--;
    if (parent == null || inorder[inIdx] != parent.val) {
      node.left = subBuildTree(inorder, postorder, parent);
    }
    return node;
  }

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    postIdx = postorder.length - 1;
    inIdx = inorder.length - 1;
    return subBuildTree(inorder, postorder, null);
  }

  /**
   * Runtime: 1 ms, faster than 100.00% of Java online submissions for Construct Binary Tree from
   * Inorder and Postorder Traversal.
   *
   * Memory Usage: 39.4 MB, less than 21.82% of Java online submissions for Construct Binary Tree
   * from Inorder and Postorder Traversal.
   *
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
    No_0106_ConstructBinaryTreeFromInorderAndPostorderTraversal no = new No_0106_ConstructBinaryTreeFromInorderAndPostorderTraversal();

    System.out.println(no.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}).printTree());;
  }
}

