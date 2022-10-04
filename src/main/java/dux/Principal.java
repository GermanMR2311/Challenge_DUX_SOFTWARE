package dux;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner leer= new  Scanner(System.in);
		Torneo torneo = new Torneo();
		boolean revancha=true;
		Jugadores jugador1=new Jugadores();
		Jugadores jugador2=new Jugadores();
		jugador1.cargarNombre(leer, "1");
		jugador2.cargarNombre(leer, "2");
		
		torneo.jugarConRevancha(revancha,jugador1,jugador2);
		
		
		
	}
}	
		
		
	


