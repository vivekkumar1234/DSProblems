package sort;

import java.util.Arrays;

public class HeapSort<Key extends Comparable<Key>> extends AbstractSort {

  @Override
  public void sort(Comparable[] keys) {
    heapify(keys);
    delMax(keys);
  }

  private void delMax(Comparable[] keys) {
    int N = keys.length - 1;
    while (N > 0) {
      swap(N--, 0, keys);
      sink(0, keys, N);
    }
  }

  private void heapify(Comparable[] keys) {
    int k = (keys.length - 1) / 2;
    while (k >= 0) {
      sink(k, keys, keys.length);
      k--;
    }
  }

  private void sink(int k, Comparable[] keys, int size) {
    while ((2 * k + 1) < size) {
      int j = 2 * k + 1;
      if (j + 1 < size && less(j, j + 1, keys)) {
        j++;
      }
      if (less(k, j, keys)) {
        swap(k, j, keys);
      }
      k = j;
    }
  }

  public static void main(String... strings) {
    String[] countries = { "srilanka", "india", "japan", "uk", "usa", "venezuala", "costarica", "sudan" };
    AbstractSort<String> absSort = new HeapSort<String>();
    absSort.sort(countries);
    Arrays.asList(countries).forEach(System.out::println);
  }

}
