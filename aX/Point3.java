public class Point3 extends Point2 {
  

private int z; // the z coordinate
  
	public Point3(int x, int y) {
		super(x, y);
		z=0;
	}
   @Override 
   public boolean equals (Object p) { // overriding definition
      if (p instanceof Point3) return equals((Point3) p);
      return super.equals(p); }
   @Override
   public boolean equals (Point2 p) { // overriding definition
      if (p instanceof Point3) return equals((Point3) p);
      return super.equals(p); }

   public boolean equals (Point3 p) { // extra definition
      if (p == null || z != p.z) return false;
      return super.equals(p); }
}
