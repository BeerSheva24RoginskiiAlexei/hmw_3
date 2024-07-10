package telran.util;

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
}
