import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.h2.jdbc.JdbcSQLException;

public class DBUtils {
	public dWebDS dbConnetion(int id){
    	Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String USER = "sa"; 
        String PASS = "123";
        dWebDS result = null;
        
        // Embed Driver
        String driver = "org.h2.Driver";
        
        // Database name
        String dbName="dWebData";
        
        // ConnectionURL
        //String connectionURL = "jdbc:h2:mem:"+dbName;
        String connectionURL = "jdbc:h2:~/test";
        
        // Create Table Query
        String createString = "" ;
        
        // Load Driver
        try {
            Class.forName(driver); 
        } catch(java.lang.ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        // get Connection
        try {
            conn = DriverManager.getConnection(connectionURL,USER,PASS);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        // Select data
        try {
        	stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from dWebTable where id="+id);
            
            /*
            while (rs.next()) {
            	System.out.println(" table dWebTable : " + rs.getString("id")+" "+rs.getString("msg")+" "+rs.getString("remark")+" "+rs.getString("memo"));
            }
            rs.first();
            */
            
            if(rs != null) {
            	rs.next();
            	try{
            		result = new dWebDS(Integer.parseInt(rs.getString("id")), rs.getString("msg"), rs.getString("remark"), rs.getString("memo"));
            		//System.out.println(" table dWebTable : " + rs.getString("id")+" "+rs.getString("msg")+" "+rs.getString("remark")+" "+rs.getString("memo"));
            	} catch(org.h2.jdbc.JdbcSQLException jqe){
            		// No data error from H2 DB.
            		result = null;
            	}
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (rs!=null) try {rs.close();} catch(Exception e2) {}
            if (stmt!=null) try {stmt.close();} catch(Exception e2) {}
        }
        
     // close Connection
        try {
            conn.close();
            //System.out.println("CONN works");
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("ERR!");
        }
		return result;
    }
    
    public void defaultTableData(){
    	Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String USER = "sa"; 
        String PASS = "123";
        
        // Embed Driver
        String driver = "org.h2.Driver";
        // Database name
        String dbName="dWebData";
        // ConnectionURL
        //String connectionURL = "jdbc:h2:mem:"+dbName;
        String connectionURL = "jdbc:h2:~/test";
        // Create Table Query
        String createString = "" ;
        // Load Driver
        try {
            Class.forName(driver); 
        } catch(java.lang.ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        // get Connection
        try {
            conn = DriverManager.getConnection(connectionURL,USER,PASS);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        createString = "CREATE TABLE dWebTable ("+
						   "id INT NOT NULL,"+
						   "msg VARCHAR(MAX),"+
						   "remark VARCHAR(max),"+ 
						   "memo VARCHAR(max),"+
						   "PRIMARY KEY ( id )"+
						");";
        //Create Table
        try {
            stmt = conn.createStatement();
            System.out.println ("Creating table...");
            stmt.execute(createString);
            
            for(int i=1; i<=10; i++){
            	createString = "insert into dWebTable(id,msg,remark,memo) values ("+i+", 'test Msg"+i+"', 'test Remark"+i+"', 'test Memo"+i+"');";
            	stmt.execute(createString);
            }
        }  catch (Exception e)  {
            System.out.println("Table exist...");
        } finally {
            if (stmt!=null) try {stmt.close();} catch(Exception e2) {}
        }
        
        /*
        for(int i=1; i<=10; i++){
        	createString = "insert into dWebTable(id,msg,remark,memo) values ("+i+", 'test Msg"+i+"', 'test Remark"+i+"', 'test Memo"+i+"');";
        	try {
        		stmt = conn.createStatement();
        		stmt.execute(createString);
        	}  catch (Exception e)  {
                System.out.println("insertion error.");
                System.out.println(e);
            } finally {
                if (stmt!=null) try {stmt.close();} catch(Exception e2) {}
            }
        }
        */
     // close Connection
        try {
            conn.close();
            //System.out.println("CONN works");
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("ERR!");
        }
    }
}
