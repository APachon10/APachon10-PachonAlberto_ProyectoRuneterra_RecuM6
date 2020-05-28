package Modelos;

import java.util.ArrayList;

public class Barajas {
	private int baraja_id;
	private String nombre_baraja;
	private  int valor_baraja;
	private ArrayList cartas_baraja;
	//Getters
	public int getBaraja_id() {
		return baraja_id;
	}
	public String getNombre_baraja() {
		return nombre_baraja;
	}
	public int getValor_baraja() {
		return valor_baraja;
	}
	public ArrayList getCartas_baraja() {
		return cartas_baraja;
	}
	//Setters
	public void setBaraja_id(int baraja_id) {
		this.baraja_id = baraja_id;
	}
	public void setNombre_baraja(String nombre_baraja) {
		this.nombre_baraja = nombre_baraja;
	}	
	public void setValor_baraja(int valor_baraja) {
		this.valor_baraja = valor_baraja;
	}	
	public void setCartas_baraja(ArrayList cartas_baraja) {
		this.cartas_baraja = cartas_baraja;
	}
	
	// To String 
	@Override
	public String toString() {
		return "Barajas [baraja_id=" + baraja_id + ", nombre_baraja=" + nombre_baraja + ", valor_baraja=" + valor_baraja
				+ ", cartas_baraja=" + cartas_baraja + "]";
	}
	
}
