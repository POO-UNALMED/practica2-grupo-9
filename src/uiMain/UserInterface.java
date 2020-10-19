package uiMain;


import java.util.*;
public class UserInterface {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String name;
		int option;
		boolean exit = false;
		
		System.out.print(Mensajes.bienvenida());
		name = scan.next();
		
		
		while(!exit) {
			
			System.out.println(Mensajes.selInicio());
			System.out.print("Opcion: ");
			option = scan.nextInt();
			
			switch(option) {
			case 1:
				System.out.println(Mensajes.selUsuario());
				
				System.out.print("Opcion: ");
				
				option = scan.nextInt();
				
				switch(option) {
					case 1:
						System.out.println("Opcion 1.");
						break;
					
					case 2:
						System.out.println("Opcion 2");
						break;
						
					case 3:
						System.out.println("Opcion 3");
						break;
					
					default:
						break;
				}
				
				
				
				break;
			case 2:
				System.out.println("Escogiste la opcion 2.");
				break;
			case 3:
				System.out.println("Escogiste la opcion 3.");
				break;
			case 4:
				System.out.println("Adios.");
				exit = true;
				break;
			default:
				System.out.println("Opcion incorrecta. ");
			}
		}

	}
	
	
	
	//Functions
	
	public void crearProducto(int opcion) {
		
		switch(opcion) {
		case 1:
			//Aseo
			//new Aseo();
		case 2:
			//Abarrote
			//new Abarrote();
		case 3:
			//Juguete
			//new Juguete();
		}
		
	}

}





