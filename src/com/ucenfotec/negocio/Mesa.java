package com.ucenfotec.negocio;

import java.util.ArrayList;

public class Mesa {

	private Repartidor repartidor;
	private ArrayList<Jugador> Jugadores;
	
	public Mesa() {
		Jugadores = new ArrayList<>();
	}
	
	public Repartidor getRepartidor() {
		return repartidor;
	}
	public void setRepartidor(Repartidor repartidor) {
		this.repartidor = repartidor;
	}
	public ArrayList<Jugador> getJugadores() {
		return Jugadores;
	}
	public void agregarJugador(Jugador jugador) throws Exception {
		if(Jugadores == null)
			Jugadores = new ArrayList<>();
		
		if(Jugadores.size() == 4)
			throw new Exception("Maxima cantidad de jugadores");
		
		Jugadores.add(jugador);		
	}
	
	public void EmpezarAJugar21 () throws Exception {
		repartidor.ObtenerNaipeCompleto();
		repartidor.RevolverNaipe();
		
		for(Jugador player : Jugadores) {
			repartidor.darCarta(player);
			repartidor.darCarta(player);
		}
		
	}
	
	
}
