import java.util.Arrays;
/********************************************************************************
 * 3-SUM in quadratic time. An algorithm for the 3-SUM problem that 
 * takes time proportional to n2 in the worst case.
 *******************************************************************************/
public class ThreeSumQuadratic {
    // Count three sum in an unordered list.
    // Cost: O(N?)
    public static int countThreeSum(int[] list) {
        int count = 0;
        // Order the list in O(N?).
        Arrays.sort(list);
        
        for (int i = 0; i < list.length; i++) {
            count += countTwoSumPivot(list, i);
        }
        return count/3;
    }    
    
    // Find all two sum pairs that result in -1*list[pivor]
    // Cost: O(N)
    public static int countTwoSumPivot(int[] list, int pivot) {
        int left = pivot-1, right = pivot + 1, count = 0, pivotValue = list[pivot];
        // Start from the pivot and spread out.
        while (left >= 0 && right < list.length) {
            if (list[left]+list[right] > -pivotValue) {
                left--;
            } else if (list[left]+list[right] < -pivotValue) {
                right++;
            } else {
                count++;
                left--;
                right++;
            }
        }
        // We've reached the end on one side (either left or right). It's time to bring both "left" and "right"
        // to the same side of the pivot and scan for two sums.
        if (pivotValue > 0) {
            left = 0;
            right = pivot - 1;
        } else if (pivotValue < 0) {
            left = pivot + 1;
            right = list.length - 1;
        } else {    // pivotValue is 0, so the entire calculation was effectively a two-sum problem.
            return count;
        }
        // Start from the ends of one block and move in.
        while (left < right) {
            if (list[left]+list[right] > -pivotValue) {
                right--;
            } else if (list[left]+list[right] < -pivotValue) {
                left++;
            } else {
                count++;
                left++;
                right--;
            }
        }
        return count;
    }
    
}