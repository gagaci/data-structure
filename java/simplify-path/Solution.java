import java.util.ArrayDeque;
import java.util.Deque;

// LeetCode 71 — Simplify Path.
//
// Given an absolute Unix-style path, collapse it to its canonical form:
//
//   - "."   means "stay in the current directory"        -> ignore it.
//   - ".."  means "go up to the parent directory"        -> drop the last folder.
//   - "//"  (or any run of slashes) collapses to a single separator.
//   - the result never has a trailing slash (except the root "/").
//
// A deque used as a stack captures this perfectly. Split the path on "/", which
// hands us the path components (plus some empty strings from leading/repeated
// slashes). Then walk the components once:
//
//   - ""  or "."  -> skip, they carry no movement.
//   - ".."        -> pollLast(): pop the most recent folder if there is one.
//                    pollLast() returns null on an empty deque instead of
//                    throwing, so "/../" harmlessly resolves to "/".
//   - anything else (a real folder name) -> offerLast(): push it.
//
// Joining what's left with "/" and prefixing a "/" gives the canonical path.
//
//   "/a/./b/../../c/"  split -> [a, ., b, .., .., c]
//    a    push          stack: [a]
//    .    skip          stack: [a]
//    b    push          stack: [a, b]
//    ..   pop b         stack: [a]
//    ..   pop a         stack: []
//    c    push          stack: [c]        -> "/c"
//
// Note: Java's split drops trailing empty strings but keeps a leading one, so
// "/home/" becomes ["", "home"] and "/" becomes a zero-length array. The empty
// strings simply get skipped by the ""-guard above.
//
// Complexity: time O(n), space O(n) for the deque.
public class Solution {

  public String simplifyPath(String path) {
    Deque<String> stack = new ArrayDeque<>();
    String[] components = path.split("/"); // e.g. /home/foo -> ["", home, foo]

    for (String component : components) {
      if (component.isEmpty() || component.equals(".")) {
        continue;
      }

      if (component.equals("..")) { // ".." goes up to the parent folder
        stack.pollLast();
      } else {
        stack.offerLast(component);
      }
    }

    return "/" + String.join("/", stack);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.simplifyPath("/a/./b/../../c/")); // /c
    System.out.println(solution.simplifyPath("/home/"));          // /home
    System.out.println(solution.simplifyPath("/home//foo/"));     // /home/foo
    System.out.println(solution.simplifyPath("/../"));            // /
    System.out.println(solution.simplifyPath("/..."));            // /...
  }
}
