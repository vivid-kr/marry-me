package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0094_BinaryTreeInorderTraversal {

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<Integer>();

    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode cur = root;

    while (cur != null || !stack.empty()) {
      while (cur != null) {
        stack.add(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      list.add(cur.val);
      cur = cur.right;
    }

    return list;
  }


  /**
   * 不再赘述
   *
   * https://leetcode.com/problems/binary-tree-inorder-traversal/discuss/31213/Iterative-solution-in-Java-simple-and-readable
   *
   * 次调试错误，然后成功。
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
    No_0094_BinaryTreeInorderTraversal no = new No_0094_BinaryTreeInorderTraversal();

    System.out.println(no);
  }
}

