/********************************************************************************
* Permutation. Given two integer arrays of size n, design a subquadratic 
* algorithm to determine whether one is a permutation of the other. 
* That is, do they contain exactly the same entries but, possibly, 
* in a different order.
********************************************************************************/
public class Permutation {
    public static boolean isPermutation(Comparable[] a, Comparable[] b)  {
        ShellSort.sort(a);
        ShellSort.sort(b);
        
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i].compareTo(b[i]) != 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Comparable[] a = { 40, 87, 37, 93, 73, 75, 84, 76, 91, 79, 95, 61, 2, 80, 30, 74, 32, 48, 53, 10, 83, 92, 77, 13, 86, 7, 64, 89, 45, 29, 96, 41, 52, 94, 51, 24, 17, 81, 99, 56, 31, 18, 39, 14, 54, 43, 36, 26, 16, 42, 33, 58, 66, 85, 88, 3, 72, 100, 25, 68, 97, 28, 1, 20, 21, 63, 67, 55, 27, 38, 82, 15, 59, 65, 98, 8, 35, 62, 19, 4, 57, 78, 50, 71, 46, 11, 90, 22, 5, 34, 12, 60, 6, 70, 9, 47, 69, 23, 44, 49 };
        Comparable[] b = { 20, 53, 70, 96, 88, 31, 46, 69, 19, 82, 77, 98, 90, 62, 74, 48, 12, 95, 43, 9, 83, 57, 3, 39, 55, 86, 73, 40, 30, 56, 11, 92, 79, 87, 45, 37, 50, 36, 5, 76, 66, 38, 10, 6, 41, 29, 97, 35, 65, 49, 7, 80, 17, 100, 14, 63, 13, 18, 54, 44, 59, 71, 81, 91, 25, 99, 23, 33, 84, 27, 42, 51, 26, 34, 58, 16, 47, 67, 8, 60, 1, 78, 22, 85, 68, 52, 4, 15, 93, 61, 32, 21, 72, 89, 94, 64, 75, 28, 2, 24 };
        System.out.println(Permutation.isPermutation(a, b));
    }
}
