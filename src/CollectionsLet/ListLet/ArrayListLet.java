package CollectionsLet.ListLet;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ArrayListLet<E> implements ListLet<E> {
    private static final int START_SIZE = 10;
    private static final int RFACTOR = 2;
    private int size;
    private E[] elements;

    @SuppressWarnings("unchecked")
    public ArrayListLet(){
        elements = (E[]) new Object[START_SIZE];
        size = 0;
    }
    public int size() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    //helper method to check if the capacity is around 80%
    private boolean checkSizeUp(){
        return (float) size() / elements.length >= 0.8;
    }

    //helper method to check if the capacity is less than 25%
    private boolean checkSizeDown(){
        return size() <= elements.length / 4;
    }


    @SuppressWarnings("unchecked")
    private void resize(int capacity){
        E[] array = (E []) new Object[capacity];
        System.arraycopy(elements,0,array,0,size);
        elements = array;
    }

    @Override
    public void addFirst(E newElement) {
        if(checkSizeUp()){
            resize(elements.length * RFACTOR);
        }

        for (int i = size; i > 0; i--){
            elements[i] = elements[i - 1];
        }
        elements[0] = newElement;
        size++;
    }

    @Override
    public void addLast(E element) {
        if(checkSizeUp()){
            resize(elements.length * RFACTOR);
        }
        elements[size] = element;
        size++;
    }

    @Override
    public boolean add(E element){
        addLast(element);
        return true;
    }

    @Override
    public void add(int index, E element) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if(checkSizeUp()){
            resize(elements.length * RFACTOR);
        }

        for(int i = size; i > index ;i--){
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    @Override
    public E getFirst(){
        if(isEmpty()){
            throw new NoSuchElementException("Cannot get element from empty list");
        }
        return elements[0];
    }

    @Override
    public E getLast() {
        if(isEmpty()){
            throw new NoSuchElementException("Cannot get element from empty list");
        }
        return elements[size - 1];
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
        // zero indexed
        return elements[index];
    }
    @Override
    public E removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException("Cannot remove from empty list");
        }

        if(checkSizeDown()){
            resize(elements.length / RFACTOR);
        }

       E element = elements[0];
       for(int i = 0; i < size - 1; i++){
           elements[i] = elements[i + 1];
       }
       elements[size - 1] = null;
       size--;
       return element;
    }

    @Override
    public E removeLast() {
        if(isEmpty()){
            throw new NoSuchElementException("Cannot remove from empty list");
        }

        if(checkSizeDown()){
            resize(elements.length / RFACTOR);
        }
        E element = elements[size - 1];
        elements[size - 1] = null;
        size--;
        return element;
    }

    @Override
    public E remove(int index) {

        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }


        if(checkSizeDown()){
            resize(elements.length / RFACTOR);
        }

        E element = get(index);
        for(int i = index; i < size - 1; i++){
            elements[i] = elements[i+1];
        }
        elements[size - 1] = null;
        size--;

        return element;
    }
}
