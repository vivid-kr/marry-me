package leetcode.all;

/**
 * TODO Time
 */
public class No_0680_ValidPalindromeII {

  public boolean validPalindrome(String s) {
    int N = s.length();
    int i = 0;
    int j = N - 1;
    while (i < j && s.charAt(i) == s.charAt(j)) {
      i++;
      j--;
    }
    if (i >= j) {
      return true;
    }
    int curI = i, curJ = j;
    i++;
    while (i < j && s.charAt(i) == s.charAt(j)) {
      i++;
      j--;
    }
    if (i >= j) {
      return true;
    }
    i = curI;
    j = curJ - 1;
    while (i < j && s.charAt(i) == s.charAt(j)) {
      i++;
      j--;
    }
    return i >= j;
  }

  /**
   * Runtime: 9 ms, faster than 43.65% of Java online submissions for Valid Palindrome II.
   *
   * Memory Usage: 38.5 MB, less than 100.00% of Java online submissions for Valid Palindrome II.
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
    No_0680_ValidPalindromeII no = new No_0680_ValidPalindromeII();

    System.out.println(no.validPalindrome("aab"));
    System.out.println(no.validPalindrome("ada"));
    System.out.println(no.validPalindrome("abca"));
  }
}

