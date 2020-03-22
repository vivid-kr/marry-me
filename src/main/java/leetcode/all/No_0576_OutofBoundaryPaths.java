package leetcode.all;

/**
 * TODO Time
 */
public class No_0576_OutofBoundaryPaths {

  public int findPaths(int m, int n, int N, int i, int j) {
    if (N <= 0) return 0;

    final int MOD = 1000000007;
    int[][] count = new int[m][n];
    count[i][j] = 1;
    int result = 0;

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    for (int step = 0; step < N; step++) {
      int[][] temp = new int[m][n];
      for (int r = 0; r < m; r++) {
        for (int c = 0; c < n; c++) {
          for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
              result = (result + count[r][c]) % MOD;
            }
            else {
              temp[nr][nc] = (temp[nr][nc] + count[r][c]) % MOD;
            }
          }
        }
      }
      count = temp;
    }

    return result;
  }

  /**
   * Runtime: 12 ms, faster than 25.05% of Java online submissions for Out of Boundary Paths.
   *
   * Memory Usage: 35 MB, less than 25.00% of Java online submissions for Out of Boundary Paths.
   *
   * 太慢了，第一版本会超时，已经加入list了
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
    No_0576_OutofBoundaryPaths no = new No_0576_OutofBoundaryPaths();

    System.out.println(no.findPaths(2,2,2,0,0));
    System.out.println(no.findPaths(1,3,3,0,1));
  }
}

