package Querys;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

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
	public void cargarTablaCartas() {
		JSONParser parser = new JSONParser();
		File f = new File("../PachonAlberto_ProyectoRuneTerra/Cartas.json");
		
	}
	public void cargarTablaUsers() {
		JSONParser parser = new JSONParser();
		File f = new File("..PachonAlberto_ProyectoRuneTerra/Usuarios.json");
	}
	public void cargarTablaBarajas() {
		JSONParser parser = new JSONParser();
		File f = new File("../PachonAlberto_ProyectoRuneTerra/Barajas.json");
	}
}
