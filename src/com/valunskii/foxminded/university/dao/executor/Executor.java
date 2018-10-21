package com.valunskii.foxminded.university.dao.executor;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Executor {
    private static Logger log = Logger.getLogger(Executor.class);
    
    private Connection connection;

    public void execUpdate(String update) throws SQLException {
        log.info("Open connection");
        Connection connection = this.getConnection();
        Statement stmt = connection.createStatement();
        stmt.execute(update);
        stmt.close();
        connection.close();
        log.info("Connection closed");
    }

    public <T> T execQuery(String query, ResultHandler<T> handler) throws SQLException {
        log.info("Open connection");
        Connection connection = this.getConnection();
        Statement stmt = connection.createStatement();
        stmt.execute(query);
        ResultSet result = stmt.getResultSet();
        T value = handler.handle(result);
        result.close();
        stmt.close();
        connection.close();
        log.info("Connection closed");
        return value;
    }

    public Connection getConnection() {
        
        log.info("Get connection settings from db.properties");
        Properties props = readDbProperties();

        final String JDBC_DRIVER = props.getProperty("jdbc.driver");
        final String DB_URL = props.getProperty("jdbc.url");
        final String USER = props.getProperty("jdbc.username");
        final String PASS = props.getProperty("jdbc.password");

        try {
            DriverManager.registerDriver((Driver) Class.forName(JDBC_DRIVER).newInstance());            
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Properties readDbProperties() {
        Properties props = new Properties();
        FileInputStream in = null;
        try {
            log.info("Read properties file");
            in = new FileInputStream("src\\db.properties");
            props.load(in);
            return props;
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Cannot read file");
        } finally {
            try {
                in.close();
                log.info("File closed");
            } catch (IOException ignore) {
                log.error("Cannot close file");
            }
        }
        return props;
    }
}
