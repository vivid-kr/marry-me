package leetcode.all;

/**
 * TODO Time
 */
public class No_0765_CouplesHoldingHands {

  public static int minSwapsCouples(int[] row) {
    if (row == null || row.length == 2) return 0;
    int swapNum = 0;
    for (int i = 0; i < row.length; i+=2){
      int base = row[i]/2;
      if (base != row[i+1]/2){
        for (int j = i+2; j < row.length; j+=1){
          if(row[j]/2 == base){
            int temp = row[j];
            row[j] = row[i+1];
            row[i+1] = temp;
            swapNum++;
            break;
          }
        }
      }
    }
    return swapNum;
  }
  /**
   * Runtime:
   *
   * Memory Usage:
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
    System.out.println(minSwapsCouples(new int[]{3, 0, 2, 1}));
//    System.out.println(expect.equals(actual));
  }
}

