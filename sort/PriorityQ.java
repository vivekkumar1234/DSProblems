package sort;

import java.util.Arrays;
import java.util.Scanner;

public class PriorityQ<Key extends Comparable<Key>> {

  private Comparable[] keys;
  private static final int DEFAULT_CAPACITY = 5;
  private int currentSize = 0;
  private static int CAPACTITY = DEFAULT_CAPACITY;

  public static void main(String... args) {
    PriorityQ<Integer> pq = new PriorityQ<>();
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()) {
      pq.insert(sc.nextInt());
      Arrays.asList(pq.keys).forEach(System.out::println);
    }
  }

  public PriorityQ() {
    keys = new Comparable[DEFAULT_CAPACITY];
  }

  public PriorityQ(int capacity) {
    keys = new Comparable[capacity];
    CAPACTITY = capacity;
  }

  public void insert(Comparable key) {
    if (currentSize < CAPACTITY) {
      keys[currentSize++] = key;
      swim(currentSize - 1, keys);
    } else {
      if (less(0, key, keys)) {
        keys[0] = key;
        sink(0, keys, currentSize);
      }
    }
  }

  private void delMin(Comparable[] keys) {
    swap(currentSize--, 0, keys);
    sink(0, keys, currentSize);
  }

  private void swim(int k, Comparable[] keys) {
    while (k >= 0 && less(k, (k - 1) / 2, keys)) {
      swap((k - 1) / 2, k, keys);
      k = (k - 1) / 2;
    }
  }

  private void sink(int k, Comparable[] keys, int size) {
    while ((2 * k + 1) < size) {
      int j = 2 * k + 1;
      if (j + 1 < size && less(j + 1, j, keys)) {
        j++;
      }
      if (less(j, k, keys)) {
        swap(k, j, keys);
      }
      k = j;
    }
  }

  public boolean less(int index1, int index2, Comparable[] keys) {
    return keys[index1].compareTo(keys[index2]) < 0;
  }

  public boolean less(int index1, Comparable key, Comparable[] keys) {
    return key.compareTo(keys[index1]) < 0;
  }

  public void swap(int index1, int index2, Comparable keys[]) {
    Comparable comp1 = keys[index1];
    keys[index1] = keys[index2];
    keys[index2] = comp1;
  }

}
