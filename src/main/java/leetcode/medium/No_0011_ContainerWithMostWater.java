package leetcode.medium;

/**
 * 先用最简单的做法试试看，暴力解法
 *
 * 2019-08-12 18:19:46
 */
public class No_0011_ContainerWithMostWater {

  public static int maxArea(int[] height) {
    int maxWater = 0;
    int colLen = height.length;
    for (int i = 0; i < colLen; i++) {
      for (int j = i + 1; j < colLen; j++) {
        int h = height[i] < height[j] ? height[i] : height[j];
        int water = h * (j - i);
        if (water > maxWater) {
          maxWater = water;
        }
      }
    }
    return maxWater;
  }


  /**
   * Runtime: 200 ms, faster than 23.18%
   *
   * Memory Usage: 39.8 MB, less than 94.87%
   *
   * 直接成功。肯定空间小，但时间慢。
   *
   *
   * 新知识：
   *
   *
   */
  public static void main(String[] args) {
    int[] input = {1,8,6,2,5,4,8,3,7};
    int actual = maxArea(input);
    int expect = 49;
    System.out.println(actual);
    System.out.println(actual == expect);



  }
}

