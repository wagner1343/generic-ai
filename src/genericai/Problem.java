package genericai;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Problem<TState> {
    private TState initialState;
    private TState finalState;
    private Function<TState, Set<Movement<TState>>> stateMapFunction;

    public Problem(TState initialState, TState finalState, Function<TState, Set<Movement<TState>>> stateMapFunction){
        this.initialState = initialState;
        this.finalState = finalState;
        this.stateMapFunction = stateMapFunction;
    }

    public boolean isSolved(TState state){
        return state.equals(finalState);
    }

    public Set<Movement<TState>> getPossibilities(TState state){
        return stateMapFunction.apply(state);
    }

    public TState getInitialState(){
        return initialState;
    }
}
