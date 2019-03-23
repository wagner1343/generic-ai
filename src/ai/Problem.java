package ai;

import java.util.Set;
import java.util.function.Function;

public class Problem<TState> {
    private TState initialState;
    private TState finalState;

    public TState getFinalState() {
        return finalState;
    }

    public Function<TState, Set<Movement<TState>>> getStateMapFunction() {
        return stateMapFunction;
    }

    private Function<TState, Set<Movement<TState>>> stateMapFunction;

    public Problem(TState initialState, TState finalState, Function<TState, Set<Movement<TState>>> stateMapFunction){
        this.initialState = initialState;
        this.finalState = finalState;
        this.stateMapFunction = stateMapFunction;
    }

    public boolean isSolved(TState state){
        return state.equals(finalState);
    }


    public TState getInitialState(){
        return initialState;
    }
}
