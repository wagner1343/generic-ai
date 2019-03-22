package genericai;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem<TMovement, TState> {
    private TState initialState;
    private TState finalState;
    private Map<TState, Set<TState>> stateMap;

    public Problem(TState initialState, TState finalState, Map<TState, Set<TState>> stateMap){
        this.initialState = initialState;
        this.finalState = finalState;
        this.stateMap = stateMap;
    }

    public boolean isSolved(TState state){
        return state.equals(finalState);
    }

    public Set<TState> getPossibilities(TState state){
        return stateMap.get(state);
    }

    public TState getInitialState(){
        return initialState;
    }
}
