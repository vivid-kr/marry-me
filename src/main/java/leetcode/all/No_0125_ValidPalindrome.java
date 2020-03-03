package leetcode.all;

/**
 * TODO Time
 */
public class No_0125_ValidPalindrome {

  private boolean isAlphaNumeric(char c) {
    return '0' <= c && c <= '9' || 'a' <= c && c <= 'z';
  }

  public boolean isPalindrome(String s) {
    String ss = s.toLowerCase();
    int N = s.length();
    int i = 0;
    int j = N - 1;
    while (i < j) {
      while (i < j && !isAlphaNumeric(ss.charAt(i))) {
        i++;
      }
      while (i < j && !isAlphaNumeric(ss.charAt(j))) {
        j--;
      }
      if (i < j && ss.charAt(i) != ss.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  /**
   * Runtime: 4 ms, faster than 83.46% of Java online submissions for Valid Palindrome.
   *
   * Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Valid Palindrome.
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
    No_0125_ValidPalindrome no = new No_0125_ValidPalindrome();

    System.out.println(no.isPalindrome("aab"));
    System.out.println(no.isPalindrome("aabaa"));
    System.out.println(no.isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println(no.isPalindrome("race a car"));
  }
}

