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
		
		if(valor > 13 || valor <= 0 )
			throw new Exception("Los valores permetidos son entre 1 y 10");
		
		this.setValor(valor);
		this.setNombre(nombre);
		this.setPalo(palo);
		
		nombreDisponible.forEach(n -> {			
			if(n.equals(nombre) || valor > 10) 
				this.setValor(10);					
		});
		
		if(nombre.equals("As"))
			this.setValor(1);
		
		if(valor == 11)
			this.setNombre("Jota");
		else if(valor == 12)
			this.setNombre("Quina");
		else if(valor == 13)
			this.setNombre("K");		
		else if(valor == 1)
			this.setNombre("As");
	}		

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		return Nombre.equals(other.Nombre) && Valor == other.Valor;
	}
	
	
	
}
