package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class No_0003_LongestSubstring {

  public static int lengthOfLongestSubstring(String s) {
    //WARN 要考虑字符串是""的情况！
    if (s.length() == 0) {
      return 0;
    }
    Map<Character, Integer> strMap = new HashMap<Character, Integer>();
    int maxLen = 1;
    int curIdx = 0;
    int currentLen = 1;
    strMap.put(s.charAt(0), 0);

    for (int i = 1; i < s.length(); i++) {
      char c = s.charAt(i);
      // INFO map的函数：containsKey，remove，put，get
      if (strMap.containsKey(c)) {
        int dupIdx = strMap.get(c);
        for (int j = curIdx; j <= dupIdx; j++) {
          strMap.remove(s.charAt(j));
        }
        currentLen = i - dupIdx;
        // 错误写成了 curIdx = i，后来又错写成了curIdx = dupIdx.显然，新的idx应该是从重复的idx+1开始。
        curIdx = dupIdx + 1;
        //WARN 原来忘记在这里写"strMap.put(c, i)"，新的char虽然重复了，但也应该在移除了老的之后将新的插入。
      } else {
        currentLen += 1;
        if (currentLen > maxLen) {
          maxLen = currentLen;
        }
      }
      strMap.put(c, i);
    }
    return maxLen;
  }

  /**
   * Runtime: 8 ms, faster than 65.35%
   *
   * Memory Usage: 36.2 MB, less than 99.76%
   *
   *
   * 一次编译错误，三次调试错误，然后成功。内存还是特别省的，很不错。
   *
   * 1错：忘记考虑""的情况，后来加上判断；
   *
   * 2错：现在37行，curIdx = i，直接从重复字母出现的位置开始重新记长度，错误；
   *
   * 2错：现在37行，curIdx = dupIdx，其实应该是从上一个重复字母之后算，正确的是dupIdx + 1
   */
  public static void main(String[] args) {
    /*
    INFO 首先是java的String基本函数，虽然indexOf之类的不太好用，不过length()和charAt()还是要了解的;
    其次是charAt返回的是char，对应的封箱是Character
    String s = "asdasd";
    System.out.println(s.charAt(0));
    System.out.println(s.charAt(s.length()-1));
     */
    String s = "aabaab!bb";
    System.out.println(lengthOfLongestSubstring(s));


  }
}

