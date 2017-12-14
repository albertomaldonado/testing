package pe.com.develop.refactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import pe.com.develop.enums.ProcessEnum;
import pe.com.develop.enums.StateEnum;
import pe.com.develop.util.ConnectionDB;
import pe.com.develop.util.ReadPropertie;

public class JobLoggerRefactory 
{

	private static Logger logger;
	

	public boolean LogMessage(String messageText, int process, int state) 
	{
		boolean response = false;
		try 
		{
			int indicator = getStateMessage(state);
			
			if (ProcessEnum.FILE.getValue()==process) 
			{
				response = insertFile(messageText, indicator);			
			}
	
			if (ProcessEnum.DATABASE.getValue()==process)
			{
				response = insertDataBase(messageText, indicator);
			}
		}
		catch(Exception e) 
		{
			
		}
		return response;
	}
	
	/**
	 * Insert in file
	 * */
	public boolean insertFile(String message, int t) throws IOException
	{
		boolean response = false;
		ReadPropertie read = ReadPropertie.getInstance();
		String fileName = read.getValue("nombreArchivo");
		File file = new File(fileName);
		if(file.exists())
		{
			response = writeFile(message, fileName, t);
		}
		else
		{
			try (BufferedWriter buffer = new BufferedWriter(new FileWriter(fileName)))
			{
				response = writeFile(message, fileName, t);
			} 
		}
		return response;
	}
	
	private boolean writeFile(String message, String fileName, int i)
	{
		boolean response = true;
		try(BufferedWriter buffer = new BufferedWriter(new FileWriter(fileName, true)))
		{
			buffer.write(message + " "+String.valueOf(i)+"\n");
		}
		catch(IOException e)
		{
			response = false;
		}
		return response;
	}
	
	/**
	 * Insert in database
	 * */
	private boolean insertDataBase(String message, int t) throws SQLException
	{
		boolean response = false;
		try(Connection connection = ConnectionDB.getConnection()) 
		{
			PreparedStatement stmt = null;
			
			stmt = connection.prepareStatement("INSERT INTO Log_Values values (?, ?)");
			stmt.setString(1, message);
			stmt.setString(2, String.valueOf(t));
			stmt.executeUpdate();
			response = true;
		}
		return response;
	}
	
	private static int getStateMessage(int state)
	{
		int response = 0;
		if(StateEnum.ERROR.getValue()==state)
		{
			response = StateEnum.ERROR.getValue();
		}
		else if(StateEnum.MESSAGE.getValue()==state)
		{
			response = StateEnum.MESSAGE.getValue();
		}
		else if(StateEnum.WARNING.getValue()==state)
		{
			response = StateEnum.WARNING.getValue();
		}
		return response;
	}
	
}
