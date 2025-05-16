package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
public static Connection conectar() {
String url = "jdbc:mysql://localhost:3306/javapooSL";

String usuario = "root";


String contraseña = "1234";
Connection conexion = null; 
try {
conexion = DriverManager.getConnection(url, usuario, contraseña);
System.out.println("¡Conexión exitosa!");
} catch (SQLException e) {
System.out.println("Error de conexión: " + e.getMessage());
}
return conexion;
}}