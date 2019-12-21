package leetcode.medium;

/**
 * TODO Time
 */
public class No_0036_ValidSudoku {


  public static boolean isValidSudoku(char[][] board) {
    // board = new int[9]
    // for (int i = 1; i < 9; i++) {
    // 	board[i] = 1<<i;
    // }
    //check row
    for (int i = 0; i < 9; i++) {
      int bool = 0;
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          int f = 1 << (board[i][j] - '0');
          if ((f & bool) == 0) {
            bool = bool | f;
          } else {
            return false;
          }
        }
      }
    }
    //check column
    for (int j = 0; j < 9; j++) {
      int bool = 0;
      for (int i = 0; i < 9; i++) {
        if (board[i][j] != '.') {
          int f = 1 << (board[i][j] - '0');
          if ((f & bool) == 0) {
            bool = bool | f;
          } else {
            return false;
          }
        }
      }
    }
    //check sub-boxes
    for (int a = 0; a < 9; a++) {
      int lb = a / 3;
      int ub = a % 3;
      int bool = 0;
      for (int b = 0; b < 9; b++) {
        int l = b / 3;
        int u = b % 3;
        int i = 3 * lb + l;
        int j = 3 * ub + u;
        if (board[i][j] != '.') {
          int f = 1 << (board[i][j] - '0');
          if ((f & bool) == 0) {
            bool = bool | f;
          } else {
            return false;
          }
        }
      }
    }
    return true;
  }

  /**
   * Runtime: 1 ms, faster than 99.99% of Java online submissions for Valid Sudoku.
   *
   * Memory Usage: 43.7 MB, less than 82.61% of Java online submissions for Valid Sudoku.
   *
   *
   * 0次调试错误，然后成功。
   *
   * 错误：没什么错误
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
    char input[][] = {
        {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    boolean expect = true;
    boolean actual = isValidSudoku(input);

    System.out.println(actual);
    System.out.println(expect == actual);
  }
}

