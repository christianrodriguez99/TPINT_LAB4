package negocioImpl;

import java.util.ArrayList;

import Models.Cuentas;
import Models.CuentasPorClientes;
import negocio.CuentasNegocio;

public class CuentasNegocioImpl implements CuentasNegocio {

	public int eliminarCuentaUsuario(int id) 
	{
		return id;
		
	}
	
	public int agregarCuenta(String query)
	{
		int a = 0;
		
		return a;
	 };
	public ArrayList<CuentasPorClientes> obtenerCuentasClientes()
	{
		ArrayList<CuentasPorClientes> cuentas = new ArrayList<CuentasPorClientes>();
		
		return cuentas;
		
	};
	public ArrayList<Cuentas> obtenerTiposCuentas()
	{
		ArrayList<Cuentas> cuentas = new ArrayList<Cuentas>();
		
		return cuentas;
		
	};
	public ArrayList<CuentasPorClientes> obtenerDNIClientes()
	{
		
		ArrayList<CuentasPorClientes> cuentas = new ArrayList<CuentasPorClientes>();
		
		return cuentas;
		
	};
	
	public ArrayList<CuentasPorClientes> obtenerCuentasxCliente(int dni)
	{
		ArrayList<CuentasPorClientes> cuentas = new ArrayList<CuentasPorClientes>();
		
		return cuentas;
	}
	public int obtenerCantidadCuentas(int dni)
	{
		int a = 0;
		return a;
	}

	public int obtenerSaldoCuentaPornroCuenta(int nroCuenta)
	{
		int a = 0;
		return a;
	}
	public void pagarPrestamo(int nroCuenta,int importeTotal)
	{
		
	}
}
