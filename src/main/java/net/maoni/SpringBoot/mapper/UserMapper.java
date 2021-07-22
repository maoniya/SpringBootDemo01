package net.maoni.SpringBoot.mapper;

import net.maoni.SpringBoot.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserMapper {
    private static Map<String, User> userMap = new HashMap<>();
    static{
        userMap.put("maoni",new User(1,"maoni","123"));
        userMap.put("shuaihsuai",new User(2,"shuaihsuai","12345"));
        userMap.put("xx",new User(3,"xx","123456"));
    }

    public User login(String username,String pwd){
        User user = userMap.get(username);
        if(user ==null){
            return  null;
        }
        if (user.getPwd().equals(pwd)){
            return user;
        }
        return null;
    }


    public List<User> listUser(){
        List<User> list =new ArrayList<>();
        list.addAll(userMap.values());
        return list;

    }

}
