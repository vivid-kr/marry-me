package leetcode.all;

import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0988_SmallestStringStartingFromLeaf {

  public String smallestFromLeaf(TreeNode root) {
    return dfs(root, "");
  }

  public String dfs(TreeNode node, String suffix) {
    if (null == node) {
      return suffix;
    }
    suffix = "" + (char) ('a' + node.val) + suffix;
    if (null == node.left && null == node.right) {
      return suffix;
    }
    if (null == node.left || null == node.right) {
      return (null == node.left) ? dfs(node.right, suffix) : dfs(node.left, suffix);
    }

    String left = dfs(node.left, suffix);
    String right = dfs(node.right, suffix);

    return left.compareTo(right) <= 0 ? left : right;
  }


  /**
   * Runtime: 1 ms, faster than 99.92% of Java online submissions for Smallest String Starting From
   * Leaf.
   *
   * Memory Usage: 36.8 MB, less than 100.00% of Java online submissions for Smallest String
   * Starting From Leaf.
   *
   * https://leetcode.com/problems/smallest-string-starting-from-leaf/discuss/231117/java-dfs-O(N)
   *
   * 一句话反思：没有新意，不再赘述
   *
   * 新知识：
   */


  public static void main(String[] args) {
    No_0988_SmallestStringStartingFromLeaf no = new No_0988_SmallestStringStartingFromLeaf();

    System.out.println(no.smallestFromLeaf(TreeNode.construct("[1,2]")));
  }
}

