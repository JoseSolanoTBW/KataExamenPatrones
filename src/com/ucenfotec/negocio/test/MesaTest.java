package com.ucenfotec.negocio.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ucenfotec.negocio.Jugador;
import com.ucenfotec.negocio.Mesa;
import com.ucenfotec.negocio.Repartidor;

public class MesaTest {
	
	static Mesa mesa;
	
	//Inicializador 
	
	@BeforeClass
	public static void init() {
		mesa =  new Mesa();
	}

	@Test
	public void MesaSinJugadores() {
		assertEquals(0, mesa.getJugadores().size());
	}
	
	@Test
	public void MesaConRepartidor() {
		Repartidor nuevoRepartidor = new Repartidor();
		mesa.setRepartidor(nuevoRepartidor);
		assertTrue(mesa.getRepartidor() != null);
	}
	
	@Test
	public void AgregarJugador() throws Exception {
		mesa =  new Mesa();
		Jugador nuevoJugador = new Jugador();
		mesa.agregarJugador(nuevoJugador);
		assertEquals(1, mesa.getJugadores().size());
	}
	
	@Test(expected = Exception.class)
	public void AgregarMaxJugador() throws Exception {
		mesa =  new Mesa();
		
		Jugador nuevoJugador = new Jugador();
		mesa.agregarJugador(nuevoJugador);
		
		Jugador nuevoJugador2 = new Jugador();
		mesa.agregarJugador(nuevoJugador2);

		Jugador nuevoJugador3 = new Jugador();
		mesa.agregarJugador(nuevoJugador3);
		
		Jugador nuevoJugador4 = new Jugador();
		mesa.agregarJugador(nuevoJugador4);
		
		Jugador nuevoJugador5 = new Jugador();
		mesa.agregarJugador(nuevoJugador5);
		
		assertEquals(4, mesa.getJugadores().size());
	}

}
