package ru.gb.LinkedList;


import ru.gb.singlyLinkedList.ListElement;

public class LinkedList {
    private LinkedListElement head;       // указатель на первый элемент
    private LinkedListElement tail;
    private int length = 0;

    public void addFront (int data){
        LinkedListElement a = new LinkedListElement();
        a.data = data;
        length++;
        if (head == null) {
            head = a;
            tail = a;
        } else {

            a.next = head;
            head.previous = a;
            head = a;
        }
    }
    public void addBack(int data){
        LinkedListElement a = new LinkedListElement();
        a.data = data;
        if (tail == null){
            head = a;
            tail = a;
        } else {
            tail.next = a;
            a.previous = tail;
            tail = a;

        }
        length ++;
    }
    public void printList()                //печать списка
    {
        LinkedListElement t = head;       //получаем ссылку на первый элемент
        System.out.println('\n');
        while (t != null)           //пока элемент существуе
        {
            System.out.print(t.data + " "); //печатаем его данные
            t = t.next;                     //и переключаемся на следующий
        }
    }
    public void remove(int data){
        if (head.data == data){
            head.next.previous = null;
            head = head.next;
            return;
        }
        if (tail.data == data){
            tail.previous.next = null;
            tail = tail.previous;
            return;
        }
        LinkedListElement t = head.next;

        while (t.next != null) {
            if (t.data == data) {
                t.previous.next = t.next;
                t.next.previous = t.previous;
                length--;
                return;
            }
            t = t.next;
        }
    }
    public void removeByPosition(int position){
        if (position > length || position < 1){
            System.out.println("Position is larger than array length or smaller 1. Error");
            return;
        }
        if (position == 1){
            head = head.next;
            length --;
            return;
        }
        if (position == length){
            tail = tail.previous;
            tail.next = null;
            length --;
            return;
        }
        int currentPosition = 2;
        LinkedListElement t = head.next;
        while (currentPosition<= position) {
            if (currentPosition == position){
                t.previous.next = t.next;
                t.next.previous = t.previous;
                length --;
                break;
            } else {
                t = t.next;
                currentPosition ++;
            }

        }
    }

    public int getLength() {
        return length;
    }
}
