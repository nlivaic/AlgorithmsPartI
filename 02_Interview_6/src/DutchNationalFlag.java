/********************************************************************************
 * Dutch national flag. Given an array of n buckets, each containing a red, 
 * white, or blue pebble, sort them by color. The allowed operations are:
 *
 * swap(i,j): swap the pebble in bucket i with the pebble in bucket j.
 * color(i): determine the color of the pebble in bucket i.
 * The performance requirements are as follows:
 *
 * At most n calls to color().
 * At most n calls to swap().
 * Constant extra space.
 ********************************************************************************/
public class DutchNationalFlag {
    private Comparable[] a;
    private Comparable mid = "R";
    private int colorCount = 0;
    private int swapCount = 0;
    
    public DutchNationalFlag(Comparable[] a, Comparable mid) {
        this.a = a;
        this.mid = mid;
    }
    
    public void sort() {
        int i = 0;              // Bottom group pointer.
        int j = 0;              // Element under inspection.
        int n = a.length - 1;   // Top group pointer;
        Comparable element = null;
        
        while (j <= n) {
            element = color(j);
            if (element.compareTo(mid) < 0) {
                swap(i, j);
                i++;
                j++;
            } else if (element.compareTo(mid) > 0) {
                swap(n, j);
                n--;
            } else {
                j++;
            }    
        }
    }
    
    public Comparable color(int index) {
        colorCount++;
        return a[index];
    }
    
    public void swap(int index1, int index2) {
        swapCount++;
        Comparable temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
    
    public int getColorCount() {
        return colorCount;
    }
    
    public int getSwapCount() {
        return swapCount;
    }
    
    public static void main(String[] args) {
        Comparable[] a = { "W", "R", "B", "W", "B", "R", "B", "W", "B", "R" };
        //Comparable[] a = { "W", "W", "W", "R", "R", "R", "B", "B", "B", "B" };
        //Comparable[] a = { "R", "R", "R", "R", "R", "R", "R", "R", "R", "R" };
        //Comparable[] a = { "W", "W", "W", "W", "W", "W", "W", "W", "W", "W" };
        DutchNationalFlag d = new DutchNationalFlag(a, "R");
        d.sort();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("color() count:: " + d.getColorCount());
        System.out.println("swap() count:: " + d.getSwapCount());
    }
}
