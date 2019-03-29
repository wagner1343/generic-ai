package ai.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MovementNode<TState> {
    public MovementNode<TState> origin;

    public TState getState() {
        return state;
    }
    public TState state;

    public MovementNode(MovementNode<TState> origin, TState state) {
        this.origin = origin;
        this.state = state;
    }

    public List<TState> getResultStack(){
        LinkedList<TState> result = new LinkedList<>();
        fillResultStack(result);
        return result;
    }

    public void fillResultStack(LinkedList<TState> result){
        result.addLast(state);
        if(origin != null)
            origin.fillResultStack(result);
    }

    @Override
    public String toString(){
        String str = "";
        str = str.concat("state: " + state.toString());

        return str;
    }
}
