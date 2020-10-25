package gestorAplicacion.finanzas;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private int edad;
	private int nivel_afiliacion;
	private String metodo_pago;
	private List<Factura> facturas = new ArrayList<Factura> ();
	public List<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getNivel_afiliacion() {
		return nivel_afiliacion;
	}
	public void setNivel_afiliacion(int nivel_afiliacion) {
		this.nivel_afiliacion = nivel_afiliacion;
	}
	public String getMetodo_pago() {
		return metodo_pago;
	}
	public void setMetodo_pago(String metodo_pago) {
		this.metodo_pago = metodo_pago;
	}
	
}
