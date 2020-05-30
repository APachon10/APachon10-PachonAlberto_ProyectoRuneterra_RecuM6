package Main;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import Conexion.GestionarConexion;
import Querys.Login;

public class Principal {
	public static void main(String[] args) {
		try {
			desactivar_Log();
			
			GestionarConexion c = new GestionarConexion();
			Login l = new Login();
			MongoClient cliente = c.abrirConexionAtlas();
			String db_name = "RuneTerra";
			MongoDatabase db = c.obtenerBasedeDatos(cliente, db_name);
			Menu m = new Menu();
			m.menu(db);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void desactivar_Log() {
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);
		mongoLogger.getLogger("org.mongodb.driver.connection").setLevel(Level.OFF);
		mongoLogger.getLogger("org.mongodb.driver.management").setLevel(Level.OFF);
		mongoLogger.getLogger("org.mongodb.driver.cluster").setLevel(Level.OFF);
		mongoLogger.getLogger("org.mongodb.driver.protocol.insert").setLevel(Level.OFF);
		mongoLogger.getLogger("org.mongodb.driver.protocol.query").setLevel(Level.OFF);
		mongoLogger.getLogger("org.mongodb.driver.protocol.update").setLevel(Level.OFF);
	}
}
