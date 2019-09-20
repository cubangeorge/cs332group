import java.util.Random;

/**
 * @author jorge, Valeria, Blake
 *
 */
public class BlackBox {
	private String content;
	
	public BlackBox() {
		String s="\n";
		for (int i=1;i<255;i++) {
			s+= Character.toString((char)i);
			System.out.println(s);
		}
		this.content+=s;
		
		
	}
	public BlackBox(String s) {
		this.content+=s;
	}
	
	@Override
	public String toString() {
		String s = "001000100100111001000101010101100100010101010010010011110101000001000101010"
				+ "01110010000010100001001001100010000010100001101001011010000100100111101011000"
				+ "001000010010000100100001001000010010000100111010001011010011111001101101011011"
				+ "0101101101011011010110110101110111011101110111011101110111011000010110100001100"
				+ "0010110100001100001011010000110000101101000011000010110100001100001011010000110"
				+ "0001011010000110000100100010";
		String r = "";
		return content+"\n"+decode(0,r,s);
	}
private static String decode(int i, String r, String s) {
		
		if (i>=s.length()-8) {
			return r;
		}
		r+=  (char)Integer.parseInt(s.substring(i, i+8),2);
		if(i==40||i==72||i==80||i==120) r+=" ";
		return decode(i+8,r,s);
		
	} 
}
