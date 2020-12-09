package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



import Models.Movimientos;

public class MovimientosDaoImpl {
	

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bd_tpintegrador";

	public void agregarMovimientoPagos(Movimientos movimiento) {
		String query = "Insert into movimientos(nroCuenta,tipoMovimiento,fecha,importe,Concepto) values (?,?,?,?,?)";
		Connection cn = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(host+dbName, user,pass);
			
			   PreparedStatement preparedStmt = cn.prepareStatement(query);
			      preparedStmt.setInt (1, movimiento.getNroCuenta());
			      preparedStmt.setInt (2, movimiento.getTipoMovimiento());
			      preparedStmt.setDate (3, (Date) movimiento.getFecha());		
			      preparedStmt.setInt (4, movimiento.getImporte());	
			      preparedStmt.setString (5, movimiento.getConcepto());	
			      preparedStmt.execute();				      
			      
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public ArrayList<Movimientos> obtenerMovimientos(int dni) 
	{ 
		try { Class.forName("com.mysql.cj.jdbc.Driver");
		}
	 catch (ClassNotFoundException e) {
		 e.printStackTrace();  
	 }
	ArrayList<Movimientos> lista = new ArrayList<Movimientos>(); 
	Connection conn = null;
	try { conn = DriverManager.getConnection(host + dbName, user, pass);
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery("select movimientos.nroCuenta,movimientos.fecha,movimientos.importe,movimientos.concepto from Movimientos inner join cuentas on movimientos.nroCuenta = cuentas.nroCuenta where cuentas.dniCliente="+dni);
	while(rs.next())
	{ 
		Movimientos Seg = new Movimientos();
		Seg.setId(rs.getInt("movimientos.nroCuenta"));
		Seg.setFecha(rs.getDate("movimientos.fecha"));
		Seg.setImporte(rs.getInt("movimientos.importe"));
		Seg.setConcepto(rs.getString("movimientos.concepto"));
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
}


