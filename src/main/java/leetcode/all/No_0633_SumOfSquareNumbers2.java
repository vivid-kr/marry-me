package leetcode.all;

import java.util.ArrayList;
import java.util.List;
import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0637_AverageofLevelsinBinaryTree {

  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> resSum = new ArrayList<>();
    List<Integer> resCount = new ArrayList<>();
    List<Double> resMean = new ArrayList<>();
    subLevelOrder(resSum, resCount, root, 0);
    for (int i = 0; i < resSum.size(); i++) {
      resMean.add(resSum.get(i) / resCount.get(i));
    }
    return resMean;
  }

  private void subLevelOrder(List<Double> resSum, List<Integer> resCount, TreeNode root, int level) {
    if (root == null) {
      return;
    }
    if (resSum.size() < level + 1) {
      resSum.add(0d);
      resCount.add(0);
    }
    resSum.set(level, resSum.get(level) + root.val);
    resCount.set(level, resCount.get(level) + 1);
    subLevelOrder(resSum, resCount, root.left, level + 1);
    subLevelOrder(resSum, resCount, root.right, level + 1);
  }

  /**
   * Runtime: 2 ms, faster than 97.27% of Java online submissions for Average of Levels in Binary Tree.
   *
   * Memory Usage: 39.9 MB, less than 100.00% of Java online submissions for Average of Levels in Binary Tree.
   *
   * 0次调试错误，然后成功。相比于利用102找出每一层，然后再算均值，这个解法的内存空间比较小
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
    No_0637_AverageofLevelsinBinaryTree no = new No_0637_AverageofLevelsinBinaryTree();

    System.out.println(no);
  }
}

