package leetcode.easy;

/**
 * TODO Time
 */
public class No_0009_PalindromeNumber_Test {
  public static int reverse(int x) {
    int ret = 0;
    int posBy10 = Integer.MAX_VALUE / 10;
    int posRest = Integer.MAX_VALUE % 10;
    int negBy10 = Integer.MIN_VALUE / 10;
    int negRest = Integer.MIN_VALUE % 10;
    while (x != 0) {
      int last = x % 10;
      x /= 10;
      if (ret > posBy10 || (ret == posBy10 && last > posRest)) {
        return 0;
      }
      if (ret < negBy10 || (ret == negBy10 && last < negRest)) {
        return 0;
      }
      ret = ret * 10 + last;
    }
    return ret;
  }

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

  public static void main(String[] args) {
    long st = System.currentTimeMillis();
    int count = 0;
    int t2f = 0;
    int t2fNum = 0;
    int f2t = 0;
    int f2tNum = 0;
    for(int i = 1000000000; i < Integer.MAX_VALUE; i++){
      if (i % 5000000 == 0) {
        System.out.println(i);
      }
      if (i%10 >= 2){
        boolean correctResult = isPalindrome(i);
        boolean errorResult = isPalindrome2(i);
        if (correctResult != errorResult){
          if (correctResult == true){
            t2f = i;
            t2fNum++;
          }else{
            f2t = i;
            f2tNum++;
          }
        }
      }
    }
    long end = System.currentTimeMillis();
    System.out.println("time:" + (end-st));
    System.out.println("count: "+ count);
    System.out.println("t2f:" + t2f);
    System.out.println("t2fNum:" + t2fNum);
    System.out.println("f2t:" + f2t);
    System.out.println("f2tNum:" + f2tNum);
    // All ZERO.
  }
}

