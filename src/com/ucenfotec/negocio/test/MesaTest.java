package com.ucenfotec.negocio.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

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

}
