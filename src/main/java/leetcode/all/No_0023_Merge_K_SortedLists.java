package leetcode.hard;

import leetcode.LeetUtils.ListNode;

/**
 * An implementation not good enough
 */
public class No_0023_Merge_K_SortedLists {


  public static ListNode mergeTwo(ListNode a, ListNode b) {
    if (a == null) {
      return b;
    }
    if (b == null) {
      return a;
    }
    ListNode head;
    if (a.val < b.val) {
      head = a;
      a = a.next;
    } else {
      head = b;
      b = b.next;
    }
    ListNode p = head;
    while (a != null && b != null) {
      if (a.val < b.val) {
        p.next = a;
        a = a.next;
      } else {
        p.next = b;
        b = b.next;
      }
      p = p.next;
    }
    if (a == null) {
      p.next = b;
    } else {
      p.next = a;
    }
    return head;
  }


  public static ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    ListNode ret = lists[0];
    for (int i = 1; i < lists.length; i++) {
      ret = mergeTwo(ret, lists[i]);
    }
    return ret;
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
    System.out.println(mergeKLists(null) == null);
  }
}

