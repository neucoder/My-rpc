package com.example.rpc_server.service;

import com.example.rpc_server.domain.User;
import com.example.rpc_server.result.ApiResult;

import java.net.UnknownHostException;

public interface UserService {
    ApiResult<User> getUser(Long id) throws UnknownHostException;
}
