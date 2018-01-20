/********************************************************************************
* Intersection of two sets. Given two arrays a[] and b[], 
* each containing n distinct 2D points in the plane, 
* design a subquadratic algorithm to count the number of points 
* that are contained both in array a[] and array b[].
********************************************************************************/
public class Intersect {
    // Return the number of items that are the same in both sets.
    public static int intersect(Comparable[] a, Comparable[] b) {
        int count = 0;
        ShellSort.sort(a);
        ShellSort.sort(b);
        for (int i = 0, j = 0; i < a.length && j < b.length; ) {
            // Move "a" pointer so it catches up with the value "b" is pointing to.
            while (i < a.length && j < b.length && a[i].compareTo(b[j]) < 0) {
                i++;
            }
            // Move "b" pointer so it catches up with the value "a" is pointing to.
            while (i < a.length && j < b.length && a[i].compareTo(b[j]) > 0) {
                j++;
            }
            if (i < a.length && j < b.length && a[i].compareTo(b[j]) == 0) {
                count++;
                i++;
                j++;
            }
        }
        return count;
    }
    
    public static void test() {
        // 4 elements should be the same.
        Point[] a = {  
                new Point( 7,  2),
                new Point( 6,  2),
                new Point( 5,  1),
                new Point(-4, -3), 
                new Point( 4, -2),
                new Point(-1, -2), 
                new Point( 3,  2),
                new Point(17, -22),
                new Point(-1,  0), 
                new Point( 2,  2),
                new Point(-2, -2), 
                new Point(-4, -2),
                new Point(-1, -1), 
                new Point(-5, -4) };
        Point[] b = {
                new Point(-4,  -3), 
                new Point(-4,  -2), 
                new Point( 4,  -2),
                new Point(-1,  -2), 
                new Point( 3,   2),
                new Point(-7,  -2),
                new Point( 1,  19), 
                new Point(-6,  12),
                new Point( 4,  -7),
                new Point(17, -22),
                new Point(-11,100), 
                new Point(-22, 72) };
        int count = Intersect.intersect(a, b);
        System.out.println("Number of points that are contained both in array a[] and array b[]:: " + count);
    }
    
    public static void main(String[] args) {
        test();
    }
}
