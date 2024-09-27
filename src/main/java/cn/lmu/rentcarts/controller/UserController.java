package cn.lmu.rentcarts.controller;

import cn.lmu.rentcarts.pojo.JsonData;
import cn.lmu.rentcarts.pojo.User;
import cn.lmu.rentcarts.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/RentCarts")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping(value = "findAll",method = RequestMethod.GET)
    public JsonData findAll(){
        List<User> users = userService.findAll();
        if(users==null || users.isEmpty()){
            return new JsonData(-1,"没有用户信息");
        }else {
            return new JsonData(0,users,"查询成功");
        }
    }

    @RequestMapping(value = "findByname",method = RequestMethod.GET)
    public JsonData SelectByName(String name){
        User result=userService.selectByname(String.valueOf(name));
        if(result!=null){
            return new JsonData(0,result,"查询成功");
        }else {
            return new JsonData(-1,"没有用户信息");
        }
    }
}
