import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // Walk the array once, keeping a map of value -> index for everything
    // seen so far. For each element we ask: "have I already seen the number
    // that completes the target?" (the complement). If yes, we're done —
    // the stored index and the current index are the answer. If no, we
    // remember the current value so future elements can pair with it.
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        System.out.println(Arrays.toString(solution.twoSum(new int[] {2, 7, 11, 15}, 9)));   // [0, 1]
        System.out.println(Arrays.toString(solution.twoSum(new int[] {3, 2, 4}, 6)));         // [1, 2]
        System.out.println(Arrays.toString(solution.twoSum(new int[] {3, 3}, 6)));            // [0, 1]
    }
}
