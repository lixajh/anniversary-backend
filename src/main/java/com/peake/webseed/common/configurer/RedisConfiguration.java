package com.peake.webseed.common.configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis配置
 *
 * @create 2018-04-24 下午9:38
 **/
@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {
//    @Value("${redis.host}")
//    private String host;
//    @Value("${redis.port}")
//    private Integer port;
//    @Value("${redis.timeout}")
//    private Integer timeout;
//    @Value("${redis.maxTotal}")
//    private Integer maxTotal;
//    @Value("${redis.maxIdle}")
//    private Integer maxIdle;
//    @Value("${redis.maxWaitMillis}")
//    private Long maxWaitMillis;
//    @Value("${redis.testOnBorrow}")
//    private Boolean testOnBorrow;
//    @Value("${redis.database}")
//    private Integer database;


    /**
     * 注入 RedisConnectionFactory
     */
    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    /**
     * 缓存管理器.
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
        CacheManager cacheManager = new RedisCacheManager(redisTemplate);
        return cacheManager;
    }


    /**
     * 配置redisTemplate
     * <p>
     * 通过redisConnectionFactory引入redis在配置文件中的连接配置
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        initDomainRedisTemplate(redisTemplate, redisConnectionFactory);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        JedisPoolConfig jedisPoolConfig = getJedisPoolConfig();
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
////        jedisConnectionFactory.setHostName(host);
////        jedisConnectionFactory.setPort(port);
////        jedisConnectionFactory.setDatabase(database);
//        jedisConnectionFactory.setUsePool(true);
//        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
//        return jedisConnectionFactory;
//    }

//    private JedisPoolConfig getJedisPoolConfig() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        //控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
//        //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
////        jedisPoolConfig.setMaxTotal(maxTotal);
////        //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
////        jedisPoolConfig.setMaxIdle(maxIdle);
////        //表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
////        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
////        //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
////        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
//        return jedisPoolConfig;
//    }

    /**
     * 设置数据存入 redis 的序列化方式
     * 配置中一般需要配置redisTemplate的序列化方式,因为Spring redis的默认序列化方式是JDK序列化，所以缓存对象一般都要实现java.io.Serializable接口，不然在使用时会报错，
     * 而且在redis中读取内容时，除了属性信息外还会有很多其他信息，可读性较差。我这里使用的是GenericJackson2JsonRedisSerializer接口，
     * 相比Jackson2JsonRedisSerializer接口多了@class属性，类的全路径包名，方便反系列化。
     *
     * @param redisTemplate
     * @param factory
     */
    private void initDomainRedisTemplate(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory factory) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(factory);
    }


}
