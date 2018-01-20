public class Point implements Comparable {
    public int x;
    public int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    //  0 - points have same coordinates
    // -1 - points have different coordinates
    public int compareTo(Object arg0) {
        Point b = (Point)arg0;
        //return this.x == b.x && this.y == b.y ? 0 : -1;
        if (this.x < b.x) return -1;
        else if (this.x == b.x  && this.y < b.y) return -1;
        else if (this.x == b.x  && this.y == b.y) return 0;
        else if (this.x == b.x  && this.y > b.y) return  1;
        else return 1;
    }
    
    public String toString() {
        return "(" + String.format("%3d", x) + ", " + String.format("%3d", y) + ")";
    }
}
