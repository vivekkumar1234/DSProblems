package sort;

import java.util.Random;

public class KthLargest<Key extends Comparable<Key>> {

  public static void main(String... strings) {
    String[] countries = { "srilanka", "india", "japan", "uk", "usa", "venezuala", "costarica", "sudan" };
    KthLargest<String> select = new KthLargest<String>();
    shuffle(countries);
    int pos = select.select(countries, 0, countries.length - 1, 7);
    if (pos == -1) {
      System.out.println("Element not found");
    } else {
      System.out.println(countries[pos]);
    }
  }

  private static void shuffle(Comparable[] keys) {
    Random rand = new Random();
    for (int i = 0; i < keys.length; i++) {
      swap(i, rand.nextInt(keys.length), keys);
    }
  }

  private int select(Comparable[] keys, int lo, int hi, int pos) {
    if (hi < lo) {
      return -1;
    }
    int j = partition(keys, lo, hi);
    if (j == pos) {
      return j;
    } else if (pos < j) {
      return select(keys, lo, j - 1, pos);
    } else if (pos > j) {
      return select(keys, j + 1, hi, pos);
    }
    return -1;
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

  public boolean less(int index1, int index2, Comparable keys[]) {
    return keys[index1].compareTo(keys[index2]) < 0;
  }

  public static void swap(int index1, int index2, Comparable keys[]) {
    Comparable comp1 = keys[index1];
    keys[index1] = keys[index2];
    keys[index2] = comp1;
  }

}
