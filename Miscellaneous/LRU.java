import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class LRU {

    LinkedHashSet<Integer> cache = null;
    private final int capacity;

    public LRU(int capacity) {
        this.cache = new LinkedHashSet<>(capacity);
        this.capacity = capacity;
    }

    public void refer(int key){
        if(!cache.contains(key)){
            if(cache.size() == capacity){
                int first = cache.iterator().next();
                cache.remove(first);
            }
        }
        cache.remove(key);
        cache.add(key);
    }

    public void display(){
        LinkedList<Integer> linkedList = new LinkedList<>(cache);
        Iterator<Integer> itr = linkedList.descendingIterator();
        while (itr.hasNext())
            System.out.print(itr.next() + " ");
    }

    public static void main(String[] args) {
        LRU ca = new LRU(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }
}