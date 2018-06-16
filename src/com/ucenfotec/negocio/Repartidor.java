package com.ucenfotec.negocio;

import java.util.Collections;

public class Repartidor {

	private Naipe NaipeCompleto;

	public Naipe getNaipeCompleto() {
		return NaipeCompleto;
	}

	public void setNaipeCompleto(Naipe naipeCompleto) {
		NaipeCompleto = naipeCompleto;
	}
	
	public void ObtenerNaipeCompleto() throws Exception {
		NaipeCompleto = new Naipe();
		NaipeCompleto.Generar();
	}
	
	public void RevolverNaipe() {
		Collections.shuffle(NaipeCompleto.getCartas());
	}
	
}
