package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Time
 */
public class No_0068_TextJustification {

  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> res = new ArrayList<>();
    int i = 0;
    while (i < words.length) {
      List<String> curLine = new ArrayList<>();
      int num = 0, curLen = 0;
      // start building current string line
      while (i < words.length && (curLen + words[i].length() + num <= maxWidth)) {
        curLen += words[i].length();
        curLine.add(words[i]);
        num++;
        i++;
      }
      // left justify
      if (num == 1 || i == words.length) {
        res.add(leftJustifyBuild(curLine, maxWidth));
      }
      // regular build with more space on the left side
      else {
        res.add(regularBuild(maxWidth - curLen, num, curLine));
      }
    }
    return res;
  }
  public String leftJustifyBuild(List<String> curLine, int maxWidth) {
    StringBuilder sb = new StringBuilder();
    int rest = maxWidth;
    for (int j = 0; j < curLine.size(); j++) {
      String str = curLine.get(j);
      rest -= str.length();
      sb.append(str);
      if (rest != 0) {
        sb.append(" ");
        rest--;
      }
    }
    // append rest of spaces
    while (rest != 0) {
      sb.append(" ");
      rest--;
    }
    return new String(sb);
  }
  public String regularBuild(int space, int num, List<String> curLine) {
    StringBuilder sb = new StringBuilder();
    int extra = space % (num - 1);
    int each = space / (num - 1);
    for (int j = 0; j < curLine.size(); j++) {
      String str = curLine.get(j);
      sb.append(str);
      if (j == curLine.size() - 1) continue;
      for (int k = 1; k <= each; k++) {
        sb.append(" ");
      }
      if (extra > 0) {
        sb.append(" ");
        extra--;
      }
    }
    return new String(sb);
  }

  /**
   * 差评很多，不再多写
   *
   * Runtime: 1 ms, faster than 44.49% of Java online submissions for Text Justification.
   *
   * Memory Usage: 35 MB, less than 97.22% of Java online submissions for Text Justification.
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
    No_0068_TextJustification no = new No_0068_TextJustification();

    System.out.println(no.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."},16));
  }
}

