package leetcode.all;

/**
 * TODO Time
 */
public class No_0188_BestTimetoBuyandSellStockIIII {

  public int maxProfit(int k, int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int n = prices.length;
    if (k >= n / 2) {
      int maxPro = 0;
      for (int i = 1; i < n; i++) {
        if (prices[i] > prices[i - 1]) {
          maxPro += prices[i] - prices[i - 1];
        }
      }
      return maxPro;
    }

    int[] local = new int[k + 1];
    int[] global = new int[k + 1];
    for (int i = 1; i < n; i++) {
      int diff = prices[i] - prices[i - 1];
      for (int j = k; j >= 1; --j) {
        local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
        global[j] = Math.max(global[j], local[j]);
      }
    }
    return global[k];
  }

  /**
   * Runtime: 2 ms, faster than 86.35% of Java online submissions for Best Time to Buy and Sell
   * Stock IV.
   *
   * Memory Usage: 36 MB, less than 100.00% of Java online submissions for Best Time to Buy and Sell
   * Stock IV.
   *
   * 解答：https://www.cnblogs.com/grandyang/p/4295761.html 注意，line 27需要从大向小，如果小的更新过了，就变成了第j步，而不是第j-1步了！
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
    No_0188_BestTimetoBuyandSellStockIIII no = new No_0188_BestTimetoBuyandSellStockIIII();

    System.out.println(no.maxProfit(3, new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
//    System.out.println(no.maxProfit(new int[]{1,2,3,4,5}));
  }
}

