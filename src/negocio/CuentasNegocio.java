package negocio;

import java.util.ArrayList;

import Models.Cuentas;
import Models.CuentasPorClientes;

public interface CuentasNegocio {

	public int eliminarCuentaUsuario(int id);
	public int agregarCuenta(String query);
	public ArrayList<CuentasPorClientes> obtenerCuentasClientes();
	public ArrayList<Cuentas> obtenerTiposCuentas();
	public ArrayList<CuentasPorClientes> obtenerDNIClientes();
	public ArrayList<CuentasPorClientes> obtenerCuentasxCliente(int dni);
	public int obtenerCantidadCuentas(int dni);
	public int obtenerSaldoCuentaPornroCuenta(int nroCuenta);
	public void pagarPrestamo(int nroCuenta,int importeTotal);
}
