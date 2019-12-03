package leetcode.easy;

/**
 * TODO Time
 */
public class No_0009_PalindromeNumber {

  public static boolean isPalindrome(int x) {
    //1. IMPORTANT: we can't simply reverse x and compare x with rev-x, rev may be overflow!
    //2. if x is negative, return false;
    if (x < 0) {
      return false;
    }
    if (x == 0) {
      return true;
    }
    //3. Any number a multiple of 10 cannot be palindrome
    if (x % 10 == 0) {
      return false;
    }
    //A positive number is up to 10 digits
    int digits[] = new int[10];
    int l = 0;
    while (x > 0) {
      digits[l] = x % 10;
      x /= 10;
      l++;
    }
    for (int i = 0; i < l / 2; i++) {
      if (digits[i] != digits[l - 1 - i]) {
        return false;
      }
    }
    return true;
  }

  //error version
  public static boolean isPalindrome2(int x) {
    if (x < 0) {
      return false;
    }
    if (x == 0) {
      return true;
    }
    int ret = 0;
    int tmp = x;
    while (x != 0) {
      int last = x % 10;
      x /= 10;
      ret = ret * 10 + last;
    }
    return tmp == ret;
  }

  /**
   * Runtime: 7 ms, faster than 66.60% of Java online submissions for Palindrome Number.
   *
   * Memory Usage: 36.9 MB, less than 5.02% of Java online submissions for Palindrome Number.
   * 次调试错误，然后成功。
   *
   * 错误：0
   *
   * 1错：
   *
   * 2错：
   *
   * 一句话反思：写到一半发现了直接算出回文数、再比较的问题，所以改正了，但是想看看 LeetCode有没有测试到那种：本来不是回文数，但是回文之后越界了，恰好一样的数字，结果判断为"是回文数"
   *
   * 但是没有测出来，所以version 2很凑巧的通过了，我们测一下。不计算。用0007的函数算一下，会越界的一共901063401个，正常，末尾只要>1就会越界
   *
   * 在另一个文件 _Test中，发现并没有：正确的回文数：不会越界；错误的数字（回文后越界），越界了就是负数了，所以也不是
   *
   * 新知识：
   */


  public static void main(String[] args) {
    int input = 121;
    System.out.println(isPalindrome(input));
  }
}

