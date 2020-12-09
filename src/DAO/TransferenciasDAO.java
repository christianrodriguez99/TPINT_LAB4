package DAO;

public interface TransferenciasDAO {
	public int verificarCbu(int cbu);
	public void generarTransferencia(int cbu, int importe, int nroCuenta);
}
