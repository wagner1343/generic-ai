package ai;

import java.util.LinkedList;
import java.util.List;

public class MundoDosBlocosProblem implements Problem<StackState> {
    private StackState initialState;
    private StackState finalState;

    public MundoDosBlocosProblem(){
        initialState = new StackState(3);
        finalState = new StackState(3);

        for(int x = 1; x < 7; x++)
            initialState.getStacks()[0].push(x);


        for(int x = 6; x >= 1; x--)
            finalState.getStacks()[2].push(x);
    }

    @Override
    public StackState getInitialState() {
        return initialState;
    }

    @Override
    public boolean isFinalState(StackState stackState) {
        return stackState.equals(finalState);
    }

    @Override
    public List<Movement<StackState>> mapPossibleMovements(StackState state) {
        LinkedList<Movement<StackState>> resultSet = new LinkedList<>();

        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                if(x != y && !state.getStacks()[x].empty()){
                    StackState newState = new StackState(state);
                    newState.getStacks()[y].push(newState.getStacks()[x].pop());

                    Movement<StackState> possibleMovement = new Movement<>(state, newState);
                    resultSet.add(possibleMovement);
                }
            }
        }

        return resultSet;
    }
}
