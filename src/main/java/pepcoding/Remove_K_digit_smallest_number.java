package pepcoding;

import java.util.Stack;

public class Remove_K_digit_smallest_number {
    public static void main(String[] args) {
        String str = "12";
        int k = 2;

        if(str.length() == k) {
            System.out.println(0);
            return;
        }
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            while (st.size() > 0 && k > 0 && st.peek() > ch) {
                st.pop();
                k--;
            }
            st.push(ch);
        }

        while (k > 0) {
            st.pop();
            k--;
        }

        char ans[] = new char[st.size()];
        int h = ans.length - 1;
        while (h >= 0) {
            ans[h--] = st.pop();
        }
        int d = 0;
        while (d < ans.length && ans[d] == '0') {
            d++;
        }
        StringBuilder sb = new StringBuilder();
        while (d < ans.length) {
            sb.append(ans[d++]);
        }
//        if (sb.length() == 0) {
//            sb.append('0');
//        }
        System.out.println(sb);
    }
}
