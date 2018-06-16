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
	
	public Jugador RecibirManos() {
		
		int currentWinner = 0;
		boolean isADraw = false;
		int summaryUser = 0;
		Jugador winner = null;
		
		
		for(Jugador player : Jugadores) {
			for(Carta card : player.getMano()) {
				summaryUser += card.getValor();
			}
			if(currentWinner == summaryUser) {
				isADraw = false;
				winner = null;
			}
			else if(summaryUser == 12) {
				winner = player;
				break;
			}
			else if(currentWinner < summaryUser && summaryUser <= 21) {
				currentWinner = summaryUser;
				winner =  player;
				isADraw = false;
			}
				
				
			summaryUser = 0;
		}
		
		return winner;
	}
	

	
}
