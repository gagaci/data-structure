import java.util.Arrays;

// LeetCode 242 — Valid Anagram (sorting version).
//
// Two strings are anagrams exactly when they hold the same multiset of
// characters. Sorting turns that multiset into a canonical form: if we
// sort both strings letter by letter, anagrams collapse to the *same*
// sequence and non-anagrams don't.
//
// So we splay each string into a char[], sort both arrays, and compare
// them element by element with Arrays.equals. No explicit length check is
// needed — arrays of different lengths are never equal.
//
//   s "anagram" -> sorted "aaagmnr"
//   t "nagaram" -> sorted "aaagmnr"   equal -> true
//
// Trade-off vs. the HashMap tally: this is O(n log n) for the sort rather
// than O(n), but it needs no auxiliary map and is a single, compact idea.
public class SolutionSorting {
    public boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }

    public static void main(String[] args) {
        SolutionSorting solution = new SolutionSorting();

        System.out.println(solution.isAnagram("anagram", "nagaram")); // true
        System.out.println(solution.isAnagram("rat", "car"));         // false
        System.out.println(solution.isAnagram("a", "ab"));            // false
        System.out.println(solution.isAnagram("ab", "ba"));           // true
    }
}
