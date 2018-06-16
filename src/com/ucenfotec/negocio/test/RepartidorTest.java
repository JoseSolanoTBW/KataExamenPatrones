package com.ucenfotec.negocio.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ucenfotec.negocio.Carta;
import com.ucenfotec.negocio.Jugador;
import com.ucenfotec.negocio.Naipe;
import com.ucenfotec.negocio.Repartidor;

public class RepartidorTest {

	static Repartidor repartidor;
	
	//Inicializador 
	@BeforeClass
	public static void init() throws Exception {
		repartidor =  new Repartidor();
		repartidor.ObtenerNaipeCompleto();
	}
	
	@Test
	public void NaipesIguales() throws Exception {
		repartidor.ObtenerNaipeCompleto();
		Naipe naipe1 = repartidor.getNaipeCompleto();
		repartidor.ObtenerNaipeCompleto();
		Naipe naipe2 = repartidor.getNaipeCompleto();
		assertTrue(naipe1.equals(naipe2));		
	}
	
	@Test
	public void NaipeCompleto() {
		assertEquals(52, repartidor.getNaipeCompleto().getCartas().size());
	}
	
	@Test
	public void NaipeNoOrdenado() throws Exception {
		repartidor.ObtenerNaipeCompleto();
		repartidor.RevolverNaipe();
		Naipe naipe1 = repartidor.getNaipeCompleto();
		repartidor.ObtenerNaipeCompleto();
		Naipe naipe2 = repartidor.getNaipeCompleto();
		assertFalse(naipe1.equals(naipe2));		
	}
	
	@Test
	public void DarCarta() throws Exception {
		repartidor.ObtenerNaipeCompleto();
		Jugador nuevoJugador = new  Jugador();
		repartidor.darCarta(nuevoJugador);
		assertEquals(51, repartidor.getNaipeCompleto().getCartas().size());
	}
	
	@Test
	public void JugadorConCarta() throws Exception {
		repartidor.ObtenerNaipeCompleto();
		Jugador nuevoJugador = new  Jugador();
		repartidor.darCarta(nuevoJugador);
		assertEquals(1, nuevoJugador.getMano().size());
	}
	
	@Test
	public void NoPuedeCambiarMaso() throws Exception {
		Jugador nuevoJugador = new  Jugador();		
		Carta carta = new Carta();
		carta.CrearCarta("5","Flores", 5);
		nuevoJugador.addCardToMano(carta);	
		assertFalse(repartidor.VerificarCambio(nuevoJugador.getMano()));
	}
	
	@Test
	public void PuedeCambiarMaso() throws Exception {
		Jugador nuevoJugador = new  Jugador();
		Carta carta = new Carta();
		carta.CrearCarta("3","Estrellas", 3);
		nuevoJugador.addCardToMano(carta);
		Carta otraCarta = new Carta();
		otraCarta.CrearCarta("Jota","Estrellas", 10);
		nuevoJugador.addCardToMano(otraCarta);
		assertTrue(repartidor.VerificarCambio(nuevoJugador.getMano()));
	}

}
