
public class Point2 {

    private int x; // the x coordinate
    private int y; // the y coordinate

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

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
    public String toString() {
    	return "("+this.x()+","+this.y()+")";
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
}
