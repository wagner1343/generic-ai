package ai;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class AIAlgorithm {

    public static <TState> SearchResult SearchDFS(Problem<TState> problem){
        SearchResult<TState> result = new SearchResult<>();
        List<TState> pastStates = new ArrayList<>();
        DFS(null, problem.getInitialState(), problem.getStateMapFunction(), problem.getFinalState() , result, pastStates);

        return result;
    }

    private static <TState>  boolean DFS(Movement<TState> movement, TState currentState,
                                         Function<TState, Set<Movement<TState>>> movementMapFunction,
                                         TState targetState, SearchResult<TState> result, List<TState> pastStates){

        pastStates.add(currentState);

        if(movement != null)
            result.getAllMovementList().add(movement);

        if(targetState.equals(currentState)){
            if(movement != null)
                result.getResultMovementList().add(movement);

            return true;
        }

        for(Movement<TState> possibleMovement : movementMapFunction.apply(currentState))
            if(!pastStates.contains(possibleMovement.getToState()))
                if(DFS(possibleMovement, possibleMovement.getToState(), movementMapFunction, targetState, result, pastStates)) {
                    if(movement != null)
                        result.getResultMovementList().add(movement);

                    return true;
                }

        return false;
    }
}
