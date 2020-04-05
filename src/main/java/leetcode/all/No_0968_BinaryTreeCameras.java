package leetcode.all;

import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0968_BinaryTreeCameras {

  public int minCameraCover(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }
    // 二元数组：root节点有camera的，和root节点没有camera的
    int[] minCam = helper(root);
    return Math.min(minCam[0], minCam[1]);
  }

  private boolean isLeaf(TreeNode node) {
    return node.left == null && node.right == null;
  }

  private int[] helper(TreeNode root) {
    if (root.left == null && root.right == null) {
      return new int[]{1, 0};
    } else {
      int[] ret = new int[2];
      int[] leftMinCam = null;
      int[] rightMinCam = null;
      if (root.left != null) {
        leftMinCam = helper(root.left);
      }
      if (root.right != null) {
        rightMinCam = helper(root.right);
      }
      if (root.left == null) {
        ret[0] = Math.min(rightMinCam[0], rightMinCam[1]) + 1;
        ret[1] = rightMinCam[0];
      } else if (root.right == null) {
        ret[0] = Math.min(leftMinCam[0], leftMinCam[1]) + 1;
        ret[1] = leftMinCam[0];
      } else {
        int leftMin = Math.min(leftMinCam[0], leftMinCam[1]);
        int rightMin = Math.min(rightMinCam[0], rightMinCam[1]);
        ret[0] = 1 + leftMin + rightMin;
        if (isLeaf(root.left)) {
          ret[1] = leftMinCam[0] + rightMin;
        } else if (isLeaf(root.right)) {
          ret[1] = rightMinCam[0] + leftMin;
        } else {
          ret[1] = Math.min(leftMinCam[0] + rightMin, rightMinCam[0] + leftMin);
        }
      }
      return ret;
    }
  }

  /**
   * <p>这个是错误版本。首先，少考虑了一种情况。这里只区分了node有没有CAM，但是注意，某子树不一定要全被照亮，
   * 因为子树的"子根节点"可以不被照亮，交给上面处理。典型的例子就是单分支六层的树。这个错误算法中需要三个cam，但其实只要两个
   * </p>
   *
   * 另外，可以贪心的思考，详见file2.
   *
   * 次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：line 16, 注意，如果root是leaf，那么至少为1.
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    No_0968_BinaryTreeCameras no = new No_0968_BinaryTreeCameras();

    System.out
        .println(no.minCameraCover(TreeNode.construct("[0,0,null,null,0,0,null,null,0,0,null]")));
    System.out.println(no.minCameraCover(TreeNode.construct("[0,0,0,null,null,null,0]")));
    System.out.println(no.minCameraCover(TreeNode.construct("[0,0,null,0,0]")));
  }
}

