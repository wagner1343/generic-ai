package ai;

public class Main {
    public static void main(String[] args) {
        Problem<Integer[][]> p = new EightPuzzleProblem();
        System.out.println(ArrayFunction.toString(p.getInitialState()));
        SearchResult<Integer[][]> res = AIAlgorithm.SearchDFS(p);

        for(Movement<Integer[][]> m : res.getResultMovementList()){
            System.out.println(ArrayFunction.toString(m.getToState()));
        }
    }
}
