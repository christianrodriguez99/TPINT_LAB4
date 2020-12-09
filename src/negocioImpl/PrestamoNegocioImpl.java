package negocioImpl;

import java.util.ArrayList;



import Models.Prestamos;
import daoImpl.PrestamosDaoImpl;


public class PrestamoNegocioImpl {

	public int agregarPrestamo(Prestamos prestamo)
	{
		PrestamosDaoImpl prestamoDao = new PrestamosDaoImpl();
		int registroExitoso = prestamoDao.agregarPrestamo(prestamo);
		return registroExitoso;
	}
	public ArrayList<Prestamos> obtenerPrestamos()
	{
		ArrayList<Prestamos> prestamos = new ArrayList<Prestamos>();	
		return prestamos;
	}
	public ArrayList<Prestamos> obtenerTodosLosPrestamos()
	{
		ArrayList<Prestamos> prestamos = new ArrayList<Prestamos>();	
		return prestamos;
	}
	
	public ArrayList<Prestamos> obtenerTodosLosPrestamosPorEstado(String estado)
	{
		ArrayList<Prestamos> prestamos = new ArrayList<Prestamos>();	
		return prestamos;
	}
	public int modificarEstadoAceptado(int id, String estado)
	{
		int a = 0;
		return a;
	}
	public int crearTablaCuotas(Prestamos prestamo) {
		PrestamosDaoImpl prestamoDao = new PrestamosDaoImpl();
		int registroExitoso = prestamoDao.crearTablaCuotas(prestamo);
		return registroExitoso;
	}
	public void pagarPrestamo(int idPrestamo,int importeTotal, int cuotas)
	{
		
	}
	
	public int obtenerValorCuota(int idPrestamo, int cantidadCuotas) {
		int a = 0;
		return a;
	}
	public int obtenerCuotasRestantes(int idPrestamo)
	{
		int a = 0;
		return a;
	}
}
