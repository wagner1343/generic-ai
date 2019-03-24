package ai;

public class Main {
    public static void main(String[] args) {
        int sampleSize = 10;
        long start;

        Problem problem = new MundoDosBlocosProblem();

        for(int x = 0; x < sampleSize; x++){
            AIAlgorithm.SearchDFS(problem);
            AIAlgorithm.SearchDFSList(problem);
        }
        start = System.nanoTime();
        for(int x = 0; x < sampleSize; x++)
            AIAlgorithm.SearchDFSList(problem);
        long elapsedList = System.nanoTime() - start;

        start = System.nanoTime();
        for(int x = 0; x < sampleSize; x++)
            AIAlgorithm.SearchDFS(problem);
        long elapsedSet = System.nanoTime() - start;

        System.out.println("elapsedList = " + elapsedList);

        System.out.println("elapsedSet  = " + elapsedSet);

    }
}
