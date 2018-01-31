package com.ruby.ideashop.user.service.impl;

import com.ruby.ideashop.user.dao.UserMapper;
import com.ruby.ideashop.user.pojo.User;
import com.ruby.ideashop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{
    @Autowired
    public UserMapper userMapper;
    /*
       增加用户
     */
    @Override
    public String addUser(User user) {
         int i = userMapper.insertSelective(user);
         if(i==0){
             return "error";
         }
        return "user_save";
    }
}
