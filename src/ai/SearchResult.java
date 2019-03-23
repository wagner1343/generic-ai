package ai;

import java.util.LinkedList;
import java.util.List;

public class SearchResult<TState> {
    private List<Movement<TState>> allMovementList;
    private List<Movement<TState>> resultMovementList;

    public SearchResult(){
        allMovementList = new LinkedList<>();
        resultMovementList = new LinkedList<>();
    }


    public List<Movement<TState>> getAllMovementList() {
        return allMovementList;
    }


    public List<Movement<TState>> getResultMovementList() {
        return resultMovementList;
    }

}
