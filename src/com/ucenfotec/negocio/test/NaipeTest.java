package com.ucenfotec.negocio.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ucenfotec.negocio.Carta;
import com.ucenfotec.negocio.Naipe;

public class NaipeTest {

static Naipe naipe;
	
	//Inicializador 
	@BeforeClass
	public static void init() {
		naipe =  new Naipe();
	}
	
	///Valida la cantodad de cartas generadas
	@Test
	public void CantidadCartas() throws Exception {
		naipe.Generar();
		assertEquals(52, naipe.getCartas().size());
	}
	
	///Valida que las cartas tengan los 4 palos 
	@Test
	public void NaipeConEscudo() throws Exception {
		Carta escudo = naipe.getCartas().get(0);
		assertEquals("Escudos", escudo.getPalo());		
	}
	
	@Test
	public void NaipeConFlor() throws Exception {
		Carta flor = naipe.getCartas().get(13);
		assertEquals("Flores", flor.getPalo());		
	}
	
	@Test
	public void NaipeConEstrella() throws Exception {
		Carta estrella = naipe.getCartas().get(26);
		assertEquals("Estrellas", estrella.getPalo());	
	}

	@Test
	public void NaipeConGota() throws Exception {
		Carta gota = naipe.getCartas().get(39);
		assertEquals("Gotas", gota.getPalo());
	}
	
	//Valida que todos los tipos de cartas esten presentes
	@Test
	public void NaipeConCartasValidas() throws Exception {
		
		int numeroPorPalo = 1;
		for(Carta card : naipe.getCartas()) 
		{
			assertEquals(numeroPorPalo > 10 ? 10 : numeroPorPalo, card.getValor());
			numeroPorPalo++;
			
			if(numeroPorPalo > 13)
				numeroPorPalo = 1;
		}		
	}
	

}
