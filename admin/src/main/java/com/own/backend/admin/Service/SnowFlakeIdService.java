package com.own.backend.admin.Service;

import com.own.backend.admin.Config.SnowFlake;
import org.springframework.stereotype.Service;

/**
 * @Author fangting
 * @create 2020/11/4 13:22
 * @description
 **/
@Service
public class SnowFlakeIdService {
    //web项目中的可以注入此类，则为单例的，分布式部署，不同服务器设置不同的workerId和datacenterId
    private SnowFlake worker = new SnowFlake(0,0);

    public Long nextId(){
        return worker.nextId();
    }
}
