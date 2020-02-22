package leetcode.all;

import java.util.ArrayList;
import java.util.List;
import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0113_PathSumII {

  private List<List<Integer>> res = new ArrayList<>();
  private List<Integer> curPath = new ArrayList<>();

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    if (root == null) {
      return res;
    }
    helper(root, sum);
    return res;
  }

  private void helper(TreeNode root, int sum) {
    if (root.left == null && root.right == null) {
      if (sum == root.val) {
        ArrayList<Integer> a = new ArrayList<>(curPath);
        a.add(sum);
        res.add(a);
      }
    } else {
      curPath.add(root.val);
      if (root.left != null) {
        pathSum(root.left, sum - root.val);
      }
      if (root.right != null) {
        pathSum(root.right, sum - root.val);
      }
      curPath.remove(curPath.size() - 1);
    }
  }


  /**
   * Runtime: 1 ms, faster than 100.00% of Java online submissions for Path Sum II.
   *
   * Memory Usage: 37.8 MB, less than 100.00% of Java online submissions for Path Sum II.
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    No_0113_PathSumII no = new No_0113_PathSumII();

    System.out.println(no.pathSum(TreeNode.construct("[1,2]"), 0));
  }
}

