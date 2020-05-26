package Modelos;

public class Usuarios {
	private int id;
	private String username;
	private String password;
	
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
	
	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
}
