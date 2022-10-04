package dux;

import java.sql.Connection;

public class JugadoresBO {
	private String mensaje="";
	private JugadoresDAO jdao= new JugadoresDAO();
	Connection conn=Conexion.getConnection();

	
	public String agregarJugador(Jugadores jugador) {
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
	
	public void mostrarJugadores() {
		jdao.mostrarJugadores(conn);
}
	
	public void editarJugador(String nombreACambiar, String nombreCambiado) {
		jdao.editarJugador(conn, nombreACambiar, nombreCambiado);
	}
	
	public Jugadores buscarJugador(String nombre) {
		return jdao.buscarJugador(conn, nombre);
		
	}
	}