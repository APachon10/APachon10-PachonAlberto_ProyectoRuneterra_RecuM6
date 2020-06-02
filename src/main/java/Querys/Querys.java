package Querys;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

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
	public ArrayList<Usuarios> mostrarUsers(MongoDatabase db){
		MongoCollection<Document> usuario = db.getCollection("Users");
		FindIterable<Document> docs = usuario.find();
		
		ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		Document doc_user = new Document();
		
		for (Document document : docs) {
			Usuarios g = new Usuarios();
			//System.out.println("id: "+document.get("id")+" - "+",username: "+document.get("username")+" - "+", cartas_compradas: "+document.get("cartas_compradas")+", barajas_usuario :"+document.get("barajas"));
		
			g.setId((Integer.parseInt (document.get("id").toString()) ));
			g.setUsername((String)document.get("username"));
			g.setCartas_compradas((ArrayList<Integer>) document.get("cartas_compradas"));
			g.setBarajas((ArrayList<Integer>) document.get("barajas"));
			
			lista.add(g);
		}
		return lista;
	}
	public ArrayList<Cartas> mostrarCartas(MongoDatabase db,ArrayList<Cartas> cartas,Cartas c) {
		MongoCollection<Document> cartas_compradas = db.getCollection("Cards");
		FindIterable<Document> docs = cartas_compradas.find();
		
		Iterator<Document> iterator_user = null;
		Document doc_user = new Document();
		
		for (Document document : docs) {
			c= new Cartas();
			
			c.setId(Integer.parseInt(document.get("id").toString()));
			c.setTipo((String) document.get("tipo"));
			c.setNombre_carta((String) document.get("nombre_carta"));
			c.setCoste_invocacion(Integer.parseInt(document.get("coste_invocacion").toString()));
			c.setAtaque(Integer.parseInt(document.get("ataque").toString()));
			c.setVida(Integer.parseInt(document.get("vida").toString()));
			c.setHabilidad_especial((String) document.get("habilidad_especial"));
			c.setFaccion((String) document.get("faccion"));
			
			cartas.add(c);
		}
		return cartas;
	}
	public ArrayList<Barajas> mostrarBarajas(MongoDatabase db,ArrayList<Barajas> decks,Barajas d) {
		MongoCollection<Document> decks2 = db.getCollection("Decks");
		FindIterable<Document> docs = decks2.find();
		
		Iterator<Document> iterator_user = null;
		Document doc_user = new Document();
		
		for (Document document : docs) {
			d= new Barajas();
			
			d.setBaraja_id(Integer.parseInt(document.get("baraja_id").toString()));
			d.setNombre_baraja((String)document.get("nombre_baraja"));
			d.setValor_baraja(Integer.parseInt(document.get("valor_baraja").toString()));
			d.setCartas_baraja((ArrayList<Integer>) document.get("cartas_barajas"));
			
			decks.add(d);
		}
		return decks;
	}
	
	/**/
	
	public void mostrarUser(MongoDatabase db,ArrayList<Usuarios> lista_usuarios,String username) {
		lista_usuarios = mostrarUsers(db);
		for (int i = 0; i < lista_usuarios.size(); i++) {
			if(lista_usuarios.get(i).getUsername().equalsIgnoreCase(username)) {
				System.out.println(lista_usuarios.get(i));
			}
		}
	}
	public ArrayList<Integer> obteneridBarajas(MongoDatabase db,ArrayList<Integer> barajas_id,String username) {
		MongoCollection<Document> usuarios = db.getCollection("Users");
		FindIterable<Document> docs = usuarios.find();
		
		ArrayList<Usuarios> lista_usuarios2 = mostrarUsers(db);
		
		for (int i = 0; i < lista_usuarios2.size(); i++) {
			if(lista_usuarios2.get(i).getUsername().equalsIgnoreCase(username)) {
				barajas_id = lista_usuarios2.get(i).getBarajas();
			}
		}
		return barajas_id;
	}
	public ArrayList<Integer> obtenerCartascompradas_por_user(MongoDatabase db,ArrayList<Integer> cartas_compradas,String username){
		MongoCollection<Document> usuarios = db.getCollection("Users");
		FindIterable<Document> docs = usuarios.find();
		
		ArrayList<Usuarios> lista_usuarios2 = mostrarUsers(db);
		
		for (int i = 0; i < lista_usuarios2.size(); i++) {
			if(lista_usuarios2.get(i).getUsername().equalsIgnoreCase(username)) {
				cartas_compradas = lista_usuarios2.get(i).getCartas_compradas();
			}
		}
		return cartas_compradas;
	}
	public ArrayList<Integer> mostrarCartasCompradas_por_user(MongoDatabase db,String username) {
		ArrayList<Integer> cartas_compradas = new ArrayList<Integer>();
		cartas_compradas = obtenerCartascompradas_por_user(db,cartas_compradas,username);
		
		for (int i = 0; i < cartas_compradas.size(); i++) {
			System.out.println(cartas_compradas.get(i));
		}
		return cartas_compradas;
	}
	
	// Querys relacionadas con la tabla Cartas
	public void comprarCartas(MongoDatabase db,String username){
		MongoCollection<Document> usuario = db.getCollection("Users");
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> cartas_compradas = new ArrayList<Integer>();
		cartas_compradas = obtenerCartascompradas_por_user(db,cartas_compradas,username);
		boolean compra_finalizada=false;
		int carta_escogida = 0;
		ArrayList<Cartas> cartas_totales = new ArrayList<Cartas>();
		Cartas c= new Cartas();
		cartas_totales = mostrarCartas(db, cartas_totales, c);
		System.out.println("Cartas Compradas por el usuario ");
		System.out.println("===========================");
		for (int i = 0; i < cartas_compradas.size(); i++) {
			System.out.println(cartas_compradas.get(i));
		}System.out.println("===========================");
		
		do {
			System.out.println("Que carta quieres comprar? ");
			System.out.println("Cartas Disponibles");
			System.out.println("===========================");
			for (int i = 0; i < cartas_totales.size(); i++) {
				System.out.println(cartas_totales.get(i));
			}
			System.out.println("===========================");
			System.out.print("carta_Escogida: ");
			carta_escogida = scanner.nextInt();
			if (carta_escogida <= 0) {
				compra_finalizada=true;
			}else {
				for (int i = 0; i < cartas_totales.size(); i++) {
					if(!cartas_totales.contains(carta_escogida)) {
						for (int j = 0; j < cartas_compradas.size(); j++) {
							if(!cartas_compradas.contains(carta_escogida)) {
								System.out.println("Carta: "+carta_escogida + " obtenida por el usuario:" + username);
								System.out.println("=================================");
								cartas_compradas.add(carta_escogida);
								compra_finalizada = true;
							}
						}
					}
				}
				Document filtro = new Document("username", username);
				Document nuevo_documento = new Document("cartas_compradas", cartas_compradas);
				Document documento_actualizado = new Document("$set", nuevo_documento);
				
				usuario.updateOne(filtro, documento_actualizado); 
				for (int i = 0; i < cartas_compradas.size(); i++) {
					System.out.println(cartas_compradas.get(i));
				}
			}
		} while (compra_finalizada);
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
	public void cambiarNombreBaraja(MongoDatabase db,int baraja_id) {
		
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
					((Usuarios)o).setCartas_compradas((ArrayList<Integer>) object.get("cartas_compradas"));
					((Usuarios)o).setBarajas((ArrayList<Integer>) object.get("barajas"));
					
					new_doc = new Document("id", ((Usuarios) o).getId())
							.append("username", ((Usuarios) o).getUsername())
							.append("cartas_compradas",((Usuarios) o).getCartas_compradas())
							.append("barajas", ((Usuarios) o).getBarajas());
				}else if(o instanceof Barajas) {
					JSONObject object = (JSONObject) iter.next();
					((Barajas)o).setBaraja_id(Integer.parseInt(object.get("baraja_id").toString()));
					((Barajas)o).setNombre_baraja((String)object.get("nombre_baraja"));
					((Barajas)o).setValor_baraja(Integer.parseInt(object.get("valor_baraja").toString()));
					((Barajas)o).setCartas_baraja((ArrayList<Integer>) object.get("cartas_barajas"));
					
					
					new_doc = new Document("baraja_id", ((Barajas) o).getBaraja_id())
							.append("nombre_baraja", ((Barajas) o).getNombre_baraja())
							.append("cartas_baraja",((Barajas) o).getCartas_baraja())
							.append("valor_baraja",((Barajas) o).getValor_baraja());
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
