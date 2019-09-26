/*
A short version of the Poly class for a 332 assignment.

	G 01066284 Valeria L Green (VG)
	G 00402127 Jorge L Martinez (JM) 
	G 01082586 Blake Khan (BK)
 */

public class Poly {

	private int[] trms;
	private int deg;

	// rep-inv:
	// 1) deg = trms.length - 1
	// 2) trms.length >= 1
	// 3) trms != null
	// 4) if deg > 0 then trms[deg] != 0

	// Constructs the zero Poly
	public Poly() {
		trms = new int[1]; trms[0] = 0;
		deg = 0;
	}

	// Constructs the monomial cx^n
	public Poly(int c, int n) throws IllegalArgumentException {
		if (n < 0) {
			throw new IllegalArgumentException("Poly(int, int) constructor");
		}
		if (c == 0) {
			trms = new int[1]; 
			trms[0] = 0;
			deg = 0;
			return;
		}
		trms = new int[n+1];
		for (int i=0; i < n; i++) {
			trms[i] = 0;
		}
		trms[n] = c;
		deg = n;
	}

	// for use by producers
	private Poly (int n) {
		trms = new int[n+1];
		deg = n;
	}

	// returns the degree of this
	public int degree() {
		return deg;
	}

	// returns this + q (throws NPE if q is null)
	public Poly add(Poly q) throws NullPointerException {
		Poly la, sm;
		if (deg > q.deg) {
			la = this; sm = q;
		}
		else {
			la = q; sm = this;
		}
		int newdeg = la.deg;
		if (deg == q.deg) {
			for (int k = deg; k > 0; k--) {   // fixed k++ bug here 10/10/2011
				if (trms[k] + q.trms[k] != 0) {
					break;
				}
				else {
					newdeg--;
				}
			}
		}
		Poly r = new Poly(newdeg);
		int i;
		for (i = 0; i <= sm.deg && i <= newdeg; i++) {
			r.trms[i] = sm.trms[i] + la.trms[i];
		}
		for (int j = i; j <= newdeg; j++) {
			r.trms[j] = la.trms[j];
		}
		return r;
	}

	// implements AF - assuming all four predicates in rep-invariant
	public String toString() {
		String r = "Poly:";

		if (deg == 0 || trms[0] != 0) {
			r += " " + trms[0];
		}

		for (int i = 1; i <= deg; i++) {
			if (trms[i] < 0) {
				r += " - " + -trms[i] + "x^" + i;
			}
			else if (trms[i] > 0) {
				r += " + " +  trms[i] + "x^" + i;
			}
		}
		return r;
	}

	/*Implement the original rep-invariant in a method repOk(). 
	 */

	public boolean repOk() {
		/*  trms != null
   		 * 	deg = trms.length - 1
   		 *	trms.length >= 1
   		 * if deg > 0 then trms[deg] != 0
		*/
					
		if (weakRepOk()) { //check first 3 constrains
			if(deg > 0) {  // check 4th 
				if (trms[deg]!=0) {	//check last constrain
					return true;
				}
			}
		}
		
		
		return false;
	}

	/*
	 * Implement the weaker rep-invariant in a method weakRepOk().
	 */
	public boolean weakRepOk() {
		if ( trms != null && deg == trms.length - 1 && (trms.length >= 1) && (trms.length >= 1) )    
			return true;
		return false;
	}


}
