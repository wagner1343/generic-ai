package ai.eightpuzzle;

import ai.ProblemWeighted;
import ai.util.ArrayFunction;
import ai.util.Movement;
import ai.Problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class EightPuzzleProblem implements ProblemWeighted<Board> {
    private Board initialState;
    private Board finalState;

    public int getWeight(Board b){
        int res = 0;
        Integer[][] m = b.getValue();
        for(int x = 0; x < m.length; x++){
            for(int y = 0; y < m[x].length; y++){
                if(m[x][y] == finalState.getValue()[x][y])
                    res++;
            }
        }

        return res;
    }

    public EightPuzzleProblem(){
        LinkedList<Integer> numbers = new LinkedList<>();
        initialState = new Board(3, 3);
        finalState = new Board(3, 3);

        Random r = new Random();

        for(int x = 0; x < 9; x++){
            numbers.addLast(x);
        }

        int count  = 0;
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                initialState.getValue()[x][y] = numbers.remove(r.nextInt(numbers.size()));
                finalState.getValue()[x][y] = count;
                count++;
            }
        }


    }
    @Override
    public Board getInitialState() {
        return initialState;
    }

    @Override
    public boolean isFinalState(Board board) {
        return finalState.equals(board);
    }

    @Override
    public List<Movement<Board>> mapPossibleMovements(Board board) {
        ArrayList<Movement<Board>> movements = new ArrayList<>();

        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                if(board.getValue()[x][y].equals(0)){
                    if(x != 0){
                        Board up = copy(board);

                        up.getValue()[x][y] = up.getValue()[x-1][y];
                        up.getValue()[x-1][y] = 0;

                        movements.add(new Movement<>(board, up));
                    }

                    if(y != 0){
                        Board left = copy(board);
                        left.getValue()[x][y] = left.getValue()[x][y-1];
                        left.getValue()[x][y-1] = 0;

                        movements.add(new Movement<>(board, left));
                    }
                    if(x != 2){
                        Board down = copy(board);
                        down.getValue()[x][y] = down.getValue()[x+1][y];
                        down.getValue()[x+1][y] = 0;

                        movements.add(new Movement<>(board, down));
                    }

                    if(y != 2){
                        Board right = copy(board);
                        right.getValue()[x][y] = right.getValue()[x][y+1];
                        right.getValue()[x][y+1] = 0;

                        movements.add(new Movement<>(board, right));
                    }
                }
            }
        }

        return movements;
    }

    public Board copy(Board src){
        Board newBoard = new Board(src.width(), src.width());

        for(int x = 0; x < src.width(); x++) {
            for (int y = 0; y < src.width(); y++) {
                newBoard.getValue()[x][y] = src.getValue()[x][y].intValue();
            }
        }
        return newBoard;
    }



}
