package leetcode.hard;

/**
 * TODO Time
 */
public class No_0042_TrappingRainWater {

  public int trap(int[] height) {
    int[] stack = new int[height.length + 1];
    int p = 0;
    int trap = 0;
    for (int i = 0; i < height.length; i++) {
      while (p >= 0 && height[i] >= height[stack[p]]) {
        trap += (height[stack[p]] - height[stack[p + 1]]) * (i - stack[p] - 1);
        p--;
      }
      if (p >= 0) {
        trap += (height[i] - height[stack[p + 1]]) * (i - stack[p] - 1);
      }
      stack[++p] = i;
    }
    return trap;
  }

  /**
   * Runtime: 1 ms, faster than 96.08% of Java online submissions for Trapping Rain Water.
   *
   * Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Trapping Rain Water.
   *
   * 2错误：
   *
   * 1错：line 16 ，从0开始，而不是从1开始（其实不算错误，没细看）
   *
   * 2错：line 17：忽略了一种情况：4,2,3。3开始回溯，到4停止。这时候4比3高，3需要累积一些水！
   *
   *
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    No_0042_TrappingRainWater no = new No_0042_TrappingRainWater();
    System.out.println(6 == no.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    System.out.println(2 == no.trap(new int[]{2, 0, 2}));
    System.out.println(1 == no.trap(new int[]{4, 2, 3}));

  }
}

