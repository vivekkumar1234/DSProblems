package sort;

import java.util.Arrays;

public class BottomUpMerge<Key extends Comparable<Key>> extends Merge {

  @Override
  public void sort(Comparable[] keys) {
    if (keys == null || keys.length <= 1) {
      return;
    }
    Comparable[] aux = new Comparable[keys.length];
    sort(keys, aux);
  }

  private void sort(Comparable[] keys, Comparable[] aux) {
    if (keys == null || keys.length <= 1) {
      return;
    }
    for (int sz = 1; sz < keys.length; sz += sz) {
      for (int inner = 0; inner < keys.length - sz; inner += sz + sz) {
        merge(keys, aux, inner, Math.min(inner + sz + sz - 1, keys.length - 1), inner + sz - 1);
      }
    }

  }

  public static void main(String... strings) {
    String[] countries = { "srilanka", "india", "japan", "uk", "usa", "venezuala", "costarica", "sudan" };
    BottomUpMerge<String> merge = new BottomUpMerge<String>();
    merge.sort(countries);
    Arrays.asList(countries).forEach(System.out::println);
  }

}
