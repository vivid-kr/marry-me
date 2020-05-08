package leetcode.hard;

import leetcode.LeetUtils.ListNode;

/**
 * TODO Time
 */
public class No_0025_ReverseNodesInKGroup {

  /**
   * Runtime: 0~1ms, beat 100%~35%
   *
   * Memory Usage: : 38.1 MB, less than 25.86%
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   *
   * 3错：line 61,62, 丢掉了next
   *
   * 一句话反思：用[1,2,3,4,5]推导一下就成功了。要注意是节点还是节点的next
   *
   * 新知识：无
   */
  // true: meet NULL intermediately
  public static boolean movePointArray(ListNode nodes[], int k, ListNode first) {
    nodes[0] = first;
    for (int i = 0; i < k; i++) {
      if (nodes[i].next == null) {
        return true;
      } else {
        nodes[i + 1] = nodes[i].next;
      }
    }
    return false;
  }

  public static ListNode reverseKGroup(ListNode head, int k) {
    //k assert
    if (k < 2) {
      return head;
    }
    //prepare node point array and the first fake node.
    ListNode nodes[] = new ListNode[k + 1];
    ListNode fake = new ListNode(0);
    fake.next = head;
    if (movePointArray(nodes, k, fake)) {
      return head;
    }
    while (true) {
      //reverse k nodes
      nodes[0].next = nodes[k];
      nodes[1].next = nodes[k].next;
      for (int j = k; j > 1; j--) {
        nodes[j].next = nodes[j - 1];
      }
      //check and move node points
      if (movePointArray(nodes, k, nodes[1])) {
        break;
      }
    }
    return fake.next;
  }

  public static String util(ListNode listNode) {
    StringBuilder sb = new StringBuilder("");
    while (listNode != null) {
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
    input.next.next.next.next = new ListNode(5);
    String expect = "2,1,4,3,5,";
    ListNode actual = reverseKGroup(input, 2);
    String actualStr = util(actual);
    System.out.println(expect.equals(actualStr));
    System.out.println(actualStr);
  }
}

