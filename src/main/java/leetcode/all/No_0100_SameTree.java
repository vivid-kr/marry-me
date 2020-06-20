package leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0100_SameTree {

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == null && q == null)
      return true;
    if(p == null || q == null)
      return false;
    return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
   *
   * Memory Usage: 34 MB, less than 100.00% of Java online submissions for Same Tree.
   *
   *
   * 0次调试错误，然后成功。不用说了，估计大家做法都一样
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
    No_0100_SameTree no = new No_0100_SameTree();
  }
}

