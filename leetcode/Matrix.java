package leetcode;

import java.util.Arrays;

public class Matrix {
  public static int[][] flipAndInvertImage(int[][] A) {
    int length = A.length;
    int middle = length / 2;
    for (int row = 0; row < length; row++) {
      for (int col = 0; col < middle; col++) {
        int temp = A[row][length - col - 1];
        A[row][length - col - 1] = A[row][col];
        A[row][col] = temp;

      }
    }
    for (int row = 0; row < length; row++) {
      for (int col = 0; col < length; col++) {
        A[row][col] ^= 1;
      }
    }
    return A;
  }

  public static void main(String... args) {
    int[][] in = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
    System.out.println(Arrays.deepToString(flipAndInvertImage(in)));
  }
}
