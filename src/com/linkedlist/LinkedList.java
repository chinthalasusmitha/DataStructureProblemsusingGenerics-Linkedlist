package com.linkedlist;


public class LinkedList<T> {
    Node<T> head;
//     * Method for Appending the specified element to the end of this list.

    public void add(T value) {
        Node<T> newNode = new Node<T>();
        newNode.data = value;
        newNode.next = null;
        if (head == null) {
            head = newNode;
        } else {
            Node<T> last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }


//     * Method for printing the data inside the linkedlist.

    public void show() {
        Node<T> node = head;
        while (node.next != null) {
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);
    }

//     * Method for Inserting the specific element at the start of the list.

    public void addAtStart(T value) {

        Node<T> newNode = new Node<>();
        newNode.data = value;
        newNode.next = head;
        head = newNode;
        System.out.println(newNode.data);
    }

    public void addAtIndex(int index, T data) {
        Node<T> newNode = new Node<>();
        newNode.data = data;

        if (index == 0) {
            addAtStart(data);
        } else {
            Node<T> node = head;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            newNode.next = node.next;
            node.next = newNode;
        }
    }
        public void pop () {
            if (null != head) {
                Node<T> newHead = head.next;
                head = newHead;
            }

        }
    public void popLast() {
        Node<T> tail = head;
        Node<T> prevNode = head;
        while (tail.next != null) {
            prevNode = tail;
            tail = tail.next;
        }
        prevNode.next = null;
    }


    public static void main(String[] args) {
        LinkedList<Integer> numberList = new LinkedList<>();
        numberList.add(56);
        numberList.add(70);
        numberList.addAtIndex(1, 30);
        System.out.println("Before Deleting Last Element");
        numberList.show();
        System.out.println("After Deleting Last Element");
        numberList.popLast();
        numberList.show();    }
}

