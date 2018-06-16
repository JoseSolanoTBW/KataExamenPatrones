package com.ucenfotec.negocio;

import java.util.ArrayList;
import java.util.Collections;

public class Naipe {

	private ArrayList<Carta> Cartas;

	public ArrayList<Carta> getCartas() {
		return Cartas;
	}

	public void setCartas(Carta carta) {
		if(Cartas == null)
			Cartas =  new ArrayList<Carta>();
		
		Cartas.add(carta);
	}
	
	public void Generar() throws Exception  {
		ArrayList<String> palos = new ArrayList<String>() {{
		    add("Escudos");
		    add("Flores");
		    add("Estrellas");
		    add("Gotas");
		}};
		
		palos.forEach(palo -> {
			for (int i = 1; i <= 13 ; i++) {
				Carta nuevaCarta = new Carta();
				try {
					nuevaCarta.CrearCarta(i + "" , palo, i);
					setCartas(nuevaCarta);
				} catch (Exception e) {
										
				}
			}
		});
	}
	
	
	
	
}
