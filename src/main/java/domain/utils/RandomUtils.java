package domain.utils;

import domain.common.ErrorMessageException;
import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();
    private RandomUtils(){
    }
    public int nextInt(int startInclusive, int endInclusive){
        if(startInclusive > endInclusive){
            throw new IllegalArgumentException();
        }
        return startInclusive + random.nextInt((endInclusive - startInclusive) + 1);
    }
}
