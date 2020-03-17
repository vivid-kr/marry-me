package leetcode.all;

/**
 * TODO Time
 */
public class No_0279_PerfectSquares {

  public static int numSquares(int num) {
    if (num <= 0) {
      return -1;
    }
    // determine the max square number
    int d = 1;
    while (d * d < num) {
      d++;
    }
    if (d * d > num) {
      d--;
    }
    int[] retNum = new int[num + 1];
    int[][] retList = new int[num + 1][];
    // put square number first
    for (int i = 1; i <= d; i++) {
      retNum[i * i] = 1;
      retList[i * i] = new int[]{i * i};
    }
    // calculate each number from 1 to num
    for (int nn = 1; nn <= num; nn++) {
      if (retNum[nn] == 1) {
        continue;
      }
      // execute sub problem
      int minN = Integer.MAX_VALUE;
      int minRest = -1;
      for (int j = 1; j * j <= nn; j++) {
        int rest = nn - j * j;
        if (retNum[rest] + 1 < minN) {
          minN = retNum[rest] + 1;
          minRest = rest;
        }
      }
      retNum[nn] = minN;
      // construct result array
      int[] t = new int[minN];
      System.arraycopy(retList[minRest], 0, t, 0, minN - 1);
      t[minN - 1] = nn - minRest;
      retList[nn] = t;
    }
    // return retList[num];
    return retNum[num];
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
    System.out.println(numSquares(12) == 3);
  }
}

