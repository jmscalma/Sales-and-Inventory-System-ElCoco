
package salesAndInventorySystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author james
 */
public class DBConnector {
    
    public static Connection mycon(){
        
        Connection con = null;
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/el_coco_db","root","root");
            return con;
            
        }catch(ClassNotFoundException | SQLException e){
            
            System.out.println(e);
            return null;
        }
        
    }
    
}
