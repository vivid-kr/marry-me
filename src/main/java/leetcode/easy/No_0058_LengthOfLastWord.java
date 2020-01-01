package leetcode.easy;

/**
 * TODO Time
 */
public class No_0058_LengthOfLastWord {

  public int lengthOfLastWord(String s) {
    if (s == null || "".equals(s)) {
      return 0;
    }
    int idx = 0;
    int st;
    int len = 0;
    while (true) {
      for (; idx < s.length() && s.charAt(idx) == ' '; idx++) {
      }
      if (idx == s.length()) {
        break;
      }
      st = idx;
      for (; idx < s.length() && s.charAt(idx) != ' '; idx++) {
      }
      len = idx - st;
    }
    return len;
  }

  /**
   * Runtime: 1 ms, faster than 49.58% of Java online submissions for Length of Last Word.
   *
   * Memory Usage: 35.5 MB, less than 100.00% of Java online submissions for Length of Last Word.
   *
   * 0次调试错误，然后成功。
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
    No_0058_LengthOfLastWord no = new No_0058_LengthOfLastWord();

    System.out.println(no.lengthOfLastWord("Hello World"));
  }
}

