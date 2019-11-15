import java.io.Serializable;
import java.util.Date;

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

    public Date start () { return new Date(start.getTime()); }

    public Date end () { return new Date(end.getTime()); }

    public String toString() { return start + " - " + end; }

   // ... // Remainder omitted
}

 
