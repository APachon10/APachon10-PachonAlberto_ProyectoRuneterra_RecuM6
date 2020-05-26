package Querys;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login {
	public boolean verificarnombredeUsuario(MongoDatabase db,String username) {
		MongoCollection<Document> tabla_usuarios = db.getCollection("Users");
		FindIterable<Document> docs = tabla_usuarios.find();
		
		Iterator<Document> iterator_user = null;
		Document doc_user = new Document();
		boolean existe=false;
		
		try {
			// Le decimso al programa lo que tiene que buscar 
			doc_user.append("username", username);
			iterator_user = tabla_usuarios.find(doc_user).iterator();
			
			if(iterator_user.hasNext()) {
				existe=true;
			}else {
				existe=false;
			}
		} catch (Exception e) {
			System.out.println("ERROR!");
			System.out.println("======================");
			e.printStackTrace();
		}
		return existe;
		

	}
	public boolean verificarPassword(MongoDatabase db ,String password) {
		MongoCollection<Document> tabla_usuarios = db.getCollection("Users");
		FindIterable<Document> docs = tabla_usuarios.find();
		
		Iterator<Document> iterator_user = null;
		Document doc_user = new Document();
		boolean existe=false;
		
		try {
			// Le decimso al programa lo que tiene que buscar 
			doc_user.append("password", password);
			iterator_user = tabla_usuarios.find(doc_user).iterator();
			
			if(iterator_user.hasNext()) {
				existe=true;
			}else {
				existe=false;
			}
		} catch (Exception e) {
			System.out.println("ERROR!");
			System.out.println("======================");
			e.printStackTrace();
		}
		return existe;
	}
}