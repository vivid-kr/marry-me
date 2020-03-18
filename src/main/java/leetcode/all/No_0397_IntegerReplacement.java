package leetcode.all;

/**
 * TODO Time
 */
public class No_0397_IntegerReplacement {

  public int integerReplacement(int n) {
    int count = 0;
    if(n==Integer.MAX_VALUE){
      count++;
      n = 1073741824;
    }
    while (n > 1) {
      if(n == 3)
        return count+2;
      if (n % 4 == 0 || n % 4 == 2) {
        n /= 2;
      } else if (n % 4 == 1) {
        n--;
      } else {
        n++;
      }
      count++;
    }
    return count;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Integer Replacement.
   *
   * Memory Usage: 32.8 MB, less than 10.00% of Java online submissions for Integer Replacement.
   *
   * 次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：忽略了3这个重要因素。
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    No_0397_IntegerReplacement no = new No_0397_IntegerReplacement();

    System.out.println(no.integerReplacement(2147483647));
    System.out.println(no.integerReplacement(6));
    System.out.println(no.integerReplacement(7));
    System.out.println(no.integerReplacement(8));
  }
}

