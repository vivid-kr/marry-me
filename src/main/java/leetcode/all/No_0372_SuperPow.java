package leetcode.all;

/**
 * TODO Time
 */
public class No_0372_SuperPow {

  //ab % k = (a%k)(b%k)%k,
  //a^n % k = ((a % k)^n) % k, proof: induction, a^10 % k = (a^9 % k) * (a % k) % k = (((a % k)^9) % k) * (a % k) % k  = ((a % k)^10) % k

  //(a^12345) % k = ((a^12340) * (a^5)) % k = (((a^1234)^10) * (a^5)) % k = ((((a^1234 % k)^10) % k) * ((a^5) % k)) % k
  //super(a, 12345) = powerMode((super(a,1234),10) * powerMode(a, 5) % k
  public int superPow(int a, int[] b) {
    if (b == null || b.length == 0) {
      return 1;
    }
    if (a == 0) {
      return 0;
    }

    return helper(a, b, b.length - 1, 1337);
  }

  public int helper(int a, int[] b, int index, int k) {
    if (index == 0) {
      return powerMode(a, b[index], k);
    }
    return (powerMode(helper(a, b, index - 1, k), 10, k) * powerMode(a, b[index], k)) % k;
  }

  //a^b % 1337,
  //use: ab % k = ((a%k)*(b%k))%k,
  public int powerMode(int a, int b, int k) {
    if (b == 0 || b == 1) {
      return b == 0 ? 1 : a % k;
    }

    return (powerMode(a, b - 1, k) * (a % k)) % k;
  }

  /**
   * 不再做，借鉴https://leetcode.com/problems/super-pow/discuss/84502/Pure-recursion-in-Java
   *
   * 错误：笔误，加上忽视了-1为base。
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
    No_0372_SuperPow no = new No_0372_SuperPow();
    System.out.println(no.superPow(2, new int[]{3}));
  }
}

