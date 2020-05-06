package leetcode.easy;

import java.util.*;

/**
 * TODO Time
 */
public class No_0020_ValidParentheses {

  public static boolean isValid(String s) {
    if (s == null || "".equals(s)) {
      return true;
    }
    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      switch (c) {
        case '(':
        case '[':
        case '{':
          stack.push(c);
          break;
        case ')':
        case ']':
        case '}':
          if (stack.isEmpty())
            return false;
          char pc = stack.pop();
          if (pc == '(' && c != ')' || pc == '[' && c != ']' || pc == '{' && c != '}') {
            return false;
          }
          break;
        default:
          return false;
      }
    }
    return stack.isEmpty();
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
//    String input = "()"; boolean expect = true;
//    String input = "()[]{}"; boolean expect = true;
    String input = "{[]}"; boolean expect = true;
//    String input = "(]"; boolean expect = false;
//    String input = "([)]"; boolean expect = false;
    boolean actual = isValid(input);

    System.out.println(expect == actual);
  }
}

