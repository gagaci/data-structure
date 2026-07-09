import java.util.HashMap;
import java.util.Map;

// LeetCode 383 — Ransom Note.
//
// Can the ransomNote be built using only the letters found in the
// magazine, where each magazine letter may be used at most once?
//
// The idea is a two-pass tally. First we walk the magazine and count how
// many of each character it offers, storing those counts in a HashMap —
// this is the "inventory" of available letters. Then we walk the ransom
// note and spend from that inventory one letter at a time: if a letter we
// need has a remaining count of 0, the magazine can't cover the note and
// we bail out early with false. If we get through the whole note without
// running dry, every character was covered and the answer is true.
//
//   magazine  "ababc"  ->  counts {a:2, b:2, c:1}
//   ransom    "aabb"   ->  spend a,a,b,b  ->  all covered  ->  true
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> counts = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            // Update a char's occurrence count in the magazine.
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            int remaining = counts.getOrDefault(c, 0);
            if (remaining == 0) {
                return false;
            }

            counts.put(c, remaining - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.canConstruct("a", "b"));        // false
        System.out.println(solution.canConstruct("aa", "ab"));      // false
        System.out.println(solution.canConstruct("aa", "aab"));     // true
        System.out.println(solution.canConstruct("aabb", "ababc")); // true
    }
}
