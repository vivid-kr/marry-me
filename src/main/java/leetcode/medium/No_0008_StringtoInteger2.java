package leetcode.medium;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自己采用更简单的做法试试看，只记录符合范围的部分，然后用substring来做
 */
public class No_0008_StringtoInteger2 {

  public static int myAtoi(String str) {
    int startIdx = -1;
    int endIdx = -1;
    int flag = 0; // 0: reading flag; 1: reading sign; 2: reading num
    int sign = -1;
    boolean noMore = false;
    for (int i = 0; i < str.length(); i++) {
      switch (flag) {
        case 0:
          if (str.charAt(i) == '+') {
            sign = 1;
            flag = 1;
            startIdx = i;
          } else if (str.charAt(i) == '-') {
            sign = 0;
            flag = 1;
            startIdx = i;
          } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            sign = 1;
            flag = 2;
            //漏了这个
            startIdx = i;
            endIdx = i;
          } else if (str.charAt(i) != ' ') {
            //Illegal
            return 0;
          }
          break;
        case 1:
          if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            flag = 2;
            endIdx = i;
          } else {
            //Illegal, 正负号之后没有数字，接了其他的，全都当做异常
            return 0;
          }
          break;
        case 2:
          if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            endIdx = i;
          } else {
            noMore = true;
          }
          break;
      }
      if (noMore) {
        break;
      }
    }
    if (flag != 2) {
      return 0;
    }
    //处理完了，先按照最简单的试一下
    int ret;
    try {
      ret = Integer.valueOf(str.substring(startIdx, endIdx + 1));
    } catch (NumberFormatException e) {
      ret = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    }
    return ret;
  }

  /**
   * Runtime: 3 ms, faster than 25.51%
   *
   * Memory Usage: 36 MB, less than 100.00%
   *
   * 1次调试错误，然后成功。慢
   *
   * 错误：
   *
   * 1. 35行，忘记改 startIdx 了，导致最后startIdx是-1
   *
   * 新知识：
   *
   * subString(beginIndex, endIndex), 其中endIndex是exclusive的，不包含自身的，这个词不错
   *
   */
  public static void main(String[] args) {
    int actual = myAtoi("-91283472332");
    int expect = 1 << 31;
    System.out.println(actual == expect);


  }
}

