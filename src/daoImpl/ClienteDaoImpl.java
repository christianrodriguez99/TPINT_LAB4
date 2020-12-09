package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import DAO.ClienteDAO;
import Models.Cliente;
import Models.Usuario;

public class ClienteDaoImpl implements ClienteDAO 
{
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bd_tpintegrador";
	
	public boolean Insert (Cliente cliente) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "Insert into clientes(DNI,cuil,nombre,apellido,email,sexo,nacionalidad,fechaNacimiento,direccion,localidad,provincia,activo) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		Connection cn = null;
				
		try
		{
			cn = DriverManager.getConnection(host+dbName,user,pass);
			 PreparedStatement preparedStmt = cn.prepareStatement(query);
		      preparedStmt.setInt (1, cliente.getDni());
		      preparedStmt.setInt (2, cliente.getCuil());
		      preparedStmt.setString   (3, cliente.getNombre());
		      preparedStmt.setString   (4, cliente.getApellido());
		      preparedStmt.setString   (5, cliente.getMail());
		      preparedStmt.setString   (6, cliente.getSexo());
		      preparedStmt.setString   (7, cliente.getNacionalidad());
		      preparedStmt.setDate   (8, (Date) cliente.getFechaNac());
		      preparedStmt.setString   (9, cliente.getDireccion());
		      preparedStmt.setString   (10, cliente.getLocalidad());
		      preparedStmt.setString   (11, cliente.getProvincia());
		      preparedStmt.setBoolean   (12, true);		
		      preparedStmt.execute();		      
		      return true;		      
		     
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public Cliente obtenerCliente(int dni)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cliente x = new Cliente();
		Connection cn = null;
		try
		{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			Statement st = cn.createStatement();
			String query = "Select * from clientes where dni="+dni;
			ResultSet rs = st.executeQuery(query);
			rs.next();
			x.setNombre(rs.getString("nombre"));
			x.setApellido(rs.getString("apellido"));
			x.setCuil(rs.getInt("cuil"));
			x.setMail(rs.getString("email"));
			x.setFechaNac(rs.getDate("fechaNacimiento"));
			x.setDireccion(rs.getString("direccion"));
			x.setLocalidad(rs.getString("localidad"));
			x.setProvincia(rs.getString("provincia"));
			x.setNacionalidad(rs.getString("nacionalidad"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}
}
