package ru.gb;

import ru.gb.LinkedList.LinkedList;
import ru.gb.singlyLinkedList.SinglyLinkedList;

public class Main {

    public static void main(String[] args) {
        SinglyLinkedList array = new SinglyLinkedList();
        array.addFront(1);
        array.addBack(3);
        array.addFront(5);
        //array.printList();

        LinkedList linkedList = new LinkedList();
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);
        linkedList.addFront(4);
        linkedList.addBack(0);

        linkedList.printList();
        System.out.println("\n длина массива " +  linkedList.getLength());
        linkedList.removeByPosition(8);
        linkedList.printList();

        System.out.println("\n длина массива " + linkedList.getLength());
    }
}
