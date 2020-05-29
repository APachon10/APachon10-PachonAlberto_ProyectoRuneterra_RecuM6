package Modelos;

import java.util.ArrayList;

public class Usuarios extends Object{
	private int id;
	private String username;
	private String password;
	private ArrayList cartas_compradas;
	private ArrayList barajas;
	//Getters
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public ArrayList getCartas_compradas() {
		return cartas_compradas;
	}
	public ArrayList getBarajas() {
		return barajas;
	}
	//Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setCartas_compradas(ArrayList cartas_compradas) {
		this.cartas_compradas = cartas_compradas;
	}
	public void setBarajas(ArrayList barajas) {
		this.barajas = barajas;
	}
	// To String
	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", username=" + username + ", password=" + password + ", cartas_compradas="
				+ cartas_compradas + ", barajas=" + barajas + "]";
	}
	
	
	
}
