package com.ruby.ideashop.service.user;

import com.ruby.ideashop.pojo.user.User;

import java.util.List;

public interface UserService {

    String addUser(User userSaveVo);

    List<User> findAllUser();

    void findUserById(int id1);
}
