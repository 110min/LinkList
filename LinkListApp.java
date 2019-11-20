/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linklistapp;

/**
 *
 * @author 174110J
 */
public class LinkListApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList l1 = new LinkedList();
        
        l1.insertFirst(9);
        l1.insertFirst(7);
        l1.insertFirst(21);
        l1.insertFirst(5);
        l1.displayList();
        l1.deleteFirst();
        l1.displayList();
        l1.delete(2);
        l1.displayList();
        Node n=l1.find(2);
        n.display();
                
    }

}

class Node {

    int item;
    Node next;

    public Node(int item) {
        this.item = item;
        this.next = null;
    }

    public void display() {
        System.out.print(this.item + " ");
    }
}

class LinkedList {

    private Node head;

    public LinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        //return (head == null);
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertFirst(int i) {
        //………
        Node n = new Node(i);
        n.next = head;
        head = n;

    }

    public Node deleteFirst() {
        if (isEmpty()) {
            System.out.println("Linkedlist is empty nothing to delete");
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null; //return krana kenata link list 1ta access karanna beri wenna
        return temp;
    }

    public void displayList() {
        if (isEmpty()) {
            System.out.println("Linkedlist is empty nothing to print");
            return;
        }
        Node current = head;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }

    public Node find(int key) {
        if (isEmpty()) {
            System.out.println("linked list is empty nothimg to find");
            return null;
        }
        int i = 1;
        Node current = head;
        while (current != null) {
            //i<1 unoth out of bound kiyanna if 1k danna puluwan
            if (i == key) {
                return current;
            }
            current = current.next;
            i++;
        }
        System.out.println("key is out of the linkedlist");
        return null;
    }

    public void delete(int key) {
        if(isEmpty()){
            System.out.println("Linked list is empty. nothing to delete");
            return;
        }
        Node current, previous;
        current = head;
        previous = head;
        int i = 1;
        while (current != null) {
            if (i == key) {
                if (i == 1) {//if(current==head)
                    head = head.next;
                } else {
                    previous.next = current.next;
                }
                System.out.println(current.item + " was Deleted");
                return;
            }
            previous = current;
            current = current.next;
            i++;
        }
        System.out.println("No item found for the key. deletion terminated.");
    }

}
