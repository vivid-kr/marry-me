package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Time
 */
public class No_0093_RestoreIPAddresses {

  public List<String> restoreIpAddresses(String s) {
    List<String> ret = new ArrayList<>();
    dfs(s, 0, 0, "", ret);
    return ret;
  }

  private void dfs(String s, int idx, int c, String path, List<String> ret) {
    if (c >= 4) {
      if (idx == s.length()) {
        ret.add(path.substring(0, path.length() - 1));
      }
      return;
    }
    for (int i = idx + 1; i <= s.length(); i++) {
      if (isValid(s.substring(idx, i))) {
        dfs(s, i, c + 1, path + s.substring(idx, i) + '.', ret);
      }
    }
  }

  private boolean isValid(String s) {
    if (s.startsWith("0") && !s.equals("0")) {
      return false;
    }
    return s.length() < 4 && 0 <= Integer.valueOf(s) && Integer.valueOf(s) < 256;
  }

  /**
   * Runtime: Memory Usage:
   *
   * 不再赘述
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
    No_0093_RestoreIPAddresses no = new No_0093_RestoreIPAddresses();

    System.out.println(no);
  }
}

