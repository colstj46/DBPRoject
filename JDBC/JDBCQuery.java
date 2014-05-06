import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import com.jgoodies.forms.factories.FormFactory;
//import net.miginfocom.swing.MigLayout;

public class JDBCQuery{
	private static JFrame frame;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_6;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
    public static void main ( String [] args ){

    	frame = new JFrame();
    	frame.setName("Student Assesment Item Info");
    	frame.setSize(582, 550);
    	frame.setVisible(true);
    	SpringLayout springLayout = new SpringLayout();
    	frame.getContentPane().setLayout(springLayout);


    	JLabel lblWelcomeToOur = new JLabel("Welcome to our program. Suck it");
    	springLayout.putConstraint(SpringLayout.NORTH, lblWelcomeToOur, 7, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, lblWelcomeToOur, 69, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, lblWelcomeToOur, 35, SpringLayout.NORTH, frame.getContentPane());
    	lblWelcomeToOur.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	frame.getContentPane().add(lblWelcomeToOur);
    	lblWelcomeToOur.setVisible(true);

    	JLabel lblWhatWouldYou = new JLabel("Please select a query");
    	springLayout.putConstraint(SpringLayout.NORTH, lblWhatWouldYou, 39, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, lblWhatWouldYou, 7, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, lblWhatWouldYou, 67, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, lblWhatWouldYou, 336, SpringLayout.WEST, frame.getContentPane());
    	frame.getContentPane().add(lblWhatWouldYou);
    	lblWhatWouldYou.setVisible(true);

    	ButtonGroup bg = new ButtonGroup();

    	final JRadioButton rdbtnQ1 = new JRadioButton("Average score based on criterion ex.(A1F12C2)");
    	springLayout.putConstraint(SpringLayout.NORTH, rdbtnQ1, 71, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, rdbtnQ1, 7, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, rdbtnQ1, 98, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, rdbtnQ1, 336, SpringLayout.WEST, frame.getContentPane());
    	frame.getContentPane().add(rdbtnQ1);
    	rdbtnQ1.setVisible(true);
    	rdbtnQ1.setSelected(true);
    	bg.add(rdbtnQ1);

    	textField = new JTextField();
    	springLayout.putConstraint(SpringLayout.NORTH, textField, 71, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, textField, 445, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, textField, 98, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, textField, 537, SpringLayout.WEST, frame.getContentPane());
    	frame.getContentPane().add(textField);
    	textField.setColumns(10);
    	textField.setVisible(true);

    	final JRadioButton rdbtnQ2 = new JRadioButton("Average score based on CDAI with Semester ex.(A1F12)");
    	springLayout.putConstraint(SpringLayout.NORTH, rdbtnQ2, 102, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, rdbtnQ2, 7, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, rdbtnQ2, 130, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, rdbtnQ2, 336, SpringLayout.WEST, frame.getContentPane());
    	frame.getContentPane().add(rdbtnQ2);
    	rdbtnQ2.setVisible(false);
    	bg.add(rdbtnQ2);

    	textField_1 = new JTextField();
    	springLayout.putConstraint(SpringLayout.NORTH, textField_1, 102, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, textField_1, 445, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, textField_1, 130, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, textField_1, 537, SpringLayout.WEST, frame.getContentPane());
    	textField_1.setColumns(10);
    	frame.getContentPane().add(textField_1);
    	textField_1.setVisible(true);

    	final JRadioButton rdbtnQ3 = new JRadioButton("Average score based on CDAI ex.(A1)");
    	springLayout.putConstraint(SpringLayout.NORTH, rdbtnQ3, 134, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, rdbtnQ3, 7, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, rdbtnQ3, 162, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, rdbtnQ3, 336, SpringLayout.WEST, frame.getContentPane());
    	frame.getContentPane().add(rdbtnQ3);
    	rdbtnQ3.setVisible(true);
    	bg.add(rdbtnQ3);

    	textField_2 = new JTextField();
    	springLayout.putConstraint(SpringLayout.NORTH, textField_2, 134, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, textField_2, 445, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, textField_2, 162, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, textField_2, 537, SpringLayout.WEST, frame.getContentPane());
    	textField_2.setColumns(10);
    	frame.getContentPane().add(textField_2);
    	textField_2.setVisible(true);

    	final JRadioButton rdbtnQ4 = new JRadioButton("Average score for all CDAI with semester ex.(A1F12)");
    	springLayout.putConstraint(SpringLayout.NORTH, rdbtnQ4, 166, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, rdbtnQ4, 7, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, rdbtnQ4, 194, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, rdbtnQ4, 336, SpringLayout.WEST, frame.getContentPane());
    	frame.getContentPane().add(rdbtnQ4);
    	rdbtnQ4.setVisible(true);
    	bg.add(rdbtnQ4);

    	final JRadioButton rdbtnQ5 = new JRadioButton("Average score for all CDAI  ex.(A1)");
    	springLayout.putConstraint(SpringLayout.NORTH, rdbtnQ5, 198, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, rdbtnQ5, 7, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, rdbtnQ5, 226, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, rdbtnQ5, 336, SpringLayout.WEST, frame.getContentPane());
    	frame.getContentPane().add(rdbtnQ5);
    	rdbtnQ5.setVisible(true);
    	bg.add(rdbtnQ5);

    	final JRadioButton rdbtnQ6 = new JRadioButton("Identify CDAI with highest average score");
    	springLayout.putConstraint(SpringLayout.NORTH, rdbtnQ6, 230, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, rdbtnQ6, 7, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, rdbtnQ6, 257, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, rdbtnQ6, 336, SpringLayout.WEST, frame.getContentPane());
    	frame.getContentPane().add(rdbtnQ6);
    	rdbtnQ6.setVisible(true);
    	bg.add(rdbtnQ6);

    	final JRadioButton rdbtnQ7 = new JRadioButton("Identify CDAI with lowest average score");
    	springLayout.putConstraint(SpringLayout.NORTH, rdbtnQ7, 261, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, rdbtnQ7, 7, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, rdbtnQ7, 289, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, rdbtnQ7, 336, SpringLayout.WEST, frame.getContentPane());
    	frame.getContentPane().add(rdbtnQ7);
    	rdbtnQ7.setVisible(true);
    	bg.add(rdbtnQ7);  

    	final JRadioButton rdbtnQ8 = new JRadioButton("Average,Lowest,Highest scores over all CDAI in each emphasis");
    	springLayout.putConstraint(SpringLayout.NORTH, rdbtnQ8, 293, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, rdbtnQ8, 7, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, rdbtnQ8, 321, SpringLayout.NORTH, frame.getContentPane());
    	frame.getContentPane().add(rdbtnQ8);
    	rdbtnQ8.setVisible(true);
    	bg.add(rdbtnQ8);

    	final JRadioButton rdbtnQ9 = new JRadioButton("All CDAI for a student specified by first and last names");
    	springLayout.putConstraint(SpringLayout.NORTH, rdbtnQ9, 325, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, rdbtnQ9, 7, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, rdbtnQ9, 353, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, rdbtnQ9, 374, SpringLayout.WEST, frame.getContentPane());
    	frame.getContentPane().add(rdbtnQ9);
    	rdbtnQ9.setVisible(true);
    	bg.add(rdbtnQ9);

    	JLabel lblFirst = new JLabel("First:");
    	springLayout.putConstraint(SpringLayout.NORTH, lblFirst, 325, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, lblFirst, 416, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, lblFirst, 353, SpringLayout.NORTH, frame.getContentPane());
    	frame.getContentPane().add(lblFirst);
    	lblFirst.setVisible(true);

    	textField_3 = new JTextField();
    	springLayout.putConstraint(SpringLayout.NORTH, textField_3, 325, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, textField_3, 445, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, textField_3, 353, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, textField_3, 537, SpringLayout.WEST, frame.getContentPane());
    	textField_3.setColumns(10);
    	frame.getContentPane().add(textField_3);
    	textField_3.setVisible(true);

    	JLabel label_1 = new JLabel("Last:");
    	springLayout.putConstraint(SpringLayout.NORTH, label_1, 357, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, label_1, 417, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, label_1, 385, SpringLayout.NORTH, frame.getContentPane());
    	frame.getContentPane().add(label_1);
    	label_1.setVisible(true);

    	textField_6 = new JTextField();
    	springLayout.putConstraint(SpringLayout.NORTH, textField_6, 357, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, textField_6, 445, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, textField_6, 385, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, textField_6, 537, SpringLayout.WEST, frame.getContentPane());
    	textField_6.setColumns(10);
    	frame.getContentPane().add(textField_6);
    	textField_6.setVisible(true);


    	final JRadioButton rdbtnQ10 = new JRadioButton("Average,Lowest,Highest scores over all CDAI for a student");
    	springLayout.putConstraint(SpringLayout.NORTH, rdbtnQ10, 389, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, rdbtnQ10, 7, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, rdbtnQ10, 416, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, rdbtnQ10, 0, SpringLayout.EAST, rdbtnQ9);
    	frame.getContentPane().add(rdbtnQ10);
    	rdbtnQ10.setVisible(true);
    	bg.add(rdbtnQ10);


    	JLabel label = new JLabel("First:");
    	springLayout.putConstraint(SpringLayout.NORTH, label, 389, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, label, 416, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, label, 416, SpringLayout.NORTH, frame.getContentPane());
    	frame.getContentPane().add(label);
    	label.setVisible(true);

    	textField_4 = new JTextField();
    	springLayout.putConstraint(SpringLayout.NORTH, textField_4, 389, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, textField_4, 445, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, textField_4, 416, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, textField_4, 537, SpringLayout.WEST, frame.getContentPane());
    	textField_4.setColumns(10);
    	frame.getContentPane().add(textField_4);
    	textField_4.setVisible(true);

    	JLabel lblNewLabel = new JLabel("Last:");
    	springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 420, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 417, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 448, SpringLayout.NORTH, frame.getContentPane());
    	frame.getContentPane().add(lblNewLabel);
    	lblNewLabel.setVisible(true);

    	textField_5 = new JTextField();
    	springLayout.putConstraint(SpringLayout.NORTH, textField_5, 420, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, textField_5, 445, SpringLayout.WEST, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, textField_5, 448, SpringLayout.NORTH, frame.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, textField_5, 537, SpringLayout.WEST, frame.getContentPane());
    	textField_5.setColumns(10);
    	frame.getContentPane().add(textField_5);
    	textField_5.setVisible(true);

    	JButton btnNewButton = new JButton("Submit Search");
    	btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			if(rdbtnQ1.isSelected()){
    				SQLClass.TestJDBC(1,textField.getText(),"");
    				System.out.println("Table Added");

    			}else if(rdbtnQ2.isSelected()){
    				SQLClass.TestJDBC(2,textField_1.getText(),"");
    				System.out.println("Table Added");
    				
    			}else if(rdbtnQ3.isSelected()){
    				SQLClass.TestJDBC(3,textField_2.getText(),"");
    				System.out.println("Table Added");

    			}else if(rdbtnQ4.isSelected()){
    				SQLClass.TestJDBC(4,"","");
    				System.out.println("Table Added");

    			}else if(rdbtnQ5.isSelected()){
    				SQLClass.TestJDBC(5,"","");
    				System.out.println("Table Added");

    			}else if(rdbtnQ6.isSelected()){
    				SQLClass.TestJDBC(6,"","");
    				System.out.println("Table Added");

    			}else if(rdbtnQ7.isSelected()){
    				SQLClass.TestJDBC(7,"","");
    				System.out.println("Table Added");

    			}else if(rdbtnQ8.isSelected()){
    				SQLClass.TestJDBC(8,"","");
    				System.out.println("Table Added");

    			}else if(rdbtnQ9.isSelected()){
    				SQLClass.TestJDBC(9,textField_3.getText(),textField_6.getText());
    				System.out.println("Table Added");

    			}else if(rdbtnQ10.isSelected()){
    				SQLClass.TestJDBC(10,textField_4.getText(),textField_5.getText());
    				System.out.println("Table Added");
    			}

    		}
    	});
    	springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 18, SpringLayout.SOUTH, lblNewLabel);
    	springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, lblFirst);
    	springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, textField);
    	btnNewButton.setVisible(true);
    	frame.getContentPane().add(btnNewButton);



    }

}