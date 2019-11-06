/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 */

public class Point2 {

    private int x; // the x coordinate
    private int y; // the y coordinate

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Determines the equality of two objects. This compares the x and y values.
     *
     * @param obj The general object to compare
     * @return boolean Whether the two objects are found to be equal
     */
    @Override
    public boolean equals(Object p) {
        if (p == this) {
            return true;
        }

        //check class and null validation
        if (!(p instanceof Point2)) {
            return false;
        }

        //check instance variables
        return x == ((Point2) p).x() && y == ((Point2) p).y();

    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
}
