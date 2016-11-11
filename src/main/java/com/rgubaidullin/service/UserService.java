package com.rgubaidullin.service;


import com.rgubaidullin.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Renat Gubaidullin on 10/31/2016.
 */
public class UserService {
    private static Map<Integer, User> users = new HashMap<Integer, User>(){{
        put(1, new User(1, "Renat", "Gubaidullin", "rgubaidullin@gmail.com"));
        put(2, new User(2, "Dimitri", "Stoyanov", "dimitri.stoyanov@gmail.com"));
        put(3, new User(3, "John", "Brennan", "john.brennan@gmail.com"));
        put(4, new User(4, "Omid", "Touhuri", "omid.touhuri@gmail.com"));
    }};

    public static Integer getNewId(){
       return users.entrySet().stream().max((entry1, entry2) -> entry1.getKey() > entry2.getKey() ? 1 : -1).get().getKey() + 1;
    }

    public void printMap(){
        users.forEach((id, user) -> System.out.println(id + "|" + user.getFirstName() + "|" + user.getLastName() + "|" + user.getEmail()));
    }

    public List<User> getUsers(){
        return users.entrySet().stream()
                .map(value -> value.getValue())
                .collect(Collectors.toList());
    }

    public User getUser(Integer id){
        return users.get(id);
    }

    public void addUser(User user){
        Integer id = getNewId();
        users.put(id, new User(id, user.getFirstName(), user.getLastName(), user.getEmail()));
    }

    public void updateUser(User user){
        Integer id = user.getId();
        if(id != null){
            users.put(id, user);
        }else{
            System.out.println("User ID is null");
        }
    }

    public void deleteUser(Integer id){
        if(id != null){
            users.remove(id);
        }else{
            System.out.println("User ID is null");
        }
    }
}
