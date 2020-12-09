package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TransferenciasDaoImpl {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bd_tpintegrador";

	public int verificarCbu(int cbu)
	{
		String query = "Select cbu from cuentas where cbu="+cbu;

		Connection cn = null;
		int filas=0;		
		try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn = DriverManager.getConnection(host+dbName, user,pass);
				Statement st = cn.createStatement();				
				ResultSet rs = st.executeQuery(query);
				if(!rs.next())
				{
				filas = 0;
				}
				else
				{
				filas=rs.getInt("cbu");
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		return filas;
	}
	
	public void generarTransferencia(int cbu, int importe, int nroCuenta) {
		String query = "Update cuentas set saldo = saldo-"+importe+" where nroCuenta="+nroCuenta;

		Connection cn = null;
					
		try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn = DriverManager.getConnection(host+dbName, user,pass);
					
				Statement st = cn.createStatement();
				st.executeUpdate(query);
				
				
				String query2 = "Update cuentas set saldo = saldo+"+importe+" where cbu="+cbu;
				Statement st2 = cn.createStatement();
				st2.executeUpdate(query2);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		
	}

}
