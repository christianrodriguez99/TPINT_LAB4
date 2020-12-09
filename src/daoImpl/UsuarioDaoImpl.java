package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import DAO.UsuarioDao;
import Models.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bd_tpintegrador";
	
	public int agregarUsuario(Usuario usuario)
	{
		
		String query = "Insert into usuarios(dni,tipoUsuario,contraseña) values (?,?,?)";
			Connection cn = null;
		
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn = DriverManager.getConnection(host+dbName, user,pass);
				
				   PreparedStatement preparedStmt = cn.prepareStatement(query);
				      preparedStmt.setInt (1, usuario.getDni());
				      preparedStmt.setInt (2, usuario.getTipoUsuario());
				      preparedStmt.setString   (3, usuario.getContraseña());
				
				      preparedStmt.execute();				      
				      return 1;
				      
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return 0;
	}
	
	public Usuario obtenerUsuario(int dni)
	{
		
		Usuario x = new Usuario();
		Connection cn = null;
		
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(host+dbName, user,pass);
			Statement st = cn.createStatement();
			String query = "Select * from usuarios where dni="+dni;
			ResultSet rs = st.executeQuery(query);
			rs.next();
			x.setDni(rs.getInt("DNI"));
			x.setContraseña(rs.getString("contraseña"));
			x.setTipoUsuario(rs.getInt("tipoUsuario"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}
	
	public boolean verificarUsuario(int dni, String clave)
	{
		Connection cn = null;
		boolean verificacion = false;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(host+dbName, user,pass);
			  int rsdni = 0;
		      String rsclave=null;
		        
			String query = "Select * from usuarios where dni=? and contraseña=?";
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setInt(1,dni);
			pst.setString(2,clave);
			ResultSet rs = pst.executeQuery();
			
			 while(rs.next()){
			        rsdni = rs.getInt(1);
			        rsclave =rs.getString("contraseña");
			        if ((dni == rsdni) && (clave.equals(rsclave))){
			        verificacion = true;
			        return verificacion;
			        }
			        else {
			            verificacion = false;
			        } 
			 }
			        cn.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return verificacion;
	}
}

