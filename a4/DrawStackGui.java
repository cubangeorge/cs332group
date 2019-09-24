/**
 * @author jorge
 *
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.Random;
import java.util.Vector;

import javax.swing.*;



public class DrawStackGui extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1245757140777120082L;
	
	public static void main(String[] args) 
	{
        SwingUtilities.invokeLater( new Runnable() {   public void run() { createAndShowGUI();}   });
    }//end main
    
    private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+ SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Stack Gui");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JComponent contentPane = new MyStackPanel();
        f.setContentPane(contentPane);
        f.pack();
        f.setVisible(true);

        
    }
}//end DrawStackGui

class MyStackPanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5034104827583672362L;
	private Dimension area; //indicates area taken up by graphics
    private Vector<Rec> boxes; //coordinates used to draw graphics
    private JPanel drawingPane;
 
    
    public MyStackPanel() {
        super(new BorderLayout());
 
        area = new Dimension(0,0);
        boxes = new Vector<Rec>();
 
        //Set up the instructions.
        JLabel  instructions = new JLabel("The highest box represents the Stack TOP");
        instructions.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel instructionPanel = new JPanel(new GridLayout(0,1));
        //instructionPanel.setFocusable(true);
        instructionPanel.add(instructions);
 
        //Set up the drawing area.
        drawingPane = new DrawingPane();
        drawingPane.setBackground(Color.white);
        drawStuff_in_memory();
        
        //Put the drawing area in a scroll pane.
        JScrollPane scroller = new JScrollPane(drawingPane);
        scroller.setPreferredSize(new Dimension(600,600));
 
        //Lay out this demo.
        add(instructionPanel, BorderLayout.PAGE_START);
        add(scroller, BorderLayout.CENTER);
    }
 
    /** The component inside the scroll pane. */
    public class DrawingPane extends JPanel {
        /**
		 * 
		 */
		private static final long serialVersionUID = 8307146537943810012L;

    	@Override
		protected void paintComponent(Graphics g) {
            super.paintComponent(g);
        	         
            int corner = 120;//corner angle
            	
            Rec rect;
            for (int i = 0; i < boxes.size(); i++) {
                rect = boxes.elementAt(i);
                g.setColor(Color.black); 
                g.fillRoundRect(rect.x, rect.y, rect.width, rect.height, corner, corner);
                //draw little sqr
                g.setColor(rect.color);
                g.fillRoundRect(rect.x+20, rect.y+20, rect.width-40, rect.height-40, corner, corner-20);;
                //draw the text
                g.setColor(Color.black);
                g.drawString("-->",rect.x+rect.width/2,rect.y+rect.height/2);
                
             }
        }
    }
 
    //drawstuff save the parameters for the area in which each box is saved, the put it in the 
    //vector for painting later
    public void drawStuff_in_memory() {
    	
    	boolean changed = false;

    	int x=210;//outside sqr origin x
        int y=80;// outside sqr Origin y
        int lenx = 280;//outside sqr x len
        int leny = 180;//outside sqr y len
        
        final Color colors[] = {
                Color.red, Color.white, Color.green, Color.orange,
                Color.cyan, Color.pink, Color.lightGray, Color.yellow};
        
        Random rand = new Random(23);
        
        //draw node 
        for (int i =0; i<10;i++) {

        	Rec rect = new Rec(x, y, lenx, leny, colors[rand.nextInt(colors.length)] );
        	boxes.addElement(rect);
        	drawingPane.scrollRectToVisible(rect);
        	

        	y=y+leny;
        	int this_height = (y + 2);
        	if (this_height > area.height) {
        		area.height = this_height; changed=true;
        	}
        }
    	if (changed) {
    		//Update client's preferred size because
    		//the area taken up by the graphics has
    		//gotten larger or smaller (if cleared).
    		drawingPane.setPreferredSize(area);

    		//Let the scroll pane know to update itself
    		//and its scrollbars.
    		drawingPane.revalidate();
    	}
    	drawingPane.repaint();
    }

    
   
}

	class Rec extends Rectangle{
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		Color color; 
	
		public Rec(int x , int y, int lenx, int leny, Color c) {
			super ( x ,  y, lenx, leny); 
	
			color = c;
		}
	
}