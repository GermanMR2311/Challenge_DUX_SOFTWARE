package dux;

import java.sql.Connection;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class Principal {

	public static void main(String[] args) {
		


		Scanner leer= new  Scanner(System.in);
		Torneo torneo = new Torneo();
		boolean revancha=true;
		boolean usarJugadorE;
		
		
		Jugadores jugador1=new Jugadores();
		Jugadores jugador2=new Jugadores();
		JugadoresBO jugadorbo=new JugadorBO();
		
		System.out.println("Quiere usar un jugador ya existente?");
		usarJugadorE=leer.hasNextBoolean();
		if(usarJugadorE==true) {
			System.out.println("Ingrese el nombre del jugador");
			
		}
		jugador1.cargarNombre(leer, "1");
		jugador2.cargarNombre(leer, "2");
		torneo.jugarConRevancha(revancha,jugador1,jugador2);
		
		
		
	}
}	
		
		
	


