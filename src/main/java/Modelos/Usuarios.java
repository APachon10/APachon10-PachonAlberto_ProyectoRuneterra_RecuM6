package Modelos;

import java.util.ArrayList;

public class Usuarios extends Object{
	private int id;
	private String username;
	private ArrayList<Integer> cartas_compradas;
	private ArrayList<Integer> barajas;
	//Getters
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public ArrayList<Integer> getCartas_compradas() {
		return cartas_compradas;
	}
	public ArrayList<Integer> getBarajas() {
		return barajas;
	}
	//Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setCartas_compradas(ArrayList<Integer> cartas_compradas) {
		this.cartas_compradas = cartas_compradas;
	}
	public void setBarajas(ArrayList<Integer> barajas) {
		this.barajas = barajas;
	}
	// To String
	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", username=" + username +", cartas_compradas="
				+ cartas_compradas + ", barajas=" + barajas + "]";
	}
	
	
	
}
