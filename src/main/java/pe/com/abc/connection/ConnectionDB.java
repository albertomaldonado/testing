package pe.com.abc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;

import pe.com.abc.config.ReadPropertie;

public class ConnectionDB {

	private static Connection connection = null;

	public static Connection getConnection(Map dbParams) 
	{
		ReadPropertie read = ReadPropertie.getInstance();
		try 
		{
			if (connection == null) 
			{

				Properties connectionProps = new Properties();
				connectionProps.put("user", read.getValue("usuario"));
				connectionProps.put("password", read.getValue("clave"));
				
				connection = DriverManager.getConnection("jdbc:derby://localhost:1527/testDb", connectionProps);
			}
		} 
		catch (Exception e) 
		{
			e.getMessage();
		}
		return connection;

	}

}
