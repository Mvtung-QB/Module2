package B6_CauTrucDuLieuVaGiaiThuat.TrienKhaiArrayList;

public class MyListTest{
    public static void main(String[] args) {
        MyList<String>  myList= new MyList<>();
        myList.add(0,"A");
        myList.add(1,"B");
        myList.add(2,"C");
        myList.add(3,"D");
        myList.add(4,"E");
        myList.printList();
        System.out.println(myList.remove(3));
        myList.printList();
        myList.clear();
        System.out.println("+++++++sau khi clear");
        myList.printList();
    }
}
