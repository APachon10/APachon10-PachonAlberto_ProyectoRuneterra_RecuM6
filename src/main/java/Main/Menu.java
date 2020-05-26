package Main;

import java.util.Scanner;

import com.mongodb.client.MongoDatabase;

import Querys.Login;

public class Menu {	
	 public void menu(MongoDatabase db) {
		 Scanner scanner = new Scanner(System.in); 
		 int opcion = 0;
		 do {
			System.out.println("Que quieres hacer? "
					+ "\n1 - Login "
					+ ""
					+ ""
					+ ""
					+ "\n0 - Salir ");
			System.out.print("opcion:");
			opcion = scanner.nextInt();
			
			switch (opcion) {
			case 1:
				boolean existe_user=false,password_correct =false;
				System.out.println("=================");
				
				// Pedimos las credenciales al usuario 
				System.out.print("Username: ");
				String username = scanner.next();
				System.out.println("=================");
				System.out.print("Password:");
				String password = scanner.next();
				System.out.println("====================");
				
				Login g= new Login();
				existe_user= g.verificarnombredeUsuario(db, username);
				System.out.println("====================");
				password_correct = g.verificarPassword(db, password);
				
				// Verificamos los datos y entramos en caso de que los datos sean correctos 
				if(existe_user == true && password_correct == true) {
					Scanner scan2 =  new Scanner(System.in);
					int opcion2 = 0;
					do {
						System.out.println("Que quieres hacer  " + username + " ? "
								+ "\n 1 - Crear Baraja"
								+ "\n 2 - Modificar Baraja"
								+ "\n 3 - Importar Mazo por Defecto"
								+ "\n 4 - Comprar Cartas");
						System.out.println("======================");
						System.out.print("Opcion:");
						opcion2 = scan2.nextInt();
						
						switch(opcion2) {
							case 1:
								break;
						}
					} while (opcion2!=0);
				}else {
					System.out.println("Login Incorrecto vuelve a intentarlo ");
				}
				break;
			case 0:
				System.out.println("Programa Terminado");
				break;
			}
		} while (opcion!=0);
	 }
}