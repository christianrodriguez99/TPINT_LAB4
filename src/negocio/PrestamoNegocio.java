package negocio;

import java.util.ArrayList;

import Models.Prestamos;

public interface PrestamoNegocio {
	public int agregarPrestamo(Prestamos prestamo);
	public ArrayList<Prestamos> obtenerPrestamos();
	public ArrayList<Prestamos> obtenerTodosLosPrestamos();
	public ArrayList<Prestamos> obtenerTodosLosPrestamosPorEstado(String estado);
	public int modificarEstadoAceptado(int id, String estado);
	public int crearTablaCuotas(Prestamos prestamo);
	public void pagarPrestamo(int idPrestamo,int importeTotal, int cuotas);
	public int obtenerValorCuota(int idPrestamo, int cantidadCuotas);
	public int obtenerCuotasRestantes(int idPrestamo);
}
