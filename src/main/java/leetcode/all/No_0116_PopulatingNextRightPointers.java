package leetcode.all;

/**
 * TODO Time
 */
public class No_0116_PopulatingNextRightPointers {

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


  private void helper(Node root, int depth, Node[] levelLasts) {
    if (levelLasts[depth] == null) {
      levelLasts[depth] = root;
    } else {
      levelLasts[depth].next = root;
      levelLasts[depth] = root;
    }
    if (depth < levelLasts.length - 1) {
      helper(root.left, depth + 1, levelLasts);
      helper(root.right, depth + 1, levelLasts);
    }
  }

  public Node connect(Node root) {
    if (root == null) {
      return root;
    }
    //find Depth
    int depth = 0;
    Node node = root;
    while (node != null) {
      depth++;
      node = node.left;
    }
    Node[] levelLasts = new Node[depth];
    helper(root, 0, levelLasts);
    return root;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Populating Next Right
   * Pointers in Each Node.
   *
   * Memory Usage: 39.7 MB, less than 6.35% of Java online submissions for Populating Next Right
   * Pointers in Each Node.
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
    No_0116_PopulatingNextRightPointers no = new No_0116_PopulatingNextRightPointers();

    System.out.println(no);
  }
}

