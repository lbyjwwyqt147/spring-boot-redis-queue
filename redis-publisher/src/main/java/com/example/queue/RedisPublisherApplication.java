package com.example.queue;

import com.example.queue.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class RedisPublisherApplication  implements CommandLineRunner {

    @Autowired
    private PublisherService publisherService;

    public static void main(String[] args) {
        SpringApplication.run(RedisPublisherApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        publisherService.pushMsg("止戈流");
    }
    /**
     * 计数器，用来控制线程
     * @return
     */
    @Bean
    public CountDownLatch latch(){
        return new CountDownLatch(1);//指定了计数的次数 1
    }

}
