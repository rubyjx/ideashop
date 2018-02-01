package com.ruby.ideashop.service.impl.user;

import com.ruby.ideashop.dao.user.UserMapper;
import com.ruby.ideashop.pojo.user.User;
import com.ruby.ideashop.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;
    @Resource
    private RedisTemplate redisTemplate;
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

    /**
     * find All User List
     * @return
     */
    @Override
    public List<User> findAllUser() {


        return null;
    }

    @Override
    public void findUserById(int id1) {
        //
        String key="user"+id1;

        //String key = "city_" + id;
        ValueOperations<String, User> operations = redisTemplate.opsForValue();

        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            User user = operations.get(key);

            LOGGER.info("CityServiceImpl.findCityById() : 从缓存中获取了城市 >> " + user.toString());

        }

        // 从 DB 中获取城市信息
        User user = userMapper.selectByPrimaryKey(id1);

        // 插入缓存
        operations.set(key, user, 10, TimeUnit.SECONDS);
        LOGGER.info("CityServiceImpl.findCityById() : 城市插入缓存 >> " + user.toString());


    }
}
