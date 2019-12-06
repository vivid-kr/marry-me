package leetcode.medium;

import java.util.*;

/**
 * TODO Time
 */
public class No_0022_GenerateParentheses {

  public static void subFunc(List<String> ret, StringBuilder sb, int l, int r) {
    if (l == 0 && r == 0) {
      ret.add(sb.toString());
      return;
    }
    if (l < r) {
      //l比r剩下的少，左括号用多了，所以可以加右括号，否则不能平白无故加右括号
      sb.append(')');
      subFunc(ret, sb, l, r-1);
      sb.deleteCharAt(sb.length()-1);
    }
    if (l > 0){
      sb.append('(');
      subFunc(ret, sb, l-1, r);
      sb.deleteCharAt(sb.length()-1);
    }
  }

  public static List<String> generateParenthesis(int n) {
    List<String> ret = new ArrayList<String>();
    if (n <= 0)
      return ret;
    StringBuilder sb = new StringBuilder(2*n);
    subFunc(ret, sb, n, n);
    return ret;
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
    int input = 4;
    List<String> actual = generateParenthesis(input);

    System.out.println("input:" + input);
    for (String str : actual) {
      System.out.println(str);
    }
  }
}

