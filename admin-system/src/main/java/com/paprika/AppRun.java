package com.paprika;

import com.paprika.utils.SpringContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

/**
 * @author adam
 * @date 2019/5/13
 * PS: You may say that I'm a dreamer.But I'm not the only one.
 */

@SpringBootApplication
@EnableTransactionManagement
@EnableWebSocketMessageBroker
public class AppRun {
    public static void main(String[] args) {
        SpringApplication.run(AppRun.class, args);
    }

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }
}
