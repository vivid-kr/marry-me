package leetcode.hard;

/**
 * TODO Time
 */
public class No_0032_LongestValidParentheses {

  public int longestValidParentheses(String s) {
    if (s == null || s.length() <= 1) {
      return 0;
    }
    int max = 0;
    int[] lastPLens = new int[s.length()];
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        if (s.charAt(i - 1) == '(') {
          lastPLens[i] = (i >= 2 ? lastPLens[i - 2] : 0) + 2;
        } else if
        (i - lastPLens[i - 1] > 0 && '(' == s.charAt(i - lastPLens[i - 1] - 1))
        {
          lastPLens[i] = lastPLens[i - 1] + ((i - lastPLens[i - 1]) >= 2 ? lastPLens[i - lastPLens[i - 1] - 2] : 0) + 2;
        }
        max = Math.max(lastPLens[i], max);
      }
    }
    return max;
  }

  /**
   * Runtime: 1 ms, faster than 100.00% of Java online submissions for Longest Valid Parentheses.
   *
   * Memory Usage: 37.3 MB, less than 96.08% of Java online submissions for Longest Valid Parentheses.
   *
   *
   * 3次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：line 17, () 错误
   *
   * 2错：line 21，注意，如果 (()，这时候len=2，但再来一个)，len不是4，还要考虑能不能和更前面的接上
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    No_0032_LongestValidParentheses no = new No_0032_LongestValidParentheses();

    Object actual = no.longestValidParentheses("()(())");
    System.out.println(actual);
  }
}

