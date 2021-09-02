package DataStructures.stacks;

import java.util.Arrays;
import java.util.Scanner;

public class Stack {
    int size = 10;
    int[] arr = new int[size];
    int top = -1;

    public void push(int ele) {
        if (top == size - 1) {
            System.out.println("Stack overflow");
        }
        top++;
        arr[top] = ele;
    }

    public void pop() {
        if (top < 0) {
            System.out.println("Underflow");
        }
        System.out.println(arr[top] + "is removed");
        top--;
    }

    public void peek() {
        System.out.println(arr[top] + "is peek");
    }

    public void printStack() {
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr,0,top)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        int n = 0;
        do {
            n = sc.nextInt();
            switch (n) {
                case 1:
                    int m = sc.nextInt();
                    stack.push(m);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.peek();
                    break;
                case 4:stack.printStack();
            }
        } while (n != 5);
    }

//    int top = -1;
//    int maxsize = 10;
//    int[] arr = new int[maxsize];
//
//    public boolean isEmpty() {
//        return (top < 0);
//    }
//
//    public boolean push(Scanner sc) {
//        if (top == maxsize - 1) {
//            System.out.println("Overflow");
//            return false;
//        } else {
//            System.out.println("Enter value");
//            top++;
//            int i= sc.nextInt();
//            arr[top] = i;
//            System.out.println("Item pushed");
//            return true;
//        }
//    }
//
//    public boolean pop() {
//        if (top == -1) {
//            System.out.println("Underflow");
//            return false;
//        } else {
//            top--;
//            System.out.println("Item poped");
//            return true;
//        }
//    }
//
//    public void display() {
//        if(!isEmpty()) {
//            for (int i = top; i > -1; i--) {
//                System.out.print(" " + arr[i]);
//            }
//            return;
//        }
//        System.out.println("Empty Array");
//    }

}

//    public static void main(String[] args) {
//        Stack stack = new Stack();
//        Scanner sc = new Scanner(System.in);
//        int i;
//        System.out.println("1. Push");
//        System.out.println("2. Pop");
//        System.out.println("3. Display");
//        System.out.println("Enter choice");
//
//        do {
//            i = sc.nextInt();
//            switch (i) {
//                case 1:
//                    stack.push(sc);
//                    break;
//                case 2:
//                    stack.pop();
//                    break;
//                case 3:
//                    stack.display();
//                    break;
//            }
//
//        } while (i != 4);
//    }