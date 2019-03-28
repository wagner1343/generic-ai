package ai;

import ai.eightpuzzle.Board;
import ai.eightpuzzle.EightPuzzleProblem;
import ai.util.ArrayFunction;
import ai.util.Movement;
import ai.util.SearchResult;

public class Main {
    public static void main(String[] args) {
        Problem<Board> p = new EightPuzzleProblem();
        System.out.println(p.getInitialState().toString());
        SearchResult<Board> res = AIAlgorithm.SearchDFS(p);

        for(Movement<Board> m : res.getResultMovementList()){
            System.out.println(m.getToState().toString());
        }
    }
}
