package escuelaing.arep.meanStandard;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class LinkedList<T> implements List<T> {

    private Head head;
    private int size;

    LinkedList() {
        this.head = new Head(null, null);
        this.size = 0;
    }

    @Override
    public boolean add(T data) {
        Node node = new Node(data, null);
        
        if (size == 0) {
            head.setFirst(node);
            head.setLast(node);
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

    @Override
    public void add(int index, T element) {
        Node node = new Node(element, null);
        Node temp = head.getFirst();

        if (index < 0 || index > this.size) {
            throw new Error("out of range");
        } else if (index == 0) {
            node.setNext(temp);
            head.setFirst(node);
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

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {

        int temp = index;

        for(T e : c ){
            this.add(temp, e);
            temp += 1;
        }

        /*Iterator elements = c.iterator();
        
        if (index < 0 || index > this.size) {
            throw new Error("out of range");
        } else if (index == 0) {
            Node tempFirst = head.getFirst();
            Node newFirst = new Node( (T) elements.next(), null);
            Node tempLast = newFirst;

            head.setFirst(newFirst);

            while (elements.hasNext()) {
                Node node = new Node( (T) elements.next(), null);
                tempLast.setNext(node);
                tempLast = node;
            }
            return true;
        }*/
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
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
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public void clear() {

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
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
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
        return 0;
    }

    @Override
    public Object[] toArray() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /**
     * Node
     */
    private class Node {

        private T data;
        private Node next;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

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