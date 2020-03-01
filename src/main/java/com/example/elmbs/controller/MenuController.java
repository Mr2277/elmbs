package com.example.elmbs.controller;

import com.example.elmbs.entity.Menu;
import com.example.elmbs.service.MenuService;
import com.example.elmbs.utils.SecProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统菜单(Menu)表控制层
 *
 * @author makejava
 * @since 2020-02-29 17:29:39
 */
@RestController
@RequestMapping("/api/menus")
public class MenuController {
    /**
     * 服务对象
     */
    @Resource
    private MenuService menuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Menu selectOne(Long id) {
        return this.menuService.queryById(id);
    }
    /**
     * 登录成功构建菜单
     *
     * @param
     * @return 菜单
     */
    @GetMapping(value = "/build")
    public ResponseEntity<Object> buildMenus(){
        System.out.println("build");
        /*
        Me user = userService.findByName(SecurityUtils.getUsername());
        List<MenuDto> menuDtoList = menuService.findByRoles(roleService.findByUsersId(user.getId()));
        List<MenuDto> menuDtos = (List<MenuDto>) menuService.buildTree(menuDtoList).get("content");
        return new ResponseEntity<>(menuService.buildMenus(menuDtos), HttpStatus.OK);
        */
        return ResponseEntity.ok("ok");
    }

}
