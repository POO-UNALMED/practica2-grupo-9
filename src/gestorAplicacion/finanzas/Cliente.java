/*La clase Cliente sirve para guardar la informacion del usuario que esta en nuetro programa
  de esta misma clase se podran usar los metodos de descuentos correspondiente a cada usuario
  dependiendo de su afiliacion, edad o metodo de pago.
*/



package gestorAplicacion.finanzas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Serializable {
	private int edad;
	private int nivel_afiliacion;
	private String metodo_pago;
	private List<Factura> facturas = new ArrayList<Factura>();

	//Este es el constructor que recibe como atributos "edad" y "metodo_pago" 
	//para modificarlos cuando se requiera la clase
	public Cliente(int edad, String metodo_pago) {
		this.edad = edad;
		this.nivel_afiliacion = 0;
		this.metodo_pago = metodo_pago;
	}

	//Este metodo aumenta en uno (1) el nivel de afiliacion del cliente con la tienda
	public void aumentarAfiliacion() {
		setNivel_afiliacion(getNivel_afiliacion() + 1);
	}

	//Este metodo disminuye en uno (1) el nivel de afiliacion del cliente con la tienda
	public void disminuirAfiliacion() {
		setNivel_afiliacion(getNivel_afiliacion() - 1);
	}

	//Este metodo hace valido el descuento del cliente dependiedo su nivel de afiliacion
	//si es nivel 1 tendra un descuento del 10%
	//y si es nivel 2 tendra un descuento del 20%
	public void descuentoAfiliacion() {
		if (getNivel_afiliacion() == 1) {
			((Factura) facturas).setDescuento(10);
		} else if (getNivel_afiliacion() == 2) {
			((Factura) facturas).setDescuento(20);
		}
	}

	//Metodo que sirve para agregar una factura correspondiente a un cliente
	public void agregarFactura(Factura factura) {
		facturas.add(factura);
	}

	//Este metodo hace valido el descuento del 20% para clientes mayores de 60 años
	public void descuentoEdad(int ed) {
		if (ed >= 60) {
			((Factura) facturas).setDescuento(20);
		}
	}

	//Este metodo hace valido el descuento del 20% para clientes que paguen en efectivo
	public void descuentoMetodoPago(String metodo) {
		if (metodo == "Efectivo") {
			((Factura) facturas).setDescuento(20);
		}
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	//Metodo set de factura
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	//metodo get del atributo edad
	public int getEdad() {
		return edad;
	}

	//metodo set del atributo edad
	public void setEdad(int edad) {
		this.edad = edad;
	}

	//metodo get del atributo nivel_afiliacion
	public int getNivel_afiliacion() {
		return nivel_afiliacion;
	}

	//metodo set del atributo nivel_afiliacion
	public void setNivel_afiliacion(int nivel_afiliacion) {
		this.nivel_afiliacion = nivel_afiliacion;
	}

	//metodo get del atributo metodo_pago
	public String getMetodo_pago() {
		return metodo_pago;
	}

	//metodo set del atributo metodo_pago
	public void setMetodo_pago(String metodo_pago) {
		this.metodo_pago = metodo_pago;
	}

}
