package ai;

import ai.util.Movement;

import java.util.List;

public interface ProblemWeighted<TState> extends Problem<TState>{
    int getWeight(TState t);
}
