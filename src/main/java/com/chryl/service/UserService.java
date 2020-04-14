package com.chryl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chryl.dto.User;

/**
 * 接口service也需要继承接口类,泛型为PoJo
 * 接口service也需要继承接口类,泛型为PoJo
 * <p>
 * Created by Chryl on 2019/10/15.
 */
public interface UserService extends IService<User> {

    void add(User user);

}
