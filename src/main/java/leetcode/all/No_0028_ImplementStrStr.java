package leetcode.easy;

/**
 * TODO Time
 */
public class No_0028_ImplementStrStr {

  public static int strStr(String haystack, String needle) {
    if ("".equals(needle)) {
      return 0;
    }
    //create KMP
    // int kmpIdx[] = new int[needle.length()];
    char first = needle.charAt(0);
    for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
      if(haystack.charAt(i) == first){
        int j = 0;
        for (; j < needle.length(); j++) {
          if (haystack.charAt(i+j) != needle.charAt(j))
            break;
        }
        if (j == needle.length()) {
          return i;
        }
      }
    }
    return -1;
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


  public static void main(String[] args) {
    int expect = 2;
    int actual = strStr("hello", "ll");

    System.out.println(expect == actual);
  }
}

