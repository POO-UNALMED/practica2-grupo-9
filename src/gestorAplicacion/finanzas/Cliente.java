package gestorAplicacion.finanzas;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private int edad;
	private static int nivel_afiliacion;
	private String metodo_pago;
	private List<Factura> facturas = new ArrayList<Factura> ();
	
	
	public void aumentarAfiliacion() {
		setNivel_afiliacion(getNivel_afiliacion()+1);
	}
	
	public void disminuirAfiliacion() {
		setNivel_afiliacion(getNivel_afiliacion()-1);
	}
	
	public void descuentoAfiliacion() {
		if (getNivel_afiliacion()==1) {
			((Factura) facturas).setDescuento(10);
		}
		else if (Cliente.getNivel_afiliacion()==2) {
			((Factura) facturas).setDescuento(20);
		}
			
	}
	
	public void descuentoEdad(int ed) {
		if (ed >= 60) {
			((Factura) facturas).setDescuento(20);
		}
	}
	
	public void descuentoMetodoPago(String metodo) {
		if (metodo == "efectivo") {
			((Factura) facturas).setDescuento(20);
		}
	}
	
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
	public static int getNivel_afiliacion() {
		return nivel_afiliacion;
	}
	public void setNivel_afiliacion(int nivel_afiliacion) {
		Cliente.nivel_afiliacion = nivel_afiliacion;
	}
	public String getMetodo_pago() {
		return metodo_pago;
	}
	public void setMetodo_pago(String metodo_pago) {
		this.metodo_pago = metodo_pago;
	}
	
}
