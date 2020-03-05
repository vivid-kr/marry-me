package leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Time
 */
public class No_0212_WordSearchII {

  public List<String> findWords(char[][] board, String[] words) {
    List<String> res = new ArrayList<>();
    if (board.length == 0 || board[0].length == 0 || words.length == 0) {
      return res;
    }
    for (String word : words) {
      if (exist(board, word)) {
        res.add(word);
      }
    }
    return res;
  }

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
   * Runtime: 309 ms, faster than 20.59% of Java online submissions for Word Search II.
   *
   * Memory Usage: 44.2 MB, less than 77.78% of Java online submissions for Word Search II.
   *
   * 0次调试错误，然后成功。直接借用wordSearch题目的解法
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
    No_0212_WordSearchII no = new No_0212_WordSearchII();
    char[][] board = new char[][]{
        {'o', 'a', 'a', 'n'},
        {'e', 't', 'a', 'e'},
        {'i', 'h', 'k', 'r'},
        {'i', 'f', 'l', 'v'}
    };
    String[] words = {"oath", "pea", "eat", "rain"};

    System.out.println(no.findWords(board,words));
  }
}

