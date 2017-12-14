package pe.com.test.refactory;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestRefactory {

	@Test
	public void test() {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userName", "alberto");
			map.put("password", "12345");
			//JobLoggerRefactory jl = new JobLoggerRefactory(true, true, true, true, true, true, map);
			//jl.LogMessage("abc", true, false, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(0, 0);
	}
}
