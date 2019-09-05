import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TestStuffCS332 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int j; // uninitialized
		int [ ] a = {1,3,5,7,9}; // creates a 5-element array
		int [ ] b = new int[3];
		String s = "abcdef"; // creates a new string
		String t = "";
		t = t + "g";
		System.out.println(""+t);
		
		b = new int[] {2,3,4,5,6};
	
		List<Integer> list_a = Arrays.asList(1,2,3,4,5);
		
		list_a.forEach(System.out::print);
		list_a.stream().forEach((c) -> System.out.println(c));
		list_a.stream().forEach((c) -> System.out.printf("%d",c));
		
		for (Integer i : list_a  )
				System.out.println(i);
		
		Iterator<Integer> itr = list_a.iterator();
	 
		while(itr.hasNext()) {
		    System.out.print(itr.next()); 
		}
		//in reverse
		ListIterator<Integer> litr = list_a.listIterator(list_a.size());
		
		while(litr.hasPrevious()) {
			System.out.print(litr.previous()); 
		}
	
		System.out.println("list size is: "+list_a.size());
		System.out.println("item at index 3 is: "+list_a.get(3));
		
	}
	
	

}
