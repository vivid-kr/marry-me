package leetcode.all;

import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0968_BinaryTreeCameras2 {

  private int NOT_MONITORED = 0;
  private int MONITORED_NOCAM = 1;
  private int MONITORED_WITHCAM = 2;
  private int cameras = 0;

  public int minCameraCover(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int top = dfs(root);
    return cameras + (top == NOT_MONITORED ? 1 : 0);
  }

  private int dfs(TreeNode root) {
    if (root == null) {
      return MONITORED_NOCAM;
    }
    int left = dfs(root.left);
    int right = dfs(root.right);
    if (left == MONITORED_NOCAM && right == MONITORED_NOCAM) {
      return NOT_MONITORED;
    } else if (left == NOT_MONITORED || right == NOT_MONITORED) {
      cameras++;
      return MONITORED_WITHCAM;
    } else {
      return MONITORED_NOCAM;
    }
  }

  /**
   * 从底向上推是可以的，因为有一个最简单的结论：叶子节点如果有父节点，那给父节点cam，肯定比叶子节点好。这是dominate的！
   *
   * <p>然后就可以发现，这是可以贪心的一步步上推的。就是这个解法。具体分析：从有没有灯、照不照亮有2*2中情况，</p>
   * <p>但是有灯不会暗，所以实际上是3种情况（file1只考虑了两种。）</p>
   * <p>NOT_MONITORED就一定要上面照顾。</p>
   * <p>MONITORED_NOCAM是不用管我，我也帮不上你（所以叶子节点的null孩子都是这种类型）;</p>
   * <p>MONITORED_WITHCAM有灯。可以照顾上层。</p>
   *
   * <p>注意line 29~35的三分支，可以画个3*3的方阵就知道了。第一种：我不用管下面的，下面的也不管我，我就报告自己not-moniter</p>
   * <p>第二种，子节点有一个是没人管的，所以就需要一盏灯</p>
   * <p>第三种，两个子节点都不是"未照亮"，也不是"都被别人照亮"，就意味着至少有一个是有灯的，那这个节点也就被照亮了</p>
   */


  public static void main(String[] args) {
    No_0968_BinaryTreeCameras2 no = new No_0968_BinaryTreeCameras2();

    System.out
        .println(no.minCameraCover(TreeNode.construct("[0,0,null,null,0,0,null,null,0,0,null]")));
    System.out.println(no.minCameraCover(TreeNode.construct("[0,0,0,null,null,null,0]")));
    System.out.println(no.minCameraCover(TreeNode.construct("[0,0,null,0,0]")));
  }
}

