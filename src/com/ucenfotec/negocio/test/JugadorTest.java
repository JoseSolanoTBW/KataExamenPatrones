package com.ucenfotec.negocio.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ucenfotec.negocio.Carta;
import com.ucenfotec.negocio.Jugador;


public class JugadorTest {

	static Jugador jugador;
	
	//Inicializador 
	
	@BeforeClass
	public static void init() {
		jugador =  new Jugador();
	}
	
	@Test
	public void CrearJugadorNombre() {
		jugador.setNombre("Jose");
		assertEquals("Jose", jugador.getNombre());
	}
	
	@Test
	public void AgregarCartaMano() throws Exception {
		Carta nuevaCarta = new Carta();
		nuevaCarta.CrearCarta("As", "Estrellas", 1);
		jugador.addCardToMano(nuevaCarta);
		assertEquals(1, jugador.getMano().size());
		
	}

}
