package StackProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class validateExpr {
  public static boolean isValid(String s) {
    Stack<Character> bracketValidatorStack = new Stack<Character>();
    Map<Character, Character> matchOperatorMap = new HashMap<Character, Character>();
    matchOperatorMap.put(')', '(');
    matchOperatorMap.put(']', '[');
    matchOperatorMap.put('}', '{');

    Set<Character> openBracketsset = new HashSet<Character>();
    openBracketsset.add('(');
    openBracketsset.add('[');
    openBracketsset.add('{');

    for (char token : s.toCharArray()) {
      if (openBracketsset.contains(token)) {
        bracketValidatorStack.push(token);
      } else if (matchOperatorMap.containsKey(token)) {
        if (bracketValidatorStack.isEmpty() || matchOperatorMap.get(token) != bracketValidatorStack.peek()) {
          return false;
        }
        bracketValidatorStack.pop();
      }
    }
    return bracketValidatorStack.isEmpty();

  }

  public static void main(String... strings) {
    System.out.println(isValid("()"));
  }
}
