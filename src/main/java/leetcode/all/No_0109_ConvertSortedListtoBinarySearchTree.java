package leetcode.all;

import leetcode.LeetUtils.ListNode;
import leetcode.LeetUtils.TreeNode;

/**
 * TODO Time
 */
public class No_0109_ConvertSortedListtoBinarySearchTree {

  ListNode head;

  public TreeNode sortedListToBST(ListNode head) {
    this.head = head;
    int listSize = getSize(head);
    return inOrderTraverse(0, listSize - 1);
  }

  private int getSize(ListNode head) {
    int size = 0;
    while (head != null) {
      head = head.next;
      size++;
    }
    return size;
  }

  private TreeNode inOrderTraverse(int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = start + (end - start) / 2;
    TreeNode left = inOrderTraverse(start, mid - 1);
    TreeNode root = new TreeNode(head.val);
    head = head.next;
    TreeNode right = inOrderTraverse(mid + 1, end);
    root.left = left;
    root.right = right;
    return root;
  }

  /**
   * 这是个不错的思路。虽然数组看起来更简单，但是实际上，添加叶子节点使用inorder遍历，那么顺序上就是链表，不要陷入思维窠臼
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
    No_0109_ConvertSortedListtoBinarySearchTree no = new No_0109_ConvertSortedListtoBinarySearchTree();

    System.out.println(no);
  }
}

