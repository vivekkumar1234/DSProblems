package StackProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPrefix {

  enum OpertatorPrecedence {
    OPENBRACKET(')', 1), ADDITION('+', 2), SUBSRTACTION('-', 2), MULTIPLY('*', 3), DIVIDE('/', 3);
    char operator;
    int precedence;
    private static final Map<Character, Integer> operPrecedenceMap = new HashMap<>();

    static {
      for (OpertatorPrecedence operPrece : OpertatorPrecedence.values()) {
        operPrecedenceMap.put(operPrece.operator, operPrece.precedence);
      }
    }

    private OpertatorPrecedence(char operator, int precedence) {
      this.operator = operator;
      this.precedence = precedence;
    }

    public static int getPrecedence(char operator) {
      return operPrecedenceMap.get(operator);
    }
  }

  private static String infixToPrefix(String infixExpr) {
    StringBuilder prefixExpr = new StringBuilder();
    Stack<Character> operatorStack = new Stack<>();
    char[] infixExprArray = infixExpr.toCharArray();
    for (int counter = infixExprArray.length - 1; counter >= 0; counter--) {
      char token = infixExprArray[counter];
      if (Character.isLetterOrDigit(token)) {
        prefixExpr.insert(0, token);
      } else if (token == ')') {
        operatorStack.push(token);
      } else if (token == '(') {
        token = operatorStack.pop();
        while (!operatorStack.isEmpty() && token != ')') {
          prefixExpr.insert(0, token);
          token = operatorStack.pop();
        }
      } else {
        while (!operatorStack.isEmpty()
            && OpertatorPrecedence.getPrecedence(operatorStack.peek()) >= OpertatorPrecedence.getPrecedence(token)) {
          prefixExpr.insert(0, operatorStack.pop());
        }
        operatorStack.push(token);
      }

    }
    while (!operatorStack.isEmpty()) {
      prefixExpr.insert(0, operatorStack.pop());
    }
    return prefixExpr.toString();
  }

  public static void main(String... strings) {
    /* System.out.println(infixToPrefix("A*B+C*D"));
    System.out.println(infixToPrefix("(A+B)*C-(D-E)*(F+G)"));
    System.out.println(infixToPrefix("(((A+B)*C)-((D-E)*(F+G)))"));
    */
    System.out.println(evalPrefixExpr(infixToPrefix("(((9+8)*5)-((4-3)*(2+8)))")));

  }

  public static int evalPrefixExpr(String prefixExpr) {
    Stack<Integer> operandStack = new Stack<>();
    char[] prefixCharArray = prefixExpr.toCharArray();
    for (int counter = prefixCharArray.length - 1; counter >= 0; counter--) {
      char token = prefixCharArray[counter];
      if (Character.isDigit(token)) {
        operandStack.push(Character.digit(token, 10));//token - '0' for radix 10
      } else {
        operandStack.push(evaluateExpr(token, operandStack.pop(), operandStack.pop()));
      }

    }
    return operandStack.pop();
  }

  public static int evaluateExpr(char token, int op1, int op2) {
    switch (token) {
      case '*':
        return op1 * op2;
      case '+':
        return op1 + op2;
      case '-':
        return op1 - op2;
      case '/':
        if (op2 != 0) {
          return op1 / op2;
        }
        return 0;
      default:
        return 0;
    }

  }
}
