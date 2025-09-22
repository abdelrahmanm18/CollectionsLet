package TestLet;
import CollectionsLet.ListLet.LinkedListLet;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import CollectionsLet.ListLet.ArrayListLet;
import CollectionsLet.ListLet.ListLet;
import java.util.LinkedList;
import java.util.NoSuchElementException;


public class LinkedListTest {
    private ListLet<Integer> list;

    @BeforeEach
    void setUp(){
        list = new LinkedListLet<>();
    }

    @Test
    public void shouldAcceptDifferentTypes(){
        ListLet<String>  l1 = new LinkedListLet<>();
        ListLet<Double>  l2 = new LinkedListLet<>();
        ListLet<Boolean> l3 = new LinkedListLet<>();

        l1.addFirst("string");
        l2.addFirst(3.14159);
        l3.addFirst(true);

        String s = l1.removeFirst();
        double d = l2.removeFirst();
        boolean b = l3.removeFirst();
    }


    @Test
    void shouldReturnTrueWhenListIsEmptyAfterInitialization(){
        assertTrue(list.isEmpty(),"should return true after creating list");
    }

    @Test
    void shouldReturnTrueWhenListIsEmpty(){
        list.add(10);
        list.add(20);
        list.removeLast();
        list.removeLast();
        assertTrue(list.isEmpty(), "should return true if the list is empty");
    }

    @Test
    void shouldReturnZeroForEmptyList(){
        assertEquals(0, list.size(), "should return the correct size");
    }

    @Test
    void shouldReturnCorrectListSizeForSmallInput(){
        list.add(10);
        list.add(20);
        list.add(50);
        assertEquals(3, list.size(), "should return the correct size for small inputs");
    }

    @Test
    void shouldReturnCorrectListSizeForLargeInput(){
        for(int i = 0; i < 10000;i++){
            list.addLast(i);
        }
        assertEquals(10000, list.size(), "should return the correct size for large inputs");
    }

    @Test
    void shouldReturnCorrectSizeAfterRemoval(){
        for(int i = 0; i < 10000;i++){
            list.addLast(i);
        }

        for(int i = 0; i < 5000;i++){
            list.removeLast();
        }
        assertEquals(5000, list.size(), "should return the correct size after removing");

    }

    @Test
    void shouldReturnCorrectElementAfterRemovingAtIndex(){
        for(int i = 0; i < 25;i++){
            list.add(i);
        }
        //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
        int element = list.remove(12);
        assertEquals(12, element, "should return the correct element after using the remove method");
    }

    @Test
    void shouldReturnCorrectSizeAfterRemovingAtIndex(){
        for(int i = 0; i < 25;i++){
            list.add(i);
        }
        //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
        list.remove(12);
        assertEquals(24, list.size(), "should return the correct size after using the remove method");
    }



    @Test
    void shouldReturnCorrectListAfterRemovingAtIndex(){
        for(int i = 0; i < 25;i++){
            list.add(i);
        }
        list.remove(12);

        ListLet<Integer> expected = new LinkedListLet<>();
        for(int i = 0; i < 25;i++){
            if(i == 12){
                continue;
            }
            expected.add(i);
        }

        for(int i = 0; i < expected.size(); i++){
            assertEquals(list.get(i),expected.get(i),"should have the same elements and the same order after using the remove method");
        }
    }


    @Test
    void shouldThrowExceptionWhenRemovingElementFromEmptyList(){
        assertAll("assert removing from empty list",
                () -> assertThrows(RuntimeException.class, () -> list.removeFirst(), "should throw NoSuchElement Exception When removing first element from empty list"),
                () -> assertThrows(RuntimeException.class, () -> list.removeLast(), "should throw NoSuchElement Exception When removing last element from empty list" )
        );
    }

    @Test
    void shouldThrowExceptionWhenRemovingAllElementsFromEmptyList(){
        list.add(1);
        list.add(2);
        list.removeFirst();
        list.removeLast();
        assertAll("Checking if the list is empty after removing all elements",
                () -> assertTrue(list.isEmpty(), "list should be empty after removing all the elements"),
                () -> assertThrows(RuntimeException.class, () -> list.removeFirst(), "removing first from empty list should throw"),
                () -> assertThrows(RuntimeException.class, () -> list.removeLast(), "removing last from empty list should throw")
        );
    }

    @Test
    void shouldThrowExceptionWhenRemovingElementFromEmptyListWithInvalidIndex(){
        assertAll("checking invalid index",
                () -> assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0), "should throw IndexOutOfBounds Exception When removing element from empty list"),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1), "should throw IndexOutOfBounds Exception When the index is negative"),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> list.remove(100), "should throw IndexOutOfBounds Exception when index is greater than size")
        );
    }

    @Test
    void shouldThrowExceptionWhenRemovingElementWithIndexGreaterThanSize(){
        for(int i = 0; i < 100;i++){
            list.add(i);
        }

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(100));
    }

    @Test
    void shouldThrowExceptionWhenRemovingElementWithIndexLessThanZero(){
        for(int i = 0; i < 100;i++){
            list.add(i);
        }
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-3));
    }

    @Test
    void shouldThrowExceptionWhenGettingElementFromEmptyList() {
        assertAll("assert getting from empty list",
                () -> assertThrows(NoSuchElementException.class, () -> list.getFirst(), "should throw NoSuchElement Exception When getting first element from empty list"),
                () -> assertThrows(NoSuchElementException.class, () -> list.getLast(), "should throw NoSuchElement Exception When getting last element from empty list")
        );
    }

    @Test
    void shouldThrowExceptionWhenGettingElementWithInvalidIndex() {
        assertAll("checking invalid index for get method",
                () -> assertThrows(IndexOutOfBoundsException.class, () -> list.get(0), "should throw IndexOutOfBounds Exception When getting element from empty list"),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> list.get(100), "should throw IndexOutOfBounds Exception when index is greater than size")
        );
    }

    @Test
    void shouldThrowExceptionWhenGettingElementWithNegativeIndex() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1), "should throw IndexOutOfBounds Exception When the index is negative");
    }

    @Test
    void shouldAddAtIndexZeroAndSize() {
        list.add(1);
        list.add(2);
        list.add(3);

        // Add at index 0
        list.add(0, 999);
        assertEquals(999, list.get(0));
        assertEquals(4, list.size());

        // Add at index equal to size
        list.add(list.size(), 888);
        assertEquals(888, list.get(list.size() - 1));
        assertEquals(5, list.size());
    }


}
