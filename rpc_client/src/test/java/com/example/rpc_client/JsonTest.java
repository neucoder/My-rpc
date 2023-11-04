package com.example.rpc_client;

import com.alibaba.fastjson.JSON;
import com.example.rpc_server.domain.User;
import com.example.rpc_server.result.ApiResult;
import org.junit.jupiter.api.Test;

public class JsonTest {

    @Test
    public void testJson() {
        User user = new User();
        user.setId(12L);
        user.setName("李四");
        user.setAge(20);
        user.setAddress("北京市海淀区");
        System.out.println(JSON.toJSONString(user));
        System.out.println(JSON.toJSONString(ApiResult.success(user)));
        System.out.println("testJson");
    }
}
