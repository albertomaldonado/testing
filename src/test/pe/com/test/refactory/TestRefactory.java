package pe.com.test.refactory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pe.com.develop.enums.ProcessEnum;
import pe.com.develop.enums.StateEnum;
import pe.com.develop.refactory.JobLoggerRefactory;

public class TestRefactory {

	private static JobLoggerRefactory refactory = new JobLoggerRefactory();
	
	@Test
	public void testSaveDataBase() 
	{
		
		boolean response = refactory.LogMessage("prueba de insersion", ProcessEnum.DATABASE.getValue(), StateEnum.WARNING.getValue());
		assertEquals(Boolean.TRUE, response);
	}

	
	
	@Test
	public void testSaveFile()
	{
		boolean response = refactory.LogMessage("prueba de registro", ProcessEnum.FILE.getValue(), StateEnum.WARNING.getValue());
		assertEquals(Boolean.TRUE, response);

	}
	
}
