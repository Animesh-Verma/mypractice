package pepcoding;

import java.util.HashMap;
import java.util.Stack;

public class NextSmallerElementArray {
    public static void main(String[] args) {
        int [] arr = {0};
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        stack.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(stack.empty()){
                stack.push(arr[i]);
                continue;
            }

            while(!stack.isEmpty() && stack.peek()>arr[i]){
                map.put(stack.peek(),arr[i]);
                stack.pop();
            }
            stack.push(arr[i]);
        }


        while (!stack.isEmpty()){
            map.put(stack.peek(),-1);
            stack.pop();
        }

        map.forEach((key,value) -> {
            System.out.println(key+"->"+value);
        });
    }
}
