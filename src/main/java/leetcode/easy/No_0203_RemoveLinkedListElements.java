package leetcode.easy;

import leetcode.LeetUtils.ListNode;

/**
 * TODO Time
 */
public class No_0203_RemoveLinkedListElements {

  /**
   * 203. Remove Linked List Elements Easy
   *
   * 2184
   *
   * 107
   *
   * Add to List
   *
   * Share Remove all elements from a linked list of integers that have value val.
   *
   * Example:
   *
   * Input:  1->2->6->3->4->5->6, val = 6 Output: 1->2->3->4->5
   */
  public ListNode removeElements(ListNode head, int val) {
    // find the first valid node
    while (head != null && head.val == val) {
      head = head.next;
    }
    if (head == null) {
      return null;
    }
    ListNode prev = head;
    ListNode current = head.next;
    while (current != null) {
      if (current.val == val) {
        prev.next = current.next;
      }else{
        prev = current;
      }
      current = current.next;
    }
    return head;
  }

  /**
   * Runtime: 0 ms, faster than 98.93% of Java online submissions for Two Sum.
   *
   * Memory Usage: 38.2 MB, less than 98.95% of Java online submissions for Two Sum.
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
    ListNode head = ListNode.array2ListNode(new int[]{1, 2, 6, 3, 4, 5, 6});
    ListNode ret = (new No_0203_RemoveLinkedListElements()).removeElements(head, 6);
    System.out.println(ListNode.treeToString(ret));
  }
}