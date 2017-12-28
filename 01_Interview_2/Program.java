import edu.princeton.cs.algs4.StdOut;

public class Program {
    public static void main(String[] args) {
        testBitonicBinarySearch();
    }
    
    public static void testBitonicBinarySearch() {
        int[] bitonicSearchList1 = {6,13,14,25,33,43,51,53,64,72,/**/97,96,95,93,84};
        int[] bitonicSearchList2 = {6,13,14,25,33,43,51,53,64,72,96,/**/97,95,93,84};  //pivot: 11
        int[] bitonicSearchList3 = {6,13,14,25,33,43,51,53,64,72,95,96,/**/97,93,84};
        int[] bitonicSearchList4 = {6,13,14,25,33,43,51,53,64,72,93,95,96,/**/97,84};
        int[] bitonicSearchList5 = {6,13,14,25,33,43,51,/**/97,96,95,93,72,84,64,53};
        int[] bitonicSearchList6 = {6,13,14,25,33,43,/**/97,96,95,93,72,84,64,53,51};
        int[] bitonicSearchList7 = {6,13,14,25,33,43,51,96,/**/97,95,93,72,84,64,53};
        int[] bitonicSearchList8 = {51,/**/97,96};
        int[] bitonicSearchList9 = {51,96,/**/97};
        int[] bitonicSearchList10 = {/**/97,96,51,2};
        int[] binarySearchList =   {6,13,14,25,33,43,51,53,64,72,84,93,95,96,/**/97};
        
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.bitonicFind(bitonicSearchList1, 51));    // 6
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.bitonicFind(bitonicSearchList2, 84));    // 14    *
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.bitonicFind(bitonicSearchList3, 96));    // 11
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.bitonicFind(bitonicSearchList4, 33));   // 4
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.bitonicFind(bitonicSearchList5, 96));    // 8    *
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.bitonicFind(bitonicSearchList6, 43));    // 5
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.bitonicFind(bitonicSearchList7, 93));    // 10  *
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.bitonicFind(bitonicSearchList8, 51));    // 0
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.bitonicFind(bitonicSearchList9, 97));    // 2
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.bitonicFind(bitonicSearchList10, 97));   // 0
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.bitonicFind(binarySearchList, 97));    // 14
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.bitonicFind(binarySearchList, 1000000));    // -1
    }
    
    
    public static void testPivotBinarySearch() {
        int[] bitonicSearchList1 = {6,13,14,25,33,43,51,53,64,72,/**/97,96,95,93,84};
        int[] bitonicSearchList2 = {6,13,14,25,33,43,51,53,64,72,96,/**/97,95,93,84};
        int[] bitonicSearchList3 = {6,13,14,25,33,43,51,53,64,72,95,96,/**/97,93,84};
        int[] bitonicSearchList4 = {6,13,14,25,33,43,51,53,64,72,93,95,96,/**/97,84};
        int[] bitonicSearchList5 = {6,13,14,25,33,43,51, 97, 96,95,93,72,84,64,53};
        int[] bitonicSearchList6 = {6,13,14,25,33,43, 97, 96,95,93,72,84,64,53,51};
        int[] bitonicSearchList7 = {6,13,14,25,33,43,51,96, 97, 95,93,72,84,64,53};
        int[] bitonicSearchList8 = {51, 97, 96};
        int[] bitonicSearchList9 = {51, 96, 97};
        int[] bitonicSearchList10 = {97, 96, 51, 2};
        int[] binarySearchList =   {6,13,14,25,33,43,51,53,64,72,84,93,95,96,97};
        
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.findPivot(bitonicSearchList1));    // 10
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.findPivot(bitonicSearchList2));    // 11
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.findPivot(bitonicSearchList3));    // 12
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.findPivot(bitonicSearchList4));    // 13
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.findPivot(bitonicSearchList5));    // 7
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.findPivot(bitonicSearchList6));    // 6
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.findPivot(bitonicSearchList7));    // 8
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.findPivot(bitonicSearchList8));    // 1
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.findPivot(bitonicSearchList9));    // 2
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.findPivot(bitonicSearchList10));   // 0
        StdOut.printf("Bitonic pivot search result: %d\n", BitonicSearch.findPivot(binarySearchList));    // 14
    }
}