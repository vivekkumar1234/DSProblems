package csdojo;

public class Power {

  static float power(float x, int n) {
    if (n <= 0) {
      return 1;
    } else if (n % 2 == 0) {
      float y = power(x, n / 2);
      return y * y;
    } else {
      return x * power(x, n - 1);
    }
  }

  /* Program to test function power */
  public static void main(String[] args) {
    float x = 2;
    int y = 10;
    System.out.printf("%f", power(x, y));
  }
}
