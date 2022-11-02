package com.linkedlist;


    public class LinkedList<T> {
        Node<T> head;

//         * Method for Appending the specified element to the end of this list.

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


//         * Method for printing the data inside the linked list.

        public void show() {
            Node<T> node = head;
            while (node.next != null) {
                System.out.println(node.data);
                node = node.next;
            }
            System.out.println(node.data);
        }

        public static void main(String[] args) {
            LinkedList<Integer> numberList = new LinkedList<>();
            numberList.add(56);
            numberList.add(30);
            numberList.add(70);
            numberList.show();
        }
    }

