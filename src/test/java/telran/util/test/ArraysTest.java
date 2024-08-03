package telran.util.test;

import org.junit.jupiter.api.Test;

import telran.util.CharacterRule;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static telran.util.Arrays.*;

import java.util.Comparator;
import java.util.Random;
import java.util.function.Predicate;


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
    // @Test
    // void addTest(){
    // int newNumber = 100;
    // int[] expected = { 10, 7, 12, -4, 13, 3, 14, newNumber };
    // assertArrayEquals(expected, add(numbers, newNumber));
    // }

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
    assertFalse(isOneSwap(sortedArray));

    int [] swapPossible1 = {1, 2, 13, 4, 4, 20};
    assertTrue(isOneSwap(swapPossible1 ));

    int [] swapImpossible2 = {1, 2, 2, 3};
    assertFalse(isOneSwap(swapImpossible2));

    int[] swapPossible = {1, 3, 2, 4, 5};
    assertTrue(isOneSwap(swapPossible));

    int[] swapImpossible = {1, 3, 2, 5, 4};
    assertFalse(isOneSwap(swapImpossible));

    int[] emptyArray = {};
    assertFalse(isOneSwap(emptyArray));
}


@Test 
    void binarySearchAnyTypeTest() {
        String [] strings = {"lmn", "cfta", "w", "aa"};
        String [] expectedASCII = {"aa", "cfta", "lmn", "w"};
        String [] expectedLenght = {"w", "aa", "lmn", "cfta"};
        sort (strings, new ComparatorASCII());
        assertArrayEquals(expectedASCII, strings);
        sort (strings, new ComparatorLenght());
        assertArrayEquals(expectedLenght, strings);
    }

        @Test
    public void testBinarySearch() {
        Comparator<String> comp = new ComparatorLenght();
        String[] array = {"a", "bb", "ccc", "dddd", "eeeee"};
        
        assertEquals(0, binarySearch(array, "x", comp));  
        assertEquals(1, binarySearch(array, "xx", comp));  
        assertEquals(2, binarySearch(array, "xxx", comp)); 
        assertEquals(3, binarySearch(array, "xxxx", comp)); 
        assertEquals(4, binarySearch(array, "xxxxx", comp)); 
        
        assertEquals(-1, binarySearch(array, "", comp));  
        assertEquals(-6, binarySearch(array, "xxxxxx", comp)); 
    }

    @Test
    void binarySearchNoComparator(){
        String [] strings = {"aa", "cfta", "lmn", "w"};
        Person prs1 = new Person(10, "Vasya");
        Person prs2 = new Person(20, "Itay");
        Person prs3 = new Person(30, "Sara");
        Person [] persons ={ prs1, prs2, prs3};

        assertEquals(1, java.util.Arrays.binarySearch(strings, "cfta"));
        assertEquals(0, java.util.Arrays.binarySearch(persons, prs1));
        assertEquals(-1, java.util.Arrays.binarySearch(persons, new Person(5, "Serg")));
    }

    @Test
    void evenOddSorting() {
        Integer[] array = {7, -8, 10, -100, 13, -10, 99};
        Integer[] expected = {-100, -10, -8, 10, 99, 13, 7};
        // sort(array, new ComparatorEvenOddSort());
        sort(array, (arg0, arg1) -> {
            boolean isArg0Even = arg0 % 2 == 0;
            boolean isArg1Even = arg1 % 2 == 0;
            boolean noSwapFlag = (isArg0Even && !isArg1Even) ||
            (isArg0Even && isArg1Even && arg0 <= arg1) ||
            (!isArg0Even && !isArg1Even && arg0 >= arg1);
            return noSwapFlag ? -1 : 1;
        });
        assertArrayEquals(expected, array);
    }


    @Test
    void findTest(){
        Integer [] array = {7, -8, 10, -100, 13, -10, 99};
        Integer [] expected  = {7, 13, 99};

        assertArrayEquals(expected, find(array, n -> n % 2 !=0));
    }

    @Test
    void removeIfTest() {
        Integer[] array = {7, -8, 10, -100, 13, -10, 99};
        Integer[] expected = {-8, 10, -100, -10}; 

        assertArrayEquals(expected, removeIf(array, new OddNumbersPredicate()));
    }

    @Test
    void testRemoveIfNoElementsToRemove() {
        Integer[] array = {2, 4, 6, 8, 10};
        Predicate<Integer> isOdd = new OddNumbersPredicate(); 
        Integer[] expected = {2, 4, 6, 8, 10}; 

        assertArrayEquals(expected, removeIf(array, isOdd));
    }

    @Test
    void testRemoveIfEmptyArray() {
        Integer[] array = {};
        Predicate<Integer> isOdd = new OddNumbersPredicate(); 
        Integer[] expected = {}; 

        assertArrayEquals(expected, removeIf(array, isOdd));
    }

    @Test
    void testBinarySearchWithoutComparator() {
        Integer[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] sortedArray1 = {"apple", "banana", "cherry", "date", "fig", "grape"};

        
        assertEquals(0, java.util.Arrays.binarySearch(sortedArray, 1));  
        assertEquals(0, java.util.Arrays.binarySearch(sortedArray1, "apple")); 

        
        assertEquals(-1, java.util.Arrays.binarySearch(sortedArray, 0));    
        assertEquals(-7, java.util.Arrays.binarySearch(sortedArray1, "kiwi")); 
    }


    @Test
    void matchesRulesTest() {    
        CharacterRule[] rulesPositive = new CharacterRule[] {
            new CharacterRule(true, Character::isUpperCase, "no uppercase letter"),
            new CharacterRule(true, Character::isLowerCase, "no lowercase letter"),
            new CharacterRule(true, Character::isDigit, "no digit found"),
            new CharacterRule(true, c -> c == '.', "no dot symbol"),
        };

        CharacterRule[] negativeRules = new CharacterRule[] {
            new CharacterRule(false, Character::isWhitespace, "space is not allowed"),
        };

        char[] testArray1 = new char[] {'a', 'B', '3', '.'};
        char[] testArray2 = new char[] {'a', 'B', '3', '.', ' '};
        char[] testArray3 = new char[] {'a', '3', '.'};
        char[] testArray4 = new char[] {'B', '3', '.'};
        char[] testArray5 = new char[] {'a', 'B', '.'};
        char[] testArray6 = new char[] {'a', 'B', '3'};
        char[] testArray7 = new char[] {' '};

    assertEquals("", matchesRules(testArray1, rulesPositive, negativeRules));
    assertEquals("space is not allowed", matchesRules(testArray2, rulesPositive, negativeRules));
    assertEquals("no uppercase letter", matchesRules(testArray3, rulesPositive, negativeRules));
    assertEquals("no lowercase letter", matchesRules(testArray4, rulesPositive, negativeRules));
    assertEquals("no digit found", matchesRules(testArray5, rulesPositive, negativeRules));
    assertEquals("no dot symbol", matchesRules(testArray6,rulesPositive, negativeRules));
    assertEquals("no uppercase letter, no lowercase letter, no digit found, no dot symbol, space is not allowed", matchesRules(testArray7, rulesPositive, negativeRules));
    }
}




