public class Point2{
   private int x=0; // the x coordinate
   private int y=0; // the y coordinate

   public Point2(int x , int y) {
	    this.x=x;
	    this.y=y;
   }
   
   @Override
   public boolean equals(Object p) {
	   //check class and null validation
	   if (p == null || !(p instanceof Point2)) return false;
	   //check instance variables
	   return (x==((Point2)p).x() && y == ((Point2)p).y())? true : false;

   }
   
   public int x() { return x;}
   public int y() { return y;}

}
