package com.chryl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chryl.dto.User;

/**
 * Created by Chryl on 2019/10/15.
 */
public interface UserService extends IService<User> {

    void add(User user);

}
