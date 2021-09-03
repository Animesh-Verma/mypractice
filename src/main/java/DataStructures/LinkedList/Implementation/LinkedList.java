package DataStructures.LinkedList.Implementation;

public class LinkedList {
    Node head;

    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }

    public LinkedList insert(LinkedList list , int data){
        Node newNode = new Node(data);
        newNode.next = null;
        if(list.head == null){
            list.head = newNode;
        }
        else{
            Node last = list.head;
            while (last.next != null){
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    public void printList(LinkedList list){
        Node currNode = list.head;
    }
}
















