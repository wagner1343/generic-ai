package genericai;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenericAI<MovementType> {
    public static <MovementType, StateType>  SearchResult AStar(
            MovementType currentMovement, Set<StateType> pastStates,
            Map<StateType, List<MovementType>> movementsMap){

    }

    public static <TMovement, TState> SearchResult SearchDFS(Problem<TMovement, TState> problem, SearchResult result){

    }

    private static <TMovement, TState>  boolean DFS(TState currentState, Problem<TMovement, TState> problem,
                                                    SearchResult result, List<TState> pastStates){
        if(problem.isSolved(currentState)){
            return true;
        }

        for(TState state : problem.getPossibilities(currentState)){
            if(!pastStates.contains(state))
        }

    }

}
