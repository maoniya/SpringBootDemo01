package net.maoni.SpringBoot.service;

import net.maoni.SpringBoot.domain.User;

import java.util.List;

public interface UserService {
    String login(String username,String pwd);

    List<User> listUser();
}
