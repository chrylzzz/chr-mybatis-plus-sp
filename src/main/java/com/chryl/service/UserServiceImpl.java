package com.chryl.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chryl.dto.User;
import com.chryl.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chryl on 2019/10/15.
 */
@Service                              //第一个参数:集成BaseMapper的mapper接口,//第二个参数:mapper接口的实体类
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(User user) {
        baseMapper.insert(user);
    }
}
