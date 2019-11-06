/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 */

public class Point3 extends Point2 {
	
	// Fields ------------------------------------

    private int z; // the z coordinate
    
    // Constructors ------------------------------------

    public Point3(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
    
    // Methods ------------------------------------

    /**
    * Determines the equality of two objects. This is a general catch all
    *
    * @param obj The general object to compare
    * @return boolean Whether the two objects are found to be equal
    */
    public boolean equals(Object p) { // overriding definition
        if (p instanceof Point3) {
            return equals((Point3) p);
        }

        return super.equals(p);
    }

    /**
     * Determines the equality of two objects. This is if an object thats an instance of Point2 object was sent in
     *
     * @param Point2 The Point2 object to compare
     * @return boolean Whether the two objects are found to be equal
     */
    public boolean equals(Point2 p) { // overriding definition
        if (p instanceof Point3) {
            return equals((Point3) p);
        }

        return super.equals(p);
    }

    /**
     * Determines the equality of two objects. This is if the object sent in turned out to be an instance of Point3 class.
     * This only compares the z value because the super call takes care of the rest.
     *
     * @param Point3 The Point3 object to compare
     * @return boolean Whether the two objects are found to be equal
     */
    public boolean equals(Point3 p) { // extra definition
        if (p == null || z != p.z) {
            return false;
        }

        return super.equals(p);
    }
}
