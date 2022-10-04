package dux;

import java.util.Scanner;

public class Jugadores {
	
	public Jugadores() {
	
	}
	
	public Jugadores(String nombre) {
		super();
		this.nombre = nombre;
		puntos=0;
		SetsGanados=0;
		gamesGanados=0;
		saca=false;
	}
	
	private String nombre;
	private int puntos;
	private int SetsGanados;
	private String torneoJugado;
	public String getTorneoJugado() {
		return torneoJugado;
	}

	public void setTorneoJugado(String torneoJugado) {
		this.torneoJugado = torneoJugado;
	}

	private int gamesGanados;
	private boolean saca;
	public boolean isSaca() {
		return saca;
	}

	public void setSaca(boolean saca) {
		this.saca = saca;
	}
	public boolean getSaca() {
		return saca;
	}

	public int getGamesGanados() {
		return gamesGanados;
	}

	public void setGamesGanados(int gamesGanados) {
		this.gamesGanados = gamesGanados;
	}

	public int getSetsGanados() {
		return SetsGanados;
	}

	public void setSetsGanados(int setsGanados) {
		SetsGanados = setsGanados;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void cargarNombre(Scanner leer,String a) {
		System.out.println("Ingrese el nombre del jugador " + a);
		this.setNombre(leer.next());
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	private double probabilidadDeGanar;
	
	public double getProbabilidadDeGanar() {
		return probabilidadDeGanar;
	}

	public void setProbabilidadDeGanar(double probabilidadDeGanar) {
		this.probabilidadDeGanar = probabilidadDeGanar;
	}
	public void sumarPunto() {
		if(this.puntos==30) {
			puntos+=10;
		}else {
		puntos+=15;
		}
	}
	public void SumarSet() {
	 SetsGanados+=1;
	}
	
	public void sumarGame() {
		gamesGanados+=1;
	}
	
	public void restarPunto() {
		if(this.puntos>=30 &&this.puntos<=40) {
			puntos-=10;
		}
		else {
		puntos-=15;
		}
	}
	
}
