/********************************************************************************
 * Search in a bitonic array. An array is bitonic if it is comprised of an 
 * increasing sequence of integers followed immediately by a decreasing sequence
 * of integers. Write a program that, given a bitonic array of n distinct 
 * integer values, determines whether a given integer is in the array.
 * 
 * Standard version: Use ~3lgn compares in the worst case.
 *******************************************************************************/
public class BitonicSearch {
    // Recursive binary search in a sorted array of ascending integers.
    private static int findAscending(int[] list, int value, int low, int high) {
        int mid;
        if (low <= high) {
            mid = low + (high - low) / 2;
            if (list[mid] > value) { return findAscending(list, value, low, mid - 1); }
            else if (list[mid] < value) { return findAscending(list, value, mid + 1, high); }
            else return mid;
        }
        return -1;
    }
    
    // Recursive binary search in a sorted array of descending integers.
    private static int findDescending(int[] list, int value, int low, int high) {
        int mid;
        if (low <= high) {
            mid = low + (high - low) / 2;
            if (list[mid] < value) { return findDescending(list, value, low, mid - 1); }
            else if (list[mid] > value) { return findDescending(list, value, mid + 1, high); }
            else return mid;
        }
        return -1;
    }
    
    // Binary find in a bitonic array.
    // First determines the pivot point.
    // Then does two distinct O(lgN) binary searches, one left of pivot and one right of pivot.
    public static int bitonicFind(int[] list, int value) {
        int pivotIndex = findPivot(list);
        int valueIndex = -1;
        // Search left of pivot.
        valueIndex = findAscending(list, value, 0, pivotIndex);
        if (valueIndex > -1) {
            return valueIndex;
        }
        // Search right of pivot.
        valueIndex = findDescending(list, value, pivotIndex+1, list.length-1);
        return valueIndex;
    }
    
    // Binary search for pivot in a bitonic array.
    // O(lgN)
    public static int findPivot(int[] list) {
        int low, high, mid, slope;
        
        low = 0;
        high = list.length - 1;
        mid = low + (high-low)/2;
        slope = determineSlope(list, mid);
        
        while (slope < 0 && low < high - 2) {
            if (slope == -1) {    // Move left.
                high = mid;
            } else 
            if (slope == -2) {    // Move right.
                low = mid;
            }
            mid = low + (high-low)/2;
            slope = determineSlope(list, mid);
        }
        if (slope == 1) {
            return low;
        } else if (slope == 2) {
            return high;
        }
        return mid;
    }
    
    // -1 decreasing sequence around index. ?-_
    // -2 increasing sequence around index. _-?
    // +1 decreasing sequence around index (as -1 above). Index 0 is pivot.
    // +2 increasing sequence around index (as  1 above). Index list.length-1 is pivot.
    //  0 concave sequence _-_ found the pivot
    //
    // index whose environment we're probing to determine sequence.
    //       Consider index as potential pivot.
    private static int determineSlope(int[] list, int index) {
        int left, right, mid;
        left = list[index-1];
        right = list[index+1];
        mid = list[index];
        
        if (left > mid && mid > right) {
            if (index == 1) {
                return 1;
            } else {
                return -1;
            }
        } else if (left < mid && mid < right) {
            if (index == list.length - 2) {
                return 2;
            } else {
                return -2;
            }
        } else {
            return 0;
        }
    }
}