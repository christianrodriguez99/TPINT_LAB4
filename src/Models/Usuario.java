package Models;

public class Usuario {
	
	private int dni;
	private String contraseña;
	private int tipoUsuario;
	//private TipoUsuario tipoUsuario;
	
	public int getDni() {
		return dni;
	}
	public void setDni(int usuario) {
		this.dni = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}
