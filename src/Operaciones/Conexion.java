package Operaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    protected String usuario;
    protected String password;
    protected Connection cnn;

    public Conexion(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public Connection establecer_conexion() throws Exception{
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-469NVCC0:1433;database=BIBLIOTECAGESTBD;" +
                    "user=" +usuario+";password=" +password+";encryt=false");
            return cnn;
        }catch (SQLException e){
            throw new Exception("\nError NO se pudo realzar la conexion");
        }catch (ClassNotFoundException e){
            throw new Exception("\nError programador: "+e+
                    "\t->Error<- No se pudo realizar la carga del driver puente jdbc_Odbc");
        }
    }
}
