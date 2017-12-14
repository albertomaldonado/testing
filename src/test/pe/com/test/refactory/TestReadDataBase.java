package pe.com.test.refactory;

import org.junit.Test;

import pe.com.develop.refactory.JobLoggerRefactory;

public class TestReadDataBase {
	private static JobLoggerRefactory refactory = new JobLoggerRefactory();

	@Test
	public void testGetInformationDataBase() 
	{
		refactory.getInformationDataBase();
	}
}
