package genericai;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenericAI {

    public static <TState> SearchResult SearchDFS(Problem<TState> problem){
        SearchResult<TState> result = new SearchResult<>();
        List<TState> pastStates = new ArrayList<>();

        DFS(null, problem.getInitialState(), problem, result, pastStates);

        return result;
    }

    private static <TState>  boolean DFS(Movement<TState> movement, TState currentState, Problem< TState> problem,
                                                    SearchResult<TState> result, List<TState> pastStates){
        pastStates.add(currentState);
        if(movement != null) result.getAllMovementList().add(movement);

        if(problem.isSolved(currentState)){
            if(movement != null) result.getResultMovementList().add(movement);
            return true;
        }

        for(Movement<TState> possibleMovement : problem.getPossibilities(currentState)){
            if(!pastStates.contains(possibleMovement.getToState()))
                if(DFS(possibleMovement, possibleMovement.getToState(), problem, result, pastStates)) {
                    if(movement != null) result.getResultMovementList().add(movement);
                    return true;
                }
        }

        return false;
    }

}
