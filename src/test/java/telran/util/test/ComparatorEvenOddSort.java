package telran.util.test;

import java.util.Comparator;

public class ComparatorEvenOddSort implements Comparator<Integer> {

    @Override
    public int compare(Integer first, Integer second) {
        int res;
        boolean isEvenFirst = first % 2 == 0;
        boolean isEvenSecond = second % 2 == 0;

        if (isEvenFirst == isEvenSecond) {
            int cmp = Integer.compare(first, second);
            res = isEvenFirst ? cmp : -cmp;
        } else {
            res = isEvenFirst ? -1 : 1;
        }

        return res;
    }

}
