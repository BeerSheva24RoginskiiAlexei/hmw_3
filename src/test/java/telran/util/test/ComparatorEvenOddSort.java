package telran.util.test;

import java.util.Comparator;

public class ComparatorEvenOddSort implements Comparator<Integer> {

    @Override
    public int compare(Integer first, Integer second) {
        if (isEven(first) && !isEven(second)) {
            return -1;
        } else if (!isEven(first) && isEven(second)) {
            return 1;
        } else if (isEven(first) && isEven(second)) {
            return first.compareTo(second);
        } else {
            return second.compareTo(first);
        }
    }
    
    private boolean isEven(int number) {
        return number % 2 == 0;
    }

}
