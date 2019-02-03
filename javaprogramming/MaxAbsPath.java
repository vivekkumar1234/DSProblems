package javaprogramming;

import java.io.File;

public class MaxAbsPath {

  String maxPath = "";

  public int lengthLongestPath(String input) {
    int[] maxLength = new int[] { 0 };
    File file = new File(input);
    recDirectories(new File[] { file }, 0, maxLength);
    return maxLength[0];
  }

  public void recDirectories(File[] input, int currLength, int[] maxLength) {
    if (input == null) {
      return;
    }
    for (int i = 0; i < input.length; i++) {
      currLength += input[i].getName().length();
      if (currLength > maxLength[0]) {
        maxLength[0] = currLength;
        maxPath = input[i].getPath();
      }
      if (input[i].isDirectory()) {       
        recDirectories(input[i].listFiles(), currLength, maxLength);
      }
      currLength -= input[i].getName().length();
    }
  }

  public static void main(String... strings) {
    MaxAbsPath absPath = new MaxAbsPath();
    System.out.println(absPath.lengthLongestPath("C:\\tax\\2017 proofs (2)"));
    System.out.println(absPath.maxPath);
  }
}
