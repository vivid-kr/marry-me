package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Time
 */
public class No_0052_N_QueensII {

  private static int queen(int row, int colFlag, int diag1Flag, int diag2Flag, final int N) {
    int count = 0;
    for (int col = 0; col < N; col++) {
      int diag1 = row + col;
      int diag2 = N + col - row;
      if ((colFlag & (1 << col)) != 0 ||
          (diag1Flag & (1 << diag1)) != 0 ||
          (diag2Flag & (1 << diag2)) != 0) {
        continue;
      }
      if(row == N - 1){
        count++;
        continue;
      }
      colFlag |= 1 << col;
      diag1Flag |= 1 << diag1;
      diag2Flag |= 1 << diag2;
      count += queen(row + 1, colFlag, diag1Flag, diag2Flag, N);
      colFlag &= ~(1 << col);
      diag1Flag &= ~(1 << diag1);
      diag2Flag &= ~(1 << diag2);
    }
    return count;
  }

  public static int totalNQueens(int n) {
    if (n == 0) {
      return 0;
    }
    int colFlag = 0;
    int diag1Flag = 0;
    int diag2Flag = 0;
    return queen(0, colFlag, diag1Flag, diag2Flag, n);
  }


  /**
   * Runtime: 1 ms, faster than 97.05% of Java online submissions for N-Queens II.
   *
   * Memory Usage: 32.7 MB, less than 13.04% of Java online submissions for N-Queens II.
   *
   *
   * 0次调试错误，然后成功。内存占用基本没什么意义，因为都很小，是随机结果
   *
   * 错误：
   *
   * 1错：位运算符号
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    System.out.println(totalNQueens(4));
  }
}

