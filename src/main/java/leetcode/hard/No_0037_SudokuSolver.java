package leetcode.hard;

import java.util.Arrays;

/**
 * TODO Time
 */
public class No_0037_SudokuSolver {

  public static int global_to_sub_box(int i, int j) {
    return 3 * (i / 3) + j / 3;
  }

  private static boolean sub_solveSudoku(int[][] intBoard, int idx,
      int[] row_flags, int[] col_flags, int[] box_flags) {
    if (idx == 81) {
      return true;
    }
    int row = idx / 9;
    int col = idx % 9;
    if (intBoard[row][col] != 0) {
      return sub_solveSudoku(intBoard, idx + 1, row_flags, col_flags, box_flags);
    } else {
      for (int v = 1; v <= 9; v++) {
        int f = 1 << v;
        if ((f & row_flags[row]) != 0 || (f & col_flags[col]) != 0) {
          continue;
        }
        int box = global_to_sub_box(row, col);
        if ((f & box_flags[box]) != 0) {
          continue;
        }
        //都不是，可以填一下
        row_flags[row] |= f;
        col_flags[col] |= f;
        box_flags[box] |= f;
        intBoard[row][col] = v;
        //下一步
        if (sub_solveSudoku(intBoard, idx + 1, row_flags, col_flags, box_flags)) {
          return true;
        }
        //归位
        intBoard[row][col] = 0;
        row_flags[row] &= ~f;
        col_flags[col] &= ~f;
        box_flags[box] &= ~f;
      }
    }
    return false;
  }

  public static void solveSudoku(char[][] board) {
    //transform
    int[] row_flags = new int[9];
    int[] column_flags = new int[9];
    int[] box_flags = new int[9];

    int[][] intBoard = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          intBoard[i][j] = 0;
        } else {
          int v = board[i][j] - '0';
          intBoard[i][j] = v;
          row_flags[i] |= 1 << v;
          column_flags[j] |= 1 << v;
          int box = global_to_sub_box(i, j);
          box_flags[box] |= 1 << v;
        }
      }
    }
    if (!sub_solveSudoku(intBoard, 0, row_flags, column_flags, box_flags)) {
      return;
    }
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (intBoard[i][j] == '.') {
          board[i][j] = '.';
        } else {
          board[i][j] = (char) (intBoard[i][j] + '0');
        }
      }
    }
  }

  /**
   * Runtime:
   *
   * Memory Usage:
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

  public static void printSudoku(char[][] input) {
    for (int i = 0; i < 9; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < 9; j++) {
        sb.append(input[i][j]);
        sb.append(',');
      }
      System.out.println(sb.toString());
    }
  }

  public static void main(String[] args) {
    char input[][] = {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    String expect = "[[C@1d44bcfa, [C@266474c2, [C@6f94fa3e, [C@5e481248, [C@66d3c617, [C@63947c6b, [C@2b193f2d, [C@355da254, [C@4dc63996]";
    solveSudoku(input);
    printSudoku(input);
    System.out.println(expect.equals(Arrays.toString(input)));
  }
}

