import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyboardRow {

    // Every letter a–z lives on exactly one of the three keyboard rows.
    // "rows" is a lookup table: rows.charAt(letter - 'a') gives the row
    // number ('0', '1', or '2') for that letter. A word is keepable only
    // if all of its letters map to the same row.
    //
    //   row 0: q w e r t y u i o p
    //   row 1: a s d f g h j k l
    //   row 2: z x c v b n m
    //
    // For each word we read the row of its first letter as the "target",
    // then scan the rest of the letters — the moment one lands on a
    // different row the word is disqualified and we stop early.
    public String[] findWords(String[] words) {
        String rows = "12210111011122000010020202";
        List<String> result = new ArrayList<>();

        for (String word : words) {
            String lower = word.toLowerCase();
            char target = rows.charAt(lower.charAt(0) - 'a');
            boolean isValid = true;

            for (char c : lower.toCharArray()) {
                if (rows.charAt(c - 'a') != target) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) result.add(word);
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        KeyboardRow solution = new KeyboardRow();

        System.out.println(Arrays.toString(
            solution.findWords(new String[] {"Hello", "Alaska", "Dad", "Peace"})));  // [Alaska, Dad]
        System.out.println(Arrays.toString(
            solution.findWords(new String[] {"omk"})));                              // []
        System.out.println(Arrays.toString(
            solution.findWords(new String[] {"adsdf", "sfd"})));                     // [adsdf, sfd]
    }
}
