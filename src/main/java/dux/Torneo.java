package dux;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Torneo{

	private String nombreTorneo;
	private double SetsTotales;
	private String ganador;
	Scanner leer= new  Scanner(System.in);
	
	public Torneo() {
		
	}
	
	public Torneo(String nombreTorneo) {
		super();
		this.nombreTorneo = nombreTorneo;
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
	
	
	public void cargarPorbabilidadDeGanar(Jugadores jugador1, Jugadores jugador2) {
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
	}
	
	
	
	private void JugarPunto(Jugadores jugador1,Jugadores jugador2) {
		Random generator = new Random();
		double numeroRandom = generator.nextDouble();
		
			if((jugador1.getProbabilidadDeGanar()/100)!=0 && (jugador1.getProbabilidadDeGanar()/100)>numeroRandom) {
				jugador1.sumarPunto();
				
				if(jugador1.getPuntos()>40 && jugador2.getPuntos()<40) {
					
					System.out.println("Punto de "+jugador1.getNombre());
					return;
				}
				
				if(jugador1.getPuntos()==55 &&jugador2.getPuntos()==55) {
					jugador1.restarPunto();
					jugador2.restarPunto();
				}
				System.out.println("Punto de "+jugador1.getNombre());
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

				}
			}
			else {
				jugador2.sumarPunto();
				if(jugador2.getPuntos()>40 &&jugador1.getPuntos()<40) {
					System.out.println("Punto de "+jugador2.getNombre() );
					return;
				}
					
					
				if(jugador1.getPuntos()==55 &&jugador2.getPuntos()==55) {
					jugador1.restarPunto();
					jugador2.restarPunto();
				}
				System.out.println("Punto de "+jugador2.getNombre());
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
		
		if(jugador1.getPuntos()>55 || (jugador1.getPuntos()>40 && jugador2.getPuntos()<40)) {
			jugador1.sumarGame();
			System.out.println("Gana el game "+ jugador1.getNombre()+" /// "+ jugador1.getNombre()+" " +jugador1.getGamesGanados()+" vs "+ jugador2.getNombre()+" "  + jugador2.getGamesGanados());
		}
		if(jugador2.getPuntos()>55 || (jugador2.getPuntos()>40 && jugador1.getPuntos()<40)){
			jugador2.sumarGame();
			System.out.println("Gana el game "+ jugador2.getNombre()+"///"+ jugador1.getNombre()+" " +jugador1.getGamesGanados()+" vs "+ jugador2.getNombre()+" "  + jugador2.getGamesGanados());
		}
		jugador1.setPuntos(0);
		jugador2.setPuntos(0);
	}
	
	public void jugarSets(Jugadores jugador1,Jugadores jugador2) {
		
		
		while((jugador1.getSetsGanados()<(this.getSetsTotales()/2)) && (jugador2.getSetsGanados()<(this.getSetsTotales()/2))){
		while(jugador1.getGamesGanados()<6 &&jugador2.getGamesGanados()<6) {
			this.jugarGame(jugador1, jugador2);
			if(jugador1.getSaca()==true) {
				jugador1.setSaca(false);
				jugador2.setSaca(true);
			}
			else {
				jugador2.setSaca(false);
				jugador1.setSaca(true);
			}
		}
		
		if(jugador1.getGamesGanados()>jugador2.getGamesGanados()) {
			jugador1.SumarSet();
			System.out.println("Gana el set "+jugador1.getNombre() +"/// "+jugador1.getNombre()+": "+jugador1.getSetsGanados()+". "+jugador2.getNombre()+": "+ jugador2.getSetsGanados());
			jugador1.setGamesGanados(0);
			jugador2.setGamesGanados(0);
		}
		else {
			jugador2.SumarSet();
			System.out.println("Gana el set "+jugador2.getNombre() +"/// "+jugador2.getNombre()+": "+jugador2.getSetsGanados()+". "+jugador1.getNombre()+": "+ jugador1.getSetsGanados());
			jugador1.setGamesGanados(0);
			jugador2.setGamesGanados(0);
		}
		}
		
	}
	
	public void jugarPartido(Jugadores jugador1, Jugadores jugador2) {
		System.out.println("Empieza el partido");
		this.jugarSets(jugador1, jugador2);
		this.getGanador(jugador1, jugador2);
	}
	
	public void revancha(boolean revancha) {
		String valor=JOptionPane.showInputDialog("¿Quiere revancha?");
        revancha = valor.equalsIgnoreCase("si");
       if(revancha==true) {
       	JOptionPane.showMessageDialog(null,"Empieza la revancha");
       }
       else {
       	JOptionPane.showMessageDialog(null,"Partida terminada, Hasta luego");
       }
	}
	
	public String getGanador(Jugadores jugador1, Jugadores jugador2) {
		if(jugador1.getSetsGanados()>jugador2.getSetsGanados()) {
		System.out.println("Gana el torneo "+this.getNombreTorneo()+" "+ jugador1.getNombre()+": "+jugador1.getSetsGanados()+" a "+jugador2.getSetsGanados() );
		return jugador1.getNombre();
		}else {
			System.out.println("Ganador del torno "+this.getNombreTorneo()+" es "+ jugador2.getNombre()+": "+jugador2.getSetsGanados()+" a "+jugador1.getSetsGanados()+" Sets" );
			return jugador2.getNombre();
		}
	}
	public void setGanador(String ganador) {
		this.ganador = ganador;
	}
	
	public void jugarConRevancha(boolean revancha,Jugadores jugador1, Jugadores jugador2) {
	
		while(revancha==true) {
			
			
			this.cargarNombreTorneo(jugador1, jugador2);
			
			this.cargarSets();
			this.cargarPorbabilidadDeGanar(jugador1, jugador2);
			this.jugarPartido(jugador1, jugador2);
			this.revancha(revancha);	
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
