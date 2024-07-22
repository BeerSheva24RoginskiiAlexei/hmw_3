package telran.util;

import java.util.Comparator;
import java.util.function.Predicate;

public class Arrays {
public static int search(int[] array, int key) {
    int index = 0;
    while(index < array.length && array[index] != key) {
        index++;
    };

    return index == array.length ? -1 : index;
}

public static int[] add(int[] array, int number) {
    int [] res = java.util.Arrays.copyOf(array, array.length + 1);
    res[array.length] = number;

    return res;
}

public static int[] insert(int[] array, int index, int number) {
    int[] newArray = java.util.Arrays.copyOf(array, array.length + 1);
    System.arraycopy(array, index, newArray, index + 1, array.length - index);
    newArray[index] = number;

    return newArray;
}

public static int[] remove(int[] numbers, int index) {
    int[] newArray = java.util.Arrays.copyOf(numbers, numbers.length -1);
    System.arraycopy(numbers, 0, newArray, 0, index);
    System.arraycopy(numbers, index + 1, newArray, index, numbers.length - index - 1);

    return newArray;
}

private static boolean pushMaxAtEnd(int[] array, int length) {
    boolean res = true;
    for(int i = 0; i < length; i++) {
        if ( array[i] > array[i + 1]) {
            res = false;
            swap(array, i, i + 1);
        }
    }
    return res;
}

private static void swap(int[] array, int i, int j) {
   int tmp = array[i];
   array[i] = array[j];
   array[j] = tmp;
}   

public static void sort(int[] array) {
    int length = array.length ;
    boolean flSorted = false;
    while(!flSorted) {
        length--;
      flSorted = pushMaxAtEnd(array, length);
    }
}

public static int binarySearch(int [] array, int key) {
    int left = 0;
    int right = array.length - 1;

    while ( left <= right) {
        int middle = (left + right) / 2;

        if (array[middle] == key) {
            return middle;
        }

        if (array[middle] < key) {
            left = middle + 1;
        } else {
            right = middle - 1;
        }
    }
    return -(left + 1);
}

public static int[] insertSorted(int[] arSorted, int number) {

    int  insertPos = binarySearch(arSorted, number);

    if ( insertPos < 0) {
        insertPos = -(insertPos + 1);
    }

    int [] newArray = new int[arSorted.length + 1];

    System.arraycopy(arSorted, 0, newArray, 0, insertPos);

    newArray[insertPos] = number;

    System.arraycopy(arSorted, insertPos, newArray, insertPos + 1, arSorted.length - insertPos);

    return newArray;
}

public static boolean isOneSwap(int[] array) {
    int n = array.length;
    int first = -1, second = -1;

    for (int i = 0; i < n - 1; i++) {
        if (array[i] > array[i + 1]) {
            first = i;
            break;
        }
    }
    
    if (first == -1) {
        return false;
    }

    for (int i = n - 1; i > first; i--) {
        if (array[i] < array[first]) {
            second = i;
            break;
        }
    }

    swap(array, first, second);

    for (int i = 0; i < n - 1; i++) {
        if (array[i] > array[i + 1]) {
            return false;
        }
    }

    return true;
}

public static <T> void sort (T[] array, Comparator<T> comparator) {
    int length = array.length;
    boolean flSorted = false;
    do{
        length--;
        flSorted = true;
        for (int i = 0; i < length; i++) {
          if(comparator.compare(array[i], array[i + 1]) > 0) {
             swap(array, i, i+1);
             flSorted = false;
        }
    
        }
    } while(!flSorted);
}

private static <T> void swap(T[] array, int i, int j) {
    T temp = array[i];
    array[i] = array[j];
    array[j] = temp;
    }

    public static <T> int binarySearch(T[] array, T key, Comparator<T> comp) {
        int left = 0;
        int right = array.length - 1;
        int middle = (left + right) / 2; 
        while (left <= right && comp.compare(array[middle], key) != 0) {
            if (comp.compare(array[middle], key) > 0) { 
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            middle = (left + right) / 2;
        }
        return left > right ? -(left + 1) : middle;
    }

    public static <T> T[] insert(T [] array, int index, T item) {
        T[] newArray = java.util.Arrays.copyOf(array, array.length + 1);
        System.arraycopy(array, index, newArray, index + 1, array.length - index);
        newArray[index] = item;
        return newArray;
    }

    public static <T> T[] find (T [] array, Predicate<T> predicate) {
        T[] result = java.util.Arrays.copyOf(array, 0);

        for (int i = 0; i < array.length; i++) {
            if (predicate.test(array[i])) {
                result = insert(result, result.length, array[i]);
            }
        }
        return result;

    }

    public static <T> T[] removeIf(T[] array, Predicate<T> predicate) {
        return find(array, predicate.negate());
    }

    public static <T extends Comparable<T>> int binarySearch1(T[] array, T key) {
        return java.util.Arrays.binarySearch(array, key);
    }

}
