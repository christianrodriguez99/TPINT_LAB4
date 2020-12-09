package negocio;

public interface TransferenciasNegocio {
	public int verificarCbu(int cbu);
	public void generarTransferencia(int cbu, int importe, int nroCuenta);
}
