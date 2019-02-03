package sort;

public abstract class AbstractSort<Key extends Comparable<Key>> {

  public abstract void sort(Comparable keys[]);

  public boolean less(int index1, int index2, Comparable keys[]) {
    return keys[index1].compareTo(keys[index2]) < 0;
  }

  public void swap(int index1, int index2, Comparable keys[]) {
    Comparable comp1 = keys[index1];
    keys[index1] = keys[index2];
    keys[index2] = comp1;
  }

}
