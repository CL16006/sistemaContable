/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fatycalderon
 */
public class Conexion {
    public static final String URL="jdbc:mysql://localhost:3306/sistema_contable";
    public static final String USER="fatima";
    public static final String PASSWORD="user";
    Connection con=null;
  public Connection getConexion() throws SQLException, ClassNotFoundException{
     Connection conexion=null;
     try{
         Class.forName("com.mysql.jdbc.Driver");
         conexion=(Connection)DriverManager.getConnection(URL,USER,PASSWORD);
         this.con=conexion;
         return conexion;
     }catch(ClassNotFoundException | SQLException e){
         
     }
     return conexion;
  }
  
  public ResultSet findAllCatalogo(){
      String resultado="";
      ResultSet rs=null;
        try {
            Statement stm=con.createStatement();
            rs=stm.executeQuery("select * from catalogo_contable");
            while(rs.next()){
                resultado=rs.getString(2);
            }
              return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
  }
  
    
}
