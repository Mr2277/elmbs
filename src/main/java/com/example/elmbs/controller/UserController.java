package com.example.elmbs.controller;

import com.example.elmbs.entity.User;
import com.example.elmbs.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 系统用户(User)表控制层
 *
 * @author makejava
 * @since 2020-02-27 15:10:21
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public User selectOne(Long id) {
        return this.userService.queryById(id);
    }
    @GetMapping("/test")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String test(){
        return "test";
    }

}
