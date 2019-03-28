package ai.hash;

import java.io.Serializable;
import java.util.TreeMap;
import java.util.function.Function;

public class HashTable<Item extends Hashable> {
    TreeMap<Integer, Item> table;

    public HashTable(int size){
        table = new TreeMap();
    }

    public void add(Item hashable){
       table.put(hashable.getHash(), hashable);
       return;
    }

    public Item get(int hash){
        return table.get(hash);
    }

    public boolean contains(Item item){
        return table.get(item.getHash()) != null;
    }

}
