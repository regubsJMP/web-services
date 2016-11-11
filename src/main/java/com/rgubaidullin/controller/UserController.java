package com.rgubaidullin.controller;

import com.rgubaidullin.model.User;
import com.rgubaidullin.service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

/**
 * Created by Renat Gubaidullin on 10/31/2016.
 */
@Path("/users")
public class UserController {

    UserService userService = new UserService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") int id) throws IOException {
        return userService.getUser(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void addUser(User user){
        userService.addUser(user);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void updateUser(User user){
        userService.updateUser(user);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("id") int id){
        userService.deleteUser(id);
    }
}
