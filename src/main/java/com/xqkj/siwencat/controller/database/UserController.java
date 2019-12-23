package com.xqkj.siwencat.controller.database;

import com.xqkj.siwencat.dao.database.UserMapper;
import com.xqkj.siwencat.models.database.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {


    @Resource
    private UserMapper userService;

    /**
     * 查询全部
     * @return
     */
    public Object selectAll(){
        return userService.selectAll();
    }

    /**
     * 查询单个
     * @param id
     * @return
     */
    public Object selectByPrimaryKey(@RequestParam(value = "id",defaultValue = "1")int id){
        return userService.selectByPrimaryKey(id);
    }


    /**
     * 添加数据
     * @return
     */
    public int insert (User user){
        return userService.insert(user);
    }


    /**
     * 删除
     * @return
     */
    public int remove(int id){
        return userService.deleteByPrimaryKey(id);
    }

    /**
     * 修改
     * @param user
     * @return
     */
    public int update(User user){
        return userService.updateByPrimaryKey(user);
    }


    /**
     * 查询用户
     * @param userName
     * @return
     */
    public User selectByUserName(String userName) {
        return userService.selectByUserName(userName);
    }
}
