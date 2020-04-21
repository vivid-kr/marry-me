package leetcode.medium;


public class No_0005_LongestPalindromicSubstring {

  public static String longestPalindrome(String s) {
    if (s.length() == 0) {
      return s;
    }
    if (s.length() == 1) {
      return s;
    }
    if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
      return s;
    }

    //WARN 编译错误，是int[]!
    int[] strStates = new int[s.length()];
    // 奇数回文
    for (int i = 0; i < s.length(); i++) {
      strStates[i] = 0;
    }

    int maxLen = 1;
    String ret = s.substring(0, 1);

    for (int i = 2; i < s.length(); i++) {
      //对称轴思想
      for (int mid = (i + 1) / 2; mid < i; mid++) {
        if (strStates[mid] == -1) {
          continue;
        }
        int symIdx = mid - (i - mid);
        if (s.charAt(i) == s.charAt(symIdx)) {
          strStates[mid] += 1;
          if (strStates[mid] * 2 + 1 > maxLen) {
            maxLen = strStates[mid] * 2 + 1;
            ret = s.substring(mid - strStates[mid], mid + strStates[mid] + 1);
          }
        } else {
          strStates[mid] = -1;
        }
      }
    }

    // 偶数回文
    for (int i = 0; i < s.length(); i++) {
      strStates[i] = 0;
    }
    for (int i = 1; i < s.length(); i++) {
      //对称轴思想
      for (int mid = i / 2; mid < i; mid++) {
        if (strStates[mid] == -1) {
          continue;
        }
        int symIdx = mid - (i - (mid + 1));
        if (s.charAt(i) == s.charAt(symIdx)) {
          strStates[mid] += 1;
          if (strStates[mid] * 2 > maxLen) {
            maxLen = strStates[mid] * 2;
            ret = s.substring(mid + 1 - strStates[mid], mid + strStates[mid] + 1);
          }
        } else {
          strStates[mid] = -1;
        }
      }
    }

    return ret;
  }


  /**
   * Runtime: 27 ms, faster than 49.75%
   *
   * Memory Usage: 36.7 MB, less than 100.00%
   *
   * 一次编译错误，2次调试错误，然后成功。
   *
   * 内存还是特别省的，但是慢，不能令人满意
   *
   * 1错：为了节省时间，所以日后一旦有不对称，则立即更新对称轴为-1，以后永不需要再检验。但是注意，maxLen需要实时更新，不能最后更新！
   *
   * 2错：对于ccc输入，越界。是第一个错误的后续，要把所有变量i改成mid，但是没有改完，留下了残存的i
   */
  public static void main(String[] args) {
//    System.out.println(longestPalindrome(""));
//    System.out.println(longestPalindrome("abaa"));
//    System.out.println(longestPalindrome("cbbd"));
    System.out.println(longestPalindrome("ccc"));
  }
}

