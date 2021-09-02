package DataStructures.queues;

import java.util.Arrays;
import java.util.Scanner;

public class Queue {
    int len = 5;
    int count = 0;
    int front = 0, rear = -1;
    int[] arr = new int[len];

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == len;
    }

    public void enque(int i) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }
        rear = (rear + 1) % len;
        arr[rear] = i;
        count++;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("underflow");
            return;
        }
        front = (front + 1) % len;
        count--;
    }

    public void peek() {
        System.out.println(arr[front] + " is peak");
    }

    public void display() {
        for (int i = front; i <= rear; i++) {

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue queue = new Queue();
        int n = 0;
        do {
            n = sc.nextInt();
            switch (n) {
                case 1:
                    int m = sc.nextInt();
                    queue.enque(m);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.peek();
                    break;
                case 4:
                    queue.display();
            }
        } while (n != 5);
    }
}
