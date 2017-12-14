package pe.com.develop.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

	private static Connection connection = null;
	private static ConnectionDB instanceDB;
	
	public static ConnectionDB getInstance()
	{
	    if(instanceDB == null)
	    {
	    	instanceDB = new ConnectionDB();
	    }
	    return instanceDB;
	}
	
	public Connection getConnection() 
	{
		ReadPropertie read = ReadPropertie.getInstance();
		try 
		{
			if (connection == null) 
			{
				connection = DriverManager.getConnection(Constantes.CONNECTION_H2, read.getValue(Constantes.CONNECTION_USER), read.getValue(Constantes.CONNECTION_PASSWORD));
			}
		} 
		catch (Exception e) 
		{
			e.getMessage();
		}
		return connection;

	}

}
