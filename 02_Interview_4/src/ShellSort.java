
public class ShellSort {
    public static void sort(Comparable[] a) {
        // Determine initial increment.
        int h = 0;
        
        // Knuth's 3x+1 step. 
        for (int i = 0; i < a.length; i = 3*i+1) {
            h = i;
        }
        while (h > 0) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
            h /= 3;     // 3x+1 backwards (roughly).
        }
    }
    
    public static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
