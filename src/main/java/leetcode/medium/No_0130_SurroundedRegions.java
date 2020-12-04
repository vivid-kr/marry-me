package leetcode.medium;

import java.util.Arrays;

/**
 * TODO Time
 */
public class No_0130_SurroundedRegions {

  private static final char U = 'U';
  private static final char X = 'X';
  private static final char O = 'O';
  private static int rightIdx;
  private static int bottomIdx;

  public void solve(char[][] board) {
    if (board.length <= 2 || board[0].length <= 2) {
      return;
    }
    markUnSurrounded(board);
    changeSurrounded(board);
  }

  private void markUnSurrounded(char[][] board) {
    char[] line = board[0];
    rightIdx = line.length - 1;
    bottomIdx = board.length - 1;
    // top
    for (int col = 0; col <= rightIdx; col++) {
      if (line[col] == O) {
        detectUnSurrounded(board, 0, col);
      }
    }
    // bottom
    line = board[bottomIdx];
    for (int col = 0; col <= rightIdx; col++) {
      if (line[col] == O) {
        detectUnSurrounded(board, board.length - 1, col);
      }
    }
    // left
    for (int row = 1; row < bottomIdx; row++) {
      if (board[row][0] == O) {
        detectUnSurrounded(board, row, 0);
      }
    }
    // right
    for (int row = 1; row < bottomIdx; row++) {
      if (board[row][rightIdx] == O) {
        detectUnSurrounded(board, row, rightIdx);
      }
    }
  }

  private void detectUnSurrounded(char[][] board, int row, int col) {
    board[row][col] = U;
    // top
    if (row > 0 && board[row - 1][col] == O) {
      detectUnSurrounded(board, row - 1, col);
    }
    // bottom
    if (row < bottomIdx && board[row + 1][col] == O) {
      detectUnSurrounded(board, row + 1, col);
    }
    // left
    if (col > 0 && board[row][col - 1] == O) {
      detectUnSurrounded(board, row, col - 1);
    }
    // right
    if (col < rightIdx && board[row][col + 1] == O) {
      detectUnSurrounded(board, row, col + 1);
    }
  }

  private void changeSurrounded(char[][] board) {
    for (int row = 0; row <= bottomIdx; row++) {
      for (int col = 0; col <= rightIdx; col++) {
        if (board[row][col] == U) {
          board[row][col] = O;
        } else {
          if (board[row][col] == O) {
            board[row][col] = X;
          }
        }
      }
    }
  }


  /**
   * Runtime: 1 ms, faster than 99.81% of Java online submissions for Surrounded Regions.
   *
   * Memory Usage: 40.9 MB, less than 71.75% of Java online submissions for Surrounded Regions.
   *
   * 1次调试错误，然后成功。笔误
   *
   * 一句话反思：还可以吧，两轮
   *
   * 新知识：
   */


  public static void main(String[] args) {
    char[][] board;
    board = new char[][]{
        new char[]{X, X, X, X},
        new char[]{X, O, O, X},
        new char[]{X, X, O, X},
        new char[]{X, O, X, X},
    };
    (new No_0130_SurroundedRegions()).solve(board);
    printBoard(board);
  }

  private static void printBoard(char[][] board) {
    for (char[] chars : board) {
      System.out.println(Arrays.toString(chars));
    }
  }

}

