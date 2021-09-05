package DataStructures.LinkedList.Implementation;

public class LinkedList {
    Node head;

    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            next = null;
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

    public void insertAfter(LinkedList list , int after , int data){
        Node currNode = list.head;
        while (currNode != null){
            if(currNode.data == after){
                Node newNode = new Node(data);
                newNode.next = currNode.next;
                currNode.next = newNode;
                return;
            }
            currNode = currNode.next;
        }
    }

    public void deleteByKey(LinkedList list , int data){
        Node currNode = list.head;
        while(currNode.next != null){
            if(currNode.next.data == data){
                currNode.next = currNode.next.next;
                return;
            }
            currNode = currNode.next;
        }
    }

    public void printList(LinkedList list){
        Node currNode = list.head;
        while (currNode != null){
            System.out.println(currNode.data);
            currNode = currNode.next;
        }
    }
}
















