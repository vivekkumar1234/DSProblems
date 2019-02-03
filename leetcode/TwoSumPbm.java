package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSumPbm {

  public static int[] twoSum(int[] nums, int target) {
    Set<Integer> set = new HashSet<Integer>();
    Map<Integer, Integer> indicesToNumber = new HashMap<Integer, Integer>();
    int counter = 0;
    for (int num : nums) {
      set.add(num);
      indicesToNumber.put(num, counter++);
    }
    counter = 0;
    for (int num : nums) {
      if (set.contains(target - num) && target - num !=num) {
        return new int[] { indicesToNumber.get(num), indicesToNumber.get(target - num) };
      }
    }
    return null;
  }

  public static void main(String... args) {
    System.out.println(Arrays.toString(twoSum(new int[] { 3, 2, 4 }, 6)));
  }
}
