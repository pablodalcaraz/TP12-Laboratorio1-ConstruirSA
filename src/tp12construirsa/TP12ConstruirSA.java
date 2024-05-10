/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp12construirsa;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Pablo
 */
public class TP12ConstruirSA {  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String url="jdbc:mariadb://localhost:3306/obrador";
            String usuario="root";
            String password="";
            Connection con=DriverManager.getConnection(url,usuario,password);
//            String sql="INSERT INTO "
//                    +"empleado(dni,apellido,nombre,acceso,estado)"
//                    +"VALUES(30246516,'Tolaba','Fernando',1,1),"
//                    +"(25456778,'Cuevas','Jaime',1,1),"
//                    +"(32556456,'Chipolis','Sergio',1,1)";
//            PreparedStatement ps=con.prepareStatement(sql);
//            ps.executeUpdate();
//           String sql="INSERT INTO "
//                    +"herramienta( `nombre`, `descripcion`, `stock`, `estado`)"
//                    +"VALUES('martillo','Stanley','12',1),"
//                    +"('destornillador','black&decker','6',1)";
//              PreparedStatement ps=con.prepareStatement(sql);
//              ps.executeUpdate();

//              String sql="SELECT * FROM herramienta WHERE stock > 10";
//               PreparedStatement ps=con.prepareStatement(sql);    
//               ResultSet datos=ps.executeQuery();
//               while (datos.next()) {    
//                int id_herramienta=datos.getInt("id_herramienta");
//                String nombre=datos.getString("nombre");
//                String descripcion=datos.getString("descripcion");
//                int stock=datos.getInt("stock");
//                boolean estado=datos.getBoolean("estado");
//                System.out.println("id: "+id_herramienta);
//               System.out.println("Nombre: "+nombre);
//               System.out.println("Descripción: "+descripcion);
//               System.out.println("Stock: "+stock);
//               System.out.println("Esctado: "+estado);
//            }
              String sql="UPDATE empleado SET estado = 0 WHERE id_empleado = 4";  
              PreparedStatement ps=con.prepareStatement(sql);
              ps.executeUpdate();
                      
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargard driver");
        } catch (SQLException ex) {
            int codigoE=ex.getErrorCode();
            if(codigoE==1062){
                  JOptionPane.showMessageDialog(null, "Entrada Duplicada");
            } else if(codigoE==1049){
            JOptionPane.showMessageDialog(null, "BD Desconocida");
            }else{
                  JOptionPane.showMessageDialog(null, "Error ");
            }
            
            ex.printStackTrace();
            System.out.println("codigo de error "+ex.getErrorCode());
        }
        
        
    }
    
}
