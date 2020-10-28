/*
 * En esta Clase basicamente se leen todos los archivos .txt correspondiente a la base de datos de nuestro programa
 */

package BaseDatos;

import java.io.*;
import java.util.*;

import gestorAplicacion.finanzas.Factura;
import gestorAplicacion.productos.Abarrote;
import gestorAplicacion.productos.Aseo;
import gestorAplicacion.productos.Juguete;

public class Reader {
	static Object object;
	static File PATH = new File("");
	private static ObjectInputStream inputs;

	//Este es el metodo principal que leera todos los archivos .txt correspondientes a nuestra base de datos
	public static void Read() {
		try {

			inputs = new ObjectInputStream(
					new FileInputStream(PATH.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Abarrote.txt"));
			object = inputs.readObject();

			while (object != null) {
				Abarrote.productosAbarrotes.add((Abarrote) object);
				object = inputs.readObject();
			}

			inputs.close();

			inputs = new ObjectInputStream(
					new FileInputStream(PATH.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Aseo.txt"));
			object = inputs.readObject();

			while (object != null) {
				Aseo.productosAseo.add((Aseo) object);
				object = inputs.readObject();
			}

			inputs.close();

			inputs = new ObjectInputStream(
					new FileInputStream(PATH.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Factura.txt"));
			object = inputs.readObject();

			while (object != null) {
				Factura.facturas.add((Factura) object);
				object = inputs.readObject();
			}

			inputs.close();

			inputs = new ObjectInputStream(
					new FileInputStream(PATH.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Juguete.txt"));
			object = inputs.readObject();

			while (object != null) {
				Juguete.productosJuguetes.add((Juguete) object);
				object = inputs.readObject();
			}

			inputs.close();

		} catch (IOException error) {
			System.out.println("Error flujo de inicializacion " + error);
		} catch (ClassNotFoundException error) {
			error.printStackTrace();
		}
	}
}
