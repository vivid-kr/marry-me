package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Time
 */
public class No_0079_WordSearch {

  public boolean exist(char[][] board, String str) {
    if (board.length == 0 || board[0].length == 0 || "".equals(str)) {
      return false;
    }
    int m = board.length;
    int n = board[0].length;
    char[] word = str.toCharArray();
    boolean[][] flags = new boolean[m][n];
    // find the start points
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        if (board[row][col] == word[0]) {
          flags[row][col] = true;
          if (findPath(row, col, 1, board, flags, word)) {
            return true;
          }
          flags[row][col] = false;
        }
      }
    }
    return false;
  }

  private boolean findPath(int row, int col, int p, char[][] board, boolean[][] flags,
      char[] word) {
    if (p == word.length) {
      return true;
    }
    //up
    if (row > 0 && !flags[row - 1][col] && board[row - 1][col] == word[p]) {
      flags[row - 1][col] = true;
      if (findPath(row - 1, col, p + 1, board, flags, word)) {
        return true;
      }
      flags[row - 1][col] = false;
    }
    //down
    if (row < board.length - 1 && !flags[row + 1][col] && board[row + 1][col] == word[p]) {
      flags[row + 1][col] = true;
      if (findPath(row + 1, col, p + 1, board, flags, word)) {
        return true;
      }
      flags[row + 1][col] = false;
    }
    //left
    if (col > 0 && !flags[row][col - 1] && board[row][col - 1] == word[p]) {
      flags[row][col - 1] = true;
      if (findPath(row, col - 1, p + 1, board, flags, word)) {
        return true;
      }
      flags[row][col - 1] = false;
    }
    //right
    if (col < board[0].length - 1 && !flags[row][col + 1] && board[row][col + 1] == word[p]) {
      flags[row][col + 1] = true;
      if (findPath(row, col + 1, p + 1, board, flags, word)) {
        return true;
      }
      flags[row][col + 1] = false;
    }
    return false;
  }

  /**
   * Runtime: 4 ms, faster than 90.15% of Java online submissions for Word Search.
   *
   * Memory Usage: 41.6 MB, less than 25.51% of Java online submissions for Word Search.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：line 40, 少了!flags[row - 1][col]，所以可能回头了
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    No_0079_WordSearch no = new No_0079_WordSearch();
    char[][] board = new char[][]{
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}};
    System.out.println(no.exist(board, "ABCCED"));
    System.out.println(no.exist(board, "SEE"));
    System.out.println(no.exist(board, "ABCB"));
  }
}

