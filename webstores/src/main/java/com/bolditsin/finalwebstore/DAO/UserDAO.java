package com.bolditsin.finalwebstore.DAO;

import com.bolditsin.finalwebstore.entities.Product;
import com.bolditsin.finalwebstore.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private static int USER_COUNT;
    private List<User> users;
    {
        users= new ArrayList<>();
        users.add(new User(++USER_COUNT,"Tom","Qpldkdjs1"));
        users.add(new User(++USER_COUNT,"John","ASDdfsdfso"));
    }
    public List<User> index(){
        return users;
    }

    public User showUser(int id){
        return users.stream().filter(user -> user.getId()== id).findAny().orElse(null);
    }

    public void save(User user){
        user.setId(++USER_COUNT);
        users.add(user);
    }
}
