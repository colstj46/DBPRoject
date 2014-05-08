import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class SQLClass {

    public class Login {
        public static final String USER="colstj46";
        public static final String PWD= "j419946";
        public static final String DB="colstj46";
        public static final String DRIVER="jdbc:mysql://webdev.cs.uwosh.edu:4381/";
        public static final String DRIVER_CLASS="com.mysql.jdbc.Driver";
    }

	public static void TestJDBC(int query,String f,String l) {
        String db = Login.DB;
        String user = Login.USER;
        String pw = Login.PWD;

        try{
            Class.forName(Login.DRIVER_CLASS);  // register the driver
            String dbURL = Login.DRIVER+db+"?connectTimeout=10000";
            System.out.println("Attempting connection");
            Connection conn = DriverManager.getConnection(dbURL,user,pw);
            System.out.println("Connection successfully made");
            PreparedStatement stmt = null;
            if(query == 1) {
            	if(f.length()==7){
            		stmt = conn.prepareStatement("SELECT Crit_ID, t.AssessmentID, Sem_Start, AVG(Score) as Average " +
            			"FROM Takes t, Assessment a WHERE Crit_ID = '"+f+"' AND t.AssessmentID = a.AssessmentID " +
            			"AND a.AssessmentID = '"+f.substring(0,5)+"' AND Sem_Start = '"+f.substring(2,5)+"';");
            	}
            	else{
            		JOptionPane.showMessageDialog(null, "Invalid Criterion");
            		return;
            	}
            }
            else if(query == 2)
            	if(f.length()==5){
            		stmt = conn.prepareStatement("SELECT DISTINCT Crit_ID,t.AssessmentID, Sem_Start, (SELECT AVG(Score) FROM Takes b WHERE b.Crit_ID = t.Crit_ID) as Average " +
                			"FROM Takes t, Assessment a WHERE a.AssessmentID = '"+f+"' AND t.AssessmentID = a.AssessmentID " +
                			"AND Sem_Start = '"+f.substring(2,5)+"';");
                }
            	else{
            		JOptionPane.showMessageDialog(null, "Invalid CDAI with Semester");
            		return;
            	}
            else if(query == 3)
            	if(f.length() == 2){
            		stmt = conn.prepareStatement("SELECT DISTINCT Crit_ID, (SELECT AVG(Score) FROM Takes a WHERE a.Crit_ID = t.Crit_ID)"+
            				" AS Average FROM Takes t WHERE AssessmentID LIKE '"+f+"%';");
            	}
            	else{
            		JOptionPane.showMessageDialog(null, "Invalid CDAI");
            		return;
            	}
            else if(query == 4)
            	if(f.length() == 5){
            		stmt = conn.prepareStatement("SELECT t.AssessmentID, Sem_Start, AVG(Score) AS Average FROM Takes t, Assessment a " +
        				"WHERE a.AssessmentID = '"+f+"' AND t.AssessmentID = a.AssessmentID AND Sem_Start = '"+f.substring(2,5)+"';");
        		}
            	else{
            		JOptionPane.showMessageDialog(null, "Invalid CDAI with Semester");
            		return;
            	}
            else if(query == 5)
            	if(f.length() == 2)
            		stmt = conn.prepareStatement("SELECT AssessmentID, AVG(Score) as Average FROM Takes WHERE AssessmentID LIKE '"+f+"%';");
            	else{
            		JOptionPane.showMessageDialog(null, "Invalid CDAI");
            		return;
            	}
            else if(query == 6)
        		stmt = conn.prepareStatement("SELECT AssessmentID, MAX(Average) FROM (SELECT DISTINCT Assessment, "+
        				"(SELECT AVG(Score) From Takes b WHERE a.AssessmentID = b.AssessmentID) as Average FROM Takes a) t;");
            else if(query == 7)
        		stmt = conn.prepareStatement("SELECT AssessmentID, MIN(Average) FROM (SELECT DISTINCT AssessmentID, "+
        				"(SELECT AVG(Score) FROM Takes b WHERE a.AssessmentID = b.AssessmentID) as Average FROM Takes a) t;");
            else if(query == 8)
        		stmt = conn.prepareStatement("SELECT Emph, (SELECT AVG(Score) FROM Takes a WHERE t.UniversityID = a.UniversityID) "+
        				"AS Average, (SELECT MIN(Score) FROM Takes a WHERE t.UniversityID = a.UniversityID) AS Lowest, (SELECT MAX(Score) FROM "+
        				"Takes a WHERE t.UniversityID = a.UniversityID) AS Highest FROM Emphasis e, Takes t WHERE e.UniversityID = t.UniversityID "+
        				"GROUP BY Emph;");
            else if(query == 9)
        		stmt = conn.prepareStatement("SELECT F_Name, L_Name, AssessmentID, Crit_ID, Score FROM Student s, Takes t "+
        				"WHERE F_Name = '"+f+"' AND L_Name LIKE '%"+l+"%' AND s.UniversityID = t.UniversityID;");
            else if(query == 10)
        		stmt = conn.prepareStatement("SELECT F_Name, L_Name, (SELECT AVG(Score) FROM Takes a WHERE s.UniversityID = a.UniversityID) "+
        				"as Average, (SELECT MIN(Score) FROM Takes a WHERE s.UniversityID = a.UniversityID) as Lowest, (SELECT MAX(Score) "+
        				"FROM Takes a WHERE s.UniversityID = a.UniversityID) as Highest, Crit_ID, Score FROM Student s, Takes t "+
        				"WHERE F_Name = '"+f+"' AND L_Name LIKE '%"+l+"%' AND s.UniversityID = t.UniversityID;");
            else if(query == 11)
            	stmt = conn.prepareStatement("SELECT * FROM Student;");
            else if(query == 12)
            	stmt = conn.prepareStatement("SELECT * FROM Assessment;");
            else if(query == 13)
            	stmt = conn.prepareStatement("SELECT * FROM Takes;");
            else if(query == 14)
            	stmt = conn.prepareStatement("SELECT * FROM Emphasis;");
            else if(query == 15)
            	stmt = conn.prepareStatement("SELECT * FROM Criteria;");
            
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel dtm = buildTableModel(rs);
            if(dtm.getValueAt(0,0) == null){
            	JOptionPane.showMessageDialog(null, "No Results Found");
            	return;
            }
            JTable table = new JTable(dtm);
            JScrollPane pane = new JScrollPane(table);
            JOptionPane.showMessageDialog(null, pane,"Query "+ query,1);
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e)
        {System.out.println("SQL Error " + e.getMessage());
        JTextArea text = new JTextArea(e.getMessage());
        JOptionPane.showMessageDialog(null, text,"Error",1);}
        catch (Exception e)
        {System.out.println("General Error " + e.getMessage() + e.getStackTrace());
        JTextArea text = new JTextArea(e.getMessage());
        JOptionPane.showMessageDialog(null, text,"Error",1);}
    }
    
    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }
    

    public static void main(String [] args) {

        TestJDBC(2,"C1S11","");

    }
}
