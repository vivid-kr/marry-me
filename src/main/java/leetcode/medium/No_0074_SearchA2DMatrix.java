package leetcode.medium;

/**
 * TODO Time
 */
public class No_0074_SearchA2DMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix.length == 0 || matrix[0].length == 0)
      return false;
    int n = matrix.length;
    int m = matrix[0].length;
    int l = 0, r = m * n - 1;
    while (l != r){
      int mid = (l + r - 1) >> 1;
      if (matrix[mid / m][mid % m] < target)
        l = mid + 1;
      else
        r = mid;
    }
    return matrix[r / m][r % m] == target;
  }

  /**
   * Runtime: Memory Usage:
   *
   * 次调试错误，然后成功。
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
    No_0074_SearchA2DMatrix no = new No_0074_SearchA2DMatrix();

    System.out.println(no);
  }
}

