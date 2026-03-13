package edu.co.unicauca.microformatos.DataAccessLayer.conection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * @brief Class for manage the connection to the database. This class is responsible for connecting and disconnecting from the database, as well as providing access to the connection object.
 * @author Juan David Vela Coronado
 */
public class DBConection {
    
    private Connection connection;

    public DBConection() {}    

    public void conectar() {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.
            getConnection("jdbc:h2:mem:testfacturasdb", "sa", "");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void desconectar() {
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
