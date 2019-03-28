package ai;

import ai.hash.HashTable;
import ai.hash.Hashable;
import ai.util.Movement;
import ai.util.MovementNode;
import ai.util.SearchResult;

import java.util.*;
import java.util.function.Function;

public class AIAlgorithm {

    public static <TState> SearchResult<TState> dfs(Problem<TState> problem){
        SearchResult<TState> result = new SearchResult<>();
        List<TState> pastStates = new ArrayList<>();
        AIAlgorithm.<TState>dfs(null, problem.getInitialState(), problem::mapPossibleMovements, problem::isFinalState , result, pastStates);

        return result;
    }

    public static <TState extends Hashable> SearchResult<TState> dfsHash(Problem<TState> problem){
        SearchResult<TState> result = new SearchResult<>();
        HashTable<TState> pastStates = new HashTable<>();
        AIAlgorithm.<TState>dfs(null, problem.getInitialState(), problem::mapPossibleMovements, problem::isFinalState , result, pastStates);

        return result;
    }

    public static <TState extends Hashable> MovementNode<TState> bfsHash(Problem<TState> problem){
        HashTable<TState> pastStates = new HashTable<>();
        LinkedList<MovementNode<TState>> movementQueue = new LinkedList<>();

        movementQueue.addLast(new MovementNode<>(null, problem.getInitialState()));
        while(!movementQueue.isEmpty()){
            //System.out.println("pastStates.size() = " + pastStates.size());
            MovementNode<TState> currentMovement = movementQueue.pollFirst();
            TState currentState = currentMovement.getState();

            // Adicionar estado atual para a lista de estados já verificados
            pastStates.add(currentState);

            // Verificar se o estado alvo foi encontrado
            if(problem.isFinalState(currentState)){
                System.out.println("Estado final encontrado");
                return currentMovement;
            }

            // Adicionar todos estados possiveis a partir desse para a fila de estados a serem abertos
            for(Movement<TState> m : problem.mapPossibleMovements(currentState)){

                if(!pastStates.contains(m.getToState()))
                    movementQueue.addLast(new MovementNode<>(currentMovement, m.getToState()));
            }
        }

        return null;
    }

    private static <TState>  boolean dfs(Movement<TState> movement, TState currentState,
                                         Function<TState, List<Movement<TState>>> movementMapFunction,
                                         Function<TState, Boolean> isFinalState, SearchResult<TState> result, Collection<TState> pastStates){

        System.out.println("pastStates.size() = " + pastStates.size());
        System.out.println("CurrentState: ");
        System.out.println(currentState.toString());
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
                if(dfs(possibleMovement, possibleMovement.getToState(), movementMapFunction, isFinalState, result, pastStates)) {
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
