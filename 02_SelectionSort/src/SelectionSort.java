
public class SelectionSort {
    public static void sort(Comparable[] a) {
        int minimumIndex = 0;
        for (int i = 0; i < a.length; i++) {
            minimumIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[minimumIndex])) {
                    minimumIndex = j;
                }
            }
            exch(a, minimumIndex, i);
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
        //Integer[] list = { 10,9,8,7,6,5,4,3,2,1 };
        //Integer[] list = { 1,2,3,4,5,6,7,8,9,10 };
        //Integer[] list = { 1,5,8,4,10,7,6,5,2,9,3 };
        sort(list);
        System.out.println(isSorted(list));
    }
}