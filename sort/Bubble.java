package sort;

import java.util.Arrays;

public class Bubble<Key extends Comparable<Key>> extends AbstractSort {

  @Override
  public void sort(Comparable keys[]) {
    if (keys == null || keys.length <= 1) {
      return;
    }
    for (int counter = 0; counter < keys.length; counter++) {
      int minIndex = counter;
      for (int innerCounter = counter + 1; innerCounter < keys.length; innerCounter++) {
        if (less(innerCounter, minIndex, keys)) {
          minIndex = innerCounter;
        }
      }
      swap(minIndex, counter, keys);
    }
  }

  public static void main(String... strings) {
    String[] countries = { "srilanka", "india", "japan", "uk", "usa", "venezuala", "costarica", "sudan" };
    Bubble<String> bubble = new Bubble<String>();
    bubble.sort(countries);
    Arrays.asList(countries).forEach(System.out::println);
  }

}
