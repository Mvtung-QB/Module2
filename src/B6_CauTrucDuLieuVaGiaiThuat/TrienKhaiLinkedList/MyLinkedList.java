package B6_CauTrucDuLieuVaGiaiThuat.TrienKhaiLinkedList;

public class MyLinkedList {
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
    private int numNode;

    public MyLinkedList(Object data) {
        this.head = new Node(data);
    }

    public void add(int index, Object data) {
        Node temp = this.head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNode++;
    }

    public void addFirst(Object data) {
        Node temp = this.head;
        this.head = new Node(data);
        this.head.next = temp;
        numNode++;
    }

    public Node get(int index) {
        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Object getData(Node node) {
        return node.data;
    }

    public void printList() {
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
