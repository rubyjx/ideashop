package com.ruby.ideashop.controller.user;

import com.ruby.ideashop.pojo.user.User;
import com.ruby.ideashop.service.user.UserService;
import com.ruby.ideashop.vo.user.UserSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author xinjin
 * 用户控制层
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    /**
     * 新增/更新用户
     */
    @RequestMapping(value = "/v1",method = RequestMethod.POST)
    public  String  addUser(UserSaveVo userSaveVo){
        User user=new User();
        user.setAge("10");
        user.setMobile("3424235432");
        user.setPassword("1243243");
        user.setRole("1");
        user.setSex("1");
        user.setUserName("zahgn");
       // request.setAttribute("aaa","bbb");
        return userService.addUser(user);
    }
    /**
     * 删除用户
     */
    @RequestMapping(value = "/v1",method = RequestMethod.DELETE)
    public String deleteUser(){
        return null;
    }
    /**
     * 查询用户详情
     */
    @ResponseBody
    @RequestMapping(value = "/v1/{id}",method = RequestMethod.GET)
    public String selectById(@PathVariable("id") String id){
        int id1 = Integer.parseInt(id);
        userService.findUserById(id1);
        return "11111111111";
    }
    /**
     * 查询用户列表
     */
    @RequestMapping(value = "/v1",method = RequestMethod.GET)
    public String selectByList(){
        List<User> list=userService.findAllUser();
        return "success";
    }

}
