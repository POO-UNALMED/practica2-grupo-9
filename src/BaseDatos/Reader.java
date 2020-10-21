package BaseDatos;
import java.io.*;

import gestorAplicacion.finanzas.Factura;
import gestorAplicacion.productos.Abarrote;
import gestorAplicacion.productos.Aseo;
import gestorAplicacion.productos.Juguete;

public class Reader {
	static Object object;
	static File PATH = new File("");
	private static ObjectInputStream inputs;
	
	
	public static void Read() {
		try {
			//Lectura de los objetos de la clase Factura
			inputs = new ObjectInputStream(new FileInputStream(PATH.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Factura.txt"));
			object = inputs.readObject();
			
			try {
				while (object != null) {
					Factura.facturas.add((Factura) object);
					object = inputs.readObject();
				}
			} catch(EOFException error) { error.printStackTrace(); }
			inputs.close();
			
			//Lectura de los objetos de la clase Aseo
			inputs = new ObjectInputStream(new FileInputStream(PATH.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Aseo.txt"));
			object = inputs.readObject();
			
			try {
				while (object != null) {
					Aseo.productosAseo.add((Aseo) object);
					object = inputs.readObject();
				}
			} catch(EOFException error) { error.printStackTrace(); }
			inputs.close();
			
			//Lectura de los objetos de la clase Abarrote
			inputs = new ObjectInputStream(new FileInputStream(PATH.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Abarrote.txt"));
			object = inputs.readObject();
			
			try {
				while (object != null) {
					Abarrote.productosAbarrotes.add((Abarrote) object);
					object = inputs.readObject();
				}
			} catch(EOFException error) { error.printStackTrace(); }
			inputs.close();
			
			//Lectura de los objetos de la clase Juguete
			inputs = new ObjectInputStream(new FileInputStream(PATH.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Juguete.txt"));
			object = inputs.readObject();
			
			try {
				while (object != null) {
					Juguete.productosJuguetes.add((Juguete) object);
					object = inputs.readObject();
				}
			} catch(EOFException error) { error.printStackTrace(); }
			inputs.close();
			
			
			
		} catch(IOException error) {
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
