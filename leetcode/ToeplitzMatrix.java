package leetcode;

public class ToeplitzMatrix {
  public static boolean isToeplitzMatrix(int[][] matrix) {
    int rowLen = matrix.length;
    int colLen = matrix[0].length;
    if (colLen == 1 || rowLen == 1) {
      return true;
    }

    int[] test = new int[colLen];
    for (int row = 0; row < rowLen; row++) {
      for (int col = 0; col < colLen; col++) {
        if (row > 0 && col > 0 && test[col - 1] != matrix[row][col]) {
          return false;
        }
        if(col > 0) {
          test[col-1] = matrix[row][col-1];
        }
      }
    }
    return true;
  }

  public static void main(String... strings) {
    int[][] in = { { 1, 2, 3, 4 }, { 5, 1, 2, 3 }, { 9, 5, 1, 2 } };
    System.out.println(isToeplitzMatrix(in));
  }
}
