package leetcode.all;

import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0129_SumRoottoLeafNumbers {

  private int sum = 0;

  private void helper(TreeNode node, int value) {
    value = value * 10 + node.val;
    if (node.left == null && node.right == null) {
      sum += value;
    } else {
      if (node.left != null) {
        helper(node.left, value);
      }
      if (node.right != null) {
        helper(node.right, value);
      }
    }
  }

  public int sumNumbers(TreeNode root) {
    if (root != null) {
      helper(root, 0);
    }
    return sum;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum Root to Leaf Numbers.
   *
   * Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Sum Root to Leaf
   * Numbers.
   *
   * 0次调试错误，然后成功。
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
    No_0129_SumRoottoLeafNumbers no = new No_0129_SumRoottoLeafNumbers();
    System.out.println(no);
  }
}

