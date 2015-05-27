package calcGPA;

import javax.swing.*;

public class GpaView extends JFrame {

	
	public GpaView(){
		
		
		
		setSize(250, 400);
		setTitle("GPA Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	
	
	/**
	 * Displays the scramble pad GUI
	 * 
	 * @param args
	 *            - unused
	 */
	public static void main(String[] args) {

		GpaView testWindow = new GpaView();
		testWindow.setVisible(true);

	}

}