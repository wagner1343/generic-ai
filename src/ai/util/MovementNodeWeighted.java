package ai.util;

import java.util.LinkedList;
import java.util.List;

public class MovementNodeWeighted<TState> extends MovementNode<TState> {
    public int getWeight() {
        return weight;
    }
    private int weight;

    public MovementNodeWeighted(MovementNodeWeighted<TState> origin, TState state, int weight) {
        super(origin, state);
        this.weight = weight;
    }

    @Override
    public String toString(){
        String str = "";
        str = str.concat("state: " + state.toString() + " weight: " + weight);

        return str;
    }
}
