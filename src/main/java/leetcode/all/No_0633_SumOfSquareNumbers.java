package leetcode.all;

/**
 * TODO Time
 */
public class No_0633_SumOfSquareNumbers {


  public boolean judgeSquareSum0(int c) {
    if (c == 0) {
      return true;
    }
    int up = (int) Math.sqrt(c / 2.0f);
    for (int i = 0; i <= up; i++) {
      int otherRoot = (int) Math.sqrt(c - i * i);
      if (otherRoot * otherRoot == c - i * i) {
        return true;
      }
    }
    return false;
  }

  /**
   * Runtime: Memory Usage:
   *
   *
   *
   * 错误：
   *
   * 1错：0错误，审错题了
   *
   * 2错：5，发现了line 25这一行应该怎么写
   *
   * 3错：注意，任何情况下，整数乘法都要考虑越界
   *
   * 一句话反思：
   *
   * 新知识：
   */

  /**
   * 解法2，2毫秒，乘法比开方明显快
   */
  public boolean judgeSquareSum2(int c) {
    int l = 0, r = (int) Math.sqrt(c);

    while (l <= r) {
      int sum = l * l + r * r;
      if (sum == c) {
        return true;
      } else if (sum > c) {
        r--;
      } else {
        l++;
      }
    }
    return false;
  }

  /**
   * 解法3，最快的解法。
   * <p>
   * 下面这种解法基于费马平方和定理的一般推广形式：当某个数字的 4k+3 型的质数因子的个数均为偶数时，其可以拆分为两个平方数之和。那么我们只要统计其质数因子的个数，并且判读，若其为 4k+3
   * 型且出现次数为奇数的话直接返回 false。这里，我们从2开始遍历，若能整除2，则计数器加1，并且c也要除以2。这样我们找到都会是质数因子，因为非质数因子中的因子已经在之前被除掉了，这也是个
   * trick，需要自己好好想一下。最终在循环退出后，我们还要再判断一下，若剩余的质数因子还是个 4k+3 型，那么返回 false，否则返回 true
   * </p>
   */
  public boolean judgeSquareSum(int c) {
    for (int i = 2; i * i <= c; i++) {
      int count = 0;
      if (c % i == 0) {
        while (c % i == 0) {
          count++;
          c /= i;
        }
        if (i % 4 == 3 && count % 2 != 0) {
          return false;
        }
      }
    }
    return c % 4 != 3;
  }

  public static void main(String[] args) {
    No_0633_SumOfSquareNumbers no = new No_0633_SumOfSquareNumbers();
    System.out.println(no.judgeSquareSum(13));
    System.out.println(no.judgeSquareSum(2));
    System.out.println(no.judgeSquareSum(999999999));
    System.out.println(no.judgeSquareSum(5));
    System.out.println(no.judgeSquareSum(0));
    System.out.println(no.judgeSquareSum(8));


  }
}

