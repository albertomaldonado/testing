package pe.com.develop.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertie 
{
	private static ReadPropertie instance = null;
	private Properties properties;

	protected ReadPropertie() throws IOException {

		properties = new Properties();
		InputStream input = null;
		
		String filename = "config.properties";
		input = ReadPropertie.class.getClassLoader().getResourceAsStream(filename);
		properties.load(input);
	}

	public static ReadPropertie getInstance() 
	{
		if (instance == null) {
			try 
			{
				instance = new ReadPropertie();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return instance;
	}

	public String getValue(String key) 
	{
		return properties.getProperty(key);
	}

}
