/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicainazumafc;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author MEDAC
 */
public class PracticaInazumaFc {

        private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
        private static final String URL_CONEXION = "jdbc:mysql://localhost:3306/inazumafc";
        
     public static void main(String args[]) throws SQLException {

            final String usuario = "root";
            final String password = "1234";
            Connection dbConnection = null;
            Statement statement = null;
            Statement statement2 = null;
            try {
                Class.forName(DRIVER);
                Connection conn = DriverManager.getConnection(URL_CONEXION, usuario, password);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            } finally {
                if (statement != null) {
                    statement.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            }
            
             String sql = "INSERT INTO entrenadores (nombre, nacionalidad, experiencia, telefono) "
                   + "VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL_CONEXION, usuario, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "Mark Evans");
            ps.setString(2, "Japonesa");
            ps.setInt(3, 12);
            ps.setString(4, "612345678");

            int filas = ps.executeUpdate();

            System.out.println("Entrenador insertado. Filas afectadas: " + filas);

        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }

     }
}
