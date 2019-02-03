package generics;

import java.util.ArrayList;
import java.util.List;

public class TestGenerics {

/*  public static void acceptAnimal(Animal[] animals) {
animals[1] = new Cat();
}*/

  public static void acceptAnimal(List<? extends Animal> animals) {
    //   animals.add(new Dog());
  }

/*  public static void makeSound(Animal[] animals) {
for (Animal animal : animals) {
animal.sound();
}
} 
*/
  public static void makeSound(List<? super Animal> animals) {
    for (Object animal : animals) {
      animal.hashCode();
    }
  }

  public static <T extends Animal> List<T> makeArrayList(T t) {
    List<T> list = new ArrayList<>();
    list.add(t);
    return list;
  }

  public static void main(String[] args) {
/*    Dog[] dogs = new Dog[4];
dogs[0] = new Dog();
acceptAnimal(dogs);*/

/*    Animal[] animals = new Animal[4];
animals[0] = new Animal();
acceptAnimal(animals);
makeSound(animals);*/
/*
List<Animal> animalList = new ArrayList<Animal>();
animalList.add(new Dog());
acceptAnimal(animalList);
makeSound(animalList);
*/
    /*List<? super Animal> animalList = new ArrayList<>();
    animalList.add(new Dog());
    // acceptAnimal(animalList);
    makeSound(animalList);
    
    List<? extends Animal> animalList1 = new ArrayList<>();
    */ //animalList1.add(new Animal());
    //makeSound(animalList1);
    makeArrayList(new Dog()).forEach(System.out::println);

  }
}
