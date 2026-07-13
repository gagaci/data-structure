import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LeetCode 49 — Group Anagrams.
//
// Given an array of strings, cluster together the ones that are anagrams
// of each other — same letters, each used the same number of times, just
// reordered. The output is the list of those clusters, in any order.
//
// The trick is finding a *canonical key* that every anagram shares. Sort a
// word's characters and every anagram of it collapses to the exact same
// sorted string: "eat", "tea", and "ate" all become "aet". So we use that
// sorted string as a HashMap key and file each original word under it.
// computeIfAbsent creates the bucket the first time we meet a key and
// reuses it afterward, so words with the same signature land together.
// When every word has been filed, the map's values are the groups.
//
//   "eat" -> "aet"   ┐
//   "tea" -> "aet"   ├─ bucket "aet": [eat, tea, ate]
//   "ate" -> "aet"   ┘
//   "tan" -> "ant"   ┐
//   "nat" -> "ant"   ┴─ bucket "ant": [tan, nat]
//   "bat" -> "abt"   ── bucket "abt": [bat]
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = String.valueOf(charArray);
            // Drop the word into the bucket for its sorted signature,
            // creating that bucket on first sight.
            map.computeIfAbsent(sortedKey, key -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.groupAnagrams(
                new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(solution.groupAnagrams(new String[] {""}));
        System.out.println(solution.groupAnagrams(new String[] {"a"}));
    }
}
