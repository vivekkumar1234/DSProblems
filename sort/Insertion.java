package sort;

import java.util.Arrays;

public class Insertion<Key extends Comparable<Key>> extends AbstractSort {

  @Override
  public void sort(Comparable[] keys) {
    if (keys == null || keys.length <= 1) {
      return;
    }
    for (int outer = 0; outer < keys.length; outer++) {
      for (int inner = outer; inner >= 0; inner--) {
        if (less(inner - 1, inner, keys)) {
          break;
        }
        swap(inner, inner - 1, keys);
      }
    }
  }

  public static void main(String... strings) {
    String[] countries = { "srilanka", "india", "japan", "uk", "usa", "venezuala", "costarica", "sudan" };
    Bubble<String> bubble = new Bubble<String>();
    bubble.sort(countries);
    Arrays.asList(countries).forEach(System.out::println);
  }

}
