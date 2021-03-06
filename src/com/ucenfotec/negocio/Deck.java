package com.ucenfotec.negocio;

import java.util.ArrayList;

public class Deck {
	
	private Naipe NaipeCompleto;

	public Naipe getNaipeDeck() {
		return NaipeCompleto;
	}

	public void seDeckWithtNaipe(Naipe naipe) {
		NaipeCompleto = naipe;
	}
	
	public void tomarCarta(Jugador jugador) {		
		Carta cartaADar = NaipeCompleto.getCartas().get(0);
		jugador.addCardToMano(cartaADar);
		NaipeCompleto.getCartas().remove(cartaADar);
		DesecharCarta(jugador);
	}
	
	public void DesecharCarta(Jugador jugador) {		
		Carta cartaAEliminar = jugador.getMano().get(0);
		jugador.getMano().remove(cartaAEliminar);		
	}
	

}
