package calcGPA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class GpaView extends JFrame {

	
	/**
	 * 
	 * Sets up formatting for output of GPA
	 */
	DecimalFormat df = new DecimalFormat("0.00"); 
	
	/**
	 * 
	 * Exception to be used if credit hours are bigger than 10
	 * 
	 * @return
	 */
	CustomException creditException = new CustomException(
			"Max credit hours is 10, please choose a smaller number.");

	/**
	 * The array of letter grades
	 */
	public final String[] LETGRADES = { "None", "A", "A-", "B+", "B", "B-",
			"C+", "C", "D", "D-", "F" };

	public final double[] NUMGRADES = { 0.0, 4.00, 3.67, 3.33, 3.00, 2.67,
			2.33, 2.00, 1.67, 1.00, 0.00 };

	/**
	 * 
	 * The calculated GPA of all courses given
	 */
	private double calculatedGPA = 0;

	/**
	 * The output on the UI of the calculated GPA
	 * 
	 */
	JTextField outputGPA = new JTextField("Calculated GPA");

	/**
	 * 
	 * Drop down boxes for the user to select from for grades
	 */
	JComboBox<String> chooseGrade1 = new JComboBox<String>(LETGRADES);
	JComboBox<String> chooseGrade2 = new JComboBox<String>(LETGRADES);
	JComboBox<String> chooseGrade3 = new JComboBox<String>(LETGRADES);
	JComboBox<String> chooseGrade4 = new JComboBox<String>(LETGRADES);
	JComboBox<String> chooseGrade5 = new JComboBox<String>(LETGRADES);
	JComboBox<String> chooseGrade6 = new JComboBox<String>(LETGRADES);

	JTextArea credit1 = new JTextArea("0");
	JTextArea credit2 = new JTextArea("0");
	JTextArea credit3 = new JTextArea("0");
	JTextArea credit4 = new JTextArea("0");
	JTextArea credit5 = new JTextArea("0");
	JTextArea credit6 = new JTextArea("0");

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
		setSize(400, 300);
		setResizable(false);
		setTitle("GPA Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * Create a column of grades that users may choose from
	 * 
	 * @return columns of grade drop down
	 */
	public Component gradeList() {

		JPanel gradePanel = new JPanel();
		JPanel calcPanel = new JPanel();
		JPanel combinedPanel = new JPanel();
		JPanel outputPanel = new JPanel();

		GridLayout combinedLayout = new GridLayout(1, 2);
		GridLayout gradeLayout = new GridLayout(7, 0);

		JLabel gradeLabel = new JLabel("Grade");
		gradeLabel.setOpaque(true);
		gradeLabel.setBackground(Color.BLACK);
		gradeLabel.setForeground(Color.WHITE);
		gradeLabel.setBorder(BorderFactory.createLineBorder(Color.white));

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

		gradePanel.add(gradeLabel);
		gradePanel.add(chooseGrade1);
		gradePanel.add(chooseGrade2);
		gradePanel.add(chooseGrade3);
		gradePanel.add(chooseGrade4);
		gradePanel.add(chooseGrade5);
		gradePanel.add(chooseGrade6);

		combinedPanel.add(gradePanel);
		combinedPanel.add(calcPanel);

		calcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					calculateWeightedGpa();
				} catch (CustomException e1) {

					System.out
							.println("Please a numeric integer value less than 10");
				} catch (NumberFormatException nfe) {

					System.out
							.println("Please a numeric integer value less than 10");
				}

				
				outputGPA.setText(df.format((calculatedGPA)));
			}
		});

		gradePanel.setVisible(true);

		return combinedPanel;

	}

	/**
	 * Creates a list where users
	 * 
	 * @return
	 */
	public Component courseList() {

		JPanel coursePanel = new JPanel();
		JPanel creditPanel = new JPanel();
		JPanel combinedccPanel = new JPanel();

		GridLayout courseLayout = new GridLayout(7, 0);
		Font boldFont = new Font("SansSerif", Font.BOLD, 12);

		JLabel courseLabel = new JLabel("Course");
		courseLabel.setOpaque(true);
		courseLabel.setBackground(Color.BLACK);
		courseLabel.setForeground(Color.white);
		courseLabel.setBorder(BorderFactory.createLineBorder(Color.white));

		JLabel creditLabel = new JLabel("Credit Hrs");
		creditLabel.setOpaque(true);
		creditLabel.setBackground(Color.BLACK);
		creditLabel.setForeground(Color.white);
		creditLabel.setBorder(BorderFactory.createLineBorder(Color.white));

		// Sets up the courses column
		JTextArea course1 = new JTextArea("Course 1");
		course1.setBackground(Color.WHITE);
		course1.setFont(boldFont);
		course1.setLineWrap(true);
		course1.setBorder(BorderFactory.createLineBorder(Color.black));
		JTextArea course2 = new JTextArea("Course 2");
		course2.setBackground(Color.WHITE);
		course2.setFont(boldFont);
		course2.setLineWrap(true);
		course2.setBorder(BorderFactory.createLineBorder(Color.black));
		JTextArea course3 = new JTextArea("Course 3");
		course3.setBackground(Color.WHITE);
		course3.setFont(boldFont);
		course3.setLineWrap(true);
		course3.setBorder(BorderFactory.createLineBorder(Color.black));
		JTextArea course4 = new JTextArea("Course 4");
		course4.setBackground(Color.WHITE);
		course4.setFont(boldFont);
		course4.setLineWrap(true);
		course4.setBorder(BorderFactory.createLineBorder(Color.black));
		JTextArea course5 = new JTextArea("Course 5");
		course5.setBackground(Color.WHITE);
		course5.setFont(boldFont);
		course5.setLineWrap(true);
		course5.setBorder(BorderFactory.createLineBorder(Color.black));
		JTextArea course6 = new JTextArea("Course 6");
		course6.setBackground(Color.WHITE);
		course6.setFont(boldFont);
		course6.setLineWrap(true);
		course6.setBorder(BorderFactory.createLineBorder(Color.black));

		// sets up the credits column

		credit1.setBackground(Color.WHITE);
		credit1.setFont(boldFont);
		credit1.setLineWrap(true);
		credit1.setBorder(BorderFactory.createLineBorder(Color.black));

		credit2.setBackground(Color.WHITE);
		credit2.setFont(boldFont);
		credit2.setLineWrap(true);
		credit2.setBorder(BorderFactory.createLineBorder(Color.black));

		credit3.setBackground(Color.WHITE);
		credit3.setFont(boldFont);
		credit3.setLineWrap(true);
		credit3.setBorder(BorderFactory.createLineBorder(Color.black));

		credit4.setBackground(Color.WHITE);
		credit4.setFont(boldFont);
		credit4.setLineWrap(true);
		credit4.setBorder(BorderFactory.createLineBorder(Color.black));

		credit5.setBackground(Color.WHITE);
		credit5.setFont(boldFont);
		credit5.setLineWrap(true);
		credit5.setBorder(BorderFactory.createLineBorder(Color.black));

		credit6.setBackground(Color.WHITE);
		credit6.setFont(boldFont);
		credit6.setLineWrap(true);
		credit6.setBorder(BorderFactory.createLineBorder(Color.black));

		// Sets up the course column with each course selection
		coursePanel.setLayout(courseLayout);
		coursePanel.add(courseLabel);
		coursePanel.add(course1);
		coursePanel.add(course2);
		coursePanel.add(course3);
		coursePanel.add(course4);
		coursePanel.add(course5);
		coursePanel.add(course6);
		coursePanel.setVisible(true);

		// Sets up credit hours column
		creditPanel.setLayout(courseLayout);
		creditPanel.add(creditLabel);
		creditPanel.add(credit1);
		creditPanel.add(credit2);
		creditPanel.add(credit3);
		creditPanel.add(credit4);
		creditPanel.add(credit5);
		creditPanel.add(credit6);
		creditPanel.setVisible(true);

		combinedccPanel.setLayout(new GridLayout(0, 2));
		combinedccPanel.add(coursePanel);
		combinedccPanel.add(creditPanel);

		return combinedccPanel;

	}

	public void calculateWeightedGpa() throws CustomException {

		int totalCredits = 0;
		double totalGradePoints = 0.0;

		if (credit1.getText().length() > 1 || credit2.getText().length() > 1
				|| credit3.getText().length() > 1
				|| credit4.getText().length() > 1
				|| credit5.getText().length() > 1
				|| credit6.getText().length() > 1) {

			throw creditException;
		} else {

			totalCredits = Integer.parseInt(credit1.getText())
					+ Integer.parseInt(credit2.getText())
					+ Integer.parseInt(credit3.getText())
					+ Integer.parseInt(credit4.getText())
					+ Integer.parseInt(credit5.getText())
					+ Integer.parseInt(credit6.getText());

			totalGradePoints = calculateTotalGradePoints();

			calculatedGPA = totalGradePoints / totalCredits;
		}
	}

	public double calculateTotalGradePoints() {

		double totalGradePts = 0.0;

		totalGradePts = ((Integer.parseInt(credit1.getText())) * NUMGRADES[chooseGrade1
				.getSelectedIndex()])
				+ ((Integer.parseInt(credit2.getText())) * NUMGRADES[chooseGrade2
						.getSelectedIndex()])
				+ ((Integer.parseInt(credit3.getText())) * NUMGRADES[chooseGrade3
						.getSelectedIndex()])
				+ ((Integer.parseInt(credit4.getText())) * NUMGRADES[chooseGrade4
						.getSelectedIndex()])
				+ ((Integer.parseInt(credit5.getText())) * NUMGRADES[chooseGrade5
						.getSelectedIndex()])
				+ ((Integer.parseInt(credit6.getText())) * NUMGRADES[chooseGrade6
						.getSelectedIndex()]);

		return totalGradePts;
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