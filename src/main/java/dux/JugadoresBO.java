package dux;

import java.sql.Connection;

public class JugadoresBO {
	private String mensaje="";
	private JugadoresDAO jdao= new JugadoresDAO();
	
	
	public String agregarJugador(Jugadores jugador) {
		Connection conn=Conexion.getConnection();
		try {
			mensaje=jdao.AgregarJugadores(conn, jugador);
		}
		catch (Exception e) {
			mensaje=mensaje+" "+e.getMessage();
		}finally {
			try {
				if(conn!= null) {
					conn.close();
				}
			} catch (Exception e) {
				mensaje=mensaje+" "+e.getMessage();
			}
		}
		return mensaje;
		
		
	}
}
