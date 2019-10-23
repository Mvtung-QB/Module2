package B6_CauTrucDuLieuVaGiaiThuat.TrienKhaiArrayList;

import org.omg.CORBA.OBJ_ADAPTER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MyList<E> {
    private int size= 0;
    private Object elements[];
    private static final int DEFAUL_CAPACITY = 10;

    public MyList(int capacity) {
        this.elements= new Object[capacity];
    }

    public MyList() {
        this.elements= new Object[DEFAUL_CAPACITY];
    }

    public void ensureCapacity(int minCapacity){
        int newsize= this.elements.length+minCapacity;
        this.elements = Arrays.copyOf(this.elements,newsize);
    }

    public void add(int index, E value){
        if (size == this.elements.length) {
            ensureCapacity(1);
        }
        Object temp;
        for (int i = index ; i <this.elements.length-1 ; i++) {
             temp = this.elements[i];
            this.elements[i]=value;
            this.elements[i+1]=temp;
            if (i == size)
                break;
        }
        size++;
    }

    public E remove(int index){
        Object temp = this.elements[index];
        for (int i = index ; i <this.elements.length-1 ; i++) {
            this.elements[i]=this.elements[i+1];
        }
        size--;
        this.elements=Arrays.copyOf(this.elements,size);
        return (E ) temp;
    }

    public int size(){
        return this.size;
    }

    public Object clone(){
        Object [] newArr= new Object[this.size];
        newArr = Arrays.copyOf(this.elements,this.size);
        return newArr;
    }
    public boolean contains(E value){
        for (Object element: this.elements ) {
            if (element == value){
                return true;
            }
        }
        return false;
    }

    public int indexOf(E value){
        for (int i = 0; i <this.elements.length ; i++) {
            if (this.elements[i] == value){
                return i;
            }
        }
        return -1;
    }

    public boolean add(E value){
        if (size == this.elements.length) {
            ensureCapacity(1);
        }
        this.elements[size+1]=value;
        return true;
    }
    
    public E get(int index){
        return (E) this.elements[index];
    }

    public void clear(){
        this.elements= Arrays.copyOf(this.elements,0);
        this.size=0;
    }
    public void printList(){
        for (Object e: this.elements ) {
            System.out.println(e);
        }
    }
}
