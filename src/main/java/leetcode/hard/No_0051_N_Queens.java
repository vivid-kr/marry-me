package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Time
 */
public class No_0051_N_Queens {

  private static void addSolution(int[] solve, List<List<String>> res, char[] chars, final int N) {
    List<String> queens = new ArrayList<>();
    for (int row : solve) {
      chars[row] = 'Q';
      queens.add(new String(chars));
      chars[row] = '.';
    }
    res.add(queens);
  }

  private static void queen(int row, int[] solve, int colFlag, int diag1Flag, int diag2Flag,
      List<List<String>> res, char[] chars, final int N) {
    if (row == N) {
      addSolution(solve, res, chars, N);
    }
    // the s-th row, test all column and diag
    for (int col = 0; col < N; col++) {
      int diag1 = row + col;
      int diag2 = N + col - row;
      if ((colFlag & (1 << col)) != 0 ||
          (diag1Flag & (1 << diag1)) != 0 ||
          (diag2Flag & (1 << diag2)) != 0) {
        continue;
      }
      colFlag |= 1 << col;
      diag1Flag |= 1 << diag1;
      diag2Flag |= 1 << diag2;
      solve[row] = col;
      queen(row + 1, solve, colFlag, diag1Flag, diag2Flag, res, chars, N);
      colFlag &= ~(1 << col);
      diag1Flag &= ~(1 << diag1);
      diag2Flag &= ~(1 << diag2);
    }
  }

  public static List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new ArrayList<>();
    if (n == 0) {
      return res;
    }
    char[] chars = new char[n];
    for (int i = 0; i < n; i++) {
      chars[i] = '.';
    }
    int colFlag = 0;
    int diag1Flag = 0;
    int diag2Flag = 0;
    int[] solve = new int[n];
    queen(0, solve, colFlag, diag1Flag, diag2Flag, res, chars, n);
    return res;
  }


  /**
   * 100、100 beat
   *
   * 1次调试错误，然后成功。
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
    List<List<String>> actual = solveNQueens(4);
    for (List<String> a : actual) {
      for (String s: a) {
        System.out.println(s);
      }
      System.out.println();
    }
  }
}

