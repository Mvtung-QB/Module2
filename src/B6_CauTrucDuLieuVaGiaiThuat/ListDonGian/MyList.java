package B6_CauTrucDuLieuVaGiaiThuat.ListDonGian;

import java.util.Arrays;

public class MyList<E> {
    private int size =0;
    private int DEFAULT_CAPACITY = 10;
    private Object element[] ;

    public MyList() {
        this.element = new Object[DEFAULT_CAPACITY];
    }

    public void ensureCapa(){
        int newsize= element.length+1;
        element = Arrays.copyOf(element,newsize);
    }

    public void add(E obj){
        if (size == element.length) {
            ensureCapa();
        }
        this.element[this.size ++] = obj;
    }

    public E get(int index){
        if (index>= size || index <0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index );
        }
        return(E)element[index];
    }
}
