package leetcode.all;

/**
 * TODO Time
 */
public class No_0123_BestTimetoBuyandSellStockIII {

  public int maxProfit(int[] prices) {
    if (prices.length < 2) {
      return 0;
    }
    int[] firstMaxProfit = new int[prices.length + 1];
    int curMin = prices[0];
    for (int i = 1; i < prices.length; i++) {
      firstMaxProfit[i+1] = Math.max(prices[i] - curMin, firstMaxProfit[i]);
      if (prices[i] < curMin) {
        curMin = prices[i];
      }
    }
    int[] secondMaxProfit = new int[prices.length + 1];
    int curMax = prices[prices.length - 1];
    for (int i = prices.length-2; i >= 0; i--) {
      secondMaxProfit[i] = Math.max(curMax - prices[i], secondMaxProfit[i+1]);
      if (prices[i] > curMax) {
        curMax = prices[i];
      }
    }
    int max = 0;
    for (int i = 0; i < prices.length; i++) {
      int sum = firstMaxProfit[i] + secondMaxProfit[i];
      if(sum > max)
        max = sum;
    }
    return max;
  }

  /**
   * Runtime: 1 ms, faster than 99.75% of Java online submissions for Best Time to Buy and Sell Stock III.
   *
   * Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Best Time to Buy and Sell Stock III.
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
    No_0123_BestTimetoBuyandSellStockIII no = new No_0123_BestTimetoBuyandSellStockIII();

    System.out.println(no.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    System.out.println(no.maxProfit(new int[]{1,2,3,4,5}));
  }
}

