package pe.com.develop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionDB {

	private static Connection connection = null;

	public static Connection getConnection() 
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
