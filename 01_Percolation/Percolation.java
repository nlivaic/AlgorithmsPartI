/******************************************************************************
 *  Name: Nenad Livaic
 *  NetID: nenad.livaic
 *  Precept: P01
 *
 *  Partner Name:    None
 *  Partner NetID:   None
 *  Partner Precept: None
 * 
 *  Description:  Model an n-by-n percolation system using the union-find
 *                data structure.
 ******************************************************************************/
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    // private static final int TOP_VIRTUAL_NODE_COUNT = 1;
    private static final int TOP_VIRTUAL_NODE_COUNT = 1;
    private static final int BOTTOM_VIRTUAL_NODE_COUNT = 1;
    // Position in Union Find "id" structure.
    private static final int TOP_VIRTUAL_NODE_INDEX = 0;
    private final int dimensionSize;
    private boolean[][] grid;
    // First <TOP_VIRTUAL_NODE_COUNT+BOTTOM_VIRTUAL_NODE_COUNT> 
    // elements are not used directly by clients.
    private final WeightedQuickUnionUF uf;
    private int bottomVirtualNodeIndex;
    private int numberOfOpenSites = 0;
        
    public Percolation(int n) {
        if (n <= 0) {
            throw new java.lang.IllegalArgumentException(
                "Percolation grid cannot be initialized with non-positive values.");
        }
        dimensionSize = n;
        grid = new boolean[n][n];
        int ufSize = n*n + TOP_VIRTUAL_NODE_COUNT + BOTTOM_VIRTUAL_NODE_COUNT;
        uf = new WeightedQuickUnionUF(ufSize);
        bottomVirtualNodeIndex = ufSize - 1;    // Last index is bottom virtual node.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;        // Block all sites.
            }
        }
    }
    
    public void open(int row, int col) {
        if ((row < 1 || row > dimensionSize) || (col < 1 || col > dimensionSize)) {
            throw new java.lang.IllegalArgumentException(
                "Row and column arguments must be positive.");
        }
        int gRow = gRow(row);
        int gCol = gCol(col);
        if (grid[gRow][gCol]) {
            return;
        }        
        grid[gRow][gCol] = true;                    // Site opened.
        // Test site left of this one.
        if (col > 1 && isOpen(row, col-1)) {
            // StdOut.printf("\t\t -> Left of (" + row + ", " + col + ") ends up "
            // +"in union(" + ufElem(row, col) + ", " + ufElem(row, col-1) + ")");
            uf.union(ufElem(row, col), ufElem(row, col-1));
        }
        // Test site right of this one.
        if (col < dimensionSize && isOpen(row, col+1)) {
            // StdOut.printf("\t\t -> Right of (" + row + ", " + col + ") ends up"
            // +" in union(" + ufElem(row, col) + ", " + ufElem(row, col+1) + ")");
            uf.union(ufElem(row, col), ufElem(row, col+1));
        }
        // Test site above this one.
        if (row > 1 && isOpen(row-1, col)) {
            // StdOut.printf("\t\t -> Above (" + row + ", " + col + ") ends up in "
            // +"union(" + ufElem(row, col) + ", " + ufElem(row-1, col) + ")");
            uf.union(ufElem(row, col), ufElem(row-1, col));
        }
        // Test site below this one.
        if (row < dimensionSize && isOpen(row+1, col)) {
            // StdOut.printf("\t\t -> Below (" + row + ", " + col + ") ends up in "
            // +"union(" + ufElem(row, col) + ", " + ufElem(row+1, col) + ")");
            uf.union(ufElem(row, col), ufElem(row+1, col));
        }
        // Top row element must be connected to top virtual node.
        if (row == 1) {
            // StdOut.printf("\t\t -> Top row (" + row + ", " + col + ") ends up in "
            // +"union(" + ufElem(row, col) + ", " + TOP_VIRTUAL_NODE_INDEX + ")");
            uf.union(ufElem(row, col), TOP_VIRTUAL_NODE_INDEX);
        } 
        // Bottom row element must be connected to bottom virtual node.
        if (row == dimensionSize) {        
            // StdOut.printf("\t\t -> Bottom row (" + row + ", " + col + ") ends up "
            // +"in union(" + ufElem(row, col) + ", " + bottomVirtualNodeIndex + ")");
            uf.union(ufElem(row, col), bottomVirtualNodeIndex);
        }
        numberOfOpenSites++;
    }
    
    public boolean isOpen(int row, int col) {
        if ((row < 1 || row > dimensionSize) || (col < 1 || col > dimensionSize)) {
            throw new java.lang.IllegalArgumentException(
                "Row and column arguments must be positive.");
        }
        return grid[gRow(row)][gRow(col)];
    }
    
    public boolean isFull(int row, int col) {
        if ((row < 1 || row > dimensionSize) || (col < 1 || col > dimensionSize)) {
            throw new java.lang.IllegalArgumentException(
                "Row and column arguments must be positive.");
        }
        return uf.connected(ufElem(row, col), TOP_VIRTUAL_NODE_INDEX);
    }
    
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }
    
    public boolean percolates() {
        return uf.connected(TOP_VIRTUAL_NODE_INDEX, bottomVirtualNodeIndex);
    }
    
    // Pass in API row (1-based index), 
    // it will return a grid-compliant 0-based index.
    private int gRow(int row) { return row - 1; }
    // Pass in API column (1-based index), 
    // it will return a grid-compliant 0-based index.
    private int gCol(int col) { return col - 1; }
    // Pass in API row and column (1-based index), 
    // it will return Union Find structure's index for the respective element.
    private int ufElem(int row, int col) {
        return (row - 1) * dimensionSize + (col - 1) + TOP_VIRTUAL_NODE_COUNT; 
    }
}