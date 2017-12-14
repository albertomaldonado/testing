package pe.com.develop.util;

public final class Constantes {

  public static String CONNECTION_USER ="usuario";
  
  public static final String CONFIG_PROPERTIES = "config.properties";
  public static final String CONNECTION_H2 = "jdbc:h2:file:./test";
  public static String CONNECTION_PASSWORD = "clave";
  public static String FILE_NAME = "nombreArchivo";
  public static String SQL_INSERT = "INSERT INTO Log_Values (mensaje, estado) values (?, ?)";
  public static String SQL_SELECT = "select id, mensaje, estado from LOG_VALUES";
}
