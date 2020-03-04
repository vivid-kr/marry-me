package leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Time
 */
public class No_0131_PalindromePartitioning {

  private List<List<String>> res = new ArrayList<>();
  private List<String> curPartition = new ArrayList<>();
  private String s;

  private boolean isPalindrome(int st, int end) {
    for (int i = 0; i < (end - st + 1) / 2; i++) {
      if (s.charAt(st + i) != s.charAt(end - i)) {
        return false;
      }
    }
    return true;
  }

  private void helper(int st) {
    if (st == s.length()) {
      res.add(new ArrayList<>(curPartition));
    }
    for (int i = st; i < s.length(); i++) {
      if (isPalindrome(st, i)) {
        curPartition.add(s.substring(st, i+1));
        helper(i + 1);
        curPartition.remove(curPartition.size() - 1);
      }
    }
  }

  public List<List<String>> partition(String s) {
    if (s == null || "".equals(s)) {
      return res;
    }
    this.s = s;
    helper(0);
    return res;
  }

  /**
   * Runtime: 2 ms, faster than 95.53% of Java online submissions for Palindrome Partitioning.
   *
   * Memory Usage: 38.2 MB, less than 100.00% of Java online submissions for Palindrome Partitioning.
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
    No_0131_PalindromePartitioning no = new No_0131_PalindromePartitioning();

    System.out.println(no.partition("aab"));
  }
}

