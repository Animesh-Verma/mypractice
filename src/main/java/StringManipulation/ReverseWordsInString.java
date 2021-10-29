package StringManipulation;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String st = " sky is the blue  ";
        String ans = "";
        int i, j;
        i = st.length() - 1;
        while (i >= 0) {
            while (i >= 0 && st.charAt(i) == ' ') {
                i--;
            }
            j = i;
            while (i >= 0 && st.charAt(i) != ' ') {
                i--;
            }
            if (i < 0)
                break;
            if (ans.isEmpty()) {
                ans = ans.concat(st.substring(i + 1, j + 1));
            } else {
                ans = ans.concat(" " + st.substring(i + 1, j + 1));
            }

        }
        System.out.println(ans);
    }
}
