import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    // Walk the array once, adding each value to a set.
    // HashSet.add returns false when the value is already present,
    // so the first failed add means we've found a duplicate.
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();

        int[] withDuplicate = {1, 2, 3, 1};
        int[] noDuplicate = {1, 2, 3, 4};

        System.out.println("has duplicate: " + solution.containsDuplicate(withDuplicate));
        System.out.println("has duplicate: " + solution.containsDuplicate(noDuplicate));
    }
}
