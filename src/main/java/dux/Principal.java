package dux;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String seguir=".";
		
		Scanner leer= new  Scanner(System.in);
		Random generator = new Random();
		double numeroRandom;
		
		System.out.println("Ingrese el nombre del jugador 1");
		Jugadores jugador1=new Jugadores(leer.next());
		jugador1.setSaca(true);
		
		System.out.println("Ingrese el nombre del jugador 2");
		Jugadores jugador2=new Jugadores(leer.next());
		
		boolean revancha=true;
		
		while(revancha==true) {
		
		
		System.out.println("Ingrese el nombre del torneo");
		Torneo torneo=new Torneo(leer.next());
		jugador1.setTorneoJugado(torneo.getNombreTorneo());
		jugador2.setTorneoJugado(torneo.getNombreTorneo());
		
		
		System.out.println("Ingrese el mejor de que quire jugar (Mejor de 3 o mejor de 5)");
		
		try{
			do {
			torneo.setSetsTotales(leer.nextInt());
			if(torneo.getSetsTotales()!=3 &&  torneo.getSetsTotales()!=5) {
				System.out.println("Escribio un numero incorrecto, debe ser 3 o 5");
			}
			}
			while(torneo.getSetsTotales()!=3 &&  torneo.getSetsTotales()!=5);
		}
		catch (Exception e) {
			System.out.println("A ocurrido el siguiente error " + e + " reinicie el programa, tenga en cuenta de ingresar solo numeros");
				
			}
		
		System.out.println("Ingrese la probabilidad de ganar del jugador 1");

		try {	
		
			jugador1.setProbabilidadDeGanar(leer.nextDouble());
			while(jugador1.getProbabilidadDeGanar()>100.0 ||  jugador1.getProbabilidadDeGanar()<1.0) {
				System.out.println("Porcentaje incorrecto, debe ser entre 1% y 100%, ingrese de nuevo");
				jugador1.setProbabilidadDeGanar(leer.nextDouble());
		}
		}
		catch (Exception e) {
			System.out.println("A ocurrido el siguiente error " + e + " reinicie el programa, tenga en cuenta de ingresar solo numeros");
		}
		jugador2.setProbabilidadDeGanar(100.0-jugador1.getProbabilidadDeGanar());
		
		System.out.println("La probabilidad de ganar de "+jugador1.getNombre()+" son de "+jugador1.getProbabilidadDeGanar()+"% y las de ganar de "+jugador2.getNombre()+" "+jugador2.getProbabilidadDeGanar()+"%");
		
		System.out.println("EMPIEZA EL PARTIDO");
	
		
		
		
		torneo.jugarSets(jugador1, jugador2);
		
		torneo.getGanador(jugador1, jugador2);
		
        String valor=JOptionPane.showInputDialog("¿Quiere revancha?");
        revancha = valor.equalsIgnoreCase("si");
       if(revancha==true) {
       	JOptionPane.showMessageDialog(null,"Empieza la revancha");
       }
       else {
       	JOptionPane.showMessageDialog(null,"Partida terminada, Hasta luego");
       }
		
		JugadoresBO jbo1=new JugadoresBO();
		JugadoresBO jbo2=new JugadoresBO();
		
		
		String mensaje="";
		mensaje=jbo1.agregarJugador(jugador1);
		System.out.println(mensaje);
		mensaje=jbo2.agregarJugador(jugador2);
		System.out.println(mensaje);
		
		

	       
		
		}
	}
}	
		
		
	


