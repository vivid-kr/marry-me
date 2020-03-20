package leetcode.all;

import java.util.List;

/**
 * TODO Time
 */
public class No_0559_Maximum_DepthOfN_AryTree {

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

  private int maxDepth = 0;

  public int maxDepth(Node root) {
    if (root == null) {
      return 0;
    }
    subLevelOrder(root, 1);
    return maxDepth;
  }

  private void subLevelOrder(Node root, int level) {
    if (root.children == null || root.children.isEmpty()) {
      if (maxDepth < level) {
        maxDepth = level;
      }
      return;
    }
    for (Node child : root.children) {
      subLevelOrder(child, level + 1);
    }
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of N-ary Tree.
   *
   * Memory Usage: 39.7 MB, less than 100.00% of Java online submissions for Maximum Depth of N-ary
   * Tree.
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
    No_0559_Maximum_DepthOfN_AryTree no = new No_0559_Maximum_DepthOfN_AryTree();

    System.out.println(no);
  }
}

