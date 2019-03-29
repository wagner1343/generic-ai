package ai.util;

import java.lang.reflect.Array;
import java.util.LinkedList;

public class Permutation {
    private static final int CACHE_SIZE = 1024;
    private static int[] fatorialCache = new int[CACHE_SIZE];

    public static int fatorial(int n){
        if(n <= 0) return 0;
        if(n == 1) return 1;

        if(fatorialCache[n] == 0)
            fatorialCache[n] = n * fatorial(n-1);


        return fatorialCache[n];
    }

    public static long getPermutationIndex(Object[] target, Object[] base){
        LinkedList<Object> baseCopy = new LinkedList<>();
        int[] result = new int[base.length];

        for(int x = 0; x < base.length; x++){
            baseCopy.addLast(base[x]);
        }


        for(int x = 0; x < base.length; x++){
            int index = 0;
            while(!baseCopy.isEmpty()) {
                Object o = baseCopy.get(index); // a - a  cba abc 321   321  212 abc acb bac bca cab cba
                if (o.equals(target[x])) {
                    result[x] = index;
                    baseCopy.remove(index);
                    break;
                }
                index++;
            }
        }

        int fat = 1;
        long sum = 0;

        for(int x = result.length-2; x >=0 ; x--){
            sum += result[x] * fatorial(fat);
            fat++;
        }

        return sum;
    }
}
