package CollectionsLet;

//import CollectionsLet.ListLet.ArrayListLet;
import CollectionsLet.ListLet.LinkedListLet;
import CollectionsLet.ListLet.ListLet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

       LinkedListLet<Integer> list = new LinkedListLet<>();
       list.addLast(5);
       list.addLast(6);
       list.addLast(7);
       list.addLast(8);

        System.out.println(list.get(2));
        System.out.println(list.size());
    }
}
