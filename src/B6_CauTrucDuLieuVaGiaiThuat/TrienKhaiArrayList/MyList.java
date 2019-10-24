package B6_CauTrucDuLieuVaGiaiThuat.TrienKhaiArrayList;

import org.omg.CORBA.OBJ_ADAPTER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MyList<E> {
    private int size = 0;
    private Object elements[];
    private static final int DEFAUL_CAPACITY = 10;

    public MyList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("lo so am");
        }
        this.elements = new Object[capacity];
    }

    public MyList() {
        this.elements = new Object[DEFAUL_CAPACITY];
    }

    public void ensureCapacity(int minCapacity) {
        int newsize = this.elements.length + minCapacity;
        this.elements = Arrays.copyOf(this.elements, newsize);
    }

    public void add(int index, E value) {
        if (index < 0) {
            throw new IllegalArgumentException("lo so am");
        }
        if (size == this.elements.length) {
            ensureCapacity(1);
        }
        Object temp;
        System.arraycopy(elements, index, elements, index + 1, (size - index));
        elements[index] = value;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("it is null");
        }
        Object temp = this.elements[index];
        int num = size - index - 1;
        if (num > 0) {
            System.arraycopy(elements, index + 1, elements, index, num);
            this.elements[size - 1] = null;
            size--;
        }
        return (E) temp;
    }

    public int size() {
        return this.size;
    }

    public MyList clone() {
        MyList<E> newArr = new MyList<>();
        newArr.elements = Arrays.copyOf(this.elements, this.size);
        return newArr;
    }

    public boolean contains(E value) {
        for (Object element : this.elements) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E value) {
        for (int i = 0; i < this.elements.length - 1; i++) {
            if (value.equals(this.elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E value) {
        if (size == this.elements.length) {
            ensureCapacity(1);
        }
        this.elements[size + 1] = value;
        return true;
    }

    public E get(int index) {
        if (index <0|| index>size){
            throw new IndexOutOfBoundsException("index invalid");
        }
        return (E) this.elements[index];
    }

    public void clear() {
        this.elements = Arrays.copyOf(this.elements, 0);
        this.size = 0;
    }

    public void printList() {
        for (Object e : this.elements) {
            System.out.print(e + " ");
        }
    }
}
