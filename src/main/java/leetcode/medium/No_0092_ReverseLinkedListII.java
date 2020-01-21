package leetcode.medium;

import leetcode.LeetUtils.ListNode;

/**
 * TODO Time
 */
public class No_0092_ReverseLinkedListII {


  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null || head.next == null || m == n) {
      return head;
    }
    ListNode pre, dummy = new ListNode(0);
    pre = dummy;
    dummy.next = head;
    for (int i = 0; i < m - 1; i++) {
      pre = pre.next;
    }
    ListNode cur = pre.next, p = pre.next, node = null;
    for (int i = 0; i <= n - m; i++) {
      ListNode nxt = cur.next;
      cur.next = node;
      node = cur;
      cur = nxt;
    }
    p.next = cur;
    pre.next = node;
    return dummy.next;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
   *
   * Memory Usage: 34.2 MB, less than 100.00% of Java online submissions for Reverse Linked List
   * II.
   *
   * 取巧，直接换值
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
    No_0092_ReverseLinkedListII no = new No_0092_ReverseLinkedListII();

    System.out.println(no);
  }
}

