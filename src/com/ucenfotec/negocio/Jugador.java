package com.ucenfotec.negocio;

import java.util.ArrayList;

public class Jugador {
	
	private String Nombre;
	private ArrayList<Carta> Mano;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public ArrayList<Carta> getMano() {
		return Mano;
	}
	public void setMano(ArrayList<Carta> mano) {
		Mano = mano;
	}
	public void addCardToMano(Carta card) {
		if(Mano == null)
			Mano = new ArrayList<>();
		
		Mano.add(card);			
	}
	
	

}
