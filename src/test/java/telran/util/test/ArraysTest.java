package telran.util.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static telran.util.Arrays.*;

import java.util.Random;

public class ArraysTest {
    int[] numbers = { 10, 7, 12, -4, 13, 3, 14 };
    private static final int N_ELEMENTS = 1000;
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

    @Test
void sortTest(){
    int [] testNumbers = java.util.Arrays.copyOf(numbers, numbers.length); 
    int [] expected = {-4, 3, 7, 10, 12, 13, 14 };
    sort(testNumbers);
    assertArrayEquals(expected, testNumbers);
}

@Test 
void sortTestRandomArray(){
    int[] array = getRandomArray(N_ELEMENTS);
    int limit = array.length -1 ;
    sort(array);
    for (int i = 0; i < limit; i++) {
        assertTrue(array[i]<=array[i+1]);
    }
}
private int[] getRandomArray(int nElements) {
    int [] res = new int [nElements];
    Random random = new Random();
    for(int i = 0; i < nElements; i++) {
        res[i] = random.nextInt();
    }
    return res;
}

@Test 
void binarySearchTest(){
    int [] sortedArrays= {-4, 3, 7, 10, 12, 13, 14 };
    assertEquals(0, binarySearch(sortedArrays, -4));
    assertEquals(1, binarySearch(sortedArrays, 3));
    assertEquals(4, binarySearch(sortedArrays, 12));

    assertEquals(-1, binarySearch(sortedArrays, -5));

    assertEquals(-4, binarySearch(sortedArrays, 8));

    assertEquals(-8, binarySearch(sortedArrays, 15));
}

@Test 
void insertSortedTest(){
    int [] sortedArrays= {-4, 3, 7, 10, 12, 13, 14 };

    int[] result = insertSorted(sortedArrays, -5);
    int[] expected = {-5, -4, 3, 7, 10, 12, 13, 14};
    assertArrayEquals(expected, result);
}

@Test 
void insertSortedTest1(){
    int [] sortedArrays= {-4, 3, 7, 10, 12, 13, 14 };

    int[] result = insertSorted(sortedArrays, 8);
    int[] expected = { -4, 3, 7, 8, 10, 12, 13, 14};
    assertArrayEquals(expected, result);
}

@Test 
void insertSortedTest2(){
    int [] sortedArrays= {-4, 3, 7, 10, 12, 13, 14 };

    int[] result = insertSorted(sortedArrays, 15);
    int[] expected = { -4, 3, 7, 10, 12, 13, 14, 15};
    assertArrayEquals(expected, result);
}

@Test 
void insertSortedTest3(){
    int [] sortedArrays= {-4, 3, 7, 10, 12, 13, 14 };

    int[] result = insertSorted(sortedArrays, 7);
    int [] expected= {-4, 3, 7, 7, 10, 12, 13, 14 };
    assertArrayEquals(expected, result);
}

@Test 
void isOneSwapTest(){

    int[] sortedArray = {1, 2, 3, 4, 5};
    assertTrue(isOneSwap(sortedArray));

    int[] swapPossible = {1, 3, 2, 4, 5};
    assertTrue(isOneSwap(swapPossible));

    int[] swapImpossible = {1, 3, 2, 5, 4};
    assertFalse(isOneSwap(swapImpossible));

    int[] emptyArray = {};
    assertTrue(isOneSwap(emptyArray));
}

}




