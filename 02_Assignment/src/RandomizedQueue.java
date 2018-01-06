/******************************************************************************
 *  Name: Nenad Livaic
 *  NetID: nenad.livaic
 *  Precept: P01
 *
 *  Partner Name:    None
 *  Partner NetID:   None
 *  Partner Precept: None
 * 
 *  Description:  Write a generic data type for a randomized queue.
 ******************************************************************************/
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
   private int size;   // Real member count.
   private int index; // Pointer to next free spot in queue.
   private Item[] queue;
   // construct an empty randomized queue
   public RandomizedQueue() {
       size = 0;
       index = 0;
       queue = (Item[]) new Object[1];
   }
   // is the randomized queue empty?
   public boolean isEmpty() {
       return size == 0;
   }
   // return the number of items on the randomized queue
   public int size() {
       return size;
   }
   // add the item
   public void enqueue(Item item) {
       if (item == null) {
           throw new java.lang.IllegalArgumentException("Can't enqueue a null item.");
       }
       queue[index++] = item;
       size++;
//       StdOut.printf("Enqueued. index: %d, size: %d\n", index, size);
       if (size == queue.length) {
           // Queue is full.
           resize(queue.length*2);
       } else if (index == queue.length) { // We've reached the end of array.
           if (size > queue.length/2) {
               // Queue is more than half full. Once we double
               // the size, it will still be over one quarter
               // full, which maintains the invariant: every stack
               // is in between 25% and 100% full. 
               resize(queue.length*2);
           } else {
               // Queue is below half full. If we double it,
               // the new queue won't be even quarter full
               // and thrashing will occur.
               resize(queue.length);
           }
       }
   }
   // remove and return a random item
   public Item dequeue() {
       if (size == 0) {
           throw new 
            java.util.NoSuchElementException("Can't dequeue an empty queue.");
       }
       int randomIndex = getRandomAvailableIndex();
       Item item = queue[randomIndex];
       queue[randomIndex] = null;
       size--;
//       StdOut.printf(
//         "Dequeued at %d. index: %d, size: %d\n", randomIndex, index, size);
       if (size == queue.length/4) {
           resize(queue.length/2);
           index = size; // Resizing compacts the array. 
                         // We have to readjust the index. 
       }
       return item;
   }
   // return a random item (but do not remove it)
   public Item sample() {
       if (size == 0) {
           throw new 
            java.util.NoSuchElementException("Can't sample an empty queue.");
       }
       return queue[getRandomAvailableIndex()];
   }
   
   // return an independent iterator over items in random order
   public Iterator<Item> iterator() {
       return new RandomizedQueueIterator();
   }
   
   // Obtain a random queue index. If the item in that slot does exist,
   // return it.
   private int getRandomAvailableIndex() {
       if (size == 0) {
           throw new 
            java.util.NoSuchElementException(
                    "Can't get random index from empty queue.");
       }
       int randomIndex = 0;
       Item item = null;
       do {
           randomIndex = StdRandom.uniform(index);
           item = queue[randomIndex];
       } while (item == null);
       return randomIndex;
   }
   
   private void resize(int length) {
       Item[] newQueue = (Item[]) new Object[length];
       int newQueueIndex = 0;
       for (int i = 0; i < queue.length; i++) {
           /*
           StdOut.printf(
                   "\t\tResizing. Current index %d is " + 
                    ((queue[i] == null) ? "" : "not") + 
                    " null.\n", i);
           */
           if (queue[i] != null) {
               newQueue[newQueueIndex++] = queue[i];
           }
       }
       queue = newQueue;
//       StdOut.printf("Resized to %d\n", length);
   }
   
   private class RandomizedQueueIterator implements Iterator<Item> {
       private final int[] randomizedOrder;
       private int iteratorIndex, iteratorCount;
       
       public RandomizedQueueIterator() {
           randomizedOrder = StdRandom.permutation(index);
           iteratorIndex = 0;
           iteratorCount = 0;
       }
       
        @Override
        public boolean hasNext() {
            return iteratorCount < size;
        }
    
        @Override
        public Item next() {
            if (iteratorCount >= size) {
                throw new java.util.NoSuchElementException("next");
            }
            Item item = null;
            int queueIndex = -1;
            do {
                queueIndex = randomizedOrder[iteratorIndex++];
                item = queue[queueIndex];
                /*
                StdOut.printf(
                        "\t\tIterating. Current index %d is " + 
                         ((queue[queueIndex] == null) ? "" : "not") + 
                         " null.\n", queueIndex);
                */
            } while (item == null && iteratorIndex < randomizedOrder.length);
            iteratorCount++;
            return item;
        }
    
        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException("remove");
        }
   }
   
   // unit testing (optional)
//   public static void main(String[] args) {
//       RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
//       System.out.println(rq.isEmpty());
//       rq.enqueue(2);
//       rq.enqueue(21);
//       rq.enqueue(22);
//       rq.enqueue(23);
//       rq.enqueue(24);
//       rq.enqueue(25);
//       rq.enqueue(26);
//       rq.enqueue(27);
//       System.out.println(rq.sample());
//       System.out.println(rq.sample());
//       System.out.println(rq.sample());
//       System.out.println(rq.sample());
//       System.out.println(rq.sample());
//       System.out.println(rq.sample());
//       System.out.println(rq.sample());
//   }
}