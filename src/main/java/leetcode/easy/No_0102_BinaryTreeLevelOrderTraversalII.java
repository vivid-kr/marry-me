package leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0102_BinaryTreeLevelOrderTraversalII {

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    subLevelOrder(res, root, 0);
    Collections.reverse(res);
    return res;
  }

  private void subLevelOrder(List<List<Integer>> res, TreeNode root, int level) {
    if (root == null) {
      return;
    }
    if (res.size() < level + 1) {
      res.add(new ArrayList<>());
    }
    List<Integer> values = res.get(level);
    values.add(root.val);
    subLevelOrder(res, root.left, level + 1);
    subLevelOrder(res, root.right, level + 1);
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Level Order Traversal II.
   *
   * Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Binary Tree Level Order Traversal II.
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
    No_0102_BinaryTreeLevelOrderTraversalII no = new No_0102_BinaryTreeLevelOrderTraversalII();

    System.out.println(no);
  }
}

