package B6_CauTrucDuLieuVaGiaiThuat.TrienKhaiArrayList;

import java.util.ArrayList;

public class MyListTest{
    public static void main(String[] args) {
        MyList<String>  myList= new MyList<>();
        myList.add(0,"A");
        myList.add(1,"B");
        myList.add(2,"C");
        myList.add(3,"D");
        myList.add(4,"E");
        myList.add(2,"K");
        myList.printList();
        System.out.println("+++++++sau khi ");
        System.out.println(myList.indexOf(""));
//        myList.clear();
//        System.out.println("+++++++sau khi clear");
//        myList.printList();
    }
}
