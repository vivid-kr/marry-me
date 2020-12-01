package leetcode.medium;

import leetcode.LeetUtils;
import leetcode.LeetUtils.ListNode;

/**
 * TODO Time
 */
public class No_0086_PartitionList {

  public ListNode partition(ListNode head, int x) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode smallDummy = new ListNode(0);
    ListNode equallargeDummy = new ListNode(0);
    ListNode sp = smallDummy;
    ListNode elp = equallargeDummy;
    ListNode p = head;
    while (p != null){
      if (p.val < x){
        sp.next = p;
        sp = p;
      }else {
        elp.next = p;
        elp = p;
      }
      p = p.next;
    }
    elp.next = null;
    sp.next = equallargeDummy.next;
    return smallDummy.next;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition List.
   *
   * Memory Usage: 36 MB, less than 100.00% of Java online submissions for Partition List.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：line 30，注意，elp.next可能指向其他地方，循环体内不用管，但是结束后要断干净
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    No_0086_PartitionList no = new No_0086_PartitionList();

    ListNode list = ListNode.array2ListNode(new int[]{1, 4, 3, 2, 5, 2});
    System.out.println(no.partition(list, 3));
  }
}

