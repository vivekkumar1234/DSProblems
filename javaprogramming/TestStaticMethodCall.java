package javaprogramming;

public class TestStaticMethodCall {

  public static String foo() {
    System.out.println("Test foo called");
    return "";
  }

  public static void main(String args[]) {
    TestStaticMethodCall obj = null;
    System.out.println(obj.foo());
  }
}
