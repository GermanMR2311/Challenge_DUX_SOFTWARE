package dux;
import java.util.Random;

public class Torneo{

	private String nombreTorneo;
	private double SetsTotales;
	private String ganador;

	
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
	public double getSetsTotales() {
		return SetsTotales;
	}
	public void setSetsTotales(double setsTotales){
		SetsTotales = setsTotales;
	}
	private void jugarGame(Jugadores jugador1, Jugadores jugador2) {
		
		while(jugador1.getPuntos()<56 && jugador2.getPuntos()<56) { 
			Random generator = new Random();
			double numeroRandom = generator.nextDouble();
			
				if((jugador1.getProbabilidadDeGanar()/100)!=0 && (jugador1.getProbabilidadDeGanar()/100)>numeroRandom) {
					jugador1.sumarPunto();
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
		
		if(jugador1.getPuntos()>55) {
			jugador1.sumarGame();
			System.out.println("Gana el game "+ jugador1.getNombre()+" /// "+ jugador1.getNombre()+" " +jugador1.getGamesGanados()+" vs "+ jugador2.getNombre()+" "  + jugador2.getGamesGanados());
		}
		else {
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
	
	
}
