package leetcode.all;

/**
 * TODO Time
 */
public class No_0278_FirstBadVersion {

  public static boolean isBadVersion(int test, int trueVersion){
    return test >= trueVersion;
  }

  public static int firstBadVersion(int n, int trueVersion) {
    long left = 0;
    long right = n;
    if (right < 0) {
      return 0;
    }
    long mid;
    while (left < right) {
      mid = (left + right) / 2;
      if (isBadVersion((int)(mid), trueVersion)){
        right = mid;
      } else{
        left = mid + 1;
      }
    }
    return (int)left;
  }

  /**
   * Runtime: 10 ms, faster than 99.72% of Java online submissions for First Bad Version.
   *
   * Memory Usage: 33 MB, less than 100.00% of Java online submissions for First Bad Version.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：int相加会越界！把类型都改成long
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
    int expect = 4;
    int actual = firstBadVersion(5,4);

    System.out.println(expect == actual);
  }
}

