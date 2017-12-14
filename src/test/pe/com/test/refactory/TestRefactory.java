package pe.com.test.refactory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pe.com.develop.enums.ProcessEnum;
import pe.com.develop.enums.StateEnum;
import pe.com.develop.refactory.JobLoggerRefactory;

public class TestRefactory {

	@Test
	public void testSaveDataBase() 
	{
		JobLoggerRefactory jl = new JobLoggerRefactory();
		boolean response = jl.LogMessage("prueba de registro", ProcessEnum.DATABASE.getValue(), StateEnum.WARNING.getValue());
		assertEquals(Boolean.FALSE, response);
	}

	@Test
	public void testSaveFile()
	{
		JobLoggerRefactory jl = new JobLoggerRefactory();
		boolean response = jl.LogMessage("prueba de registro", ProcessEnum.FILE.getValue(), StateEnum.WARNING.getValue());
		assertEquals(Boolean.TRUE, response);

	}
}
