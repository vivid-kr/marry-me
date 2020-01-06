package leetcode.medium;

/**
 * TODO Time
 */
public class No_0071_SimplifyPath {

  public String simplifyPath(String path) {
    char[] chars = path.toCharArray();
    if (chars[0] != '/') {
      return null;
    }
    int[] stack = new int[chars.length];
    int p = 0;
    int idx = 0;
    int i = 1;
    int cLen = chars.length;
    while (i < cLen) {
      if (chars[idx] != '/') {
        chars[++idx] = chars[i];
        if (chars[i] == '/') {
          stack[++p] = idx;
        }
      } else {
        if (chars[i] == '/') {

        } else if (chars[i] == '.' && (i == cLen - 1 || chars[i + 1] == '/')) {
        } else if (chars[i] == '.' && i < cLen - 1 && chars[i + 1] == '.' && (i == cLen - 2
            || chars[i + 2] == '/')) {
          i++;
          if (p > 0) {
            idx = stack[--p];
          }
        } else {
          chars[++idx] = chars[i];
        }
      }
      i++;
    }
    if (idx > 0 && chars[idx] == '/') {
      idx--;
    }
    char[] resChars = new char[idx + 1];
    System.arraycopy(chars, 0, resChars, 0, idx + 1);
    return new String(resChars);
  }

  /**
   * Runtime: 1 ms, faster than 100.00% of Java online submissions for Simplify Path.
   *
   * Memory Usage: 38.1 MB, less than 80.00% of Java online submissions for Simplify Path.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：line 22，居然在写成了 stack[++p] = i; 的情况下连过了五个测试
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */

  public static void main(String[] args) {
    No_0071_SimplifyPath no = new No_0071_SimplifyPath();

    System.out.println(no.simplifyPath("/home/"));
    System.out.println(no.simplifyPath("/../"));
    System.out.println(no.simplifyPath("/home//foo/"));
    System.out.println(no.simplifyPath("/a/./b/../../c/"));
    System.out.println(no.simplifyPath("/a/../../b/../c//.//"));
    System.out.println(no.simplifyPath("/a//b////c/d//././/.."));
  }
}

