package csdojo;

public class MaxArea {
  public static void main(String... args) {
    System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
  }

  public static int maxArea(int[] height) {
    int p1 = 0;
    int max = 0;
    int p2 = height.length - 1;
    while (p1 != p2) {
      if (height[p2] > height[p1]) {
        max = max > height[p1] * (p2 - p1) ? max : height[p1] * (p2 - p1);
        ++p1;
      } else {
        max = max > height[p2] * (p2 - p1) ? max : height[p2] * (p2 - p1);
        p2--;
      }
    }
    return max;
  }
}