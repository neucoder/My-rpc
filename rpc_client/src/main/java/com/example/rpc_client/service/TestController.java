package com.example.rpc_client.service;

import cn.anti.rpc.annotation.RpcClient;
import com.example.rpc_server.domain.User;
import com.example.rpc_server.result.ApiResult;
import com.example.rpc_server.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;

@RestController
@RequestMapping("test")
public class TestController {

    @RpcClient
    private UserService userService;

    @GetMapping("/user")
    public ApiResult<User> getUser(@RequestParam("id")Long id) throws UnknownHostException {
        System.out.println("getUser: " + id);
        ApiResult<User> user = userService.getUser(id);
        System.out.println("response user: " + user);
        return user;
    }

    @GetMapping("/user2")
    public ApiResult<User> getUser2(@RequestParam("id")Long id) throws UnknownHostException {
        System.out.println("getUser2: " + id);
        User user = new User();
        user.setId(id);
        user.setName("李四");
        user.setAge(20);
        user.setAddress("北京市海淀区");
        System.out.println("response user: " + user);
        return ApiResult.success(user);
    }
}
