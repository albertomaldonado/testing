package pe.com.develop.enums;

public enum ProcessEnum 
{
	FILE(1), CONSOLE(2), DATABASE(3);

	private final int value;

	private ProcessEnum(int v) {
		value = v;
	}

	public int getValue() {
		return value;
	}
	
	
}
