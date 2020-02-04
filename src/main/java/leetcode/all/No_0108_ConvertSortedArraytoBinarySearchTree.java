package leetcode.all;

import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0108_ConvertSortedArraytoBinarySearchTree {

  public TreeNode sortedArrayToBST(int[] nums) {
    int listSize = nums.length;
    return inOrderTraverse(nums, 0, listSize - 1);
  }

  private TreeNode inOrderTraverse(int[] nums, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = start + (end - start) / 2;
    TreeNode left = inOrderTraverse(nums, start, mid - 1);
    TreeNode root = new TreeNode(nums[mid]);
    TreeNode right = inOrderTraverse(nums, mid + 1, end);
    root.left = left;
    root.right = right;
    return root;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to
   * Binary Search Tree.
   *
   * Memory Usage: 37.5 MB, less than 80.41% of Java online submissions for Convert Sorted Array to
   * Binary Search Tree.
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
    No_0108_ConvertSortedArraytoBinarySearchTree no = new No_0108_ConvertSortedArraytoBinarySearchTree();

    System.out.println(no);
  }
}

