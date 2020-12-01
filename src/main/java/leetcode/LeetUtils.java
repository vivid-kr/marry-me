package leetcode;

public class LeetUtils {



  public static class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val) {
      this.val = val;
    }

    public static TreeNode construct(String s) {
      return null;
    }

    public boolean printTree() {
      throw new UnsupportedOperationException();
    }
  }

  public static class ListNode {

    public ListNode next;
    public int val;

    public ListNode(int val) {
      this.val = val;
    }

    public static String treeToString(ListNode head) {
      StringBuilder sb = new StringBuilder();
      while (head != null){
        sb.append(String.format("->%d", head.val));
        head = head.next;
      }
      return sb.toString();
    }

    public static ListNode array2ListNode(int[] vals) {
      if(vals.length == 0)
        return null;
      ListNode head = new ListNode(vals[0]);
      ListNode tmp = head;
      for (int i = 1; i < vals.length; i++) {
        tmp.next = new ListNode(vals[i]);
        tmp = tmp.next;
      }
      return head;
    }
  }
}
