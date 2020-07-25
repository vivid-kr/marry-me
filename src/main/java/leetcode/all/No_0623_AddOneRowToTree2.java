package leetcode.all;

import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0623_AddOneRowToTree {

  private void subAddRow(TreeNode node, int v, int d, int level) {
    if(level == d){
      TreeNode nl = new TreeNode(v);
      nl.left = node.left;
      node.left = nl;
      TreeNode nr = new TreeNode(v);
      nr.right = node.right;
      node.right = nr;
      return;
    }
    if(node.left != null)
      subAddRow(node.left, v, d, level+1);
    if(node.right != null)
      subAddRow(node.right, v, d, level+1);
  }

  public TreeNode addOneRow(TreeNode root, int v, int d) {
    if (d == 1) {
      TreeNode node = new TreeNode(v);
      node.left = root;
      return node;
    }
    if(root == null)
      return null;
    subAddRow(root, v, d, 2);
    return root;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Add One Row to Tree.
   *
   * Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for Add One Row to Tree.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：level错了1位，line 34，从1改成2就可以了
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    No_0623_AddOneRowToTree no = new No_0623_AddOneRowToTree();

    System.out.println(no);
  }
}

