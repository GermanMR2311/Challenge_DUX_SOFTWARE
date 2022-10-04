package dux;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static Connection conn=null;
	private static String login="HR";
	private static String clave="hr";
	private static String url="jdbc:oracle:thin:@//localhost:1521/XEPDB1";
	
	
	public static Connection getConnection() {
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,login,clave);
			conn.setAutoCommit(false);
			if(conn!=null) {
				System.out.println("Conexion Exitosa");
			}
			else {
				System.out.println("No se pudo conectar a la base de datos");
			}
		}
		catch (Exception e) {
			System.out.println("Hubo un error" + e.getMessage());
		}
		return conn;
	}
	
	public void desconexion() {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println("Error al desconectar" + e.getMessage());
		}
	}
	


}