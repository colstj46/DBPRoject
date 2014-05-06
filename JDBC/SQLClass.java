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
            }
            else if(query == 2)
            	if(f.length()==7){
            		stmt = conn.prepareStatement("SELECT Crit_ID, t.AssessmentID, Sem_Start, AVG(Score) as Average " +
            			"FROM Takes t, Assessment a WHERE Crit_ID = '"+f+"' AND t.AssessmentID = a.AssessmentID " +
            			"AND a.AssessmentID = '"+f.substring(0,5)+"' AND Sem_Start = '"+l+"';");
            		}
            else if(query == 3)
        		stmt = conn.prepareStatement("SELECT * FROM Student;");
            else if(query == 4)
        		stmt = conn.prepareStatement("SELECT * FROM Student;");
            else if(query == 5)
        		stmt = conn.prepareStatement("SELECT * FROM Student;");
            else if(query == 6)
        		stmt = conn.prepareStatement("SELECT * FROM Student;");
            else if(query == 7)
        		stmt = conn.prepareStatement("SELECT * FROM Student;");
            else if(query == 8)
        		stmt = conn.prepareStatement("SELECT * FROM Student;");
            else if(query == 9)
        		stmt = conn.prepareStatement("SELECT * FROM Student;");
            else if(query == 10)
        		stmt = conn.prepareStatement("SELECT * FROM Student;");
            
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel dtm = buildTableModel(rs);
            JTable table = new JTable(dtm);
            JScrollPane pane = new JScrollPane(table);
            JOptionPane.showMessageDialog(null, pane,"Query "+ query,1);
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e)
        {System.out.println("SQL Error " + e.getMessage());}
        catch (Exception e)
        {System.out.println("General Error " + e.getMessage() + e.getStackTrace());}
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

        TestJDBC(1,"","");

    }
}
