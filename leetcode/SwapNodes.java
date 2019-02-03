package leetcode;

public class SwapNodes {

  /**
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode(int x) { val = x; }
   * }
   */
  public static ListNode swapPairs(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prevNode = dummy;
    while (head != null && head.next != null) {
      prevNode.next = head.next;
      ListNode temp = head.next.next;
      head.next.next = head;
      head.next = temp;
      prevNode = head;
      head = head.next;
    }
    return dummy.next;

  }
  
  public static void main(String... args) {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    swapPairs(n1);
    
  }
}
