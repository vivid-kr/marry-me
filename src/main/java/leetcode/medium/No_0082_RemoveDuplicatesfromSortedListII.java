package leetcode.medium;

import leetcode.LeetUtils.ListNode;

/**
 * TODO Time
 */
public class No_0082_RemoveDuplicatesfromSortedListII {


  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode p, fake = new ListNode(0);
    p = fake;
    fake.next = head;
    while (head != null && head.next != null) {
      if (head.val == head.next.val) {
        while (head.next != null && head.val == head.next.val) {
          head = head.next;
        }
        head = head.next;
        p.next = head;
      } else {
        head = head.next;
        p = p.next;
      }
    }
    return fake.next;
  }

  /**
   * 类似题目。
   *
   * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/discuss/28468/Java-concise-iterative-solution.
   *
   * 0次调试错误，然后成功。
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
    No_0082_RemoveDuplicatesfromSortedListII no = new No_0082_RemoveDuplicatesfromSortedListII();

    System.out.println(no);
  }
}

