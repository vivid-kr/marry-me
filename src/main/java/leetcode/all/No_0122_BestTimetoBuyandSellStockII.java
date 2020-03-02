package leetcode.all;

/**
 * TODO Time
 */
public class No_0122_BestTimetoBuyandSellStockII {

  public int maxProfit(int[] prices) {
    if (prices.length < 2) {
      return 0;
    }
    int totalSum = 0;
    int maxProfit = 0;
    int curMin = prices[0];
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < prices[i-1]) {
        curMin = prices[i];
        if(maxProfit > 0) {
          totalSum += maxProfit;
          maxProfit = 0;
        }
      }else{
        maxProfit = prices[i] - curMin;
      }
    }
    if (maxProfit > 0) {
      totalSum += maxProfit;
    }
    return totalSum;
  }

  /**
   * Runtime: 1 ms, faster than 91.35% of Java online submissions for Best Time to Buy and Sell Stock II.
   *
   * Memory Usage: 37 MB, less than 100.00% of Java online submissions for Best Time to Buy and Sell Stock II.
   *
   * 一个原则：在下降前卖出，然后寻找新的最低点买入。
   * 假设a,b,c,d, 其中d>b>c>a，一个折线。那么分两段买d-c+b-a = d-a+(b-c) > d-a，肯定更赚钱
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
    No_0122_BestTimetoBuyandSellStockII no = new No_0122_BestTimetoBuyandSellStockII();

    System.out.println(no.maxProfit(new int[]{7,1,5,3,6,4}));
    System.out.println(no.maxProfit(new int[]{1,2,3,4,5}));

  }
}

