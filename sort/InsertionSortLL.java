package sort;

public class InsertionSortLL {

  public static ListNode sort(ListNode head) {
    // Initialize partially sorted list
    ListNode dummy = new ListNode(Integer.MIN_VALUE), prev = dummy, current = head;

    while (current != null) {
      if (prev.val > current.val)
        prev = dummy;

      // Find the right place to insert current node
      while (prev.next != null && prev.next.val < current.val)
        prev = prev.next;

      // Insert current between prev and prev.next
      ListNode nextNode = current.next;
      current.next = prev.next;
      prev.next = current;
      current = nextNode;
    }
    return dummy.next;
  }

  private static class ListNode {
    ListNode next;
    int val;

    ListNode(int val) {
      this.val = val;
    }
  }

  public static void main(String... strings) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(5);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(0);

    head = sort(head);
    while (head != null) {
      System.out.println(head.val + " ");
      head = head.next;
    }
  }
}
