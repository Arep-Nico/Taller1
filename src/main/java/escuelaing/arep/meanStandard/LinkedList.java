package escuelaing.arep.meanStandard;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* 
* @author Nicolas Cardenas
* @version: 22/01/2019
*/
class LinkedList<T> implements List<T>, Iterable<T>, Serializable, Collection<T>, Iterator<T> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Head head;
    private int size;
    private Node now;

    /* 
    * Constructor de una LinkedList
    */
    LinkedList() {
        this.head = new Head(null, null);
        this.now = head.getFirst();
        this.size = 0;
    }

    /*
     * Agregar un elemento a la lista
     * @param T dat
     * @return boolean
     */
    @Override
    public boolean add(T data) {
        Node node = new Node(data, null);
        
        if (size == 0) {
            head.setFirst(node);
            head.setLast(node);
            now = head.getFirst();
            size += 1;
            return true;
        } else if (size > 0) {
            Node last = head.getLast();
            last.setNext(node);
            head.setLast(node);
            size += 1;
            return true;
        }
        return false;
    }

    /*
     * Agregar un elemento a la lista
     * 
     * @param T dat elemento a agregar
     * @param index posicion donde de insertaran el elemento
     * 
     */
    @Override
    public void add(int index, T element) {
        Node node = new Node(element, null);
        Node temp = head.getFirst();

        if (index < 0 || index > this.size) {
            throw new Error("out of range");
        } else if (index == 0) {
            node.setNext(temp);
            head.setFirst(node);
            now = head.getFirst();
        } else {
            for (int i = 0; i < size; i++) {
                Node temp2 = temp.getNext();
                if ( (i+1) == index) {
                    Node dat = new Node(element, temp2);
                    temp.setNext(dat);
                }
                temp = temp2;
            }
        }
        size += 1;
    }

    /*
     * Agregar todos los elementos de la coleccion
     * 
     * @param C coleccion de elementos
     * 
     * @param index posicion donde de insertaran los elementos
     * 
     * @return boolean
     */
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {

        int temp = index;

        for(T e : c ){
            this.add(temp, e);
            temp += 1;
        }
        size += temp;
        return false;
    }

    /*
     * Obtener el elemento de la posicion
     * 
     * @param index posicion del elemento
     * 
     * @return T element
     */
    @Override
    public T get(int index) {
        int i = 0;
        Node res = head.getFirst();
        while (i != index ) {
            res = res.getNext();
            i ++;
        }
        return res.getData();
    }

    /*
     * Obtener el indice de un objeto
     * 
     * @param objeto para buscar en la lista
     * 
     * @return index posicion del elemento
     */
    @Override
    public int indexOf(Object o) {
        int res = -1;
        int i = 0;
        Node temp = head.getFirst();
        while (i < size + 1) {
            if (temp.getData().equals(o)) {
                temp = temp.getNext();
                return i;
            }
            i++;
        }
        return res;
    }

    @Override
    public int lastIndexOf(Object o) {
        int res = -1;
        int i = 0;
        Node temp = head.getFirst();
        while (i < size + 1) {
            if (temp.getData().equals(o)) {
                temp = temp.getNext();
                res = i;
            }
            i++;
        }
        return res;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public T remove(int index) {
        if (0 < index && index < size)
            throw new Error("Out of range");
        int i = 0;
        Node temp = head.getFirst();
        while (i != index -1) {
            temp = temp.getNext();
            i++;
        }
        Node res = temp.getNext();
        temp.setNext(res.getNext());
        size -=1 ;
        return res.getData();
    }

    @Override
    public T set(int index, T element) {
        Node temp = head.getFirst();
        int i = 0;
        while (i != index ) {
            temp = temp.getNext();
            i++;
        }
        T res = temp.getData();
        temp.setData(element);
        return res;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean res = true;
        for (T e : c) {
            res &= add(e);
        }
        return res;
    }

    @Override
    public void clear() {
        head.setFirst(null);
        head.setLast(null);
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return head.getFirst().equals(null);
    }

    @Override
    public Iterator<T> iterator() {
        return this;
    }
    
    @Override
    public boolean hasNext() {
        if (now != null && now.getNext() != null)
            return true;
        return false;
    }

    @Override
    public T next() {
        T data = now.getData();
        now = now.getNext();
        return data;
    }

    @Override
    public boolean remove(Object o) {
        boolean res = false;
        int i = indexOf(o);
        if (i != -1) {
            res = true;
            remove(i);
            size -= 1;
        }        
        return res;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] res = new Object[size];
        for (int i = 0; i < res.length; i++) {
            res[i] = get(i);
        }
        return res;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /**
     * Node class
     */
    private class Node {

        private T data;
        private Node next;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        /* 
        *
        */
        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    /**
     * Head
     */
    private class Head {
        private Node first;
        private Node last;

        Head(Node fisrt, Node last) {
            this.first = fisrt;
            this.last = last;
        }

        public Node getFirst() {
            return first;
        }

        public void setFirst(Node first) {
            this.first = first;
        }

        public Node getLast() {
            return last;
        }

        public void setLast(Node last) {
            this.last = last;
        }
    }
}