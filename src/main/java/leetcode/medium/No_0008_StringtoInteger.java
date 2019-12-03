package leetcode.medium;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No_0008_StringtoInteger {

  public static int myAtoi(String str) {
    // prepare
    Set signSet = new HashSet();
    signSet.add('+');
    signSet.add('-');
    Set numSet = new HashSet();
    numSet.add('0');
    numSet.add('1');
    numSet.add('2');
    numSet.add('3');
    numSet.add('4');
    numSet.add('5');
    numSet.add('6');
    numSet.add('7');
    numSet.add('8');
    numSet.add('9');

    List<Integer> numList = new ArrayList<Integer>();

    int flag = 0; // 0: reading flag; 1: reading sign; 2: reading num
    int sign = -1;
    boolean noMore = false;
    for (int i = 0; i < str.length(); i++) {
      switch (flag) {
        case 0:
          if (str.charAt(i) == '+') {
            sign = 1;
            flag = 1;
          } else if (str.charAt(i) == '-') {
            sign = 0;
            flag = 1;
          } else if (numSet.contains(str.charAt(i))) {
            sign = 1;
            flag = 2;
            numList.add(Integer.parseInt(String.valueOf(str.charAt(i))));
          } else if (str.charAt(i) != ' ') {
            //Illegal
            return 0;
          }
          break;
        case 1:
          if (numSet.contains(str.charAt(i))) {
            flag = 2;
            numList.add(Integer.parseInt(String.valueOf(str.charAt(i))));
          } else {
            //Illegal, 正负号之后没有数字，接了其他的，全都当做异常
            return 0;
          }
          break;
        case 2:
          if (numSet.contains(str.charAt(i))) {
            numList.add(Integer.parseInt(String.valueOf(str.charAt(i))));
          } else {
            noMore = true;
          }
          break;
        default:
          throw new RuntimeException();
      }
      if (noMore) {
        break;
      }
    }
    if (flag != 2) {
      return 0;
    }
    //处理完了，先按照最简单的试一下
    char[] charArray = new char[numList.size() + 1];
    charArray[0] = sign == 1 ? '+' : '-';
    for (int i = 0; i < numList.size(); i++) {
      charArray[i + 1] = String.valueOf(numList.get(i)).charAt(0);
    }
    int ret;
    try {
      ret = Integer.valueOf(new String(charArray));
    } catch (NumberFormatException e) {
      if (sign == 1) {
        ret = (1 << 31) - 1;
//        ret = Integer.MAX_VALUE;
      } else {
        ret = 1 << 31;
//        ret = Integer.MIN_VALUE;
      }

    }
    return ret;
  }
  /**



   */


  /**
   * Runtime: 6 ms, faster than 11.48%
   *
   * Memory Usage: 37.8 MB, less than 96.81%
   *
   * 2次调试错误，然后成功。质量不错
   *
   * 错误：
   *
   * 1. RuntimeException写错了
   *
   * 2. NumberFormatException，没考虑到越界情况
   *
   * 3. Int的最大最小值其实是 (1<<31)-1和 1<<31，写成了2<<31，那就变0了
   *
   * 4. 异常状态，比如""，或者"+"，或者"-"，其实应该判断，如果状态不是2，就肯定是异常了。
   *
   * 新知识：
   *
   * 对于Set，函数是：contains()
   *
   * 对于Map，函数是: containsKey()
   *
   * 给一个太大的数字给valueOf，会抛出异常。 java.lang.NumberFormatException: For input string: "-91283472332"
   *
   * 运行时异常是RuntimeException
   */
  public static void main(String[] args) {
    int actual = myAtoi("-91283472332");
//    int expect = 1<<31;
    System.out.println(1 << 31 == Integer.MIN_VALUE);
    System.out.println((1 << 31) - 1 == Integer.MAX_VALUE);


  }
}

