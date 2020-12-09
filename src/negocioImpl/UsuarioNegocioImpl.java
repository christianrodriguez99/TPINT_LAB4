package negocioImpl;

import java.util.List;

import Models.Usuario;
import daoImpl.UsuarioDaoImpl;


public class UsuarioNegocioImpl {

	public int agregarUsuario(Usuario usuario) {
		
		UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
		int registroExitoso = usuarioDao.agregarUsuario(usuario);
		return registroExitoso;
	}

	public Usuario obtenerUsuario(int dni)
	{ 
		Usuario usuario = new Usuario();
		return usuario;
	}

	public boolean verificarUsuario(int dni, String clave){
		boolean resultado = false;
		return resultado;
	}
	public int obtenerSaldoCuentaPornroCuenta(int nroCuenta)
	{
		int a = 0;
		return a;
	}

}
