package calcGPA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class GpaView extends JFrame {

	/**
	 * The array of letter grades
	 */
	public final String[] LETGRADES = { "None", "A", "A-", "B+", "B", "B-",
			"C+", "C", "D", "D-", "F" };

	private int calculatedGPA = 0;

	JTextField outputGPA = new JTextField("Calculated GPA");

	/**
	 * An arraylist for storing user entered courses
	 */
	ArrayList<String> courseList = new ArrayList<String>();

	/**
	 * 
	 * Used to set up the GUI, adds all the different components to the frame.
	 * 
	 */
	public GpaView() {

		add(gradeList(), BorderLayout.CENTER);
		add(courseList(), BorderLayout.WEST);
		setSize(250, 400);
		setResizable(false);
		setTitle("GPA Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * Create a column of grades that users may choose from
	 * 
	 * @return columns of grade drop down
	 */
	@SuppressWarnings("unchecked")
	public Component gradeList() {

		JPanel gradePanel = new JPanel();
		JPanel calcPanel = new JPanel();
		JPanel combinedPanel = new JPanel();
		JPanel outputPanel = new JPanel();

		GridLayout combinedLayout = new GridLayout(1, 2);
		GridLayout gradeLayout = new GridLayout(6, 0);

		JComboBox row1 = new JComboBox(LETGRADES);
		JComboBox row2 = new JComboBox(LETGRADES);
		JComboBox row3 = new JComboBox(LETGRADES);
		JComboBox row4 = new JComboBox(LETGRADES);
		JComboBox row5 = new JComboBox(LETGRADES);
		JComboBox row6 = new JComboBox(LETGRADES);

		JButton calcButton = new JButton("Calculate");

		/*
		 * Create a frame with two columns one for choosing grades and the other
		 * for output
		 */
		gradePanel.setLayout(gradeLayout);
		combinedPanel.setLayout(combinedLayout);

		outputPanel.setLayout(new GridLayout(2, 0));
		outputPanel.add(calcButton);
		outputPanel.add(outputGPA);

		calcPanel.setLayout(new BorderLayout());
		calcPanel.add(outputPanel, BorderLayout.SOUTH);

		combinedPanel.add(gradePanel);
		combinedPanel.add(calcPanel);
		gradePanel.add(row1);
		gradePanel.add(row2);
		gradePanel.add(row3);
		gradePanel.add(row4);
		gradePanel.add(row5);
		gradePanel.add(row6);

		calcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputGPA.setText(Integer.toString(calculatedGPA));
			}
		});

		gradePanel.setVisible(true);

		return combinedPanel;

	}

	public Component courseList() {

		JPanel coursePanel = new JPanel();
		GridLayout courseLayout = new GridLayout(6, 0);
		Font boldFont = new Font("SansSerif", Font.BOLD, 12);

		JTextField course1 = new JTextField("Course 1");
		course1.setEditable(false);
		course1.setBackground(Color.WHITE);
		course1.setFont(boldFont);
		JTextField course2 = new JTextField("Course 2");
		course2.setEditable(false);
		course2.setBackground(Color.WHITE);
		course2.setFont(boldFont);
		JTextField course3 = new JTextField("Course 3");
		course3.setEditable(false);
		course3.setBackground(Color.WHITE);
		course3.setFont(boldFont);
		JTextField course4 = new JTextField("Course 4");
		course4.setEditable(false);
		course4.setBackground(Color.WHITE);
		course4.setFont(boldFont);
		JTextField course5 = new JTextField("Course 5");
		course5.setEditable(false);
		course5.setBackground(Color.WHITE);
		course5.setFont(boldFont);
		JTextField course6 = new JTextField("Course 6");
		course6.setEditable(false);
		course6.setBackground(Color.WHITE);
		course6.setFont(boldFont);

		coursePanel.setLayout(courseLayout);
		coursePanel.add(course1);
		coursePanel.add(course2);
		coursePanel.add(course3);
		coursePanel.add(course4);
		coursePanel.add(course5);
		coursePanel.add(course6);

		coursePanel.setVisible(true);

		return coursePanel;

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