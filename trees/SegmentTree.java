package trees;

import java.util.Arrays;

public class SegmentTree {

  private int segmentTree[];
  private int input[];

  public SegmentTree() {

  }

  public void constructSTTree(int input[]) {
    this.input = input;
    segmentTree = new int[2 * input.length - 1];
    contructSTTree(0, input.length - 1, 0);
  }

  private int contructSTTree(int startIndexOfInput, int endIndexOfInput, int indexOfSegmentTree) {
    if (startIndexOfInput == endIndexOfInput && startIndexOfInput > input.length) {
      return (segmentTree[indexOfSegmentTree] = input[startIndexOfInput]);
    }
    int mid = (startIndexOfInput + endIndexOfInput) / 2;
    segmentTree[indexOfSegmentTree] = contructSTTree(startIndexOfInput, mid, 2 * indexOfSegmentTree + 1)
        + contructSTTree(mid + 1, endIndexOfInput, 2 * indexOfSegmentTree + 2);
    return segmentTree[indexOfSegmentTree];
  }

  public static void main(String... strings) {
    SegmentTree segmentTree = new SegmentTree();
    segmentTree.constructSTTree(new int[] { 1, 2, 3, 4, 5, 6 });
    System.out.println(Arrays.toString(segmentTree.segmentTree));
  }

}
