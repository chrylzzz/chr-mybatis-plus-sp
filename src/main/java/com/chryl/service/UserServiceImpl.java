package com.chryl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chryl.dto.User;
import com.chryl.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    public User selectByid(String id) {
        return baseMapper.selectById(id);
    }

    public List<User> selectList() {
        return baseMapper.selectList(null);
    }

    public List<Map<String, Object>> selectMaps() {
        return baseMapper.selectMaps(null);
    }

    public void update(User user) {
        baseMapper.updateById(user);
    }

    public IPage<Map<String, Object>> selectPage(long curr, long limit) {
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.like("user_name", "a")//like 条件  在Compare类中设置
//                .eq("user_name", "nac")
                .between("user_date", "2019-10-07", "2019-11-07")
//                .lt("age", 40);
        ;

        Page<User> page = new Page<>(curr, limit);
        //po
        //IPage<User> userIPage = userMapper.selectPage(page, wrapper);
        //map
        IPage<Map<String, Object>> mapIPage = baseMapper.selectMapsPage(page, wrapper);
        return mapIPage;
    }

}
