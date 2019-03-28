package ai.hash;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.function.Function;

public class HashTable<Item extends Hashable> implements Collection<Item> {
    TreeMap<Integer, Item> table;

    public HashTable(){
        table = new TreeMap<>();
    }

    @Override
    public int size() {
        return table.size();
    }

    @Override
    public boolean isEmpty() {
        return table.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return table.containsKey(((Item) o).getHash());
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Item hashable){

       return table.put(hashable.getHash(), hashable) != null;
    }

    @Override
    public boolean remove(Object o) {
        Item i = (Item) o;
        return table.remove(i.getHash(), i);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Item> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    public Item get(int hash){
        return table.get(hash);
    }

    public boolean contains(Item item){
        return table.get(item.getHash()) != null;
    }

}
