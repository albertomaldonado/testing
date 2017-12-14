package pe.com.test.refactory;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Test;

import pe.com.develop.enums.ProcessEnum;
import pe.com.develop.enums.StateEnum;
import pe.com.develop.refactory.JobLoggerRefactory;

public class TestRefactory {

	private static JobLoggerRefactory refactory = new JobLoggerRefactory();
	
	@Test
	public void testSaveDataBase() 
	{
		String message = "message " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " prueba";
		boolean response = refactory.LogMessage(message, ProcessEnum.DATABASE.getValue(), StateEnum.WARNING.getValue());
		assertEquals(Boolean.TRUE, response);
	}
	
	@Test
	public void testConsoleFile()
	{
		String message = "message " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " prueba";
		boolean response = refactory.LogMessage(message, ProcessEnum.CONSOLE.getValue(), StateEnum.WARNING.getValue());
		assertEquals(Boolean.TRUE, response);

	}
	
	@Test
	public void testSaveFile()
	{
		String message = "message " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " prueba";
		boolean response = refactory.LogMessage(message, ProcessEnum.FILE.getValue(), StateEnum.WARNING.getValue());
		assertEquals(Boolean.TRUE, response);

	}
	
}
