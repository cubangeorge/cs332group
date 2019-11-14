/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.time.Period;



public class MutablePeriod {
    // A period instance
    public final Period period;

    // period's start field, to which we shouldn't have access
    public final Date start;

    // period's end field, to which we shouldn't have access
    public final Date end;
    
    
    public MutablePeriod() {
        try {
            ByteArrayOutputStream bos =
                new ByteArrayOutputStream();
            ObjectOutputStream out =
                new ObjectOutputStream(bos);

            // Serialize a valid Period instance
            out.writeObject(new Period(new Date(), new Date()));

            /*
             * Append rogue "previous object refs" for internal
             * Date fields in Period. For details, see "Java
             * Object Serialization Specification," Section 6.4.
             */
            byte[] ref = { 0x71, 0, 0x7e, 0, 5 };  // Ref #5
            bos.write(ref); // The start field
            ref[4] = 4;     // Ref # 4
            bos.write(ref); // The end field

            // Deserialize Period and "stolen" Date references
            ObjectInputStream in = new ObjectInputStream(
                new ByteArrayInputStream(bos.toByteArray()));
            period = (Period) in.readObject();
            start  = (Date)   in.readObject();
            end    = (Date)   in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new AssertionError(e);
        }
    }
    
 // Immutable class that uses defensive copying
    public final class Period {
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
}