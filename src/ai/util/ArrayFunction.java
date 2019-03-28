package ai.util;

public class ArrayFunction {
    public static String toString(Object[][] arr){
        StringBuilder str = new StringBuilder();

        for(int x = 0; x < arr.length; x++){
            for(int y = 0; y < arr[x].length; y++){
                str.append(arr[x][y].toString());
            }

            str.append("\n");
        }

        return str.toString();
    }
}
