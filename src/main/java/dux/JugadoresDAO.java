package dux;

import java.beans.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hibernate.cfg.annotations.reflection.XMLContext.Default;

public class JugadoresDAO {
	
	private String mensaje;
	public String AgregarJugadores(Connection conn, Jugadores jugador) {
		PreparedStatement pst=null;
		String sql="INSERT INTO JUGADORES (idjugador,NOMBRE,SETS_GANADOS,TORNEO) "+ "VALUES(JUGADORES_SEQ.NEXTVAL, ?, ?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, jugador.getNombre());
			pst.setInt(2, jugador.getSetsGanados());
			pst.setString(3, jugador.getTorneoJugado());
			mensaje="Guardado correctamente";
			pst.execute();
			pst.close();
			
		} catch (SQLException e) {
			mensaje="No se puedo guardar correctamente \n" + e;
		} {
			
		}
		return mensaje;
	}
	
	
	
}