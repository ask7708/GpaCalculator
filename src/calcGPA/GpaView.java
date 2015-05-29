package calcGPA;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

public class GpaView extends JFrame {

	
	/**
	 * The array of letter grades
	 */
	public final String[] LETGRADES = {"A",  "A-", "B+", "B",
			"B-", "C+", "C",  "D",  "D-", "E",  "F"};
	
	/**
	 * An arraylist for storing user entered courses
	 */
	ArrayList<String> courseList = new ArrayList<String>();
	
	
	/**
	 * 
	 * Used to set up the GUI, adds all the different 
	 * components to the frame.
	 * 
	 */
	public GpaView(){
		
		
		add(gradeList(), BorderLayout.CENTER );
		setSize(250, 400);
		setTitle("GPA Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public Component gradeList(){
		
		JPanel gradePanel = new JPanel();
		GridLayout gradeLayout = new GridLayout(6,0);
	
		gradePanel.setLayout(gradeLayout);
		gradePanel.add(new JComboBox(LETGRADES));
		gradePanel.add(new JComboBox(LETGRADES));
		gradePanel.add(new JComboBox(LETGRADES));
		gradePanel.add(new JComboBox(LETGRADES));
		gradePanel.add(new JComboBox(LETGRADES));
		gradePanel.add(new JComboBox(LETGRADES));
		gradePanel.setVisible(true);
		
		return gradePanel;
		
	}
	
	
	
	
	/**
	 * Displays the GPA GUI
	 * 
	 * @param args
	 *            - unused
	 */
	public static void main(String[] args) {

		GpaView testWindow = new GpaView();
		testWindow.setVisible(true);

	}

}