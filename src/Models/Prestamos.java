package Models;

import java.util.Date;

public class Prestamos {

	private int id;
	private int nroCuenta;

	private float importePedido;
	private float importeAPagar;
	private Date fecha;
	private String estado;
	public int dniCliente;
	private int cuotasRestantes;
	private int cuotasTotales;
	
	
	public int getCuotasTotales() {
		return cuotasTotales;
	}

	public void setCuotasTotales(int cuotasTotales) {
		this.cuotasTotales = cuotasTotales;
	}

	public int getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(int dniCliente) {
		this.dniCliente = dniCliente;
	}

	
	public Prestamos() {
		
	}
	
	public String getEstado() {
		return estado;
	}
	


	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNroCuenta() {
		return nroCuenta;
	}
	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	public float getImportePedido() {
		return importePedido;
	}
	public void setImportePedido(float importePedido) {
		this.importePedido = importePedido;
	}
	public float getImporteAPagar() {
		return importeAPagar;
	}
	public void setImporteAPagar(float importeAPagar) {
		this.importeAPagar = importeAPagar;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public int getCuotasRestantes() {
		return cuotasRestantes;
	}
	public void setCuotasRestantes(int cuotasRestantes) {
		this.cuotasRestantes = cuotasRestantes;
	}

	
}
