package negocioImpl;

import java.util.List;

import Models.Cliente;
import daoImpl.ClienteDaoImpl;
import negocio.ClienteNegocio;

public class ClienteNegocioImpl implements ClienteNegocio {

	@Override
	public boolean Insert(Cliente cliente) {
		
		ClienteDaoImpl clienteDao = new ClienteDaoImpl();
		boolean registroExitoso = clienteDao.Insert(cliente);
		return registroExitoso;
	}

	@Override
	public boolean Delete(Cliente cliente_a_eliminar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cliente> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
