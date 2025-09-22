package CollectionsLet.ListLet;
import CollectionsLet.CollectionsLet;

public interface ListLet<E> extends CollectionsLet<E> {
     void addLast(E element);
     void addFirst(E element);
     boolean add(E element);
     void add(int index, E element);
     E removeFirst();
     E removeLast();
     E remove(int index);
     E getFirst();
     E getLast();
     E get(int index);
}
