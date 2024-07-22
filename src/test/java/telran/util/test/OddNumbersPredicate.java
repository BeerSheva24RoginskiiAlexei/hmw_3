package telran.util.test;


import java.util.function.Predicate;

public class OddNumbersPredicate implements Predicate<Integer> {
    @Override
    public boolean test(Integer number) {
        return number % 2 != 0;
    }
}
