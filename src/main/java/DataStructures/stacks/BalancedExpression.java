package DataStructures.stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedExpression {
    Stack<Character> stack = new Stack<Character>();

    public void checkExpression(String st) {
        for (int i = 0; i < st.length(); i++) {
            switch (st.charAt(i)) {
                case '{':
                    stack.push('{');
                    break;
                case '(':
                    stack.push('(');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ']':
                    if (stack.peek() == '[') stack.pop();
                    break;
                case '}':
                    if (stack.peek() == '{') stack.pop();
                    break;
                case ')':
                    if (stack.peek() == '(') stack.pop();
                    break;
                default:
                    System.out.println("Not balanced");
            }
            System.out.println(stack);
        }
            System.out.println(stack.isEmpty() ? "Balanced" : "not balanced");
    }

    public static void main(String[] args){
        BalancedExpression be = new BalancedExpression();
        be.checkExpression("{{))");
    }
}
