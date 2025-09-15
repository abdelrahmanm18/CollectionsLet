package CollectionsLet.ListLet;

import java.util.ArrayList;
import java.util.List;

public class ArrayListLet<E> implements ListLet<E> {
    private static final int START_SIZE = 10;
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
        return size > 0;
    }

//    private void resizeUp();
//private void resizeDown();
    @Override
    public void addFirst(E newElement) {
        for (int i = size; i > 0; i--){
            elements[i] = elements[i - 1];
        }
        elements[0] = newElement;
        size++;
    }

    @Override
    public E getFirst(){
        return elements[0];
    }

    @Override
    public void addLast(E element) {
        elements[size] = element;
        size++;
    }

    @Override
    public E getLast() {
        return elements[size - 1];
    }
    @Override
    public E removeFirst(){
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
        E element = elements[size - 1];
        elements[size - 1] = null;
        return element;
    }

    @Override
    public E get(int index) {
        // zero indexed
        return elements[index];
    }

    @Override
    public boolean add(E element){
        addLast(element);
        return true;
    }

    @Override
    public void add(int index, E element) {
        for(int i = size; i > index ;i--){
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }
}
