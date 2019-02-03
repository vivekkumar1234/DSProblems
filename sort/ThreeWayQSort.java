package sort;

import java.util.Arrays;

public class ThreeWayQSort<Key extends Comparable<Key>> extends AbstractSort {

  public static void main(String... strings) {
    String[] countries = { "srilanka", "india", "japan", "uk", "usa", "venezuala", "costarica", "sudan" };
    AbstractSort<String> absSort = new ThreeWayQSort<String>();
    absSort.sort(countries);
    Arrays.asList(countries).forEach(System.out::println);
  }

  @Override
  public void sort(Comparable[] keys) {
    sort(keys, 0, keys.length - 1);
  }

  private void sort(Comparable[] keys, int low, int high) {
    if (low >= high) {
      return;
    }

    int lt = low;
    int i = low;
    int gt = high;
    Comparable<Key> v = keys[low];
    while (i <= gt) {
      int cmp = keys[i].compareTo(v);
      if (cmp < 0) {
        swap(i++, lt++, keys);
      } else if (cmp > 0) {
        swap(gt--, i, keys);
      } else {
        i++;
      }
    }
    sort(keys, low, lt - 1);
    sort(keys, gt + 1, high);
  }

}
