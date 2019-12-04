package leetcode.medium;

/**
 * 更好的解法：假设最左最右是a<b，距离l。面积为min(a,b) * l
 *
 * 对于较小的a，任意ab间的节点c，距离都小于l，且min(a,c) <= min(a,b)，所以面积一定不超过ab面积，a可以跳过了
 *
 * 2019-08-12 18:19:46
 */
public class No_0011_ContainerWithMostWater2 {

  public static int maxArea(int[] height) {
    int maxWater = 0;
    int colLen = height.length;
    int left = 0;
    int right = colLen - 1;
    while (left < right){
      int water = Math.min(height[left], height[right]) * (right - left);
      if (water > maxWater)
        maxWater = water;
      if (height[left]< height[right])
        left++;
      else
        right--;
    }
    return maxWater;
  }


  /**
   * Runtime: 2 ms, faster than 94.32%
   *
   * Memory Usage: 39.6 MB, less than 95.51%
   *
   *
   */
  public static void main(String[] args) {
    int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int actual = maxArea(input);
    int expect = 49;
    System.out.println(actual);
    System.out.println(actual == expect);


  }
}

