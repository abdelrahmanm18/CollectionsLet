//package TestLet;
//import org.junit.jupiter.api.*;
//import static org.junit.jupiter.api.Assertions.*;
//import CollectionsLet.ListLet.ArrayListLet;
//import CollectionsLet.ListLet.ListLet;
//
//
//public class ArrayListTest {
//    private ListLet<Integer> list;
//
//    @BeforeEach
//    void setUp(){
//        list = new ArrayListLet<>();
//    }
//
//    /** Check if you can create ArrayList with different parameterized types */
//    @Test
//    public void shouldAcceptDifferentTypes(){
//        ListLet<String>  l1 = new ArrayListLet<>();
//        ListLet<Double>  l2 = new ArrayListLet<>();
//        ListLet<Boolean> l3 = new ArrayListLet<>();
//
//        l1.addFirst("string");
//        l2.addFirst(3.14159);
//        l3.addFirst(true);
//
//        String s = l1.removeFirst();
//        double d = l2.removeFirst();
//        boolean b = l3.removeFirst();
//    }
//
//
//    @Test
//    void shouldReturnTrueWhenListIsEmptyAfterInitialization(){
//        assertTrue(list.isEmpty(),"should return true after creating list");
//    }
//
//    @Test
//    void shouldReturnTrueWhenListIsEmpty(){
//        list.add(10);
//        list.add(20);
//        list.removeLast();
//        list.removeLast();
//        assertTrue(list.isEmpty(), "should return true if the list is empty");
//    }
//
//    @Test
//    void shouldReturnZeroForEmptyList(){
//        assertEquals(0, list.size(), "should return the correct size");
//    }
//
//    @Test
//    void shouldReturnCorrectListSizeForSmallInput(){
//        list.add(10);
//        list.add(20);
//        list.add(50);
//        assertEquals(3, list.size(), "should return the correct size for small inputs");
//    }
//
//    @Test
//    void shouldReturnCorrectListSizeForLargeInput(){
//        for(int i = 0; i < 10000;i++){
//            list.addLast(i);
//        }
//        assertEquals(10000, list.size(), "should return the correct size for large inputs");
//    }
//
//    @Test
//    void shouldReturnCorrectSizeAfterRemoval(){
//        for(int i = 0; i < 10000;i++){
//            list.addLast(i);
//        }
//
//        for(int i = 0; i < 5000;i++){
//            list.removeLast();
//        }
//        assertEquals(5000, list.size(), "should return the correct size after removing");
//
//    }
//
//
//    @Test
//    void shouldReturnCorrectSizeAtResizeTrigger(){
//        for(int i = 0; i < 7;i++){
//            list.add(i);
//        }
//        assertEquals(7, list.size(), "should return the correct size before resizing");
//
//        //resize when list size is around 80%, so when we add the eighth element
//        list.add(8);
//        assertEquals(8, list.size(), "should return the correct size after resizing");
//
//    }
//
//    @Test
//    void shouldReturnCorrectElementAfterRemovingAtIndex(){
//        for(int i = 0; i < 25;i++){
//            list.add(i);
//        }
//        //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
//        int element = list.remove(12);
//        assertEquals(12, element, "should return the correct element after using the remove method");
//    }
//
//    @Test
//    void shouldReturnCorrectSizeAfterRemovingAtIndex(){
//        for(int i = 0; i < 25;i++){
//            list.add(i);
//        }
//        //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
//        list.remove(12);
//        assertEquals(24, list.size(), "should return the correct size after using the remove method");
//    }
//
//
//
//    @Test
//    void shouldReturnCorrectListAfterRemovingAtIndex(){
//        for(int i = 0; i < 25;i++){
//            list.add(i);
//        }
//        list.remove(12);
//
//        ListLet<Integer> expected = new ArrayListLet<>();
//        for(int i = 0; i < 25;i++){
//            if(i == 12){
//                continue;
//            }
//            expected.add(i);
//        }
//
//        for(int i = 0; i < expected.size(); i++){
//            assertEquals(list.get(i),expected.get(i),"should have the same elements and the same order after using the remove method");
//        }
//    }
//
//
//
//
//
//
//
//
//
//
//}
