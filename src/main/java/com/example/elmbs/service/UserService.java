package com.example.elmbs.service;

import com.example.elmbs.entity.User;
import java.util.List;

/**
 * 系统用户(User)表服务接口
 *
 * @author makejava
 * @since 2020-02-27 15:10:19
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 通过名字查询数据
     *
     * @param name
     * @return user 实例对象
     */
    User loadUserByUsername(String name);

}
