package leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Time
 */
public class No_0589_N_AryTreePostorderTraversal {

  class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  public List<Integer> postorder(Node root) {
    List<Integer> res = new ArrayList<>();
    subLevelOrder(res, root, 0);
    return res;
  }

  private void subLevelOrder(List<Integer> res, Node root, int level) {
    if (root == null) {
      return;
    }
    if (root.children != null) {
      for (Node child : root.children) {
        subLevelOrder(res, child, level + 1);
      }
    }
    res.add(root.val);
  }

  /**
   * Runtime: 1 ms, faster than 98.49% of Java online submissions for N-ary Tree Postorder
   * Traversal.
   *
   * Memory Usage: 39.9 MB, less than 100.00% of Java online submissions for N-ary Tree Postorder
   * Traversal.
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
    No_0589_N_AryTreePostorderTraversal no = new No_0589_N_AryTreePostorderTraversal();

    System.out.println(no);
  }
}

