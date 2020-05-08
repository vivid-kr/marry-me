package leetcode.medium;

import leetcode.LeetUtils.ListNode;

/**
 * TODO Time
 */
public class No_0024_SwapNodesinPairs {


  /**
   * Runtime: beat 100%
   *
   * Memory Usage: beat 100%
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：line 50: first = last; 写成了first = last.next; 结果跳过了一格
   *
   * 2错：line46: first.next.next = last; 写成了first.next = last; 也是跳错了
   *
   * 3错：line 38, head == null的情况没考虑,只考虑了head.next == null
   *
   * 一句话反思：用[1,2,3,4]推导一下就成功了。要考虑head=null
   *
   * 新知识：无
   */
  public static ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode fake = new ListNode(0);
    fake.next = head;
    ListNode first = fake;
    ListNode last = head;
    while (true) {
      first.next = last.next;
      last.next = last.next.next;
      first.next.next = last;
      if (last.next == null || last.next.next == null) {
        break;
      } else {
        first = last;
        last = first.next;
      }
    }
    return fake.next;
  }

  public static String util(ListNode listNode){
    StringBuilder sb = new StringBuilder("");
    while (listNode != null){
      sb.append(listNode.val);
      sb.append(',');
      listNode = listNode.next;
    }
    return sb.toString();
  }



  public static void main(String[] args) {
    ListNode input = new ListNode(1);
    input.next = new ListNode(2);
    input.next.next = new ListNode(3);
    input.next.next.next = new ListNode(4);
    String expect = "2,1,4,3,";
    ListNode actual = swapPairs(input);
    String actualStr = util(actual);
    System.out.println(expect.equals(actualStr));
    System.out.println(actualStr);
  }
}

