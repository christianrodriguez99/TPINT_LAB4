package negocio;

import java.util.ArrayList;

import Models.Movimientos;

public interface MovimientosNegocio {
	public void agregarMovimientoPagos(Movimientos movimiento);
	public ArrayList<Movimientos> obtenerMovimientos(int dni);
}
