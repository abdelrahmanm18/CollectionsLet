package CollectionsLet;

import CollectionsLet.ListLet.ArrayListLet;
import CollectionsLet.ListLet.ListLet;

public class Main {

    public static void main(String[] args) {

        ListLet<Integer> mylist = new ArrayListLet<>();
        mylist.addLast(10);
        mylist.addLast(2);
        if(mylist.add(25)){
            System.out.println("done");
        };

//        [60,50,30,10,2,25]

        mylist.addFirst(50);
        mylist.addFirst(60);
        System.out.println(mylist.getFirst());
        System.out.println(mylist.get(1));
        System.out.println(mylist.getLast());

        mylist.add(2, 30);
        System.out.println(mylist.get(2));

    }
}
