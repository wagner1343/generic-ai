package ai;

import ai.eightpuzzle.Board;
import ai.eightpuzzle.EightPuzzleProblem;
import ai.util.Movement;
import ai.util.MovementNode;
import ai.util.SearchResult;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProblemWeighted<Board> p = new EightPuzzleProblem();
        System.out.println(p.getInitialState().toString());

        long time = System.nanoTime();
        MovementNode res = AIAlgorithm.bfsHashAStar(p);

        long tStar = (System.nanoTime() - time );

        if(res == null){
            System.out.println("O problema não rem resolução");
        }
        else {
            List<Board> resultList = res.getResultStack();
            System.out.println("Solução a*");
            for (Board b : resultList) {
                System.out.println(b.toString());
            }
        }

        time = System.nanoTime();
        res = AIAlgorithm.bfsHash(p);
        long tHash = (System.nanoTime() - time );


        if(res == null){
            System.out.println("O problema não rem resolução");
        }
        else {
            System.out.println("Solução hash");
            List<Board> resultList = res.getResultStack();

            for (Board b : resultList) {
                System.out.println(b.toString());
            }
        }


        System.out.println("Tempo a*          : " + (tStar/10000));
        System.out.println("Tempo apenas hash : " + (tHash/10000));
    }
}
