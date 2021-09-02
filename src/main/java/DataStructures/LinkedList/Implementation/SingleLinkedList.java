package DataStructures.LinkedList.Implementation;


public class SingleLinkedList {

    public static void main(String[] args){
     LinkedList linkedList = new LinkedList();
        linkedList.insert(linkedList,10);
        linkedList.insert(linkedList,20);
        linkedList.insert(linkedList,30);
        linkedList.insert(linkedList,40);
        linkedList.insert(linkedList,50);
        linkedList.insert(linkedList,60);
//
        linkedList.printList(linkedList);
        linkedList.deleteByKey(linkedList,30);
        linkedList.printList(linkedList);

//        //System.out.println(linkedList.read(6));
//        linkedList.rotate(linkedList.head,4);
//        linkedList.printList(linkedList);
    }
}
