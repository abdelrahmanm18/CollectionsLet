package CollectionsLet.ListLet;

import java.util.NoSuchElementException;

public class LinkedListLet<E> implements ListLet<E>{
    private class Node{
        public E value;
        public Node next;
        public Node prev;

        public Node(E value, Node next, Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
    private int size;
    private Node sentinelFront;
    private Node sentinelBack;

    public LinkedListLet(){
        size = 0;
        sentinelFront = new Node(null, null, null);
        sentinelBack = new Node(null, null, null);
        sentinelFront.next = sentinelBack;
        sentinelBack.prev = sentinelFront;
    }


    public LinkedListLet(E item){
        Node node = new Node(item, null,null);
        sentinelFront = new Node(null, node, null);
        sentinelBack = new Node(null, null, node);
        node.prev = sentinelFront;
        node.next = sentinelBack;
        size = 1;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }


    @Override
    public void addFirst(E newElement){
        Node oldFirst = sentinelFront.next;
        sentinelFront.next = new Node(newElement, sentinelFront.next, sentinelFront);
        oldFirst.prev = sentinelFront.next;
        size++;
    }

    @Override
    public void addLast(E newElement){
        Node oldLast = sentinelBack.prev;
        sentinelBack.prev = new Node(newElement, sentinelBack, sentinelBack.prev);
        oldLast.next = sentinelBack.prev;
        size++;
    }

    @Override
    public boolean add(E element){
        addLast(element);
        return true;
    }

    @Override
    public void add(int index, E element){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        int i = 0;
        Node current = sentinelFront.next;
        while (i < index && current != null){
            current = current.next;
            i++;
        }
        Node node = new Node(element, current, current.prev);
        current.prev.next = node;
        current.prev = node;
        size++;
    }

    @Override
    public E removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException("Cannot remove element from empty list");
        }

        E element = sentinelFront.next.value;
        sentinelFront.next.next.prev = sentinelFront;
        sentinelFront.next = sentinelFront.next.next;
        return element;
    }

    @Override
    public E removeLast(){
        if(isEmpty()){
            throw new NoSuchElementException("Cannot remove element from empty list");
        }

        E element = sentinelBack.prev.value;
        sentinelBack.prev.prev.next = sentinelBack;
        sentinelBack.prev = sentinelBack.prev.prev;
        size--;
        return element;
    }

    @Override
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        int i = 0;
        Node current = sentinelFront.next;
        while (i < index && current != null){
            current = current.next;
            i++;
        }
        E element = current.value;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return element;
    }

    @Override
    public E getFirst(){
        if(isEmpty()){
            throw new NoSuchElementException("Cannot get first element from empty list");
        }

        return sentinelFront.next.value;
    }

    @Override
    public E getLast(){
        if(isEmpty()){
            throw new NoSuchElementException("Cannot get last element from empty list");
        }

        return sentinelBack.prev.value;
    }

    @Override
    public E get(int index){

        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        int i = 0;
        Node current = sentinelFront.next;
        while (i < index && current != null){
            current = current.next;
            i++;
        }

        return current.value;
    }


}
