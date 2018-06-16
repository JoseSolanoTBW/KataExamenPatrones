package com.ucenfotec.negocio.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ucenfotec.negocio.Carta;

public class CartaTest {
	
	static Carta carta;
	
	//Inicializador 
	@BeforeClass
	public static void init() {
		carta =  new Carta();
	}
	
	// Crea una carta baja de 1 a 10, No es J,Quina,Ka
	@Test
	public void CrearCartaBajaTest() throws Exception{
		carta.CrearCarta("5","Flores", 5);
		assertEquals(5, carta.getValor());
		assertEquals("Flores", carta.getPalo());
		assertEquals("5", carta.getNombre());
	}
	
	///Crea carta alta con valor incorrecto, probando funcionalidad de que todas las cartas (J, Quina y K) valen 10
	@Test
	public void CrearCartaAlta() throws Exception{
		carta.CrearCarta("Quina","Escudos", 4);
		assertEquals(10, carta.getValor());
		assertEquals("Escudos", carta.getPalo());
		assertEquals("Quina", carta.getNombre());
	}
	
	/// Validando que solo existan cartas de 1 a 10
	@Test(expected = Exception.class)
	public void CrearCartaFueraDeRangoTest() throws Exception{
		carta.CrearCarta("12","Gotas", 12);
	}
	
	/// Validando que se cree el As de manera correcta aunque el valor no sea el bueno, probando funcionalidad de que el AS debe ser 1 
	@Test
	public void CrearCartaAs() throws Exception{
		carta.CrearCarta("As","Estrellas", 2);
		assertEquals("As", carta.getNombre());
		assertEquals(1, carta.getValor());
		assertEquals("Estrellas", carta.getPalo());
	}
	
	@Test
	public void CartasIguales() throws Exception{
		carta.CrearCarta("K","Flores", 10);
		Carta nuevaCarta = new Carta();
		nuevaCarta.CrearCarta("K","Estrellas", 10);
		assertTrue(carta.equals(nuevaCarta));
	}
	
	@Test
	public void CartasDiferentes() throws Exception{
		carta.CrearCarta("Jota","Estrellas", 10);
		Carta nuevaCarta = new Carta();
		nuevaCarta.CrearCarta("Quina","Estrellas", 10);
		assertFalse(carta.equals(nuevaCarta));
		
	}
}
