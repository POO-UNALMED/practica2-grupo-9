package gestorAplicacion.productos;
import java.util.*;

public class Juguete extends Producto implements Instructivo {
	private String material;
	private Date fechaSalida;
	private int garantia;
	private static ArrayList<Juguete> productosJuguetes;
	
	public Juguete(int codigo,String nombre,int inventario,float precio,
			float inversion,String categoria,
			String tipo,String material,Date fechaSalida, int garantia) {
		this.setCodigo(codigo);
		this.setNombre(nombre);
		this.setInventario(inventario);
		this.setPrecio(precio);
		this.setInversion(inversion);
		this.setGananciaNeta(precio - inversion);
		this.setCategoria(categoria);
		this.setTipo(tipo);
		this.setMaterial(material);
		this.setFechaSalida(fechaSalida);
		this.setGarantia(garantia);
		productosJuguetes.add(this);
	}

	@Override
	public float ganancia() {
		return this.getGananciaNeta();
	}
	@Override
	public float inversion() {
		return this.getInversion();
	}

	@Override
	public String instrucciones() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getGarantia() {
		return garantia;
	}

	public void setGarantia(int garantia) {
		this.garantia = garantia;
	}

}
