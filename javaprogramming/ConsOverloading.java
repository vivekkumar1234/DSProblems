package javaprogramming;

public class ConsOverloading {

/*  String s = "puppy";

  ConsOverloading() {
    this(s);
    System.out.println(s);
  }

  ConsOverloading(String s) {
    super();
  }

  public void go() {
    doStuff();
  }

  public void doStuff() {
    go();
  }

  public static void main(String... strings) {
    ConsOverloading consOverloading = new ConsOverloading();
  }*/
  

  private Object limit = new Object() {{
      System.out.print("A");
  }};

  public ConsOverloading() {
      this(new Object() {{
          System.out.print("B");
      }});
      System.out.print("C");
  }

  public ConsOverloading(Object o) {
      System.out.print("D");
  }

  public static void main(String[] args) {
      new ConsOverloading();
  }
}
