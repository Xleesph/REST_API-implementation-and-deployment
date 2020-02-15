package com.mycompany.mavenproject1;

import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/posts")
public class PostOps {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPost(@PathParam("id") String id) {
        try {
            System.out.println(id);
            Post post = Data.postDao().queryForId(Integer.parseInt(id));

            return Response.status(200).entity(post).build();
        } catch (SQLException ex) {
            Logger.getLogger(PostOps.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.status(404).build();
    }

    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(User u) {
        try {
            Dao<User, String> userDao = Data.userDao();
            userDao.create(u);

            return Response.status(201).build();

        } catch (SQLException ex) {
            Logger.getLogger(PostOps.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.status(404).build();
    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(User u) {
        try {
            Dao<User, String> userDao = Data.userDao();
            User u1 = userDao.queryForId(u.getUsername());
            if (u1.getUsername().equals(u.getUsername()) && u1.getPassword().equals(u.getPassword())) {
                return Response.status(200).build();
            } else {
                return Response.status(404).build();
            }

        } catch (SQLException ex) {
            Logger.getLogger(PostOps.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.status(404).build();
    }
}
