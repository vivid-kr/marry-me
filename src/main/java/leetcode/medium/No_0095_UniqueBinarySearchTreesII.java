package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0095_UniqueBinarySearchTreesII {

  public List<TreeNode> generateTrees(int n) {
    if (n == 0) {
      return new ArrayList<>();
    }
    return genTrees(1, n);
  }

  public List<TreeNode> genTrees(int start, int end) {

    List<TreeNode> list = new ArrayList<>();

    if (start > end) {
      list.add(null);
      return list;
    }

    if (start == end) {
      list.add(new TreeNode(start));
      return list;
    }

    List<TreeNode> left, right;
    for (int i = start; i <= end; i++) {

      left = genTrees(start, i - 1);
      right = genTrees(i + 1, end);

      for (TreeNode lnode : left) {
        for (TreeNode rnode : right) {
          TreeNode root = new TreeNode(i);
          root.left = lnode;
          root.right = rnode;
          list.add(root);
        }
      }

    }

    return list;
  }

  /**
   * Runtime: 1 ms, faster than 99.95% of Java online submissions for Unique Binary Search Trees
   * II.
   *
   * Memory Usage: 39.1 MB, less than 59.52% of Java online submissions for Unique Binary Search
   * Trees II.
   *
   * 参考。特殊之处在于要把所有的链表返回，每个链表都要新new对象。这个解法是，子树的所有可能都放到list中。这个list也是递归的。
   *
   * https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/31494/A-simple-recursive-solution
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
    No_0095_UniqueBinarySearchTreesII no = new No_0095_UniqueBinarySearchTreesII();

    System.out.println(no.generateTrees(3));

  }
}

