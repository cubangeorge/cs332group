import java.io.Serializable;
import java.util.Date;
/**
 * @author jorge
 *
 */
public class MaliciousPeriod extends Period implements Serializable {

	/**
	 * @param start used to shadow super copies
	 * @param end   used to shadow super copies
	 */
	Date start;
	Date end;
	public MaliciousPeriod(java.util.Date start, java.util.Date end) {
		//no check of any kind
		super(start,start);//wont complaint since its the same
		this.start = new Date(start.getTime());
        this.end   = new Date(end.getTime());
		
	}
	@Override
	 public Date start () { return new Date(start.getTime()); }
	@Override
	 public Date end () { return new Date(end.getTime()); }
	 @Override
	 public String toString() { return start + " - " + end; }

}
