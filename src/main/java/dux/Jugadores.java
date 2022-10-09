package dux;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Jugadores {
	private String nombre;
	private int puntos;
	private int SetsGanados;
	private String torneoJugado;
	private Integer puntoTeabreak;
	private Integer gamesGanados;
	private boolean saca;
	private int score;
	private double probabilidadDeGanar;
	private List<Integer> puntosSets= new ArrayList<Integer>();
	private List<Integer> puntosTeabreak= new ArrayList<Integer>();
	
	public void cargarPuntosSets(int setActual) {
		puntosSets.add(setActual, this.gamesGanados);
	}
	public List<Integer> getPuntosSets() {
		return puntosSets;
	}
	public void setPuntosSets(ArrayList<Integer> puntosSets) {
		this.puntosSets = puntosSets;
	}
	public Jugadores() {
		puntos=0;
		SetsGanados=0;
		gamesGanados=0;
		saca=false;
		score=0;
		puntoTeabreak=0;
	}
	public Jugadores(Jugadores jugador) {
		this.nombre=jugador.getNombre();
		this.gamesGanados=jugador.getGamesGanados();
		this.probabilidadDeGanar=jugador.getProbabilidadDeGanar();
		this.puntos=jugador.getPuntos();
		this.saca=jugador.getSaca();
		this.torneoJugado=jugador.getTorneoJugado();
		this.SetsGanados=jugador.getSetsGanados();
		this.score=jugador.getScore();
		this.puntoTeabreak=jugador.getPuntoTeabreak();
	}
	public Jugadores(String nombre) {
		super();
		this.nombre = nombre;
		puntos=0;
		SetsGanados=0;
		gamesGanados=0;
		saca=false;
		score=0;
		puntoTeabreak=0;
	}
	
	public Integer getPuntoTeabreak() {
		return puntoTeabreak;
	}
	public void setPuntoTeabreak(Integer puntoTeabreak) {
		this.puntoTeabreak = puntoTeabreak;
	}
	public String getTorneoJugado() {
		return torneoJugado;
	}
	public void sumarPuntoTeabreak() {
		puntoTeabreak+=1;
	}
	

	public void setTorneoJugado(String torneoJugado) {
		this.torneoJugado = torneoJugado;
	}

	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


	public void setSaca(boolean saca) {
		this.saca = saca;
	}
	public boolean getSaca() {
		return saca;
	}

	public Integer getGamesGanados() {
		return gamesGanados;
	}

	public void setGamesGanados(Integer gamesGanados) {
		this.gamesGanados = gamesGanados;
	}

	public int getSetsGanados() {
		return SetsGanados;
	}

	public List<Integer> getPuntosTeabreak() {
		return puntosTeabreak;
	}
	public void setPuntosTeabreak(List<Integer> puntosTeabreak) {
		this.puntosTeabreak = puntosTeabreak;
	}
	public void cargarPuntosTeabreak(int setActual) {
		puntosTeabreak.add(setActual, this.puntoTeabreak);
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
	public void cargarNombre() {
		this.setNombre(JOptionPane.showInputDialog("Ingrese nombre del jugador"));
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
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
		
		gamesGanados=gamesGanados+1;
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
