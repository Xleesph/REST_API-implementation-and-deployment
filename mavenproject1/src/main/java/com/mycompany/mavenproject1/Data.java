package com.mycompany.mavenproject1;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Data {

    static final String databaseUrl = "jdbc:sqlite:C:\\Users\\Admin\\Desktop\\Matthaios\\dist.db";

    private static JdbcConnectionSource connectionSource;

    public static Dao<Post, Integer> postDao() {
        try {
            Class.forName("org.sqlite.JDBC");
            ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

            Dao<Post, Integer> postDao = DaoManager.createDao(connectionSource, Post.class);
            return postDao;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Dao<Friends, Integer> friendDao() {
        try {
            Class.forName("org.sqlite.JDBC");

            ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

            Dao<Friends, Integer> friendDao = DaoManager.createDao(connectionSource, Friends.class);
            return friendDao;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Dao<User, String> userDao() {
        try {
            Class.forName("org.sqlite.JDBC");

            ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

            Dao<User, String> userDao = DaoManager.createDao(connectionSource, User.class);
            return userDao;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void init() {
        try {
            Class.forName("org.sqlite.JDBC");

            connectionSource = new JdbcConnectionSource(databaseUrl);

            TableUtils.createTableIfNotExists(connectionSource, User.class);
            TableUtils.createTableIfNotExists(connectionSource, Post.class);
            TableUtils.createTableIfNotExists(connectionSource, Friends.class);

            connectionSource.close();
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(ApplicationConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
