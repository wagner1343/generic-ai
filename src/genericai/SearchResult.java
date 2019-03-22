package genericai;

import java.util.LinkedList;
import java.util.List;

public class SearchResult<TMovement> {
    private List<TMovement> allMovementList;
    private List<TMovement> resultMovementList;

    public SearchResult(){
        allMovementList = new LinkedList<>();
        resultMovementList = new LinkedList<>();
    }


    public List<TMovement> getAllMovementList() {
        return allMovementList;
    }


    public List<TMovement> getResultMovementList() {
        return resultMovementList;
    }

}
