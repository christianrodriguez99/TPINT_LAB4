package Models;

import java.util.Date;

public class Transferencias {
	
	private int id;
	private int nroCuenta;
	private int cuentaDestino;
	private double importe;
	private Date fecha;
	private int cbu;
	
	public int getCbu() {
		return cbu;
	}
	public void setCbu(int cbu) {
		this.cbu = cbu;
	}
	public Transferencias() {
		
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
	public int getCuentaDestino() {
		return cuentaDestino;
	}
	public void setCuentaDestino(int cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
