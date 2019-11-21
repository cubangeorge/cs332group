import java.io.Serializable;
import java.util.Date;

/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 */
public class MaliciousPeriod extends Period implements Serializable {

    /**
     * @param start used to shadow super copies
     * @param end   used to shadow super copies
     */
    Date start;
    Date end;

    public MaliciousPeriod(java.util.Date e, java.util.Date s) {
        //no check of any kind
        super(s, s);//wont complaint since its the same
        this.start = e;
        this.end = s;

    }

    /**
     * @return Date The start time of the period
     */
    @Override
    public Date start() {
        return new Date(start.getTime());
    }

    /**
     * @return Date The end time of the period
     */
    @Override
    public Date end() {
        return new Date(end.getTime());
    }

    /**
     * @return String The start and end time of the period in string format
     */
    @Override
    public String toString() {
        return start + " - " + end;
    }

}
