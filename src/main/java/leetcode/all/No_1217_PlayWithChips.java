package leetcode.all;

/**
 * TODO Time
 */
public class No_1217_PlayWithChips {

  public int minCostToMoveChips(int[] chips) {
    int oddNum = 0;
    for (int chip : chips) {
      if (chip % 2 == 1) {
        oddNum++;
      }
    }
    return (oddNum << 1) > chips.length ? chips.length-oddNum : oddNum;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Play with Chips.
   *
   * Memory Usage: 34.8 MB, less than 100.00% of Java online submissions for Play with Chips.
   *
   * 0次调试错误，然后成功。
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
    No_1217_PlayWithChips no = new No_1217_PlayWithChips();

    System.out.println(no.minCostToMoveChips(new int[]{1,2,3}));
    System.out.println(no.minCostToMoveChips(new int[]{2,2,2,3,3}));
  }
}

