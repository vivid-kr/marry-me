package leetcode.easy;

import leetcode.LeetUtils.ListNode;

/**
 * TODO Time
 */
public class No_0021_MergeTwoSortedLists {


  /**
   * Runtime: 0ms
   *
   * Memory Usage: 38.1(less than 16.8%)
   *
   * 0次调试错误，然后成功。
   *
   *
   * 一句话反思：简单题，想找一个很漂亮的解法，想了一会儿，但这个不够漂亮。用指针再想一个。
   *
   * 新知识：
   */
  public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    if (l1.val < l2.val) {
      l1.next = mergeTwoLists1(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists1(l2.next, l1);
      return l2;
    }
  }

  /**
   * 想减少一点内存，但发现所有java都在37M以上，减少内存就没有意义了
   * @param l1
   * @param l2
   * @return
   */
  public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    // if (l1 == null) return l2;
    // if (l2 == null) return l1;
    //prepare ret, it's ugly
    ListNode p1 = l1;
    ListNode p2 = l2;
    ListNode ret =null;
    ListNode p = null;
    while (true) {
      if (p1 == null) {
        if (ret == null) return p2;
        p.next = p2;
        break;
      }
      if (p2 == null) {
        if (ret == null) return p1;
        p.next = p1;
        break;
      }
      if (p1.val < p2.val) {
        if (ret == null) ret = p = p1;
        else{
          p.next = p1;
          p = p1;
        }
        p1 = p1.next;
      }else{
        if (ret == null) ret = p = p2;
        else{
          p.next = p2;
          p = p2;
        }
        p2 = p2.next;
      }
    }
    return ret;
  }

  public static void main(String[] args) {

//    System.out.println(actual);
//    System.out.println(expect.equals(actual));
  }
}

