package leetcode.all;

import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0112_PathSum {

  public boolean hasPathSum2(TreeNode root, int sum) {
    if (root == null) {
      return sum == 0;
    }
    if (hasPathSum2(root.left, sum - root.val)) {
      return true;
    }
    return hasPathSum2(root.right, sum - root.val);
  }

  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null) {
      return root.val == sum;
    }
    if (root.left != null || hasPathSum(root.left, sum - root.val)) {
      return true;
    }
    return root.right != null || hasPathSum(root.right, sum - root.val);
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
   *
   * Memory Usage: 37.5 MB, less than 95.29% of Java online submissions for Path Sum.
   *
   * 2次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：root==null时候的定义。如果按照hashPath2的concise solution来看，root==null应该对应sum==0，
   * 但是题意不是这样的，所以外面加一个函数判断，要么写成hashPath这样的
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    No_0112_PathSum no = new No_0112_PathSum();

    System.out.println(no.hasPathSum(TreeNode.construct("[1,2]"), 0));
  }
}

