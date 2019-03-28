package ai;

import ai.eightpuzzle.Board;
import ai.eightpuzzle.EightPuzzleProblem;
import ai.util.Movement;
import ai.util.MovementNode;
import ai.util.SearchResult;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Problem<Board> p = new EightPuzzleProblem();
        System.out.println(p.getInitialState().toString());
        MovementNode res = AIAlgorithm.bfsHash(p);

        List<Board> resultList = res.getResultStack();

        for(Board b : resultList){
            System.out.println(b.toString());
        }

    }
}
