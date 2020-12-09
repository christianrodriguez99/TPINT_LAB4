package negocio;

import Models.Usuario;

public interface UsuarioNegocio {
	
	public int agregarUsuario(Usuario usuario);
	public Usuario obtenerUsuario(int dni);
	public boolean verificarUsuario(int dni, String clave);
}
