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

    public void addLast(E element) {
        Node temp = head;
        if (head == null) {
            head = temp;
        } else {
            for (int i = 0; i < numNodes - 1; i++) {
                temp = temp.next;
            }
            Node newNode = new Node(element);
            temp.next = newNode;
        }
        numNodes++;
    }

    public E remove(int index) {
        if (index < 0 || index > numNodes - 1) {
            throw new IndexOutOfBoundsException("index invalid");
        }
        Node temp = head;
        Node holder;
        // neu index bang 0 thi remove head
        if (index == 0) {
            head = head.next;
            numNodes--;
            return (E) temp.data;
        }
        // neu index bang numNode-1 thi remove phan tu cuoi cung
        if (index == numNodes - 1) {
            for (int i = 0; i < numNodes - 2; i++) {
                temp = temp.next;
            }
            holder = temp.next;
            temp.next = null;
            numNodes --;
            return (E) holder.data;
        }
        //remove o giua Linked
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = temp.next.next;
        numNodes --;
        return (E) holder.data;

    }

    public boolean remove(E object) {
        boolean isRemove = false;
        Node holder = head;
        Node temp = head;
        E a;
        for (int i = 0; i < numNodes - 1; i++) {
            if (object.equals(holder.data)) {
               a=  remove(i);
                numNodes--;
                isRemove = true;
            }
            temp = temp.next;
        }
        return isRemove;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
    }

}
