package leetcode.all;

import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0124_BinaryTreeMaximumPathSum {

  /**
   * @param root not null
   * @return int[2]: int[0]: single branch with root val, int[1]: not required to be single branch
   */
  private int[] helper(TreeNode root) {
    if (root.left == null && root.right == null) {
      return new int[]{root.val, root.val};
    }
    int[] leftMax = root.left == null ?
        new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE} : helper(root.left);
    int[] rightMax = root.right == null ?
        new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE} : helper(root.right);
    //single
    int maxSingleChild = Math.max(leftMax[0], rightMax[0]);
    int singleMax = maxSingleChild > 0 ? root.val + maxSingleChild : root.val;
    //nonSingle
    //bridge case
    int bridgeMax = root.val;
    if(leftMax[0] > 0) bridgeMax += leftMax[0];
    if(rightMax[0] > 0) bridgeMax += rightMax[0];
    int nonSingleMax = Math.max(Math.max(leftMax[1], rightMax[1]), bridgeMax);
    return new int[]{singleMax, nonSingleMax};
  }

  public int maxPathSum(TreeNode root) {
    int[] max = helper(root);
    return max[1];
  }

  /**
   * Runtime: 1 ms, faster than 99.78% of Java online submissions for Binary Tree Maximum Path Sum.
   *
   * Memory Usage: 40.5 MB, less than 91.67% of Java online submissions for Binary Tree Maximum Path Sum.
   *
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
    No_0124_BinaryTreeMaximumPathSum no = new No_0124_BinaryTreeMaximumPathSum();

    System.out.println(no.maxPathSum(TreeNode.construct("[1,2,3]")));
    System.out.println(no.maxPathSum(TreeNode.construct("[-10,9,20,null,null,15,7]")));
  }
}

