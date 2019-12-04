package leetcode.medium;

/**
 * 2019-08-12 18:47:38
 */
public class No_0012_IntegertoRoman {

  public static String printRomanDigit(String ret, int num, String one, String five, String ten) {
    if (num == 0) {
      return ret;
    } else if (num < 4) {
      for (int i = 0; i < num; i++) {
        ret += one;
      }
    } else if (num == 4) {
      ret += one + five;
    } else if (num == 5) {
      ret += five;
    } else if (num < 9) {
      ret += five;
      for (int i = 0; i < num - 5; i++) {
        ret += one;
      }
    } else if (num == 9) {
      ret += one + ten;
    }
    return ret;
  }

  public static String intToRoman(int num) {

    String ret = "";
    //1000
    int thousand = num / 1000;
    int thousandRemainder = num % 1000;

    for (int i = 0; i < thousand; i++) {
      ret += "M";
    }
    int hundred = thousandRemainder / 100;
    int hundredRemainder = thousandRemainder % 100;
    ret = printRomanDigit(ret, hundred, "C", "D", "M");

    int tens = hundredRemainder / 10;
    int tensRemainder = hundredRemainder % 10;
    ret = printRomanDigit(ret, tens, "X", "L", "C");
    ret = printRomanDigit(ret, tensRemainder, "I", "V", "X");
    return ret;
  }


  /**
   * Runtime: 4 ms, faster than 67.61%
   *
   * Memory Usage: 36.7 MB, less than 100.00%
   *
   * 很简单的题目？要加速，难道是在字符串拼接上？
   *
   * 错误：
   *
   * 1错：注意，最后个位数也要执行一次
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */
  public static void main(String[] args) {
    String expect = "MCMXCIV";
    String actual = intToRoman(1994);
    System.out.println(actual);
    System.out.println(expect.equals(actual));
  }
}

