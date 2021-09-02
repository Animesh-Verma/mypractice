package DataStructures.LinkedList.Implementation;

public class LinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public LinkedList insert(LinkedList list, int data) {
        Node newNode = new Node(data);

        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    public void deleteByKey(LinkedList list , int key){
        Node currentNode = list.head;
        Node prev = null;

        if(currentNode !=null && currentNode.data == key){
            list.head = currentNode.next;
            return;
        }

        while (currentNode != null && currentNode.data != key){
            prev = currentNode;
            currentNode = currentNode.next;
        }
        if(currentNode == null){
            return ;
        }
        prev.next = currentNode.next;
    }

    public void printList(LinkedList list){
        Node node = list.head;
        while (node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }
}
















