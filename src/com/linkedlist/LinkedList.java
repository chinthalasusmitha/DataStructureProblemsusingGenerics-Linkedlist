package com.linkedlist;


public class LinkedList<T> {
    Node<T> head;
//      Method for Appending the specified element to the end of this list.

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


//      Method for printing the data inside the linked list.

    public void show() {
        Node<T> node = head;
        while (node.next != null) {
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);
    }

//      Method for Inserting the specific element at the start of the list.

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

    public void pop() {
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

    public int searchByValue(T value) {
        Node<T> currNode = head;
        int index = 0;
        if (null != currNode) {
            while ((null != currNode.next) || (null != currNode.data)) {
                if (currNode.data == value) {
                    break;
                }
                currNode = currNode.next;
                if (null == currNode) {
                    return -1;
                }
                index++;
            }
        }
        return index;
    }
    public void searchAndInsert(T searchValue, T InsertValue){
        int index = searchByValue(searchValue) + 1;
        addAtIndex(index, InsertValue);
    }
//    Removes the element at the specified position in this list

    public void popAtIndex(int index) {
        if (index == 0) {
            pop();
        } else {
            Node<T> prevNode = head;
            Node<T> currNode = head;
            for (int i = 0; i < index; i++) {
                prevNode = currNode;
                currNode = currNode.next;
            }
            prevNode.next = currNode.next;
        }
    }

    public void searchValueAndDelete (T searchValue){
        int index = searchByValue(searchValue);
        popAtIndex(index);
    }

    public static void main(String[] args) {
        LinkedList<Integer> numberList = new LinkedList<>();
        numberList.add(56);
        numberList.add(70);
        numberList.addAtIndex(1, 30);
        numberList.show();
        String searchResult = (numberList.searchByValue(30) == -1) ? "value not found in the list" :
                "value found at index " + numberList.searchByValue(30);
        System.out.println(searchResult);
        System.out.println("After Inserting");
        numberList.searchAndInsert(30,40);
        numberList.show();
        System.out.println();
        numberList.searchValueAndDelete(40);
        System.out.println("After Deleting");
        numberList.show();
//        System.out.println("Size of list is : " + numberList.size());
    }
}

