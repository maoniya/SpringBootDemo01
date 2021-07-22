package net.maoni.SpringBoot.controller;

import net.maoni.SpringBoot.domain.User;
import net.maoni.SpringBoot.service.UserService;
import net.maoni.SpringBoot.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/pub/user")
public class UserController {
    @Autowired
    private UserService userService;
//    @PostMapping("login")
//    public JsonData login(String username,String pwd){
//        System.out.println("username:"+username+" pwd:"+pwd);
//        return JsonData.buildSuccess("");
//    }

    /**
     * 登录接口
     * @param user
     * @return
     */
    @PostMapping("login")
    public JsonData login(@RequestBody User user){
        System.out.println("username:"+user.toString());
        String token=userService.login(user.getUsername(),user.getPwd());
        return token !=null ? JsonData.buildSuccess(token):JsonData.buildError("账号密码错误");
    }

    /**
     * 列出全部用户
     * @return
     */
    @GetMapping("list")
    public JsonData listUser(){
        return JsonData.buildSuccess(userService.listUser());
    }
}
