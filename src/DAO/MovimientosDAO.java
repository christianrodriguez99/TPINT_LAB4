package DAO;

import java.util.ArrayList;

import Models.Movimientos;

public interface MovimientosDAO {
	public void agregarMovimientoPagos(Movimientos movimiento);
	public ArrayList<Movimientos> obtenerMovimientos(int dni);
}
