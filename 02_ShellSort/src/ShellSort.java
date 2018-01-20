
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
    
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Integer[] list = { 75 };
        //Integer[] list = { 75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1 };
        //Integer[] list = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75 };
        //Integer[] list = { 54,75,50,62,24,41,55,25,73,4,15,49,28,11,12,70,67,45,39,35,58,61,47,27,42,48,26,64,56,13,14,51,65,18,72,38,40,5,36,53,34,52,63,7,69,66,9,20,46,60,8,32,59,33,74,37,57,31,17,19,6,29,3,30,68,21,44,23,2,10,16,1,71,43,22 };
        //Integer[] list = { 7,1,14,12,16,13,10,8,15,4,3,11,9,2,5,6 };
        sort(list);
        System.out.println(isSorted(list));
    }
}
