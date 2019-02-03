package StackProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostfix {

  private enum OperandPrecedence {
    MULTIPLY('*', 3), DIVIDE('/', 3), ADDITION('+', 2), SUBSTRACT('-', 2), OPENBRACKET('(', 1);

    char operator;
    int precedence;
    private static final Map<Character, Integer> operatorPrecedenceMap = new HashMap<>();

    static {
      for (OperandPrecedence opPrec : OperandPrecedence.values()) {
        operatorPrecedenceMap.put(opPrec.operator, opPrec.precedence);
      }
    }

    OperandPrecedence(char operator, int precedence) {
      this.operator = operator;
      this.precedence = precedence;
    }

    public static int getOperatorPrecedence(char operator) {
      return operatorPrecedenceMap.get(operator);
    }
  }

  public static String infixToPostFix(String infixExpr) {
    StringBuilder postFixExpr = new StringBuilder();
    char[] charExpr = infixExpr.toCharArray();
    Stack<Character> opStack = new Stack<>();
    for (char token : charExpr) {
      if (Character.isLetterOrDigit(token)) {
        postFixExpr.append(token);
      } else if (token == '(') {
        opStack.push(token);
      } else if (token == ')') {
        token = opStack.pop();
        while (!opStack.isEmpty() && token != '(') {
          postFixExpr.append(token);
          token = opStack.pop();
        }
      } else {
        while (!opStack.isEmpty() && OperandPrecedence.getOperatorPrecedence(opStack.peek()) >= OperandPrecedence
            .getOperatorPrecedence(token)) {
          postFixExpr.append(opStack.pop());
        }
        opStack.push(token);
      }
    }

    while (!opStack.isEmpty()) {
      postFixExpr.append(opStack.pop());
    }
    return postFixExpr.toString();
  }

  public static void main(String... strings) {

    /*System.out.println(infixToPostFix("A*B+C*D"));
    System.out.println(infixToPostFix("(A+B)*C-(D-E)*(F+G)"));
    System.out.println(infixToPostFix("(((A+B)*C)-((D-E)*(F+G)))"));
    */
    System.out.println(evalPostFix("456*+"));

  }

  public static int evalPostFix(String postFixExpr) {
    char[] postFixCharArray = postFixExpr.toCharArray();
    Stack<Integer> operandStack = new Stack<>();

    for (char token : postFixCharArray) {
      if (Character.isDigit(token)) {
        operandStack.push(Character.digit(token, 10));
      } else {
        operandStack.push(handleOperation(token, operandStack.pop(), operandStack.pop()));
      }
    }
    return operandStack.pop();
  }

  public static int handleOperation(char operator, Integer op2, Integer op1) {
    switch (operator) {
      case '*':
        return op1 * op2;
      case '+':
        return op1 + op2;
      case '/':
        return op1 / op2;
      case '-':
        return op1 - op2;
      default:
        return 0;
    }
  }
}
