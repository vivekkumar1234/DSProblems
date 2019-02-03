package sort;

import java.util.Arrays;

public class Selection<Key extends Comparable<Key>> extends AbstractSort {

  @Override
  public void sort(Comparable[] keys) {

  }

  public static void main(String... strings) {
    String[] countries = { "srilanka", "india", "japan", "uk", "usa", "venezuala", "costarica", "sudan" };
    Selection<String> bubble = new Selection<String>();
    bubble.sort(countries);
    Arrays.asList(countries).forEach(System.out::println);
  }

}
