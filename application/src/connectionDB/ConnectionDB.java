package connectionDB;
import java.sql.*;

public class ConnectionDB {
	
		private static final String URL = "jdbc:mysql://localhost:3306/masini";
	    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	    private static final String USER = "root";
	    private static final String PASSWORD = "";
	    
	    public Connection getConnection() throws ClassNotFoundException, SQLException {
	        Class.forName(JDBC_DRIVER);
	        Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
	        return conn;
	    }
	    
	    public Connection closeConnection() throws SQLException{
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        if(rs != null)
	            rs.close();
	        if(stmt != null)
	            stmt.close();
	        if(conn != null)
	            conn.close();
	        return null;
	    }
	    
}

