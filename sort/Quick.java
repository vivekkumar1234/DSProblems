package sort;

import java.util.Arrays;
import java.util.Random;

public class Quick<Key extends Comparable<Key>> extends AbstractSort {

  @Override
  public void sort(Comparable[] keys) {
    if (keys == null || keys.length <= 1) {
      return;
    }
    shuffle(keys);
    sort(keys, 0, keys.length - 1);
  }

  private void sort(Comparable[] keys, int lo, int hi) {
    if (lo >= hi) {
      return;
    }
    swap(lo, lo + ((hi - lo) / 2), keys);
    int j = partition(keys, lo, hi);
    sort(keys, lo, j - 1);
    sort(keys, j + 1, hi);
  }

  private int partition(Comparable[] keys, int lo, int hi) {
    int pivot = lo;
    int i = lo;
    int j = hi + 1;
    while (i < hi && j > lo) {
      while (less(++i, pivot, keys)) {
        if (i == hi) {
          break;
        }
      }

      while (less(pivot, --j, keys)) {
        if (j == lo) {
          break;
        }
      }

      if (i >= j) {
        break;
      }
      swap(i, j, keys);
    }
    swap(pivot, j, keys);
    return j;
  }

  private void shuffle(Comparable[] keys) {
    Random rand = new Random();
    for (int i = 0; i < keys.length; i++) {
      swap(i, rand.nextInt(keys.length), keys);
    }
  }

  public static void main(String... strings) {
    String[] countries = { "srilanka", "india", "japan", "uk", "usa", "venezuala", "costarica", "sudan" };
    AbstractSort<String> absSort = new Quick<String>();
    absSort.sort(countries);
    Arrays.asList(countries).forEach(System.out::println);
  }

}
