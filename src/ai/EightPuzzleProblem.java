package ai;

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

                }
            }
        }

        return movements;
    }
}
