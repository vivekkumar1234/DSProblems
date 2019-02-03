package sort;

import java.util.Arrays;

public class Merge<Key extends Comparable<Key>> extends AbstractSort {

  @Override
  public void sort(Comparable[] keys) {
    Comparable[] aux = new Comparable[keys.length];
    sort(keys, aux, 0, keys.length - 1);
  }

  protected void merge(Comparable[] keys, Comparable[] aux, int low, int high, int middle) {
    if (low >= high) {
      return;
    }
    for (int counter = low; counter <= high; counter++) {
      aux[counter] = keys[counter];
    }

    int i = low;
    int j = middle + 1;
    int k = low;
    while (k <= high) {
      if (i > middle) {
        keys[k++] = aux[j++];
      } else if (j > high) {
        keys[k++] = aux[i++];
      } else if (less(i, j, aux)) {
        keys[k++] = aux[i++];
      } else {
        keys[k++] = aux[j++];
      }
    }
  }

  private void sort(Comparable[] keys, Comparable[] aux, int low, int high) {
    if (low >= high) {
      return;
    }
    int middle = low + (high - low) / 2;
    sort(keys, aux, low, middle);
    sort(keys, aux, middle + 1, high);
    merge(keys, aux, low, high, middle);
  }

  public static void main(String... strings) {
    String[] countries = { "srilanka", "india", "japan", "uk", "usa", "venezuala", "costarica", "sudan" };
    Merge<String> merge = new Merge<String>();
    merge.sort(countries);
    Arrays.asList(countries).forEach(System.out::println);
  }

}
