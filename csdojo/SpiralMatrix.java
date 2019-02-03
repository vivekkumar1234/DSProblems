package csdojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> spiralOrder = new ArrayList<Integer>();
    for (int layer = 0; layer < Math.ceil(matrix.length / 2); layer++) {
      for (int column = layer; column < matrix[0].length - layer - 1; column++) {
        spiralOrder.add(matrix[layer][column]);
      }
      for (int row = layer; row < matrix.length - layer - 1; row++) {
        spiralOrder.add(matrix[row][matrix[0].length - layer - 1]);
      }
      for (int column = matrix[0].length - layer - 1; column > layer; column--) {
        spiralOrder.add(matrix[matrix.length - 1 - layer][column]);
      }
      for (int row = matrix.length - 1 - layer; row > layer; row--) {
        spiralOrder.add(matrix[row][layer]);
      }
    }
    return spiralOrder;
  }

  public static void main(String... args) {
    int a[][] = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
    System.out.println(spiralOrder(a));
  }

}
