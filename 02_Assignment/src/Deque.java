/******************************************************************************
 *  Name: Nenad Livaic
 *  NetID: nenad.livaic
 *  Precept: P01
 *
 *  Partner Name:    None
 *  Partner NetID:   None
 *  Partner Precept: None
 * 
 *  Description:  Write a generic data type for a deque
 ******************************************************************************/
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;
    
    private class Node {
        private Item item;
        private Node prev;
        private Node next;
    }

    // construct an empty deque
    public Deque()
    {
        first = null;
        last = null;
        size = 0;
    }
    // is the deque empty?
    public boolean isEmpty()
    {
        return size == 0;
    }
    // return the number of items on the deque
    public int size()
    {
        return size;
    }
    // add the item to the front
   public void addFirst(Item item)          
    {
        if (item == null) {
            throw new java.lang.IllegalArgumentException("An error");
        }
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (oldFirst != null) {
            oldFirst.prev = first;
        }
        if (last == null) {
            last = first;
        }
        size++;
    }
       // add the item to the end
    public void addLast(Item item)
    {
        if (item == null) {
            throw new java.lang.IllegalArgumentException("An error");
        }
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.prev = oldLast;
        if (oldLast != null) {
            oldLast.next = last;
        }
        if (first == null) {
            first = last;
        }
        size++;
    }
    // remove and return the item from the front
    public Item removeFirst()
    {
        if (size() == 0) {
            throw new java.util.NoSuchElementException("removeFirst");
        }
        Node oldFirst = first;
        if (first.next != null) {
            first = first.next;
        }
        first.prev = null;
        size--;
        if (size == 0) {
            first = null;
            last = null;
        }
        return oldFirst.item;
    }
    // remove and return the item from the end
    public Item removeLast()
    {
        if (size() == 0) {
               throw new java.util.NoSuchElementException("removeLast");
        }
        Node oldLast = last;
        if (last.prev != null) {
            last = last.prev;
        }
        last.next = null;
        size--;
        if (size == 0) {
            first = null;
            last = null;
        }
        return oldLast.item;
    }
    // return an iterator over items in order from front to end
    public Iterator<Item> iterator()
    {
        return new DequeIterator();
    }
       
    private class DequeIterator implements Iterator<Item> {
        private Node node = first;
           
        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Item next() {
            if (node == null) {
                throw new java.util.NoSuchElementException("next");
            }
            Node oldNode = node;
            node = node.next;
            return oldNode.item;
        }

        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException("remove");
        }
    }
    
//    public static void main(String[] args) {
//        Deque<Integer> deque = new Deque<Integer>();
//        deque.addLast(1);
//        System.out.println(deque.removeLast());      // 1
//        System.out.println(deque.removeFirst());     // 0
//        System.out.println(deque.size());            // 0       
//        System.out.println(deque.isEmpty()    ) ;    // true
//        deque.addFirst(6);
//        System.out.println(deque.removeLast());      // 6
//    }
}
