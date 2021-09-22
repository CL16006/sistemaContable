package consultas;

import com.mysql.jdbc.Connection;

import conexion.Conexion;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author fatycalderon
 */
public class Consultas {
      PreparedStatement pstm=null;
      Statement stmt = null;
          ResultSet rs=null;
          Conexion cn=new Conexion();
      
          public ResultSet findAllCatalogo() throws ClassNotFoundException{
              try{
             Connection conn=cn.getConexion();
          pstm=conn.prepareStatement("select * from catalogo_contable");
          rs=pstm.executeQuery(); 
          return rs;
              }catch(SQLException e){
                  e.getMessage();
              }
              return null;
          }
          
                    public ResultSet findAllGastos() throws ClassNotFoundException{
              try{
             Connection conn=cn.getConexion();
          pstm=conn.prepareStatement("select * from catalogo_contable where idCuenta like 'G%'");
          rs=pstm.executeQuery(); 
          return rs;
              }catch(SQLException e){
                  e.getMessage();
              }
              return null;
          }
                      public ResultSet findAllIngresos() throws ClassNotFoundException{
              try{
             Connection conn=cn.getConexion();
          pstm=conn.prepareStatement("select * from catalogo_contable where idCuenta like 'I%'");
          rs=pstm.executeQuery(); 
          return rs;
              }catch(SQLException e){
                  e.getMessage();
              }
              return null;
          }
                  public ResultSet findAllCapital() throws ClassNotFoundException{
              try{
             Connection conn=cn.getConexion();
          pstm=conn.prepareStatement("select * from catalogo_contable where idCuenta like 'C%'");
          rs=pstm.executeQuery(); 
          return rs;
              }catch(SQLException e){
                  e.getMessage();
              }
              return null;
          }
          public double findId_Cargo(String id) throws ClassNotFoundException{
              double suma=0;
                  try{
             Connection conn=cn.getConexion();
          pstm=conn.prepareStatement("SELECT SUM(cargo) FROM sistema_contable.libroDiario WHERE idCuentaCargada='"+id+"'");
          rs=pstm.executeQuery(); 
          if(rs.next()){
              suma=rs.getDouble(1);
          }
              return suma;
              }catch(SQLException e){
                  e.getMessage();
              }
              
              return suma;
          }
          
        public double findId_Abono(String id) throws ClassNotFoundException{
            double suma=0;
                  try{
             Connection conn=cn.getConexion();
          pstm=conn.prepareStatement("SELECT SUM(abono) FROM sistema_contable.libroDiario WHERE idCuentaAbonada='"+id+"'");
          rs=pstm.executeQuery();
          if(rs.next()){
              suma=rs.getDouble(1);
          }
              return suma;
              }catch(SQLException e){
                  e.getMessage();
              }
              
              return suma;
          }
          
    public ResultSet findIdByNombreSuperior(String nombreSuperior) throws ClassNotFoundException{
              try{
              Connection conn=cn.getConexion(); 
          pstm=conn.prepareStatement("SELECT idCuenta FROM sistema_contable.catalogo_contable WHERE nombreCuenta='"+nombreSuperior+"'");
          rs=pstm.executeQuery(); 
          return rs;
              }catch(SQLException e){
                  e.getMessage();
              }
              return null;
        }
     public ResultSet findIngreso() throws ClassNotFoundException{
              try{
              Connection conn=cn.getConexion(); 
          pstm=conn.prepareStatement("SELECT nombreCuenta FROM sistema_contable.catalogo_contable WHERE idCuenta LIKE 'I%'");
          rs=pstm.executeQuery(); 
          return rs;
              }catch(SQLException e){
                  e.getMessage();
              }
              return null;
        }
        public ResultSet findGasto() throws ClassNotFoundException{
              try{
              Connection conn=cn.getConexion(); 
          pstm=conn.prepareStatement("SELECT nombreCuenta FROM sistema_contable.catalogo_contable WHERE idCuenta LIKE 'G%'");
          rs=pstm.executeQuery(); 
          return rs;
              }catch(SQLException e){
                  e.getMessage();
              }
              return null;
        }
    
        public double sumaAbonoPasivo() throws ClassNotFoundException{
            double suma=0;
              try{
              Connection conn=cn.getConexion(); 
          pstm=conn.prepareStatement("SELECT SUM(abono) FROM sistema_contable.libroDiario WHERE idCuentaAbonada LIKE 'P%'");
          rs=pstm.executeQuery(); 
          if(rs.next()){
              suma=rs.getDouble(1);
          }
          return suma;
              }catch(SQLException e){
                  e.getMessage();
              }
              return suma;
        }
        
        public double sumaCargoPasivo() throws ClassNotFoundException{
            double suma=0;
              try{
              Connection conn=cn.getConexion(); 
          pstm=conn.prepareStatement("SELECT SUM(cargo) FROM sistema_contable.libroDiario WHERE idCuentaCargada LIKE 'P%'");
          rs=pstm.executeQuery(); 
          if(rs.next()){
              suma=rs.getDouble(1);
          }
          return suma;
              }catch(SQLException e){
                  e.getMessage();
              }
              return suma;
        }
        
    public double sumaAbonoActivo() throws ClassNotFoundException{
            double suma=0;
              try{
              Connection conn=cn.getConexion(); 
          pstm=conn.prepareStatement("SELECT SUM(abono) FROM sistema_contable.libroDiario WHERE idCuentaAbonada LIKE 'A%'");
          rs=pstm.executeQuery(); 
          if(rs.next()){
              suma=rs.getDouble(1);
          }
          return suma;
              }catch(SQLException e){
                  e.getMessage();
              }
              return suma;
        }
     public double sumaCargoActivo() throws ClassNotFoundException{
            double suma=0;
              try{
              Connection conn=cn.getConexion(); 
          pstm=conn.prepareStatement("SELECT SUM(cargo) FROM sistema_contable.libroDiario WHERE idCuentaCargada LIKE 'A%'");
          rs=pstm.executeQuery(); 
          if(rs.next()){
              suma=rs.getDouble(1);
          }
          return suma;
              }catch(SQLException e){
                  e.getMessage();
              }
              return suma;
        }
    
    public double sumaCargoGastos() throws ClassNotFoundException{
            double suma=0;
              try{
              Connection conn=cn.getConexion(); 
          pstm=conn.prepareStatement("SELECT SUM(cargo) FROM sistema_contable.libroDiario WHERE idCuentaCargada LIKE 'G%'");
          rs=pstm.executeQuery(); 
          if(rs.next()){
              suma=rs.getDouble(1);
          }
          return suma;
              }catch(SQLException e){
                  e.getMessage();
              }
              return suma;
        }
        public double sumaAbonoGastos() throws ClassNotFoundException{
            double suma=0;
              try{
              Connection conn=cn.getConexion(); 
          pstm=conn.prepareStatement("SELECT SUM(abono) FROM sistema_contable.libroDiario WHERE idCuentaAbonada LIKE 'G%'");
          rs=pstm.executeQuery(); 
          if(rs.next()){
              suma=rs.getDouble(1);
          }
          return suma;
              }catch(SQLException e){
                  e.getMessage();
              }
              return suma;
        }
        
            public double sumaCargoIngreso() throws ClassNotFoundException{
            double suma=0;
              try{
              Connection conn=cn.getConexion(); 
          pstm=conn.prepareStatement("SELECT SUM(cargo) FROM sistema_contable.libroDiario WHERE idCuentaCargada LIKE 'I%'");
          rs=pstm.executeQuery(); 
          if(rs.next()){
              suma=rs.getDouble(1);
          }
          return suma;
              }catch(SQLException e){
                  e.getMessage();
              }
              return suma;
        }
            
public double sumaAbonoIngreso() throws ClassNotFoundException{
            double suma=0;
              try{
              Connection conn=cn.getConexion(); 
          pstm=conn.prepareStatement("SELECT SUM(abono) FROM sistema_contable.libroDiario WHERE idCuentaAbonada LIKE 'I%'");
          rs=pstm.executeQuery(); 
          if(rs.next()){
              suma=rs.getDouble(1);
          }
          return suma;
              }catch(SQLException e){
                  e.getMessage();
              }
              return suma;
        }

  public double sumaAbonoCapital() throws ClassNotFoundException{
            double suma=0;
              try{
              Connection conn=cn.getConexion(); 
          pstm=conn.prepareStatement("SELECT SUM(abono) FROM sistema_contable.libroDiario WHERE idCuentaAbonada LIKE 'C%'");
          rs=pstm.executeQuery(); 
          if(rs.next()){
              suma=rs.getDouble(1);
          }
          return suma;
              }catch(SQLException e){
                  e.getMessage();
              }
              return suma;
        }
  
    public double sumaCargoCapital() throws ClassNotFoundException{
            double suma=0;
              try{
              Connection conn=cn.getConexion(); 
          pstm=conn.prepareStatement("SELECT SUM(cargo) FROM sistema_contable.libroDiario WHERE idCuentaCargada LIKE 'C%'");
          rs=pstm.executeQuery(); 
          if(rs.next()){
              suma=rs.getDouble(1);
          }
          return suma;
              }catch(SQLException e){
                  e.getMessage();
              }
              return suma;
        }
        public double sumaCuentaCargo(String id) throws ClassNotFoundException{
            double suma=0;
              try{
              Connection conn=cn.getConexion(); 
          pstm=conn.prepareStatement("SELECT SUM(cargo) FROM sistema_contable.libroDiario WHERE idCuentaCargada='"+id+"'");
          rs=pstm.executeQuery(); 
          if(rs.next()){
              suma=rs.getDouble(1);
          }
          return suma;
              }catch(SQLException e){
                  e.getMessage();
              }
              return suma;
        }
               public double sumaCuentaAbono(String id) throws ClassNotFoundException{
            double suma=0;
              try{
              Connection conn=cn.getConexion(); 
          pstm=conn.prepareStatement("SELECT SUM(abono) FROM sistema_contable.libroDiario WHERE idCuentaAbonada='"+id+"'");
          rs=pstm.executeQuery(); 
          if(rs.next()){
              suma=rs.getDouble(1);
          }
          return suma;
              }catch(SQLException e){
                  e.getMessage();
              }
              return suma;
        }
      
    public void insertIntoCatalogo(String codigo,String nombre,String codigoSuperior,String nombreSuperior,String seCarga,String seAbona) throws SQLException, ClassNotFoundException{
              Connection conn=cn.getConexion();
            try{   
            
                pstm=conn.prepareStatement("insert into sistema_contable.catalogo_contable(idCuenta,nombreCuenta,idCuentaSuperior,nombreCuentaSuperior,seCarga,seAbona) values (?,?,?,?,?,?)");
                pstm.setString(1, codigo);
                pstm.setString(2, nombre);
                pstm.setString(3, codigoSuperior);
                pstm.setString(4, nombreSuperior);
                pstm.setString(5, seCarga);
                pstm.setString(6, seAbona);
                int n=pstm.executeUpdate();
                if(n>0){
                    JOptionPane.showMessageDialog(null, "Asiento guardado con exito!!!");
                }
               pstm.close();
               conn.close();
            
            }catch(HeadlessException | SQLException e){
                e.getMessage();
                
            }
        }
        
        
     public void insertIntoLibroDiario(String fechaAsiento,String idcargo,String idAbono,Double cargo,Double abono,String concepto) throws SQLException, ClassNotFoundException{
              Connection conn=cn.getConexion();
              String sql="INSERT INTO libroDiario(fecha,idCuentaCargada,idCuentaAbonada,cargo,abono,concepto)"
                      + " VALUES(?,?,?,?,?,?)";
            try{   
                pstm=conn.prepareStatement(sql);           

                 pstm.setString(1,fechaAsiento);
                 pstm.setString(2, idcargo);
                 pstm.setString(3, idAbono);
                 pstm.setDouble(4, cargo);
                 pstm.setDouble(5, abono);
                 pstm.setString(6,concepto);
                int n=pstm.executeUpdate();
                if(n>0){
                    JOptionPane.showMessageDialog(null, "datos agregados correctamente");
                }
               pstm.close();
               conn.close();
            
            }catch(HeadlessException | SQLException e){
                e.getMessage();
                
            }

        }
                 
           public double sumaIngreso() throws ClassNotFoundException{
            double suma=0;
              try{
              Connection conn=cn.getConexion(); 
          pstm=conn.prepareStatement("SELECT SUM(abono) FROM sistema_contable.libroDiario WHERE idCuentaAbonada LIKE 'I%'");
          rs=pstm.executeQuery(); 
          if(rs.next()){
              suma=rs.getDouble(1);
          }
          return suma;
              }catch(SQLException e){
                  e.getMessage();
              }
              return suma;
        }
          public double sumaGasto() throws ClassNotFoundException{
            double suma=0;
              try{
              Connection conn=cn.getConexion(); 
          pstm=conn.prepareStatement("SELECT SUM(cargo) FROM sistema_contable.libroDiario WHERE idCuentaCargada LIKE 'G%'");
          rs=pstm.executeQuery(); 
          if(rs.next()){
              suma=rs.getDouble(1);
          }
          return suma;
              }catch(SQLException e){
                  e.getMessage();
              }
              return suma;
        }       
            
     
                
}
