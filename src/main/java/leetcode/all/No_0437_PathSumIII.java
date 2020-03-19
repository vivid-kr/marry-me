package leetcode.all;

import java.util.ArrayList;
import java.util.List;
import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0437_PathSumIII {

  private int pathCount;
  private int sum;
  private List<Integer> prePath;

  public int pathSum(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }
    pathCount = 0;
    prePath = new ArrayList<>();
    this.sum = sum;
    helper(root);
    return pathCount;
  }

  private void helper(TreeNode root) {
    int curSum = 0;
    prePath.add(root.val);
    for (int i = prePath.size() - 1; i >= 0; i--) {
      curSum += prePath.get(i);
      if (curSum == sum) {
        pathCount++;
      }
    }
    if (root.left != null) {
      helper(root.left);
    }
    if (root.right != null) {
      helper(root.right);
    }
    prePath.remove(prePath.size() - 1);
  }

  /**
   * Runtime: 17 ms, faster than 9.23% of Java online submissions for Path Sum III.
   *
   * Memory Usage: 39.7 MB, less than 81.82% of Java online submissions for Path Sum III.
   *
   * 数次错误，主要是注意，不要递归出现重复的问题。以上效果不理想，但是看了一下2ms的那个，首先现在跑一下是6ms，波动很大，
   *
   * 其次，他首先计算总深度，然后new了个数组，但是做法和我的殊无二致，所以没啥意思
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
    No_0437_PathSumIII no = new No_0437_PathSumIII();

    TreeNode t1 = new TreeNode(1);
    TreeNode t2 = new TreeNode(2);
    TreeNode t3 = new TreeNode(3);
    TreeNode t4 = new TreeNode(4);
    TreeNode t5 = new TreeNode(5);
    t1.right = t2;
    t2.right = t3;
    t3.right = t4;
    t4.right = t5;
    System.out.println(no.pathSum(t1, 3));

    System.out.println(no.pathSum(TreeNode.construct("[10,5,-3,3,2,null,11,3,-2,null,1]"), 8));
  }
}

