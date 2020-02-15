package com.mycompany.mavenproject1;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.Where;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

@Path("/users")
public class UserOps {

    static final String databaseUrl = "jdbc:sqlite:C:\\Users\\Admin\\Desktop\\Matthaios";

    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("username") String username) {
        try {

            // instantiate the DAO to handle Account with String id
            Dao<User, String> userDao = Data.userDao();
            System.out.println(username);
            List<User> results
                    = userDao.queryBuilder().where().
                            eq("username", username).query();

            return Response.status(200).entity(results.get(0)).build();

        } catch (SQLException ex) {
            Logger.getLogger(UserOps.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.status(404).build();
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(User newUser) {

        try {
            Dao<User, String> userDao = Data.userDao();
            userDao.create(newUser);
            return Response.status(201).build();
        } catch (SQLException ex) {
            Logger.getLogger(UserOps.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.status(404).build();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(User newUser) {

        try {
            Dao<User, String> userDao = Data.userDao();
            userDao.update(newUser);
            return Response.status(201).build();
        } catch (SQLException ex) {
            Logger.getLogger(UserOps.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.status(404).build();
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(String credentials) {
        try {
            System.out.println(credentials);
            JSONObject jsonObj = new JSONObject(credentials);

            String username = jsonObj.getString("username");
            String password = jsonObj.getString("password");

            Dao<User, String> userDao = Data.userDao();

            QueryBuilder<User, String> queryBuilder
                    = userDao.queryBuilder();
            Where<User, String> where = queryBuilder.where();
            SelectArg selectArg = new SelectArg();

            where.eq("username", username);
            where.and();
            where.eq("password", password);

            PreparedQuery<User> preparedQuery = queryBuilder.prepare();

            List<User> accounts = userDao.query(preparedQuery);
            int x = accounts.size();

            if (x == 1) {
                return Response.status(200).build();
            } else {
                return Response.status(404).build();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserOps.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.status(404).build();
    }
}
