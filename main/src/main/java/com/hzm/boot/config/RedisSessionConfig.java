package com.hzm.boot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@ConditionalOnProperty("redis.cache.clusterNodes")
@EnableRedisHttpSession
public class RedisSessionConfig {


}