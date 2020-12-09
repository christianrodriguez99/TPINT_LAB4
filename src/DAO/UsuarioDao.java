package DAO;

import Models.Usuario;

public interface UsuarioDao {
	
	public int agregarUsuario(Usuario usuario);
	public Usuario obtenerUsuario(int dni);
	public boolean verificarUsuario(int dni, String clave);

}
