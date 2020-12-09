package negocio;

import java.util.List;

import Models.Cliente;

public interface ClienteNegocio {

	public boolean Insert(Cliente cliente);
	public boolean Delete(Cliente cliente_a_eliminar);
	public List<Cliente> readAll();
}
