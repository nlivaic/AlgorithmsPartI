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
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static final double CONFIDENCE_95 = 1.96;
    private int currentTrial;
    private final int dimensionSize, totalTrials;
    private double[] percolationThresholds;
    private double mean, stddev;
    
    // Perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new java.lang.IllegalArgumentException(
                "n and trials arguments must be positive.");
        }
        this.totalTrials = trials;
        this.dimensionSize = n;
        this.percolationThresholds = new double[trials];
        for (currentTrial = 0; currentTrial < totalTrials; currentTrial++) {
            doTrial();
        }
        calculateStats();
    }
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats percStats = new PercolationStats(n, t);
        StdOut.printf("mean                    = %f\n", percStats.mean()); 
        StdOut.printf("stddev                  = %f\n", percStats.stddev()); 
        StdOut.printf("95%% confidence interval = [%f, %f]\n", 
                      percStats.confidenceLo(), percStats.confidenceHi());
    }
    
    // Sample mean of percolation threshold
    public double mean() {
        return mean;
    }
    
    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddev;
    }
    
    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (CONFIDENCE_95*stddev()/Math.sqrt(totalTrials));
    }
    
    // hi  endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (CONFIDENCE_95*stddev()/Math.sqrt(totalTrials));
    }
    
    private void doTrial() {
        // StdOut.printf("Start doTrial().");
        int row, col;
        Percolation percolation = new Percolation(dimensionSize);
        do {
             row = StdRandom.uniform(1, dimensionSize + 1);
             col = StdRandom.uniform(1, dimensionSize + 1);
             if (percolation.isOpen(row, col)) {
                 continue;    // Skip already opened sites.
             }
             percolation.open(row, col);
             // StdOut.printf("\t\topen("+row+", "+col+").\n");
        } while (!percolation.percolates());
        gatherStatistics(percolation);
    }
    
    private void gatherStatistics(Percolation percolation) {
        percolationThresholds[currentTrial] = 
            (double) percolation.numberOfOpenSites() / 
            (dimensionSize * dimensionSize);
    }
    
    private void calculateStats() {
        mean = StdStats.mean(percolationThresholds);
        stddev = StdStats.stddev(percolationThresholds);
    }
}