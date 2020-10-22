package BaseDatos;

import java.io.*;

import gestorAplicacion.finanzas.Factura;
import gestorAplicacion.productos.Abarrote;
import gestorAplicacion.productos.Aseo;
import gestorAplicacion.productos.Juguete;
import gestorAplicacion.productos.Producto;

public class Writer {
	static File PATH = new File("");
	static ObjectOutputStream outputs;

	public static void Write() {

		try {// Facturas

			outputs = new ObjectOutputStream(
					new FileOutputStream(PATH.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Factura.txt"));
			for (int i = 0; i < Factura.facturas.size(); i++) {
				outputs.writeObject(Factura.facturas.get(i));
			}
			outputs.close();

			// Aseo

			outputs = new ObjectOutputStream(
					new FileOutputStream(PATH.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Aseo.txt"));
			for (int i = 0; i < Aseo.productosAseo.size(); i++) {
				outputs.writeObject(Aseo.productosAseo.get(i));
			}
			outputs.close();

			// Abarrotes

			outputs = new ObjectOutputStream(
					new FileOutputStream(PATH.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Abarrote.txt"));
			for (int i = 0; i < Abarrote.productosAbarrotes.size(); i++) {
				outputs.writeObject(Abarrote.productosAbarrotes.get(i));
			}
			outputs.close();

			// Juguete

			outputs = new ObjectOutputStream(
					new FileOutputStream(PATH.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Juguete.txt"));
			for (int i = 0; i < Juguete.productosJuguetes.size(); i++) {
				outputs.writeObject(Juguete.productosJuguetes.get(i));
			}
			outputs.close();
		} catch (IOException error) {
			error.printStackTrace();
		}

	}

}
