package javaprogramming;

public class ReverseInt {

  public int reverse(int x) {
    boolean isNegative = x < 0;
    if (isNegative) {
      x = -x;
    }
    String s = Integer.toString(x);
    String rev = reverseString(x);
    if (isNegative) {
      rev = "-" + rev;
    }
    return Integer.valueOf(rev);
  }

  private String reverseString(String x) {
    return new StringBuilder(x).reverse().toString();
  }
  
}
