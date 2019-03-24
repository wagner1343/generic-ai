package ai;

import java.util.List;

public interface Problem<TState> {
    TState getInitialState();
    boolean isFinalState(TState state);
    List<Movement<TState>> mapPossibleMovements(TState state);
}
