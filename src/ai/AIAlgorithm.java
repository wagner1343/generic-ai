package ai;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class AIAlgorithm {

    public static <TState> SearchResult SearchDFS(Problem<TState> problem){
        SearchResult<TState> result = new SearchResult<>();
        List<TState> pastStates = new ArrayList<>();
        AIAlgorithm.<TState>DFS(null, problem.getInitialState(), problem::mapPossibleMovements, problem::isFinalState , result, pastStates);

        return result;
    }

    private static <TState>  boolean DFS(Movement<TState> movement, TState currentState,
                                         Function<TState, List<Movement<TState>>> movementMapFunction,
                                         Function<TState, Boolean> isFinalState, SearchResult<TState> result, List<TState> pastStates){

        // Adicionar estado atual para a lista de estados já verificados
        pastStates.add(currentState);

        // Salvar movimento, se ele existir
        if(movement != null)
            result.getAllMovementList().add(movement);

        // Verificar se o estado alvo foi encontrado
        if(isFinalState.apply(currentState)){
            if(movement != null)
                result.getResultMovementList().add(movement);

            return true;
        }

        // Para todas possibilidades a partir do estado atual, avaliar se ela já foi percorrida, se ainda ela não foi, percorre-la
        for(Movement<TState> possibleMovement : movementMapFunction.apply(currentState))
            if(!pastStates.contains(possibleMovement.getToState()))
                if(DFS(possibleMovement, possibleMovement.getToState(), movementMapFunction, isFinalState, result, pastStates)) {
                    if(movement != null)
                        result.getResultMovementList().add(movement);

                    return true;
                }

        // Se o estado alvo não foi encontrado, retornar falso
        return false;
    }


    public static <TState> SearchResult SearchDFSList(Problem<TState> problem){
        SearchResult<TState> result = new SearchResult<>();
        List<TState> pastStates = new ArrayList<>();
        AIAlgorithm.<TState>DFSList(null, problem.getInitialState(), problem::mapPossibleMovements, problem::isFinalState , result, pastStates);

        return result;
    }

    private static <TState>  boolean DFSList(Movement<TState> movement, TState currentState, Function<TState,
            List<Movement<TState>>> movementMapFunction, Function<TState, Boolean> isFinalState, SearchResult<TState> result, List<TState> pastStates){

        // Adicionar estado atual para a lista de estados já verificados
        pastStates.add(currentState);

        // Salvar movimento, se ele existir
        if(movement != null)
            result.getAllMovementList().add(movement);

        // Verificar se o estado alvo foi encontrado
        if(isFinalState.apply(currentState)){
            if(movement != null)
                result.getResultMovementList().add(movement);

            return true;
        }

        // Para todas possibilidades a partir do estado atual, avaliar se ela já foi percorrida, se ainda ela não foi, percorre-la
        for(Movement<TState> possibleMovement : movementMapFunction.apply(currentState))
            if(!pastStates.contains(possibleMovement.getToState()))
                if(DFSList(possibleMovement, possibleMovement.getToState(), movementMapFunction, isFinalState, result, pastStates)) {
                    if(movement != null)
                        result.getResultMovementList().add(movement);

                    return true;
                }

        // Se o estado alvo não foi encontrado, retornar falso
        return false;
    }
}
