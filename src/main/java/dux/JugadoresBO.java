package dux;

import java.sql.Connection;
import java.util.Scanner;

public class JugadoresBO {
	private String mensaje="";
	private JugadoresDAO jdao= new JugadoresDAO();
	Connection conn=Conexion.getConnection();
	public void CrearJugador(Jugadores jugador) {
		boolean error=true;
		while(error==true) {
			
		
		try {
				jugador.cargarNombre();
				this.agregarJugador(jugador);
				System.out.println("crando");
				error=false;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Nombre ya existente elegir otro");
			error=false;
		}
		}
	}
	public void CrearJugador(Jugadores jugador, String nombre) {
		boolean error=true;
		while(error==true) {
		try {
				jugador.setNombre(nombre);
				this.agregarJugador(jugador);
				error=false;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Nombre ya existente elegir otro");
			error=false;
		}
		}
	}
	
	public void jugarExistente(Jugadores jugador, String nombre) {
		Jugadores jugadorAux=new Jugadores(this.buscarJugador(nombre));
		if(jugadorAux.getNombre()==null) {
			System.out.println("Jugador no encontrado, creando jugador nuevo");
			CrearJugador(jugador,nombre);
		}else {
			jugador.setNombre(jugadorAux.getNombre());
			jugador.setScore(jugadorAux.getScore());
		}

	}
	
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
		try{
			System.out.println("Los jugadores con sus score son:");
			jdao.mostrarJugadores(conn);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}}
			catch (Exception e) {
					e.getMessage();
				}
			}
		
	
			
		
}
	
	public void editarJugador(String nombreACambiar, String nombreCambiado) {
		try{
			jdao.editarJugador(conn, nombreACambiar, nombreCambiado);
			System.out.println("jugador editado");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}}
			catch (Exception e) {
					e.getMessage();
				}
			}
	}
	
	public Jugadores buscarJugador(String nombre) {
		
			System.out.println("El jugador "+ jdao.buscarJugador(conn, nombre).getNombre()+" se encontro");
			return jdao.buscarJugador(conn, nombre);
			
		
	}
	public void actualizarJugador(Jugadores jugador) {
		try{
			jdao.actualizar(conn, jugador);
			System.out.println("Jugador " + jugador.getNombre()+" se actualizo");
		}
		catch (Exception e) {
			e.getMessage();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}}
			catch (Exception e) {
					e.getMessage();
				}}
		}
	public void sumarScore(Jugadores jugador) {
		try{
			System.out.println("Score sumado");
			jdao.sumarScore(conn, jugador);
		}catch (Exception e) {
			e.getMessage();
			}
		finally {
			try {
				if(conn!=null) {
					conn.close();
				}}
			catch (Exception e) {
					e.getMessage();
				}
	}}
	}