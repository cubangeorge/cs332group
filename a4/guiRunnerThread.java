/**
 * 
 */

/**
 * @author jorge, Blake, Valeria
 *
 */
public class guiRunnerThread extends Thread {
	Stack s = null;
	guiRunnerThread(Stack s){
		this.s =s;
		
	}
	public void run() 
    { 
        System.out.println("Current thread name: "
                           + Thread.currentThread().getName()); 
        System.out.println("run() method called"); 
        DrawStackGui.main2(s);
        try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    } 
}
