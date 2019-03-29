package ai.eightpuzzle;

import ai.hash.Hashable;
import ai.util.Permutation;

public class Board implements Hashable {
    private static Integer [] firstPermutation = { 0, 1, 2, 3, 4, 5, 6, 7, 8} ;
    public Integer[][] getValue() {
        return value;
    }

    private Integer[][] value;

    public Board(int x, int y){
        value = new Integer[x][y];
    }

    public Integer get(int x, int y){
        return value[x][y];
    }

    public int width(){
        return value.length;
    }

    @Override
    public String toString(){
        String str = "";

        for(int x = 0; x < value.length; x++){
            for(int y = 0; y < value[x].length; y++){
                str += value[x][y] + " ";
            }
            str += "\n";
        }

        return str;
    }


    @Override
    public boolean equals(Object obj){
            Board comp = (Board) obj;

            return getHash() == ((Board) obj).getHash();
    }
    @Override
    public int getHash() {
        Integer[] currentPermutation = new Integer[value.length * value[0].length];

        for(int x = 0; x < value.length; x++){
            for(int y = 0; y < value[x].length; y++){
                currentPermutation[(x * value.length) + y] = value[x][y];
            }
        }
        return (int) Permutation.getPermutationIndex(currentPermutation, firstPermutation);
    }
}
