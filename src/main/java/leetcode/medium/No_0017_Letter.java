package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Time
 */
public class No_0017_Letter {

  public void scan(List<String> ret, Map<Character, char[]> map, String digits, int idx, StringBuilder sb){
    if (idx == digits.length()) {
      ret.add(sb.toString());
      return;
    }
    char[] chars = map.get(digits.charAt(idx));
    for (int i = 0; i < chars.length; i++) {
      sb.append(chars[i]);
      scan(ret, map, digits, idx+1, sb);
      sb.deleteCharAt(idx);
    }

  }
  public List<String> letterCombinations(String digits) {
    Map<Character, char[]> map = new HashMap<Character, char[]>();
    map.put('2', new char[]{'a','b','c'});
    map.put('3', new char[]{'d','e','f'});
    map.put('4', new char[]{'g','h','i'});
    map.put('5', new char[]{'j','k','l'});
    map.put('6', new char[]{'m','n','o'});
    map.put('7', new char[]{'p','q','r','s'});
    map.put('8', new char[]{'t','u','v'});
    map.put('9', new char[]{'w','x','y','z'});

    for (int i = 0; i < digits.length(); i++) {
      if (!map.containsKey(digits.charAt(i))) {
        return null;
      }
    }
    List<String> ret = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();
    scan(ret, map, digits, 0, sb);
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
//    String input = "";
//    String expect = "PAHNAPLSIIGYIR";
//    String actual = func(input);
//
//    System.out.println(actual);
//    System.out.println(expect.equals(actual));
  }
}

