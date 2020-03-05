package leetcode.all;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0145_BinaryTreePostorderTraversal {

  public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> ans = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    if (root == null) {
      return ans;
    }

    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pop();
      ans.addFirst(cur.val);
      if (cur.left != null) {
        stack.push(cur.left);
      }
      if (cur.right != null) {
        stack.push(cur.right);
      }
    }
    return ans;
  }

  /**
   * Runtime: Memory Usage:
   *
   * 参考 https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45556/Java-simple-and-clean
   *
   * 其实不用递归用堆栈，有什么分别呢？区别不大
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
    No_0145_BinaryTreePostorderTraversal no = new No_0145_BinaryTreePostorderTraversal();

    System.out.println(no);
  }
}

