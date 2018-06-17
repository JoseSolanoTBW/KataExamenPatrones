package com.ucenfotec.negocio.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ucenfotec.negocio.Jugador;
import com.ucenfotec.negocio.Mesa;
import com.ucenfotec.negocio.Repartidor;

public class DeckTest {
	
	static Mesa mesa;

	@Test
	public void DejarNaipeEnDeck() throws Exception {
		mesa =  new Mesa();
		Repartidor repartidor =  new Repartidor();
		mesa.setRepartidor(repartidor);	
		Jugador nuevoJugador = new Jugador();
		mesa.agregarJugador(nuevoJugador);
		Jugador otroJugador = new Jugador();
		mesa.agregarJugador(otroJugador);
		
		mesa.empezarPartidaDeRon();
		assertTrue(mesa.getDeck() != null);		
	}
	
	@Test
	public void TomarCartaDeck() throws Exception {
		mesa =  new Mesa();
		Repartidor repartidor =  new Repartidor();
		mesa.setRepartidor(repartidor);	
		Jugador nuevoJugador = new Jugador();
		mesa.agregarJugador(nuevoJugador);
		Jugador otroJugador = new Jugador();
		mesa.agregarJugador(otroJugador);
		
		mesa.empezarPartidaDeRon();
		mesa.getDeck().tomarCarta(nuevoJugador);
		mesa.getDeck().tomarCarta(otroJugador);
		
		assertEquals(36, mesa.getDeck().getNaipeDeck().getCartas().size());		
	}

}
