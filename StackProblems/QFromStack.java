package StackProblems;

import java.util.LinkedList;
import java.util.Queue;

public class QFromStack {

  /** Initialize your data structure here. */
  Queue<Integer> q = new LinkedList<Integer>();
  Queue<Integer> auxq = new LinkedList<Integer>();
  int top;

  public MyStack() {
        
    }

  /** Push element x onto stack. */
  public void push(int x) {
    q.offer(x);
    top = x;
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    while (q.size() > 1) {
      int top = q.poll();
      auxq.offer(top);
    }
    int returnValue = q.poll();
    Queue<Integer> temp = q;
    q = auxq;
    auxq = temp;
    return returnValue;
  }

  /** Get the top element. */
  public int top() {
    return top;
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return q.isEmpty() && auxq.isEmpty();
  }

  public static void main(String... strings) {
    QFromStack qFromStack = new QFromStack();
    qFromStack.push(1);
    qFromStack.push(2);
    System.out.println(qFromStack.pop());
    System.out.println(qFromStack.top());
  }
}
