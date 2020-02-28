package leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Time
 */
public class No_0117_PopulatingNextRightPointersII {

  class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }


  private void helper(Node root, int depth, List<Node> levelLasts) {
    if (depth == levelLasts.size()) {
      levelLasts.add(root);
    } else {
      levelLasts.get(depth).next = root;
      levelLasts.set(depth, root);
    }
    if (root.left != null) {
      helper(root.left, depth + 1, levelLasts);
    }
    if (root.right != null) {
      helper(root.right, depth + 1, levelLasts);
    }
  }

  public Node connect(Node root) {
    if (root == null) {
      return root;
    }
    List<Node> levelLasts = new ArrayList<>();
    helper(root, 0, levelLasts);
    return root;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Populating Next Right Pointers in Each Node II.
   *
   * Memory Usage: 38 MB, less than 100.00% of Java online submissions for Populating Next Right Pointers in Each Node II.
   *
   * 0次调试错误，然后成功。由于解法比较好，所以直接改一下116就行了，甚至不用改可以直接用到116上
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
    No_0117_PopulatingNextRightPointersII no = new No_0117_PopulatingNextRightPointersII();

    System.out.println(no);
  }
}

