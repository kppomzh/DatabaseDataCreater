package Utils;

import java.util.*;

public class CircularLinkedList<E> implements List<E> {
    transient int size=0;
    transient Node<E> first;
    transient Node<E> last;
    transient Node<E> start=null;
    public CircularLinkedList(){
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first!=null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(e);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        newNode.next=first;
        size++;
//        modCount++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        remove(indexOf(o));
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addAll(size,c);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        Node<E> pred, succ;
        if (index == size) {
            succ = null;
            pred = last;
        } else {
            succ = getIndexNode(index);
            pred = succ.prev;
        }

        for (Object o : c) {
            @SuppressWarnings("unchecked") E e = (E) o;
            Node<E> newNode = new Node<>(e);
            newNode.prev=pred;
            if (pred == null)
                first = newNode;
            else
                pred.next = newNode;
            pred = newNode;
        }

        return true;
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
    public void clear() {

    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return getIndexNode(index).item;
    }

    @Override
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> Return=getIndexNode(index);
        E e=Return.item;
        Return.item=element;
        return e;
    }

    @Override
    public void add(int index, E element) {
        checkElementIndex(index);
        Node<E> add=getIndexNode(index);
        Node<E> newnode=new Node<>(element);
        newnode.prev=add.prev;
        newnode.next=add;
        add.prev=newnode;
    }

    private Node<E> getIndexNode(int index){
        Node<E> Return=first;
        for(int loop=0;loop<index;loop++)
        {
            Return=Return.next;
        }
        return Return;
    }

    @Override
    public E remove(int index) {
        checkElementIndex(index);
        Node<E> remove=getIndexNode(index);
        remove.next.prev=remove.prev;
        remove.prev.next=remove.next;
        return remove.item;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size;
        if (o == null) {
            for (Node<E> x = last; x != null; x = x.prev) {
                index--;
                if (x.item == null)
                    return index;
            }
        } else {
            for (Node<E> x = last; x != null; x = x.prev) {
                index--;
                if (o.equals(x.item))
                    return index;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E element) {
            this.item = element;
        }

        void setnext(Node<E> next){
            this.next = next;
        }
        void setprev(Node<E> prev){
            this.prev = prev;
        }
    }

    private void checkElementIndex(int index){
        if(index < 0 && index >= size)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
    }

    public E getNext(){
        if(start==null){
            start=first;
        }
        E item=start.item;
        start=start.next;
        return item;
    }
}
