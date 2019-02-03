package sort;

import java.util.Arrays;

public class Shell<Key extends Comparable<Key>> extends AbstractSort {

  @Override
  public void sort(Comparable[] keys) {
    if (keys == null || keys.length <= 1) {
      return;
    }
    int shell = 1;
    while (shell < keys.length / 3) {
      shell = 3 * shell + 1;
    }
    while (shell >= 1) {
      for (int inner = shell; inner < keys.length; inner++) {
        for (int outer = inner; outer >= shell; outer = outer - shell) {
          if (less(outer, outer - shell, keys)) {
            swap(outer, outer - shell, keys);
          }
        }
      }
      shell = shell / 3;
    }
  }

  public static void main(String... strings) {
    String[] countries = { "srilanka", "india", "japan", "uk", "usa", "venezuala", "costarica", "sudan" };
    Shell<String> shell = new Shell<String>();
    shell.sort(countries);
    Arrays.asList(countries).forEach(System.out::println);
  }
}
