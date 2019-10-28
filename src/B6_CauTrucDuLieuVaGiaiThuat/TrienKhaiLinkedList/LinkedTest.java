package B6_CauTrucDuLieuVaGiaiThuat.TrienKhaiLinkedList;

public class LinkedTest {
    public static void main(String[] args) {
        Linked<String> myLinked = new Linked<>();
        myLinked.add(0,"a");
        myLinked.add(1,"b");
        myLinked.add(2,"c");
        myLinked.add(3,"d");
        myLinked.printList();
        System.out.println();
        System.out.println(myLinked.remove("d"));
        myLinked.printList();
    }
}
