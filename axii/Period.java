import java.io.Serializable;
import java.util.Date;
/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 */
//Got rid of the final keyword for the class so mutable period could extend it
// Immutable class that uses defensive copying

public class Period implements Serializable {
    
	private static final long serialVersionUID = 4647424730390249716L;
	private final Date start;
    private final Date end;
    /**
     * @param  start the beginning of the period
     * @param  end the end of the period; must not precede start
     * @throws IllegalArgumentException if start is after end
     * @throws NullPointerException if start or end is null
     */
    public Period(Date start, Date end) {

    	this.start = new Date(start.getTime());
        this.end   = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0)
            throw new IllegalArgumentException(
                          start + " after " + end);
    }

    /**
     * @return Date The start time of the period
     */
    public Date start () { return new Date(start.getTime()); }

    /**
     * @return Date The end time of the period
     */
    public Date end () { return new Date(end.getTime()); }

    /**
     * @return String The start and end time of the period in string format
     */
    public String toString() { return start + " - " + end; }

   // ... // Remainder omitted
}

 
