package com.valunskii.foxminded.university.repository.executor;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Executor {
    private static Logger log = Logger.getLogger(Executor.class);

    public void execUpdate(String update) throws SQLException {
        Connection connection = null;
        Statement stmt = null;
        log.trace("Get connection settings from db.properties");
        Properties props = readDbProperties();
        final String JDBC_DRIVER = props.getProperty("jdbc.driver");
        final String DB_URL = props.getProperty("jdbc.url");
        final String USER = props.getProperty("jdbc.username");
        final String PASS = props.getProperty("jdbc.password");
        try {
            DriverManager.registerDriver((Driver) Class.forName(JDBC_DRIVER).newInstance());
            log.info("Open connection");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = connection.createStatement();
            stmt.execute(update);
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
            connection.close();
            log.info("Connection closed");
        }
    }

    public <T> T execQuery(String query, ResultHandler<T> handler) throws SQLException {
        Connection connection = null;
        Statement stmt = null;
        ResultSet result = null;
        T value = null;
        log.trace("Get connection settings from db.properties");
        Properties props = readDbProperties();
        final String JDBC_DRIVER = props.getProperty("jdbc.driver");
        final String DB_URL = props.getProperty("jdbc.url");
        final String USER = props.getProperty("jdbc.username");
        final String PASS = props.getProperty("jdbc.password");
        try {
            DriverManager.registerDriver((Driver) Class.forName(JDBC_DRIVER).newInstance());
            log.info("Open connection");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = connection.createStatement();
            stmt.execute(query);
            result = stmt.getResultSet();
            value = handler.handle(result);
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            result.close();
            stmt.close();
            connection.close();
            log.info("Connection closed");
        }
        return value;
    }

    private Properties readDbProperties() {
        Properties props = new Properties();
        FileInputStream in = null;
        try {
            log.trace("Read properties file");
            in = new FileInputStream("src\\db.properties");
            props.load(in);
            return props;
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Cannot read file");
        } finally {
            try {
                in.close();
                log.trace("File closed");
            } catch (IOException ignore) {
                log.error("Cannot close file");
            }
        }
        return props;
    }
}
