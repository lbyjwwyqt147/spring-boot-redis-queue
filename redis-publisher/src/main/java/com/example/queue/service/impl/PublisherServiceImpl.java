package com.example.queue.service.impl;


import com.example.queue.config.Const;
import com.example.queue.config.RedisService;
import com.example.queue.service.PublisherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    private RedisService redisService;

    @Override
    public String pushMsg(String params) {
        log.info(" 又开始发布消息 .......... ");
        redisService.sendChannelMess(Const.CHANNEL,"我又开始发布消息了,你那边有没有收到呢?");
        return "success";
    }
}
