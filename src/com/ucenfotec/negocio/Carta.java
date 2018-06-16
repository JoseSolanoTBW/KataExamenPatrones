package com.ucenfotec.negocio;

import java.util.ArrayList;

public class Carta {

	private String Nombre;
	private String Palo;
	private int Valor;
		
	
	public String getNombre() {
		return Nombre;
	}
	
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public int getValor() {
		return Valor;
	}
	
	public void setValor(int valor) {
		Valor = valor;
	}	
	
	public String getPalo() {
		return Palo;
	}

	public void setPalo(String palo) {
		Palo = palo;
	}

	public void CrearCarta(String nombre, String palo, int valor) throws Exception 
	{	
		ArrayList<String> nombreDisponible = new ArrayList<String>() {{
		    add("Jota");
		    add("Quina");
		    add("Ka");		    
		}};
		
		if(valor > 10 || valor <= 0 )
			throw new Exception("Los valores permetidos son entre 1 y 10");
		
		this.setValor(valor);
		this.setNombre(nombre);
		this.setPalo(palo);
		
		nombreDisponible.forEach(c -> {			
			if(c.equals(nombre)) 
				this.setValor(10);					
		});
		
		if(nombre.equals("As"))
			this.setValor(1);
	}
	
}
