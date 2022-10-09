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
		String sql="INSERT INTO JUGADORES (NOMBRE, score) VALUES (?,0)";
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
		ResultSet rs=null;
		String sql="select nombre, score from jugadores";
		try {
			pst=conn.prepareStatement(sql);
			 rs= pst.executeQuery();
			while (rs.next()) {
				String a=rs.getString(1);
				while(a.length()<15) {
					a=a+" ";
				}
                System.out.print(a);
                System.out.println(" - "+ rs.getInt(2));
                System.out.println("");
            }
			
			rs.close();
			pst.execute();
			pst.close();
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		
	}
	
	public void editarJugador(Connection conn, String nombreACambiar, String nombreCambiado) {
		PreparedStatement pst=null;
		String sql="update jugadores set nombre=? where nombre=?";
		
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, nombreCambiado);
			pst.setString(2, nombreACambiar);
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}	
		
	}
	public Jugadores buscarJugador(Connection conn,String nombre) {
		
		PreparedStatement pst=null;
		String sql="select nombre, score from jugadores where nombre=?";
		ResultSet rs=null;
		Jugadores jugador= new Jugadores();
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,nombre);
			rs= pst.executeQuery();
			while(rs.next()) {
				jugador.setNombre(rs.getString("nombre"));
				jugador.setScore(rs.getInt("score"));
			}
			pst.execute();
			pst.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jugador;
	}
	
	public void actualizar(Connection conn,Jugadores jugador) {
		PreparedStatement pst=null;
		String sql="update jugadores set score=? where nombre=?";
		System.out.println("Actualizando...");
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, jugador.getScore());
			pst.setString(2, jugador.getNombre());
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void sumarScore(Connection conn,Jugadores jugador) {
		Jugadores jugador1= new Jugadores(this.buscarJugador(conn, jugador.getNombre()));
		jugador1.setScore(jugador1.getScore()+1);
		this.actualizar(conn, jugador1);
		
	}
	
}