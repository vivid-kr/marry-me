package leetcode.all;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Time
 */
public class No_0115_DistinctSubsequences {


  public static List<int[]> subNumDistinct(Map<Character, List<Integer>> tCsMap, char curC,
      List<int[]> lastIdxNums) {
    if (lastIdxNums.isEmpty()) {
      return lastIdxNums;
    }
    // char curC = t.charAt(i);
    List<Integer> curIdxs = tCsMap.get(curC);
    List<int[]> idxNums = new ArrayList<int[]>();

    int j = 0;
    for (int i = 0; i < curIdxs.size(); i++) {
      // int sum = 0;
      int curIdx = curIdxs.get(i);
      while (j < lastIdxNums.size() && (lastIdxNums.get(j))[0] < curIdx) {
        j++;
      }
      if(j > 0){
        int ac = (lastIdxNums.get(j - 1))[1];
        if (idxNums.size() > 0) {
//          if (idxNums.isEmpty()) {
//            System.out.println("asd");
//          }
          ac += idxNums.get(idxNums.size() - 1)[1];
        }
        idxNums.add(new int[]{curIdx, ac});
      }
    }
    return idxNums;
  }

  public static int numDistinct(String s, String t) {
    if (s == null || t == null || "".equals(s) || "".equals(t)) {
      return 0;
    }
    // inverted list
    Map<Character, List<Integer>> tCsMap = new HashMap<Character, List<Integer>>();
    for (int i = 0; i < t.length(); i++) {
      char tc = t.charAt(i);
      if (tCsMap.containsKey(tc)) {
        continue;
      }
      List<Integer> tcIdxs = new ArrayList<Integer>();
      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(j) == tc) {
          tcIdxs.add(j);
        }
      }
      if (!tcIdxs.isEmpty()) {
        tCsMap.put(tc, tcIdxs);
      } else
      //一个都没找到！
      {
        return 0;
      }
    }

    List<int[]> idxNums = new ArrayList<int[]>();
    idxNums.add(new int[] {-1, 1});
    for (int i = 0; i < t.length(); i++) {
      idxNums = subNumDistinct(tCsMap, t.charAt(i), idxNums);
    }
    if (idxNums.isEmpty())
      return 0;
    else
      return idxNums.get(idxNums.size()-1)[1];
  }


  /**
   * Runtime:2 ms, faster than 90.49%
   *
   * Memory Usage:34.7 MB, less than 100.00%
   *
   * 次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：基本错误：忘记写变量声明：两个地方；foreach的写法写错了；
   *
   * 2错：最后，idxNums本来就是累积结果，返回最后一个就行，结果又累加了一遍
   *
   * 3错：关键。对于当前的curIdxs，首先肯定不为空，否则在倒排的时候就返回0了。其次，对于每个curIdx，对应的是
   * curChar的一个位置。但是，不是每种curChar都能找到符合的结果的！所以line 32: if (idxNums.size() > 0)
   * 错写成了if (i > 0)。有可能i=0时没有任何匹配，到i=1的时候，idxNums还是空的，但却以为有了，要累加。导致越界
   *
   *
   * 一句话反思：line 27地方，while的写法很关键，自己也迷惑了一下。其他地方都不难
   *
   * 新知识：
   */
  public static void main(String[] args) {
//    String S = "rabbbit", T = "rabbit";int expect = 3;
    String S = "babgbag", T = "bag";int expect = 5;

    int actual = numDistinct(S, T);
    System.out.println(actual);
    System.out.println(expect == actual);
  }
}

