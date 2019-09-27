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
		trms = new int[1];
		trms[0] = 0;
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
		}//la will point to larger array sm will point to samller from here on 
		int newdeg = la.deg;
		if (deg == q.deg) {//if both have same size do this 
			//dtermine largest degree by looking new coef after adding them
			//purpose is to update newdeg stops decrementing it as soon as it detects nonzero coef
			for (int k = deg; k > 0; k--) {   // fixed k++ bug here 10/10/2011
				if (trms[k] + q.trms[k] != 0) {
					break;
				}
				else {
					newdeg--;
				}
			}
		}
		// now it knows how big the new coef should be
		Poly r = new Poly(newdeg);//so create it
		int i;
		//now compute and store new coefs in r
		for (i = 0; i <= sm.deg && i <= newdeg; i++) {
			r.trms[i] = sm.trms[i] + la.trms[i];
		}
		//i survives this loop so that 
		//it can copy the remaing terms from 
		//largest array into the new one
		//these last terms never get added
		//just copied over 
		for (int j = i; j <= newdeg; j++) {
			r.trms[j] = la.trms[j];
		}
		return r;
	}

	// implements AF - assuming all four predicates in rep-invariant
	public String toString() {
		String r = "Poly: ";

		if (deg == 0 || trms[0] != 0) {
			r += trms[0];
		}

		for (int i = 1; i <= deg; i++) {
			if (trms[i] < 0) {
				if(this.all_left_terms_r_zero(i, trms))//takes care of useles leading sign
					r += -trms[i] + "x^" + i;
				else {
					r += " - " + -trms[i] + "x^" + i;
				}
			}
			else 
				if (trms[i] > 0) {
					if(this.all_left_terms_r_zero(i, trms))//takes care of useles leading sign
						r += +  trms[i] + "x^" + i;
					else {
						r += " + " +  trms[i] + "x^" + i;
					}
			}
		}
		return r;
	}
	//this checks if all terms to the left are zero used to 
	//determine wether or not to include a sign in the term being printed
	//it starts by checking the left immediate position from the index
	//if it gets index 2 i starts checking at index 1
	//return:
	//	false if index out of range  
	//	false if index negative
	//  
	public boolean all_left_terms_r_zero(int index, int [] temp) {
		if (index <0 || index>temp.length-1)return false;
		if (index == 0 )return true; // covers first coef case 
		
		for (int i=index-1;i >= 0; i--) {
			if (temp[i]!=0) return false;
		}
		return true;
	}

	/*Implement the original rep-invariant in a method repOk(). 
	 */

	public boolean repOk() {
		/*  trms != null
   		 * 	deg = trms.length - 1
   		 *	trms.length >= 1
   		 *  if deg > 0 then trms[deg] != 0
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
	
	
	public int getCoefAtIndex(int index) {
		
		return trms[index];
	}
	/**
	 * created for testing purposes 
	 * @return
	 */
	public int[] getTermRef() {
		
		return this.trms;
	}
	
	/**
	 * 
	 * @param value for coefficient
	 * @param index index where coef is stored 
	 * @return 1 if all ok 
	 */
	public int setValueAtIndex(int val, int index) {
		//this method is used only for testing purposes 
		//in order to keep instance members private 
		
		return 1;
	}

	//will pass weakRepOk and not pass repOkay. send in array with trailing zeroes then it should be okay
	// returns this + q (throws NPE if q is null)
	public Poly weakAdd(Poly q) throws NullPointerException {
		Poly la, sm;
		//if main degree is bigger than input degree
		if (deg > q.deg) {
			la = this; sm = q;
		}
		else {
			la = q; sm = this;
		}
		int newdeg = la.deg;
		
		Poly r = new Poly(newdeg);
		int i;
		for (i = 0; i <= sm.deg && i <= newdeg; i++) {
			r.trms[i] = sm.trms[i] + la.trms[i];
		}
		for (int j = i; j <= newdeg; j++) {
			r.trms[j] = la.trms[j];
		}
		//resulting Poly array will contain zeroes any where even trailing ones
		return r;
	}
}
