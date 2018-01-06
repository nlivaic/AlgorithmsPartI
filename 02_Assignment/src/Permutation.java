/******************************************************************************
 *  Name: Nenad Livaic
 *  NetID: nenad.livaic
 *  Precept: P01
 *
 *  Partner Name:    None
 *  Partner NetID:   None
 *  Partner Precept: None
 * 
 *  Description:  Takes an integer k as a command-line argument; reads in a 
 *  sequence of strings from standard input using StdIn.readString(); 
 *  and prints exactly k of them, uniformly at random. 
 ******************************************************************************/
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        String token;
        do {
            token = StdIn.readString();
            rq.enqueue(token);
        }
        while (!StdIn.isEmpty());
        int iteratorCnt = 0;
        for (String s : rq) {
            if (iteratorCnt == k) {
                break;
            }
            StdOut.printf(s + "\n");
            iteratorCnt++;
        }
    }
}
