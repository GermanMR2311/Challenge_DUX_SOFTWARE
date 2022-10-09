package dux;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Torneo{

	private String nombreTorneo;
	private double SetsTotales;
	private String ganador;
	private int setActual=0;
	JugadoresBO jbo=new JugadoresBO();
	

	Scanner leer= new  Scanner(System.in);

	public Torneo() {
	}
	
	public Torneo(String nombreTorneo) {
		super();
		this.nombreTorneo = nombreTorneo;
	}
	
	public Integer getSetActual() {
		return setActual;
	}

	public void setSetActual(Integer setActual) {
		this.setActual = setActual;
	}
	
	public void sumaSetActual() {
		this.setActual+=1;
	}

	public String getNombreTorneo() {
		return nombreTorneo;
	}
	
	public void setNombreTorneo(String nombreTorneo) {
		this.nombreTorneo = nombreTorneo;
	}
	
	public void cargarNombreTorneo(Jugadores jugador1, Jugadores jugador2 ) {
		System.out.println("Ingrese el nombre del torneo");
		this.setNombreTorneo(leer.next());
		jugador1.setTorneoJugado(this.getNombreTorneo());
		jugador2.setTorneoJugado(this.getNombreTorneo());
		
	}
	
	public double getSetsTotales() {
		return SetsTotales;
	}
	
	public void setSetsTotales(double setsTotales){
		SetsTotales = setsTotales;
	}
	
	public void cargarSets() {
		System.out.println("Ingrese el mejor de que quiere jugar (Mejor de 3 o mejor de 5)");
		
		try{
			do {
			this.setSetsTotales(leer.nextInt());
			if(this.getSetsTotales()!=3 &&  this.getSetsTotales()!=5) {
				System.out.println("Escribio un numero incorrecto, debe ser 3 o 5");
			}
			}
			while(this.getSetsTotales()!=3 &&  this.getSetsTotales()!=5);
		}
		catch (Exception e) {
			System.out.println("A ocurrido el siguiente error " + e + " reinicie el programa, tenga en cuenta de ingresar solo numeros");
				
			}
		
	}
	
	
	public String getGanador() {
		return ganador;
	}

	public void cargarPorbabilidadDeGanar(Jugadores jugador1, Jugadores jugador2) {
		System.out.println("Ingrese la probabilidad de ganar del jugador 1");
		int n1=0;
		
		do {
		try {	
		
			jugador1.setProbabilidadDeGanar(leer.nextDouble());
			while(jugador1.getProbabilidadDeGanar()>100.0 ||  jugador1.getProbabilidadDeGanar()<1.0) {
				System.out.println("Porcentaje incorrecto, debe ser entre 1% y 100%, ingrese de nuevo");
				jugador1.setProbabilidadDeGanar(leer.nextDouble());
				n1=1;
		}
			
		}
		catch (Exception e) {
			System.out.println("A ocurrido el siguiente error " + e + ", tenga en cuenta de ingresar solo numeros");
			n1=0;
			leer.nextLine();
		}
		}
		while(n1==0);
		
		
		
		jugador2.setProbabilidadDeGanar(100.0-jugador1.getProbabilidadDeGanar());
		
		System.out.println("La probabilidad de ganar de "+jugador1.getNombre()+" son de "+jugador1.getProbabilidadDeGanar()+"% y las de ganar de "+jugador2.getNombre()+" "+jugador2.getProbabilidadDeGanar()+"%");
	}

	public void mostrarResultadoPunto(Jugadores jugador1, Jugadores jugador2) {
		if(jugador1.getPuntos()<70) {
			
			if(jugador1.getPuntos()==55) {
				if(jugador1.getSaca()==true) {	
				System.out.print("*");
				}
				System.out.println(jugador1.getNombre()+": "+"AD"+ " /// Games: " + jugador1.getGamesGanados()+" /// Sets:" + jugador1.getSetsGanados());

				if(jugador2.getSaca()==true) {
					System.out.print("*");
				}
				System.out.println(jugador2.getNombre()+": "+jugador2.getPuntos()+" /// Games: " + jugador2.getGamesGanados()+" /// Sets:" + jugador2.getSetsGanados());
				System.out.println();
			}
			else {
				if(jugador2.getPuntos()==55) {
					
					if(jugador1.getSaca()==true) {
						System.out.print("*");
					}
					System.out.println(jugador1.getNombre()+": "+jugador1.getPuntos()+" /// Games: " + jugador1.getGamesGanados()+" /// Sets:" + jugador1.getSetsGanados());
					if(jugador2.getSaca()==true) {
						System.out.print("*");
					}
					System.out.println(jugador2.getNombre()+": AD"+" /// Games: " + jugador2.getGamesGanados()+" /// Sets:" + jugador2.getSetsGanados());
					System.out.println();
					
				}
				else {
					
				
				if(jugador1.getSaca()==true) {
						System.out.print("*");
				}	
				System.out.println(jugador1.getNombre()+": "+jugador1.getPuntos()+" /// Games: " + jugador1.getGamesGanados()+" /// Sets:" + jugador1.getSetsGanados());
				if(jugador2.getSaca()==true) {
					System.out.print("*");
				}
				System.out.println(jugador2.getNombre()+": "+jugador2.getPuntos()+" /// Games: " + jugador2.getGamesGanados()+" /// Sets:" + jugador2.getSetsGanados());
				
				System.out.println();
				}
			}
				return;
		}
		
		
		if(jugador2.getPuntos()<70) {
			
			if(jugador2.getPuntos()==55) {
				if(jugador1.getSaca()==true) {
					System.out.print("*");
				}
				System.out.println(jugador1.getNombre()+": "+jugador1.getPuntos()+" /// Games: " + jugador1.getGamesGanados()+" /// Sets:" + jugador1.getSetsGanados());
				if(jugador2.getSaca()==true) {
					System.out.print("*");
				}
				System.out.println(jugador2.getNombre()+": "+"AD"+" /// Games: " + jugador2.getGamesGanados()+" /// Sets:" + jugador2.getSetsGanados());
				System.out.println();
				}
			else {
				if(jugador1.getPuntos()==55) {
					if(jugador1.getSaca()==true) {
						System.out.print("*");
					}
					System.out.println(jugador1.getNombre()+": AD"+" /// Games: " + jugador1.getGamesGanados()+" /// Sets:" + jugador1.getSetsGanados());
					
					if(jugador2.getSaca()==true) {
						System.out.print("*");
					}System.out.println(jugador2.getNombre()+": "+jugador2.getPuntos()+" /// Games: " + jugador2.getGamesGanados()+" /// Sets:" + jugador2.getSetsGanados());
					System.out.println();
				}
				else {
					if(jugador1.getSaca()==true) {
						System.out.print("*");
					}	
				System.out.println(jugador1.getNombre()+": "+jugador1.getPuntos()+" /// Games: " + jugador1.getGamesGanados()+" /// Sets:" + jugador1.getSetsGanados());
				if(jugador2.getSaca()==true) {
					System.out.print("*");
				}
				System.out.println(jugador2.getNombre()+": "+jugador2.getPuntos()+" /// Games: " + jugador2.getGamesGanados()+" /// Sets:" + jugador2.getSetsGanados());
				System.out.println();
				}
			}
		
		}	
		return;
	}
	
	private void JugarPunto(Jugadores jugador1,Jugadores jugador2) {
		Random generator = new Random();
		double numeroRandom = generator.nextDouble();
		
			if((jugador1.getProbabilidadDeGanar()/100)!=0 && (jugador1.getProbabilidadDeGanar()/100)>numeroRandom) {
				jugador1.sumarPunto();				
				if(jugador1.getPuntos()==55 &&jugador2.getPuntos()==55) {
					jugador1.restarPunto();
					jugador2.restarPunto();
				}
				System.out.println("Punto de "+jugador1.getNombre());
				mostrarResultadoPunto(jugador1, jugador2);
			}
			else {
				jugador2.sumarPunto();
				if(jugador1.getPuntos()==55 &&jugador2.getPuntos()==55) {
					jugador1.restarPunto();
					jugador2.restarPunto();
				}
				System.out.println("Punto de "+jugador2.getNombre());
				mostrarResultadoPunto(jugador1, jugador2);
			
			}			
	}
	
	private void jugarGame(Jugadores jugador1, Jugadores jugador2) {
		
		while((jugador1.getPuntos()<56 && jugador2.getPuntos()<56) ) { 
			this.JugarPunto(jugador1, jugador2);
			if(jugador1.getPuntos()>40 &&jugador2.getPuntos()<40) {
				break;
			}
			if(jugador2.getPuntos()>40 &&jugador1.getPuntos()<40) {
				break;
			}
		}
		
		this.determinarGanadorGame(jugador1, jugador2);
		jugador1.setPuntos(0);
		jugador2.setPuntos(0);
		System.out.println("Cambiando de saque");
		this.cambioDeSaque(jugador1, jugador2);
		System.out.println("Se cambio el saque");

	}
	
	public void determinarGanadorGame(Jugadores jugador1, Jugadores jugador2) {
		if(jugador1.getPuntos()>55 || (jugador1.getPuntos()>40 && jugador2.getPuntos()<40)) {
			jugador1.sumarGame();
			System.out.println("Gana el game "+ jugador1.getNombre()+" /// "+ jugador1.getNombre()+" " +jugador1.getGamesGanados()+" vs "+ jugador2.getNombre()+" "  + jugador2.getGamesGanados());
		}
		if(jugador2.getPuntos()>55 || (jugador2.getPuntos()>40 && jugador1.getPuntos()<40)){
			jugador2.sumarGame();
			System.out.println("Gana el game "+ jugador2.getNombre()+"///"+ jugador1.getNombre()+" " +jugador1.getGamesGanados()+" vs "+ jugador2.getNombre()+" "  + jugador2.getGamesGanados());
		}
	}

	public void jugarSet(Jugadores jugador1,Jugadores jugador2) {
		while(jugador1.getGamesGanados()<6 && jugador2.getGamesGanados()<6) {
			this.jugarGame(jugador1, jugador2);
		}
		if((jugador1.getGamesGanados()-jugador2.getGamesGanados())<2 &&(jugador1.getGamesGanados()-jugador2.getGamesGanados())>0) {
			this.jugarGame(jugador1, jugador2);
		}
		if((jugador2.getGamesGanados()-jugador1.getGamesGanados())<2&&(jugador2.getGamesGanados()-jugador1.getGamesGanados())>0) {
			this.jugarGame(jugador1, jugador2);
		}
		if(jugador1.getGamesGanados()==6 && jugador2.getGamesGanados()==6) {
			this.jugarTeabreak(jugador1, jugador2);
			System.out.println("Se finalizo el teabreak");
		}
		this.determinarGanadorSet(jugador1, jugador2);
		jugador1.setPuntoTeabreak(0);
		jugador2.setPuntoTeabreak(0);
		this.sumaSetActual();
		}
	
	public void determinarGanadorSet(Jugadores jugador1, Jugadores jugador2) {
		if(jugador1.getGamesGanados()>jugador2.getGamesGanados() || jugador1.getPuntoTeabreak()>jugador2.getPuntoTeabreak()) {
			jugador1.SumarSet();
			if(jugador1.getGamesGanados()==7) {
				jugador1.setGamesGanados(6);
			}
			jugador1.cargarPuntosSets(setActual);
			jugador2.cargarPuntosSets(setActual);
			jugador1.cargarPuntosTeabreak(setActual);
			jugador2.cargarPuntosTeabreak(setActual);
			System.out.println("Gana el set "+jugador1.getNombre() +"/// "+jugador1.getNombre()+": "+jugador1.getSetsGanados()+". "+jugador2.getNombre()+": "+ jugador2.getSetsGanados());
			jugador1.setGamesGanados(0);
			jugador2.setGamesGanados(0);
		}
		if(jugador2.getGamesGanados()>jugador1.getGamesGanados() || jugador2.getPuntoTeabreak()>jugador1.getPuntoTeabreak()) {
			jugador2.SumarSet();
			if(jugador2.getGamesGanados()==7) {
				jugador2.setGamesGanados(6);
			}
			jugador2.cargarPuntosSets(setActual);
			jugador1.cargarPuntosSets(setActual);
			jugador1.cargarPuntosTeabreak(setActual);
			jugador2.cargarPuntosTeabreak(setActual);
			System.out.println("Gana el set "+jugador2.getNombre() +"/// "+jugador2.getNombre()+": "+jugador2.getSetsGanados()+". "+jugador1.getNombre()+": "+ jugador1.getSetsGanados());
			jugador1.setGamesGanados(0);
			jugador2.setGamesGanados(0);
		}
	}

	public void jugarPartido(Jugadores jugador1, Jugadores jugador2) {
		System.out.println("Empieza el partido");
		while((jugador1.getSetsGanados()<(this.getSetsTotales()/2)) && (jugador2.getSetsGanados()<(this.getSetsTotales()/2))){
		this.jugarSet(jugador1, jugador2);
		}
		this.getGanador(jugador1, jugador2);
	}
	
	public boolean preguntarRevancha(boolean revancha) {
		try {
			
		
		String valor=JOptionPane.showInputDialog("¿Quiere revancha?");
        revancha = valor.equalsIgnoreCase("si");
       if(revancha==true) {
       	JOptionPane.showMessageDialog(null,"Empieza la revancha");
       }
       else {
       	JOptionPane.showMessageDialog(null,"Partida terminada, Hasta luego");
       	}
       return revancha;
	}catch (Exception e) {
		// TODO: handle exception
		return false;
	}
		
	}
	
	public Jugadores getGanador(Jugadores jugador1, Jugadores jugador2) {
		if(jugador1.getSetsGanados()>jugador2.getSetsGanados()) {
		return jugador1;
		}else {
			return jugador2;
		}
	}
	
	public void setGanador(String ganador) {
		this.ganador = ganador;
	}
	
	public void mostrarPuntosTaebreak(Jugadores jugador1, Jugadores jugador2) {
		if(jugador1.getSaca()==true) {
			System.out.print("*");
		}
		System.out.println(jugador1.getNombre()+": "+jugador1.getPuntoTeabreak());
		if(jugador2.getSaca()==true) {
			System.out.print("*");
		}
		System.out.println(jugador2.getNombre()+": "+jugador2.getPuntoTeabreak());
	}
	
	public void jugarPuntoTaebreak(Jugadores jugador1, Jugadores jugador2) {
			Random generator = new Random();
			double numeroRandom = generator.nextDouble();
			if((jugador1.getProbabilidadDeGanar()/100)!=0 && (jugador1.getProbabilidadDeGanar()/100)>numeroRandom) {
				jugador1.sumarPuntoTeabreak();
				this.mostrarPuntosTaebreak(jugador1, jugador2);
			}
			else {
				jugador2.sumarPuntoTeabreak();
				this.mostrarPuntosTaebreak(jugador1, jugador2);
			}
	}
	
	public void cambioDeSaque(Jugadores jugador1, Jugadores jugador2) {
		if(jugador1.getSaca()==true) {
			jugador1.setSaca(false);
			jugador2.setSaca(true);
		}
		else {
			jugador1.setSaca(true);
			jugador2.setSaca(false);
		}
		
			
		
	}
	
	public void cambioSaqueTeabreak(Jugadores jugador1, Jugadores jugador2) {
		if((jugador1.getPuntoTeabreak()==0 && jugador2.getPuntoTeabreak()==1)||(jugador1.getPuntoTeabreak()==1 && jugador2.getPuntoTeabreak()==0)) {
			this.cambioDeSaque(jugador1, jugador2);
		}
		if(jugador1.getPuntoTeabreak()+jugador2.getPuntoTeabreak()>1&&((jugador1.getPuntoTeabreak()+jugador2.getPuntoTeabreak())%2==1)) {
			this.cambioDeSaque(jugador1, jugador2);
		}
	}
		
	public void jugarTeabreak(Jugadores jugador1, Jugadores jugador2) {
		System.out.println("Empieza el teabreak");
		while((jugador1.getPuntoTeabreak()<7 || (jugador1.getPuntoTeabreak()-jugador2.getPuntoTeabreak())<2) &&  (jugador2.getPuntoTeabreak()<7 || (jugador2.getPuntoTeabreak()-jugador1.getPuntoTeabreak())<2))
		{
		this.cambioSaqueTeabreak(jugador1, jugador2);
		 this.jugarPuntoTaebreak(jugador1, jugador2);
		}
		jugador1.cargarPuntosTeabreak(setActual);
		jugador2.cargarPuntosTeabreak(setActual);
	}
	
	public void mostrarTablero(Jugadores jugador1, Jugadores jugador2) {
		String nombre1=jugador1.getNombre();
		String nombre2=jugador2.getNombre();
		String resultado1="";
		String resultado2="";
		if(jugador1.getNombre().length()<jugador2.getNombre().length()) {
		while(nombre1.length()<nombre2.length()){
			nombre1=nombre1+" ";
		}
		}
		if(jugador2.getNombre().length()<jugador1.getNombre().length()) {
		while(nombre2.length()<nombre1.length()){
			nombre2=nombre2+" ";
		}
		}
		for(int i=0;i<this.getSetActual();i++) {
			resultado1=resultado1+jugador1.getPuntosSets().get(i);
			if(jugador1.getPuntosTeabreak().get(i)!=null && jugador1.getPuntosTeabreak().get(i)<jugador2.getPuntosTeabreak().get(i)) {
				resultado1=resultado1+"-"+jugador1.getPuntosTeabreak().get(i);
				resultado2=resultado2+"  ";
			}
			resultado1=resultado1+" ";
		}
		
		for(int i=0;i<this.getSetActual();i++) {
			resultado2=resultado2+jugador2.getPuntosSets().get(i);
			if(jugador2.getPuntosTeabreak().get(i)!=null && jugador2.getPuntosTeabreak().get(i)<jugador1.getPuntosTeabreak().get(i)) {
				resultado2=resultado2+"-"+jugador1.getPuntosTeabreak().get(i);
				resultado1=resultado1+"  ";
			}	
			resultado2=resultado2+" ";
		}
			
		System.out.println(nombre1+"  "+resultado1);
		System.out.println(nombre2+"  "+resultado2);
			
		
	}
	
	public void mostrarTableroSwing(Jugadores jugador1, Jugadores jugador2) {
		Resultados resultado=new Resultados();
		resultado.cargarNombres(jugador1, jugador2);
		resultado.cargarResultadosSets(jugador1, jugador2,this.getSetActual());
		resultado.cargarResultadosTaebreak(jugador1, jugador2, this.getSetActual());
		resultado.setVisible(true);
		resultado.setLocationRelativeTo(null);
	}
	public void sumarScoreGanador(Jugadores jugador1,Jugadores jugador2) {
		Jugadores jugadoraux=new Jugadores(this.getGanador(jugador1, jugador2));
		jbo.sumarScore(jugadoraux);
	}
	public void mostrarGanador(Jugadores jugador) {
		System.out.println("Gana el torneo "+this.getNombreTorneo()+", "+ jugador.getNombre()+": "+jugador.getSetsGanados());
	}
	public void jugarConRevancha(boolean revancha,Jugadores jugador1, Jugadores jugador2) {
	
		while(revancha==true) {
			
			this.elegirSaque(jugador1, jugador2);
			this.cargarNombreTorneo(jugador1, jugador2);
			this.cargarSets();
			this.cargarPorbabilidadDeGanar(jugador1, jugador2);
			this.jugarPartido(jugador1, jugador2);
			this.mostrarTablero(jugador1, jugador2);
			this.mostrarTableroSwing(jugador1, jugador2);
			this.mostrarGanador(this.getGanador(jugador1, jugador2));
			this.sumarScoreGanador(jugador1, jugador2);
			revancha=this.preguntarRevancha(revancha);
			
			

		       
			
			}
	}
	
	
	public void elegirSaque(Jugadores jugador1, Jugadores jugador2) {
		Random generator = new Random();
		double numeroRandom = generator.nextDouble();
		if(0.5>numeroRandom){
			jugador1.setSaca(true);
			System.out.println("Empieza sacando "+jugador1.getNombre());
		}
		else {
			jugador2.setSaca(true);
			System.out.println("Empieza sacando "+jugador2.getNombre());

		}
	}
	
	
}
