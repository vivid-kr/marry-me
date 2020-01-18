package leetcode.medium;

import leetcode.LeetUtils.ListNode;

/**
 * TODO Time
 */
public class No_0083_RemoveDuplicatesfromSortedList {

  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode fast = head.next;
    ListNode slow = head;

    while (fast != null) {
      while (fast.val == slow.val) {
        fast = fast.next;
        if (fast == null) {
          slow.next = null;
          return head;
        }
      }
      slow.next = fast;
      slow = fast;
      fast = fast.next;
    }
    return head;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted
   * List.
   *
   * Memory Usage: 36.8 MB, less than 100.00% of Java online submissions for Remove Duplicates from
   * Sorted List.
   *
   * 0次调试错误，1次直接测试错误，然后成功。
   *
   * 错误：
   *
   * 1错：line 31. 注意，和No 26不一样，如果末尾是相同的[3，3，3]这样，fast=null时，不能直接返回，而需要截断slow。
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    No_0083_RemoveDuplicatesfromSortedList no = new No_0083_RemoveDuplicatesfromSortedList();

    System.out.println(no);
  }
}

