package ai;

import java.util.Stack;

public class StackState {
    private Stack<Integer>[] stacks;

    public StackState(StackState stackState){

        stacks = new Stack[3];

        for(int x = 0; x < stacks.length; x++){
            stacks[x] = new Stack<>();

            Object[] stackStateArray = stackState.getStacks()[x].toArray();
            for(int y = 0; y < stackStateArray.length; y++){
                stacks[x].push( new Integer ((int) stackStateArray[y]));
            }
        }

    }

    public Stack<Integer>[] getStacks() {
        return stacks;
    }

    public StackState(){
        stacks = new Stack[3];

        for(int x = 0; x < stacks.length; x++){
            stacks[x] = new Stack<>();
        }
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;

        StackState target = (StackState) obj;

        for(int x = 0; x < stacks.length; x++){
            Object[] myArray = stacks[x].toArray();
            Object[] targetArray = target.getStacks()[x].toArray();

            if(myArray.length != targetArray.length)
                return false;

            for(int y = 0; y < myArray.length; y++)
                if(!myArray[y].equals(targetArray[y])){
                    return false;
                }
        }

        return true;
    }

    @Override
    public String toString(){
        String str = "";
        for(int x = 0; x < stacks.length; x++){
            str = str.concat(x + ": {" + stacks[x].toString() + "} ");
        }
        return str;
    }
}
