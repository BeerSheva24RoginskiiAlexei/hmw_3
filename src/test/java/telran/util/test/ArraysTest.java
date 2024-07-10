package telran.util.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static telran.util.Arrays.*;

public class ArraysTest {
    int[] numbers={10, 7, 12, -4, 13, 3, 14};
    @Test
    void searchTest(){
        assertEquals(0,search(numbers, 10));
        assertEquals(1,search(numbers, 7));
        assertEquals(2,search(numbers, 12));
        assertEquals(3,search(numbers, -4));
        assertEquals(4,search(numbers, 13));
        assertEquals(5,search(numbers, 3));
        assertEquals(-1,search(numbers, 100));
    }
    @Test
    void addTest(){
    int newNumber = 100;
    int[] expected = { 10, 7, 12, -4, 13, 3, 14, newNumber };
    assertArrayEquals(expected, add(numbers, newNumber));
    }

    @Test
    void insertGoodIndexTest(){
        int newNumber = 100;
        int index = 5;
        int [] expected = { 10, 7, 12, -4, 13, newNumber, 3, 14 };
        assertArrayEquals(expected, insert(numbers, index, newNumber));
    }

    @Test
    void insertWrongIndexTest(){
        int newNumber = 100;
        int index = -1;
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            insert(numbers, index, newNumber);
        });  
    }

    @Test
    void removeGoodIndexTest(){
        int index = 5;
        int [] expected = { 10, 7, 12, -4, 13, 14 };
        assertArrayEquals(expected, remove(numbers, index));
    }

    @Test
    void removeWrongIndexTest(){
        int index = -1;
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            remove(numbers, index);
        });  
    }


}
