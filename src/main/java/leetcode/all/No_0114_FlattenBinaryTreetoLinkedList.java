package leetcode.all;

import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0114_FlattenBinaryTreetoLinkedList {

  /**
   * @param root cannot be null
   * @return the last node of link list
   */
  private TreeNode helper(TreeNode root) {
    TreeNode endNode = root;
    TreeNode rightChild = root.right;
    if (root.left != null) {
      root.right = root.left;
      endNode = helper(root.left);
    }
    if (rightChild != null) {
      endNode.right = rightChild;
      endNode = helper(rightChild);
    }
    root.left = null;
    return endNode;
  }

  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    helper(root);
  }


  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.
   *
   * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：注意line 20和21，left和rightchild都被重新指定过了
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    No_0114_FlattenBinaryTreetoLinkedList no = new No_0114_FlattenBinaryTreetoLinkedList();
    TreeNode root = TreeNode.construct("[1,2,5,3,4,null,6]");
    no.flatten(root);
    System.out.println(TreeNode.printTree(root));
  }
}

