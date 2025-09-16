package CollectionsLet.ListLet;

import CollectionsLet.CollectionsLet;

public interface ListLet<E> extends CollectionsLet<E> {

    public void addLast(E element);
    public void addFirst(E element);

    public boolean add(E element);

    public void add(int index, E element);

    public E removeFirst();

    public E removeLast();

    public E remove(int index);

    public E getFirst();
    public E getLast();

    public E get(int index);






}
