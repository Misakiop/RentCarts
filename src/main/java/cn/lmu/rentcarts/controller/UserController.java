package cn.lmu.rentcarts.controller;

import cn.lmu.rentcarts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String loginIndex() {
        return "login";
    }

    @RequestMapping(value = {"/logouted"}, method = RequestMethod.GET)
    public String loginOut() {
        return "logouted";
    }

    @RequestMapping(value = {"/loginfail"}, method = RequestMethod.GET)
    public String loginFail() {
        return "loginfail";
    }

    @RequestMapping(value = {"/access_denied"}, method = RequestMethod.GET)
    public String accessdeny() {
        return "403";
    }







//    @Resource
//    UserService userService;
//
//    @RequestMapping(value = "findAll",method = RequestMethod.GET)
//    public JsonData findAll(){
//        List<User> users = userService.findAll();
//        if(users==null || users.isEmpty()){
//            return new JsonData(-1,"没有用户信息");
//        }else {
//            return new JsonData(0,users,"查询成功");
//        }
//    }
//
//    @RequestMapping(value = "findByname",method = RequestMethod.GET)
//    public JsonData SelectByName(String name){
//        User result=userService.selectByname(String.valueOf(name));
//        if(result!=null){
//            return new JsonData(0,result,"查询成功");
//        }else {
//            return new JsonData(-1,"没有用户信息");
//        }
//    }
}
