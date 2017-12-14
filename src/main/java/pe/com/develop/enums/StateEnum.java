package pe.com.develop.enums;

public enum StateEnum 
{
	 MESSAGE(1), ERROR(2), WARNING(3);
	
	private final int value;
	
	private StateEnum(int v) {
		value = v;
	}
	
	public int getValue()
	{
		return value;
	}
}
