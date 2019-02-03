package StackProblems;

class MinStack {

  class Node {
    int val;
    Node next;

    Node(int val) {
      this.val = val;
    }
  }

  Node top;
  Node minValue;

  /** initialize your data structure here. */
  public MinStack() {

  }

  public void push(int x) {
    if (top == null) {
      top = new Node(x);
      minValue = top;
    } else {
      Node temp = new Node(x);
      temp.next = top;
      top = temp;
      if (x < minValue.val) {
        minValue = top;
      }
    }

  }

  public void pop() {
    if (top != null) {
      Node temp = top;
      top = top.next;
      temp.next = null;

      if (temp == minValue) {
        Node testNode = top;
        minValue = top;
        while (testNode != null) {
          if (testNode.val < minValue.val) {
            minValue = testNode;
          }
          testNode = testNode.next;
        }
      }

    }
  }

  public int top() {
    return top != null ? top.val : -1;
  }

  public int getMin() {
    return minValue != null ? minValue.val : -1;
  }

  /**
  * Your MinStack object will be instantiated and called as such:
  * MinStack obj = new MinStack();
  * obj.push(x);
  * obj.pop();
  * int param_3 = obj.top();
  * int param_4 = obj.getMin();
  */

  public static void main(String... strings) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin());
    minStack.pop();
    minStack.top();
    System.out.println(minStack.getMin());
  }
}