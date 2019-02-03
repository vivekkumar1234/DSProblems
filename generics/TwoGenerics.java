package generics;

public class TwoGenerics<T extends Animal, X> {

  T one;
  X two;

  public TwoGenerics(T one, X two) {
    this.one = one;
    this.two = two;
  }

  T getOne() {
    return one;
  }

  X getTwo() {
    return two;
  }

  public static void main(String... strings) {
    TwoGenerics<Dog, Integer> twos = new TwoGenerics<Dog, Integer>(new Dog(), 4);
    System.out.println(twos.getOne());
    System.out.println(twos.getTwo());
  }

}
