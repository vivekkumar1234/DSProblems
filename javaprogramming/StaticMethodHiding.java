package javaprogramming;

public class StaticMethodHiding {

  static class Animal {
    static void doStuff() {
      System.out.println("Animal");
    }
  }

  static class Dog extends Animal {
    static void doStuff() {
      System.out.println("Dog");
    }
  }

  public static void main(String... strings) {
    Animal[] animals = { new Animal(), new Dog(), null };
    for (Animal an : animals) {
      an.doStuff();
    }
  }
}
