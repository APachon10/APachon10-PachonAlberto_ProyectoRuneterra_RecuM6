package Querys;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import Modelos.Barajas;
import Modelos.Cartas;
import Modelos.Usuarios;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

public class Querys {
	
	// Querys relacionadas con la tabla Cartas
	public ArrayList mostrarCartasCompradas_por_user(MongoDatabase db) {
		MongoCollection<Document> tabla_usuarios = db.getCollection("Users");
		FindIterable<Document> docs = tabla_usuarios.find();
		
		ArrayList cartas_compradas = new ArrayList();
		
		Iterator<Document> iterator_user = null;
		Document doc_user = new Document();
		try {
			
		} catch (Exception e) {
			System.out.println("ERROR!");
			System.out.println("======================");
			e.printStackTrace();
		}
		return cartas_compradas;
	}
	public void mostrarCartas(MongoDatabase db) {
		MongoCollection<Document> cartas_compradas = db.getCollection("Cards");
		FindIterable<Document> docs = cartas_compradas.find();
		
		Iterator<Document> iterator_user = null;
		Document doc_user = new Document();
		
		for (Document document : docs) {
			
		}
	}
	public void comprarCartas(MongoDatabase db){
		
	}
	// Querys relacionadas con la tabla Barajas
	public void mostrarBarajas(MongoDatabase db) {
		MongoCollection<Document> barajas_usuario = db.getCollection("Decks");
		FindIterable<Document> docs = barajas_usuario.find();
		
		Iterator<Document> iterator_user = null;
		Document doc_user = new Document();
		
		for (Document document : docs) {
			System.out.println("id: "+document.get("baraja_id")+" - "
					+", nombre: "+document.get("nombre_baraja")+" - "
					+", valor: "+document.get("valor_baraja")
					+", cartas_baraja: "+document.get("cartas_barajas"));
		}
	}
	public void modificarBaraja() {
		
	}
	public void cambiarNombreBaraja() {
		
	}
	public void cargarBaraja_por_Defecto() {
		
	}
	//Metodo para dropear las tablas 
	public void dropeartablas(MongoDatabase db) {
		MongoCollection<Document> collection_card = db.getCollection("Cards");
		MongoCollection<Document> collection_user = db.getCollection("Users");
		MongoCollection<Document> collection_deck = db.getCollection("Decks");
		
		
		collection_card.drop();
		collection_user.drop();
		collection_deck.drop();
		
	}
	//Metodo para cargar las tablas 
	public void cargarTablaCartas(MongoDatabase db) {
		MongoCollection<Document> collection_cards = db.getCollection("Cards");
		File f = new File("../PachonAlberto_ProyectoRuneTerra/Cartas.json");
		Object o = new Cartas();
		leerFicheroJson(f,collection_cards,o);
	}
	public void cargarTablaUsers(MongoDatabase db) {
		
		MongoCollection<Document> collection_users = db.getCollection("Users");
		File f = new File("../PachonAlberto_ProyectoRuneTerra/Usuarios.json");
		Object o = new Usuarios();
		leerFicheroJson(f,collection_users,o);
	}
	public void cargarTablaBarajas(MongoDatabase db) {
		MongoCollection<Document> collection_decks = db.getCollection("Decks");
		File f = new File("../PachonAlberto_ProyectoRuneTerra/Barajas.json");
		Object o = new Barajas();
		leerFicheroJson(f,collection_decks,o);
	}
	//Metodo para leer ficheros json
	public void leerFicheroJson(File fjson,MongoCollection<Document> nueva_coleccion,Object o) {
		JSONParser parser = new JSONParser();
		Document new_doc = null;
		try {
			//Leemos el Fichero 
			FileReader fr = new FileReader(fjson);
			/*Usamos un JSONArray porque el archivo tiene esta estructura -->  
			[
			 {},
			 {}
			]*/
			
			JSONArray lista_elementos = (JSONArray) parser.parse(fr);
			// Usamos el simbolo de exclamacion para indicar que el contenido del iterator deriva de la clase Object
			Iterator<?> iter = lista_elementos.iterator();
			
			while (iter.hasNext()) {
				// Hacemos una accion u otra en base a la clase que le pasamos al metodo.
				if(o instanceof Cartas) {
					JSONObject object = (JSONObject) iter.next();
					
					((Cartas) o).setId(Integer.parseInt(object.get("id").toString()));
					((Cartas) o).setTipo((String) object.get("tipo"));
					((Cartas) o).setNombre_carta((String) object.get("nombre_carta"));
					((Cartas) o).setCoste_invocacion(Integer.parseInt(object.get("coste_invocacion").toString()));
					((Cartas) o).setAtaque(Integer.parseInt(object.get("ataque").toString()));
					((Cartas) o).setVida(Integer.parseInt(object.get("vida").toString()));
					((Cartas) o).setHabilidad_especial((String) object.get("habilidad_especial"));
					((Cartas) o).setFaccion((String) object.get("faccion"));

					new_doc = new Document("id", ((Cartas) o).getId())
							.append("tipo", ((Cartas) o).getTipo())
							.append("nombre_carta",((Cartas) o).getNombre_carta())
							.append("coste_invocacion",((Cartas) o).getCoste_invocacion())
							.append("ataque", ((Cartas) o).getAtaque())
							.append("vida", ((Cartas) o).getVida())
							.append("habilidad_especial", ((Cartas) o).getHabilidad_especial())
							.append("faccion", ((Cartas) o).getFaccion());
				}else if(o instanceof Usuarios) {
					JSONObject object = (JSONObject) iter.next();
					
					((Usuarios)o).setId(Integer.parseInt(object.get("id").toString()));
					((Usuarios)o).setUsername((String)object.get("username"));
					((Usuarios)o).setPassword((String)object.get("password"));
					((Usuarios)o).setCartas_compradas((ArrayList<Integer>) object.get("cartas_compradas"));
					((Usuarios)o).setBarajas((ArrayList<Integer>) object.get("barajas"));
					
					new_doc = new Document("id", ((Usuarios) o).getId())
							.append("username", ((Usuarios) o).getUsername())
							.append("Password",((Usuarios) o).getPassword())
							.append("cartas_compradas",((Usuarios) o).getCartas_compradas())
							.append("barajas", ((Usuarios) o).getBarajas());
				}else if(o instanceof Barajas) {
					JSONObject object = (JSONObject) iter.next();
					((Barajas)o).setBaraja_id(Integer.parseInt(object.get("baraja_id").toString()));
					((Barajas)o).setNombre_baraja((String)object.get("nombre_baraja"));
					((Barajas)o).setValor_baraja(Integer.parseInt(object.get("valor_baraja").toString()));
					((Barajas)o).setCartas_baraja((ArrayList<Integer>) object.get("cartas_baraja"));
					
					new_doc = new Document("id", ((Barajas) o).getBaraja_id())
							.append("nombre baraja", ((Barajas) o).getNombre_baraja())
							.append("Valor",((Barajas) o).getValor_baraja())
							.append("Cartas Baraja",((Barajas) o).getCartas_baraja());
				}
				nueva_coleccion.insertOne(new_doc);
			}
			
			
		} catch (Exception e) {
			System.out.println("ERROR!");
			System.out.println("======================");
			e.printStackTrace();
		}
	}
}
