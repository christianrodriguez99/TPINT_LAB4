package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.CuentasDao;
import Models.Cuentas;
import Models.CuentasPorClientes;

public class CuentasDaoImpl implements CuentasDao{

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bd_tpintegrador";
	
	public CuentasDaoImpl()
	{
		
	}
	
	public int eliminarCuentaUsuario(int id)
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int filas=0;
		Connection cn = null;
		try
		{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			Statement st = cn.createStatement();
			String query = "delete from cuentas where nroCuenta = "+id;
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
	
	public int agregarCuenta(String query)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// String query = "Insert into tipo_usuario(id,descripcion) values ('"+usuario.getId()+"','"+usuario.getDescripcion()+"')";
		Connection cn = null;
		int filas=0;
		
		try
		{
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			filas = st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
		
	}
	
	
	public ArrayList<CuentasPorClientes> obtenerCuentasClientes( )
	{

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{	 
			e.printStackTrace();
		}
		
		ArrayList<CuentasPorClientes> lista = new ArrayList<CuentasPorClientes>();
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("select DNI, nombre, apellido, nroCuenta, descripcion, SALDO from  clientes cl\r\n" + 
					"inner join cuentas cu\r\n" + 
					"on  cl.dni = cu.DNICliente\r\n" + 
					"inner join tipocuenta TP\r\n" + 
					"ON TP.id = CU.tipoCuenta");
			
			while(rs.next()){
				
				CuentasPorClientes Seg = new CuentasPorClientes();
				Seg.setDni(rs.getInt("DNI"));
				Seg.setNombre(rs.getString("nombre"));
				Seg.setApellido(rs.getString("apellido"));
				Seg.setNumCuenta(rs.getInt("nroCuenta"));
				Seg.setTipoCuenta (rs.getString("descripcion"));
				Seg.setSaldo(rs.getDouble("SALDO"));
			//	usuarioRs.setApellido(rs.getString("apellido"));
				
				lista.add(Seg);
			}
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
		
		}
		
		return lista;
	}
	
	
	public ArrayList<Cuentas> obtenerTiposCuentas() {

		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		ArrayList<Cuentas> lista = new ArrayList<Cuentas>();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("select id, descripcion from tipocuenta ");
			
			while(rs.next()){
				
				Cuentas Seg = new Cuentas();
				
				Seg.setId(rs.getInt("id"));
				Seg.setDescripcion(rs.getString("descripcion"));
			 
			//	usuarioRs.setApellido(rs.getString("apellido"));
				
				lista.add(Seg);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return lista;
	}
	

	public ArrayList<CuentasPorClientes> obtenerDNIClientes() 
	{
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	} 
	catch (ClassNotFoundException e) 
	{	 
		e.printStackTrace();
	}
	ArrayList<CuentasPorClientes> lista = new ArrayList<CuentasPorClientes>();
	Connection conn = null;
	try{
		conn = DriverManager.getConnection(host + dbName, user, pass);
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("select clientes.dni, usuarios.tipoUsuario from clientes inner join usuarios on clientes.dni = usuarios.dni where usuarios.tipoUsuario = 2");
		
		while(rs.next()){
			
			CuentasPorClientes Seg = new CuentasPorClientes();
			
			Seg.setDni(rs.getInt("DNI"));
			
			
			
			
		//	usuarioRs.setApellido(rs.getString("apellido"));
			
			lista.add(Seg);
		}
		conn.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}finally
	{
	
	}
		return lista;
	}
	
	public ArrayList<CuentasPorClientes> obtenerCuentasxCliente(int dni)
	{

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{	 
			e.printStackTrace();
		}
		
		ArrayList<CuentasPorClientes> lista = new ArrayList<CuentasPorClientes>();
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("select cuentas.nroCuenta, cuentas.fechaCreacion, cuentas.cbu, cuentas.saldo, tipocuenta.descripcion from cuentas inner join tipocuenta on cuentas.tipoCuenta = tipocuenta.id where cuentas.dniCliente ="+dni);
			
			while(rs.next()){
				
				CuentasPorClientes Seg = new CuentasPorClientes();
				Seg.setNumCuenta(rs.getInt("cuentas.nroCuenta"));
				Seg.setTipoCuenta(rs.getString("tipocuenta.descripcion"));
				Seg.setSaldo(rs.getDouble("cuentas.saldo"));
				Seg.setTipoCuenta(rs.getString("tipocuenta.descripcion"));
				Seg.setFechaCreacion(rs.getDate("cuentas.fechaCreacion"));
				Seg.setCbu(rs.getInt("cuentas.cbu"));
				
				
				
				lista.add(Seg);
			}
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
		
		}
		
		return lista;
	}
	

	
	public int obtenerCantidadCuentas(int dni) {

		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
	    int contador = 0;
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("select * from cuentas where dniCliente="+dni);
			
			while(rs.next()){
				
				contador++;
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return contador;
	}
	
	public int modificarCuentaPrestamoAceptado(int idPrestamo)
	{
		
		String query = "update cuentas inner join prestamos on cuentas.nroCuenta = prestamos.nroCuenta set cuentas.saldo = (cuentas.saldo + prestamos.importePedido) where prestamos.id ="+idPrestamo;
			int filas=0;
			Connection cn = null;
		
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn = DriverManager.getConnection(host+dbName, user,pass);
				
				Statement st = cn.createStatement();
				filas=st.executeUpdate(query);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return filas;
	}
	
	public int obtenerSaldoCuentaPornroCuenta(int nroCuenta)
	{
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{	 
			e.printStackTrace();
		}
		
		int saldo = 0;
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			String query = "Select saldo from cuentas where nroCuenta="+nroCuenta;
			ResultSet rs = st.executeQuery(query);
			rs.next();
			saldo = (rs.getInt("saldo"));
					
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
		
		}
		
		return saldo;
	}
	
	public void pagarPrestamo(int nroCuenta,int importeTotal) {
		
		String query = "Update cuentas set saldo = saldo-"+importeTotal+" where nroCuenta="+nroCuenta;

		Connection cn = null;
					
		try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn = DriverManager.getConnection(host+dbName, user,pass);
					
				Statement st = cn.createStatement();
				st.executeUpdate(query);
				
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}
	
	

}
