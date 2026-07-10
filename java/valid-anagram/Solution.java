import java.util.HashMap;
import java.util.Map;

// LeetCode 242 — Valid Anagram (HashMap tally version).
//
// Is t an anagram of s — the exact same letters, each used the same
// number of times, just reordered?
//
// If the two strings differ in length they can't possibly match, so we
// bail out early. Otherwise we do a two-pass tally. The first pass walks
// s and counts how many of each character it holds, storing those counts
// in a HashMap — the "inventory" of letters s brings. The second pass
// walks t and spends from that inventory one letter at a time: if a
// letter we need has a remaining count of 0, then t asks for a letter s
// doesn't have (or has already used up) and the two can't be anagrams, so
// we return false. Because the lengths are equal, draining the inventory
// exactly to empty is guaranteed once every character of t is covered —
// so getting through t without running dry means the answer is true.
//
//   s  "anagram"  ->  counts {a:3, n:1, g:1, r:1, m:1}
//   t  "nagaram"  ->  spend n,a,g,a,r,a,m  ->  all covered  ->  true
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> counts = new HashMap<>();

        for (char c : s.toCharArray()) {
            // Update a char's occurrence count in s.
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
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

        System.out.println(solution.isAnagram("anagram", "nagaram")); // true
        System.out.println(solution.isAnagram("rat", "car"));         // false
        System.out.println(solution.isAnagram("a", "ab"));            // false
        System.out.println(solution.isAnagram("ab", "ba"));           // true
    }
}
