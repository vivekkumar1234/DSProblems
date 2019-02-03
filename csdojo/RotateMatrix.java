package csdojo;

import java.util.Arrays;

public class RotateMatrix {

  public static void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int c = 0; c < n / 2; c++) {
      int l = n - 1 - c;
      for (int i = 0; i < Math.ceil(((double) n) / 2.); i++) {
        int temp = matrix[c][i];
        matrix[c][i] = matrix[n - 1 - i][c];
        matrix[n - 1 - i][c] = matrix[l][n - 1 - i];
        matrix[l][n - 1 - i] = matrix[i][l];
        matrix[i][l] = temp;
      }
    }
  }

  public static void main(String... args) {
    int a[][] = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
    rotate(a);
    System.out.println(Arrays.deepToString(a));

  }
}
