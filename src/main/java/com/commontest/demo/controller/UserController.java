package com.commontest.demo.controller;
import com.commontest.demo.annotation.NoResponseAdvice;
import com.commontest.demo.entity.User;
import com.commontest.demo.enums.StatusAndMsg;
import com.commontest.demo.exception.ResponseException;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RequestMapping("/users")
@RestController
public class UserController {
    @GetMapping("/get")
    public List<User> getUserList(){
        List<User> userList =new ArrayList<>();
        userList.add(new User(1l,"messi",23));
        userList.add(new User(2l,"cristiano",23));
        System.out.println("dd");
        return userList;
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        throw new ResponseException(StatusAndMsg.METHODFAIL.getCode(),StatusAndMsg.METHODFAIL.getMsg());
    }
    @GetMapping("/getStr")
    @NoResponseAdvice
    public String paramTest() {
        return "str";

    }
    @GetMapping("/testVoid")
    @NoResponseAdvice
    public void testVoid()
    {
        System.out.println("test void");
    }
}