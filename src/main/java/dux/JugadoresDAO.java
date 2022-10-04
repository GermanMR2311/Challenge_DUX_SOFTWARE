package dux;

import java.beans.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hibernate.cfg.annotations.reflection.XMLContext.Default;

import oracle.security.crypto.core.RSA;

public class JugadoresDAO {
	
	private String mensaje;
	public String AgregarJugadores(Connection conn, Jugadores jugador) {
		PreparedStatement pst=null;
		String sql="INSERT INTO JUGADORES (NOMBRE) "+ "VALUES( ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, jugador.getNombre());
			mensaje="Guardado correctamente";
			pst.execute();
			pst.close();
			
		} catch (SQLException e) {
			mensaje="No se puedo guardar correctamente \n" + e;
		} {
			
		}
		return mensaje;
	}
	
	public void mostrarJugadores(Connection conn){
		PreparedStatement pst=null;
		String sql="select nombre from jugadores";
		try {
			pst=conn.prepareStatement(sql);
			ResultSet rs= pst.executeQuery();
			while (rs.next()) {
                System.out.print(rs.getString(1));
                System.out.println("");
            }
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);;
		}
		
		
		
	}
	
	public void editarJugador(Connection conn, String nombreACambiar, String nombreCambiado) {
		PreparedStatement pst=null;
		String sql="update jugadores set nombre=? where nombre=?";
		
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, nombreCambiado);
			pst.setString(2, nombreACambiar);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public Jugadores buscarJugador(Connection conn,String nombre) {
		
		PreparedStatement pst=null;
		String sql="select nombre from jugadores where nombre=?";
		ResultSet rs=null;
		Jugadores jugador= new Jugadores();
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,nombre);
			rs= pst.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		try {
			
			jugador.setNombre(rs.getString(1).toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return jugador;
	}
	
}