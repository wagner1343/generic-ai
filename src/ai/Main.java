package ai;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Function<StackState, Set<Movement<StackState>>> mapFunction = (state) -> {
            HashSet<Movement<StackState>> resultSet = new HashSet<>();

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
        };

        StackState initialStackState = new StackState();
        StackState finalStackState = new StackState();

        for(int x = 0; x < 5; x++){
            initialStackState.getStacks()[0].push(x);
        }


        for(int x = 4; x >= 0; x--){
            finalStackState.getStacks()[2].push(x);
        }

        SearchResult<StackState> result = AIAlgorithm.SearchDFS(new Problem<>(initialStackState, finalStackState, mapFunction));

        for(Movement<StackState> m : result.getResultMovementList()){
            System.out.println(m.toString());
            System.out.println();
        }

    }
}
