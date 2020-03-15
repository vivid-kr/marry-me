package leetcode.all;

import java.util.ArrayList;
import java.util.List;
import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0257_BinaryTreePaths {

  private List<String> res = new ArrayList<>();
  private List<Integer> curPath = new ArrayList<>();

  public List<String> binaryTreePaths(TreeNode root) {
    if (root == null) {
      return res;
    }
    helper(root);
    return res;
  }

  private void helper(TreeNode root) {
    if (root.left == null && root.right == null) {
      StringBuilder sb = new StringBuilder();
      for (Integer integer : curPath) {
        sb.append(integer);
        sb.append("->");
      }
      sb.append(root.val);
      res.add(sb.toString());
    } else {
      curPath.add(root.val);
      if (root.left != null) {
        helper(root.left);
      }
      if (root.right != null) {
        helper(root.right);
      }
      curPath.remove(curPath.size() - 1);
    }
  }


  /**
   * Runtime: 1 ms, faster than 100.00% of Java online submissions for Binary Tree Paths.
   *
   * Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Binary Tree Paths.
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    No_0257_BinaryTreePaths no = new No_0257_BinaryTreePaths();

    System.out.println(no.binaryTreePaths(TreeNode.construct("[1,2]")));
  }
}

