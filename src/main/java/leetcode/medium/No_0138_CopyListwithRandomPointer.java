package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class No_0138_CopyListwithRandomPointer {

  class Node {

    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Copy List with Random
   * Pointer.
   *
   * Memory Usage: 38.3 MB, less than 89.61% of Java online submissions for Copy List with Random
   * Pointer.
   *
   * 运行很快，但是内存多占一些。主要是Map和两个list，再看看解法
   * 哈哈，一个高赞解法也是这么做的，不过只用了一个map，可以看一下
   */
  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }
    //get length
    int len = 0;
    Node tmp = head;
    while (tmp != null) {
      tmp = tmp.next;
      len++;
    }

    Node[] arrays = new Node[len];
    Map<Node, Integer> nodeToIdx = new HashMap<>();
    tmp = head;
    for (int i = 0; i < len; i++) {
      nodeToIdx.put(tmp, i);
      arrays[i] = tmp;
      tmp = tmp.next;
    }
    int idx;
    Node[] newArrays = new Node[len];
    for (int i = 0; i < len; i++) {
      Node node = new Node(arrays[i].val);
      if (i > 0) {
        newArrays[i - 1].next = node;
      }
      newArrays[i] = node;
    }
    for (int i = 0; i < len; i++) {
      if (arrays[i].random != null) {
        idx = nodeToIdx.get(arrays[i].random);
        newArrays[i].random = newArrays[idx];
      }
    }
    return newArrays[0];
  }
}
