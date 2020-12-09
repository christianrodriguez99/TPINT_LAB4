package Models;

public class Cuentas {

	

	private int id;
	private String Descripcion;
	
	
	
	
	public Cuentas()
	{}

	public Cuentas(int id, String Descripcion) {
		this.id = id;
		this.Descripcion = Descripcion;
		 
	}


	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getDescripcion() {
		return Descripcion;
	}




	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	
	
}
