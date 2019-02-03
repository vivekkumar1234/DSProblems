package leetcode;

public class Pow {

  public static double myPow(double x, int n) {
    if (x == 0 && n <= 0)
      return 0;
    double res = 1;
    double xk = x;
    int n2 = n < 0 ? -n : n;
    while (n2 != 0) {
      if ((n2 & 1) == 1)
        res = res * xk;
      n2 >>>= 1;
      xk *= xk;
    }
    return n >= 0 ? res : 1 / res;
  }

  public static void main(String... args) {
    System.out.println(myPow(2, -5));
  }
}
