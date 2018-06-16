package com.ucenfotec.negocio.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ucenfotec.negocio.Carta;
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
		mesa =  new Mesa();
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
	
	@Test
	public void RepartirCartas21() throws Exception {
		mesa =  new Mesa();
		
		Jugador nuevoJugador = new Jugador();
		mesa.agregarJugador(nuevoJugador);
		Jugador segJugador = new Jugador();
		mesa.agregarJugador(segJugador);
		
		Repartidor repartidor =  new Repartidor();
		mesa.setRepartidor(repartidor);
		
		mesa.EmpezarAJugar21();
		
		assertEquals(2, mesa.getJugadores().get(0).getMano().size());
		assertEquals(2, mesa.getJugadores().get(1).getMano().size());
		
	}
	
	@Test
	public void MasoCartas21Disminucion() throws Exception {
		mesa =  new Mesa();
		
		Jugador nuevoJugador = new Jugador();
		mesa.agregarJugador(nuevoJugador);
		Jugador segJugador = new Jugador();
		mesa.agregarJugador(segJugador);
		
		Repartidor repartidor =  new Repartidor();
		mesa.setRepartidor(repartidor);
		
		mesa.EmpezarAJugar21();
		
		assertEquals(48, mesa.getRepartidor().getNaipeCompleto().getCartas().size());
	}
		
	@Test
	public void EncotrarGanador21() throws Exception {
		mesa =  new Mesa();
		
		Jugador nuevoJugador = new Jugador();
		nuevoJugador.setNombre("Jose");
		Carta carta = new Carta();
		carta.CrearCarta("5","Flores", 5);
		nuevoJugador.addCardToMano(carta);		
		mesa.agregarJugador(nuevoJugador);
		
		Jugador segJugador = new Jugador();
		segJugador.setNombre("Fer");
		Carta segCarta = new Carta();
		segCarta.CrearCarta("2","Estrellas", 2);
		segJugador.addCardToMano(segCarta);	
		mesa.agregarJugador(segJugador);
		
		Jugador ganador = mesa.RecibirManos();
		
		assertEquals("Jose", ganador.getNombre());
	}
	
	@Test
	public void Empate21() throws Exception {
		mesa =  new Mesa();
		
		Jugador nuevoJugador = new Jugador();
		nuevoJugador.setNombre("Jose");
		Carta carta = new Carta();
		carta.CrearCarta("10","Flores", 10);
		nuevoJugador.addCardToMano(carta);		
		mesa.agregarJugador(nuevoJugador);
		
		Jugador segJugador = new Jugador();
		segJugador.setNombre("Fer");
		Carta segCarta = new Carta();
		segCarta.CrearCarta("10","Estrellas", 10);
		segJugador.addCardToMano(segCarta);	
		mesa.agregarJugador(segJugador);
		
		Jugador ganador = mesa.RecibirManos();
		
		assertTrue(ganador == null);
	}
	
	@Test
	public void GanadorPor21Medio() throws Exception {
		mesa =  new Mesa();
		
		Jugador nuevoJugador = new Jugador();
		nuevoJugador.setNombre("Jose");
		Carta carta = new Carta();
		carta.CrearCarta("10","Flores", 10);
		nuevoJugador.addCardToMano(carta);	
		Carta segCarta = new Carta();
		segCarta.CrearCarta("2","Estrellas", 2);
		nuevoJugador.addCardToMano(segCarta);	
		mesa.agregarJugador(nuevoJugador);
		
		Jugador segJugador = new Jugador();
		segJugador.setNombre("Fer");
		Carta anotherCarta = new Carta();
		anotherCarta.CrearCarta("10","Estrellas", 10);
		segJugador.addCardToMano(anotherCarta );	
		mesa.agregarJugador(segJugador);
		
		Jugador ganador = mesa.RecibirManos();
		
		assertEquals("Jose", ganador.getNombre());
	}
	

}
