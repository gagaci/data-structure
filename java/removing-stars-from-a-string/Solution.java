import java.util.Stack;

// LeetCode 2390 — Removing Stars From a String.
//
// The string contains lowercase letters and '*' characters. Each '*' is an
// instruction: "remove the closest non-star character to my left, and remove
// yourself too." Apply every star and return the string that's left.
//
// A stack is the natural fit. The character a star removes is always the most
// recently kept one — last-in, first-out. So we walk the string once:
//
//   - a letter  -> push it onto the stack (it's a candidate to be removed
//                  later by some star).
//   - a '*'     -> pop the top letter (the closest one to the left).
//
// When the walk finishes, whatever remains on the stack — in insertion order —
// is the answer. Reading a Java Stack front-to-back gives that order directly.
//
//   "leet**code"
//    l e e t   push each          stack: l e e t
//    *         pop t              stack: l e e
//    *         pop e              stack: l e
//    c o d e   push each          stack: l e c o d e   -> "lecode"
//
// The problem guarantees there is always a letter to the left of every star,
// so the pop is safe.
//
// Complexity: time O(n), space O(n) for the stack.
public class Solution {

  public String removeStars(String s) {
    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      if (c == '*') {
        stack.pop();
      } else {
        stack.add(c);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (char c : stack) {
      sb.append(c);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.removeStars("leet**code")); // lecode
    System.out.println(solution.removeStars("erase*****"));  // (empty)
    System.out.println(solution.removeStars("abc"));         // abc
  }
}
