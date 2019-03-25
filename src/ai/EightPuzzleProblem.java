package ai;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class EightPuzzleProblem implements Problem<Integer[][]> {
    private Integer[][] initialState;
    private Integer[][] finalState;

    public EightPuzzleProblem(){
        LinkedList<Integer> numbers = new LinkedList<>();
        initialState = new Integer[3][3];
        finalState = new Integer[3][3];

        Random r = new Random();

        for(int x = 0; x < 9; x++){
            numbers.addLast(x);
        }

        int count  = 0;
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                initialState[x][y] = numbers.remove(r.nextInt(numbers.size()));
                finalState[x][y] = count;
                count++;
            }
        }


    }
    @Override
    public Integer[][] getInitialState() {
        return initialState;
    }

    @Override
    public boolean isFinalState(Integer[][] integers) {
        return finalState.equals(integers);
    }

    @Override
    public List<Movement<Integer[][]>> mapPossibleMovements(Integer[][] integers) {
        ArrayList<Movement<Integer[][]>> movements = new ArrayList<>();

        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                if(integers[x][y].equals(0)){
                    if(x != 0){
                        Integer[][] up = new Integer[3][3];
                        copy(integers,  up);

                        up[x][y] = up[x-1][y];
                        up[x-1][y] = 0;

                        movements.add(new Movement<>(integers, up));
                    }

                    if(y != 0){
                        Integer[][] left = new Integer[3][3];
                        copy(integers,  left);
                        left[x][y] = left[x][y-1];
                        left[x][y-1] = 0;

                        movements.add(new Movement<>(integers, left));
                    }
                    if(x != 2){
                        Integer[][] down = new Integer[3][3];
                        copy(integers,  down);
                        down[x][y] = down[x+1][y];
                        down[x+1][y] = 0;

                        movements.add(new Movement<>(integers, down));
                    }

                    if(y != 2){
                        Integer[][] right = new Integer[3][3];
                        copy(integers,  right);
                        right[x][y] = right[x][y+1];
                        right[x][y+1] = 0;

                        movements.add(new Movement<>(integers, right));
                    }
                }
            }
        }

        System.out.println("Original movement: ");
        System.out.println(ArrayFunction.toString(integers));
        System.out.println("Movements: ");
        for (Movement<Integer[][]> m : movements)
            System.out.println(ArrayFunction.toString(m.getToState()));

        return movements;
    }

    public void copy(Integer[][] src, Integer[][] dest){
        for(int x = 0; x < src.length; x++){
            for(int y = 0; y < src.length; y++){
                dest[x][y] = src[x][y].intValue();
            }
        }
    }


}
