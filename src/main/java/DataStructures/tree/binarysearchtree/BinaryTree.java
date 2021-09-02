package DataStructures.tree.binarysearchtree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BinaryTree {
    Node root;

    private Node addRecursive(Node current , int value){
        if(current == null){
            return new Node(value);
        }

        if(value < current.value){
            current.left = addRecursive(current.left,value);
        }
        else if(value > current.value){
            current.right = addRecursive(current.right,value);
        }
        else {
            return current;
        }
        return current;
    }

    public void add(int value){
        root = addRecursive(root,value);
            System.out.println("Roost is - " + root.value);
    }

    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.add(6);
        binaryTree.add(4);
        binaryTree.add(8);
        binaryTree.add(3);
        binaryTree.add(5);
        binaryTree.add(7);
        binaryTree.add(9);

        System.out.print("\nBinary Tree InOrder: ");
        binaryTree.traverseTreeInOrder(binaryTree.root);

        System.out.print("\nBinary Tree PreOrder: ");
        binaryTree.traverseTreePreOrder(binaryTree.root);

        System.out.print("\nBinary Tree PostOrder: ");
        binaryTree.traverseTreePostOrder(binaryTree.root);

        System.out.print("\nBinary Tree Level Order: ");
        binaryTree.traverseLevelOrder();

    }

    public void traverseTreeInOrder(Node node) {
        if (node != null) {
            traverseTreeInOrder(node.left);
            System.out.print(" " + node.value);
            traverseTreeInOrder(node.right);
           // System.out.println();
        }
    }

    public void traverseTreePreOrder(Node node){
        if(node != null){
            System.out.println(" "+node.value);
            traverseTreePreOrder(node.left);
            traverseTreePreOrder(node.right);
        }
    }

    public void traverseTreePostOrder(Node node){
        if(node != null){
         traverseTreePostOrder(node.left);
         traverseTreePostOrder(node.right);
            System.out.println(node.value);
        }
    }

    public void traverseLevelOrder(){
        if(root == null){
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()){
            Node node = nodes.remove();
            System.out.println(" "+node.value);
            if(node.left != null){
                nodes.add(node.left);
            }
            if (node.right != null){
                nodes.add(node.right);
            }

        }
    }

    public static void order(String s){
        System.out.println("String - "+s);
    }

    public static void order(Object o){
        System.out.println("Object - "+o);
    }

}
