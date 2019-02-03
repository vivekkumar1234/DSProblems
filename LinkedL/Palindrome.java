package LinkedL;

public class Palindrome {

  public static boolean isPalindrome(ListNode head) {
    if (head == null) {
      return true;
    }
    int length = length(head);
    int middle = (int) Math.ceil(length / 2.0);
    ListNode dummy = head;
    int count = 0;
    while (head != null) {
      count++;
      if (count > middle) {
        if (head != dummy) {
          return false;
        }
        dummy = dummy.next;
      }
      head = head.next;
    }
    return true;
  }

  public static int length(ListNode head) {
    int length = 0;
    while (head != null) {
      length++;
      head = head.next;
    }
    return length;
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static void main(String... strings) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(0);
    head.next.next = new ListNode(1);
    System.out.println(isPalindrome(head));
  }
}
