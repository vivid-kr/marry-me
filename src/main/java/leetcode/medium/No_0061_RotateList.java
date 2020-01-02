package leetcode.medium;

import leetcode.LeetUtils.ListNode;

/**
 * TODO Time
 */
public class No_0061_RotateList {

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k == 0) {
      return head;
    }
    ListNode fast = head;
    ListNode slow = head;
    //calc total length
    int l = 1;
    for (; fast.next != null; l++) {
      fast = fast.next;
    }
    k = k % l;
    if(k == 0)
      return head;
    fast = head;
    for (int i = 0; i < k; i++) {
      fast = fast.next;
    }
    while (fast.next != null){
      fast = fast.next;
      slow = slow.next;
    }
    fast.next = head;
    head = slow.next;
    slow.next = null;
    return head;
  }


  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate List.
   *
   * Memory Usage: 37.3 MB, less than 82.76% of Java online submissions for Rotate List.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：line 32~35要仔细
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    No_0061_RotateList no = new No_0061_RotateList();

    System.out.println(no);
  }
}

