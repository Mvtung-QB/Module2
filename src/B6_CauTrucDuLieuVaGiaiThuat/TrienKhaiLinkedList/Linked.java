package B6_CauTrucDuLieuVaGiaiThuat.TrienKhaiLinkedList;

import jdk.nashorn.internal.runtime.arrays.IteratorAction;

public class Linked<E> {
    private class Node {
        private Node next;
        private Object data;

        public Object getData() {
            return this.data;
        }

        public Node(Object data) {
            this.data = data;
        }
    }

    private Node head;
    private int numNodes = 0;

    public Linked() {
        this.head = null;
    }

    public void add(int index, E element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index invalid");
        }
        if (index == 0) {
            addFirt(element);
        } else {
            Node temp = this.head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node newNode = new Node(element);
            newNode.next = temp.next;
            temp.next = newNode;
            numNodes++;
        }
    }

    public void addFirt(E element) {
        Node temp = new Node(element);
        if (head == null) {
            head = temp;
        } else {
            temp.next = head;
            head = temp;
        }
        numNodes++;
    }

    public void addLast(E element){
        Node temp= head ;
        if (head== null){
            head= temp;
        }else {
            for (int i = 0; i <numNodes-1 ; i++) {
                temp=temp.next;
            }
            Node newNode = new Node(element);
            temp.next=newNode;
        }
        numNodes++;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
    }

}
