package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Models.CuentasPorClientes;
import Models.Prestamos;

public class PrestamosDaoImpl {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bd_tpintegrador";
	
	public int agregarPrestamo(Prestamos prestamo)
	{
		
		String query = "Insert into prestamos(nroCuenta,dni,importePedido,importeAPagar,fecha,estado,cuotasRestantes,cuotasTotales) values (?,?,?,?,?,?,?,?)";
			int filas=0;
			Connection cn = null;
		
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn = DriverManager.getConnection(host+dbName, user,pass);
				
				   PreparedStatement preparedStmt = cn.prepareStatement(query);
				      preparedStmt.setInt (1, prestamo.getNroCuenta());
				      preparedStmt.setInt (2, prestamo.getDniCliente());
				      preparedStmt.setFloat (3, prestamo.getImportePedido());
				      preparedStmt.setFloat   (4, prestamo.getImporteAPagar());
				      preparedStmt.setDate   (5, (Date) prestamo.getFecha());
				      preparedStmt.setString   (6, prestamo.getEstado());
				      preparedStmt.setInt   (7, prestamo.getCuotasRestantes());
				      preparedStmt.setInt   (8, prestamo.getCuotasTotales());

				
				      boolean validacion = preparedStmt.execute();	
				      if(validacion==true)
				      {
				    	  filas = 1;
				      }
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return filas;
	}
	
	public ArrayList<Prestamos> obtenerPrestamos(int dni)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{	 
			e.printStackTrace();
		}
		
		ArrayList<Prestamos> lista = new ArrayList<Prestamos>();
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("select id,nroCuenta,importeAPagar,importePedido,fecha,estado,cuotasRestantes from Prestamos where dni="+dni);
			
			while(rs.next()){
				
				Prestamos Seg = new Prestamos();
				Seg.setId(rs.getInt("id"));
				Seg.setNroCuenta(rs.getInt("nroCuenta"));
				Seg.setImporteAPagar(rs.getInt("importeAPagar"));
				Seg.setImportePedido(rs.getInt("importePedido"));
				Seg.setFecha(rs.getDate("fecha"));
				Seg.setEstado(rs.getString("Estado"));
				Seg.setCuotasRestantes(rs.getInt("cuotasRestantes"));
				
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
	
	public ArrayList<Prestamos> obtenerTodosLosPrestamos()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{	 
			e.printStackTrace();
		}
		
		ArrayList<Prestamos> lista = new ArrayList<Prestamos>();
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("select id,nroCuenta,importePedido,fecha,estado,cuotasRestantes from Prestamos");
			
			while(rs.next()){
				
				Prestamos Seg = new Prestamos();
				Seg.setId(rs.getInt("id"));
				Seg.setNroCuenta(rs.getInt("nroCuenta"));
				Seg.setImportePedido(rs.getInt("importePedido"));
				Seg.setFecha(rs.getDate("fecha"));
				Seg.setEstado(rs.getString("Estado"));
				Seg.setCuotasRestantes(rs.getInt("cuotasRestantes"));
				
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
	
	public ArrayList<Prestamos> obtenerTodosLosPrestamosPorEstado(String estado)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{	 
			e.printStackTrace();
		}
		
		ArrayList<Prestamos> lista = new ArrayList<Prestamos>();
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("select id,nroCuenta,importeAPagar,importePedido,fecha,estado,cuotasRestantes,cuotasTotales from Prestamos where estado='"+estado+"'");
			
			while(rs.next()){
				
				Prestamos Seg = new Prestamos();
				Seg.setId(rs.getInt("id"));
				Seg.setNroCuenta(rs.getInt("nroCuenta"));
				Seg.setImporteAPagar(rs.getInt("importeAPagar"));
				Seg.setImportePedido(rs.getInt("importePedido"));
				Seg.setFecha(rs.getDate("fecha"));
				Seg.setEstado(rs.getString("Estado"));
				Seg.setCuotasRestantes(rs.getInt("cuotasRestantes"));
				Seg.setCuotasTotales(rs.getInt("cuotasTotales"));
				
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
	
	public int modificarEstadoAceptado(int id, String estado)
	{
		
		String query = "Update prestamos set Estado = '"+estado+"' where id="+id;
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
	
	public int crearTablaCuotas(Prestamos prestamo)
	{
		
		String query = "insert into cuotas(valorCuota,nroCuota) values (?,?)";
			int filas=0;
			Connection cn = null;
		
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn = DriverManager.getConnection(host+dbName, user,pass);
				
				   PreparedStatement preparedStmt = cn.prepareStatement(query);
				      preparedStmt.setInt  (1, (int) (prestamo.getImportePedido()/prestamo.getCuotasRestantes()));
				      preparedStmt.setInt (2, prestamo.getCuotasRestantes());				
				      preparedStmt.execute();	

				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return filas;
	}

	public void pagarPrestamo(int idPrestamo,int importeTotal, int cuotas) {
				
		String query = "Update prestamos set importeAPagar = importeAPagar-"+importeTotal+" where id="+idPrestamo;

		Connection cn = null;
					
		try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn = DriverManager.getConnection(host+dbName, user,pass);
					
				Statement st = cn.createStatement();
				st.executeUpdate(query);
				
				
				String query2 = "Update prestamos set cuotasRestantes = cuotasRestantes-"+cuotas+" where id="+idPrestamo;
				Statement st2 = cn.createStatement();
				st2.executeUpdate(query2);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}
	

	public int obtenerValorCuota(int idPrestamo, int cantidadCuotas) {
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{	 
			e.printStackTrace();
		}
		
		int importe = 0;
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			String query = "Select valorCuota from cuotas where id="+idPrestamo;
			ResultSet rs = st.executeQuery(query);
			rs.next();
			importe = (rs.getInt("valorCuota"));
			importe = importe*cantidadCuotas;
					
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
		
		}
		
		return importe;
	}

	public int obtenerCuotasRestantes(int idPrestamo) {
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{	 
			e.printStackTrace();
		}
		
		int cuotasRestantes = 0;
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			String query = "Select cuotasRestantes from prestamos where id="+idPrestamo;
			ResultSet rs = st.executeQuery(query);
			rs.next();
			cuotasRestantes = (rs.getInt("cuotasRestantes"));

					
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
		
		}
		
		return cuotasRestantes;
	
	}


}
