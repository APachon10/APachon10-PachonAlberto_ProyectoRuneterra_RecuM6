package Modelos;

public class Cartas {
	private int id;
    private String tipo;
    private String nombre_carta;
    private int coste_invocacion;
    private int ataque;
    private int vida;
    private String habilidad_especial;
    private String faccion;
    //Getters
	public int getId() {
		return id;
	}
	public String getTipo() {
		return tipo;
	}
	public String getNombre_carta() {
		return nombre_carta;
	}
	public int getCoste_invocacion() {
		return coste_invocacion;
	}
	public int getAtaque() {
		return ataque;
	}
	public int getVida() {
		return vida;
	}
	public String getHabilidad_especial() {
		return habilidad_especial;
	}
	public String getFaccion() {
		return faccion;
	}
	//Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setNombre_carta(String nombre_carta) {
		this.nombre_carta = nombre_carta;
	}
	public void setCoste_invocacion(int coste_invocacion) {
		this.coste_invocacion = coste_invocacion;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public void setHabilidad_especial(String habilidad_especial) {
		this.habilidad_especial = habilidad_especial;
	}
	public void setFaccion(String faccion) {
		this.faccion = faccion;
	}
	//To String 
	@Override
	public String toString() {
		return "Cartas [id=" + id + ", tipo=" + tipo + ", nombre_carta=" + nombre_carta + ", coste_invocacion="
				+ coste_invocacion + ", ataque=" + ataque + ", vida=" + vida + ", habilidad_especial="
				+ habilidad_especial + ", faccion=" + faccion + "]";
	}
    
    
}
