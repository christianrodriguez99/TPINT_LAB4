package Models;

import java.util.Date;

public class CuentasPorClientes {

	private int dni;
	private String Nombre;
	private String Apellido;
	private int NumCuenta;
	private String TipoCuenta;
	private double Saldo;
	private int cbu;
	private Date fechaCreacion;
	
	
	
	public double getSaldo() {
		return Saldo;
	}



	public void setSaldo(double saldo) {
		Saldo = saldo;
	}



	public int getCbu() {
		return cbu;
	}



	public void setCbu(int cbu) {
		this.cbu = cbu;
	}



	public Date getFechaCreacion() {
		return fechaCreacion;
	}



	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}



	public CuentasPorClientes()
	{}



	public int getDni() {
		return dni;
	}



	public void setDni(int dni) {
		this.dni = dni;
	}



	public String getNombre() {
		return Nombre;
	}



	public void setNombre(String nombre) {
		Nombre = nombre;
	}



	public String getApellido() {
		return Apellido;
	}



	public void setApellido(String apellido) {
		Apellido = apellido;
	}



	public int getNumCuenta() {
		return NumCuenta;
	}



	public void setNumCuenta(int numCuenta) {
		NumCuenta = numCuenta;
	}



	public String getTipoCuenta() {
		return TipoCuenta;
	}



	public void setTipoCuenta(String tipoCuenta) {
		TipoCuenta = tipoCuenta;
	}



	
	
	
	
}
