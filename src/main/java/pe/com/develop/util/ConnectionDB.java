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
				connection = DriverManager.getConnection("jdbc:h2:file:./test", read.getValue("usuario"), read.getValue("clave"));
			}
		} 
		catch (Exception e) 
		{
			e.getMessage();
		}
		return connection;

	}

}
