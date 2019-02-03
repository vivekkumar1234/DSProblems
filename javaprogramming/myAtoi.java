package javaprogramming;

public class myAtoi {

  public static int myAtoi(String str) {
    int intValue = 0;
    int negativeMul = 1;
    for (char c : str.toCharArray()) {
      if (c == '-') {
        negativeMul = -1;
        continue;
      }
      if (c == ' ') {
        continue;
      }
      if ((c > 'a' && c < 'z') || (c > 'A' && c < 'Z')) {
        return intValue;
      }
      if (c < 0 && c > 9) {
        continue;
      }
      long temp = intValue * 10 + (c - 48);
      if ((int) temp != temp) {
        return 0;
      }
      intValue = (int) temp;
    }
    return intValue * negativeMul;

  }

  public static int parseInt(String s, int radix) throws NumberFormatException {
/*
 * WARNING: This method may be invoked early during VM initialization
 * before IntegerCache is initialized. Care must be taken to not use
 * the valueOf method.
 */

    if (s == null) {
      throw new NumberFormatException("null");
    }

    if (radix < Character.MIN_RADIX) {
      throw new NumberFormatException("radix " + radix + " less than Character.MIN_RADIX");
    }

    if (radix > Character.MAX_RADIX) {
      throw new NumberFormatException("radix " + radix + " greater than Character.MAX_RADIX");
    }

    int result = 0;
    boolean negative = false;
    int i = 0, len = s.length();
    int limit = -Integer.MAX_VALUE;
    int multmin;
    int digit;

    if (len > 0) {
      char firstChar = s.charAt(0);
      if (firstChar < '0') { // Possible leading "+" or "-"
        if (firstChar == '-') {
          negative = true;
          limit = Integer.MIN_VALUE;
        } else if (firstChar != '+')
          throw forInputString(s);

        if (len == 1) // Cannot have lone "+" or "-"
          throw forInputString(s);
        i++;
      }
      multmin = limit / radix;
      while (i < len) {
        // Accumulating negatively avoids surprises near MAX_VALUE
        digit = Character.digit(s.charAt(i++), radix);
        if (digit < 0) {
          throw forInputString(s);
        }
        if (result < multmin) {
          throw forInputString(s);
        }
        result *= radix;
        if (result < limit + digit) {
          throw forInputString(s);
        }
        result -= digit;
      }
    } else {
      throw forInputString(s);
    }
    return negative ? result : -result;
  }

  static NumberFormatException forInputString(String s) {
    return new NumberFormatException("For input string: \"" + s + "\"");
  }

  public static void main(String... strings) {
    System.out.println(myAtoi("-0"));
  }
}
