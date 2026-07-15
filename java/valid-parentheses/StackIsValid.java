import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// LeetCode 20 — Valid Parentheses.
//
// Given a string of just the six bracket characters ()[]{}, decide whether
// every bracket is closed by the *right* kind of bracket in the *right*
// order. "()[]{}" is valid; "(]" and "([)]" are not.
//
// A stack is the natural fit: brackets nest, and the most recently opened
// bracket must be the first one closed — last-in, first-out. So we push
// every opening bracket, and when a closing bracket arrives we check it
// against whatever is on top of the stack:
//
//   - top + closer forms a matched pair ("()", "{}", "[]") -> pop it, that
//     pair is resolved.
//   - anything else (wrong type, or nothing to match against) -> the string
//     can't be valid.
//
// If, once we've read the whole string, the stack is empty, every opener
// found its partner in the correct order and the string is valid. Leftover
// openers on the stack mean something was never closed.
//
//   "([])"
//    (        push (           stack: (
//     [       push [           stack: ( [
//      ]      top [ + ] = []   pop     stack: (
//       )     top ( + ) = ()   pop     stack: (empty)   -> valid
public class StackIsValid {

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    char[] charArray = s.toCharArray();

    List<Character> openingParentheses = new ArrayList<>();
    openingParentheses.add('(');
    openingParentheses.add('{');
    openingParentheses.add('[');

    List<Character> closingParentheses = new ArrayList<>();
    closingParentheses.add(')');
    closingParentheses.add('}');
    closingParentheses.add(']');

    List<String> completeParentheses = new ArrayList<>();
    completeParentheses.add("()");
    completeParentheses.add("{}");
    completeParentheses.add("[]");

    for (char c : charArray) {
      if (openingParentheses.contains(c)) {
        stack.add(c);
      }
      if (closingParentheses.contains(c)) {
        // A closer with nothing to match against can never be valid; guard
        // the peek so ")" or "]" doesn't throw EmptyStackException.
        if (stack.isEmpty()) {
          return false;
        }
        Character peek = stack.peek();
        String x = "" + peek + c;
        if (completeParentheses.contains(x)) {
          stack.pop();
        }
      }
    }
    return stack.empty();
  }

  public static void main(String[] args) {
    StackIsValid solution = new StackIsValid();

    System.out.println(solution.isValid("()"));       // true
    System.out.println(solution.isValid("()[]{}"));   // true
    System.out.println(solution.isValid("(]"));       // false
    System.out.println(solution.isValid("([])"));     // true
    System.out.println(solution.isValid("([)]"));     // false
    System.out.println(solution.isValid("]"));        // false
    System.out.println(solution.isValid(""));         // true
  }
}
