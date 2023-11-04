package com.example.rpc_server.service.impl;

import cn.anti.rpc.annotation.RpcServer;
import com.example.rpc_server.domain.User;
import com.example.rpc_server.result.ApiResult;
import com.example.rpc_server.service.UserService;

import java.net.InetAddress;
import java.net.UnknownHostException;


@RpcServer
public class UserServiceImpl implements UserService {

    @Override
    public ApiResult<User> getUser(Long id) throws UnknownHostException {
        System.out.println("getUser: " + id + "当前地址：" + InetAddress.getLocalHost().getHostAddress());
        User user = new User();
        user.setId(id);
        user.setName("张三");
        user.setAge(18);
        user.setAddress("美国");
        return ApiResult.success(user);
    }
}
