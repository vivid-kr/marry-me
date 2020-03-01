package leetcode.all;

/**
 * TODO Time
 */
public class No_0121_BestTimetoBuyandSellStock {

  public int maxProfit(int[] prices) {
    if (prices.length < 2) {
      return 0;
    }
    int maxProfit = 0;
    int curMin = prices[0];
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < curMin) {
        curMin = prices[i];
      } else {
        int profit = prices[i] - curMin;
        if (profit > maxProfit) {
          maxProfit = profit;
        }
      }
    }
    return maxProfit;
  }

  /**
   * Runtime: 1 ms, faster than 77.07% of Java online submissions for Best Time to Buy and Sell
   * Stock.
   *
   * Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Best Time to Buy and
   * Sell Stock.
   *
   * 0次调试错误，然后成功。错了一次是笔误，只有一个price也应该是0；是不错的题，但是不绕进去的话，medium也还可以，不知道接收率为什么这么低
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
    No_0121_BestTimetoBuyandSellStock no = new No_0121_BestTimetoBuyandSellStock();

    System.out.println(no.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    System.out.println(no.maxProfit(new int[]{1, 2, 3, 4, 5}));
    System.out.println(no.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    System.out.println(no.maxProfit(new int[]{7, 6, 4, 3, 1}));
  }
}

