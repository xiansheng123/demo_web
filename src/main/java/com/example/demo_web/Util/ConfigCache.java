//package com.example.demo_web.Util;
//
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//@Configuration
//@EnableCaching
//public class ConfigCache {
//
//    private static final int DEFAULT_MAXSIZE = 1000;
//    private static final int DEFAULT_TTL = 3600;

    /**
     * 个性化配置缓存
     */
//    @Bean
//    public CacheManager cacheManager() {
//        SimpleCacheManager manager = new SimpleCacheManager();
//        //把各个cache注册到cacheManager中，GuavaCache实现了org.springframework.cache.Cache接口
//        ArrayList<GuavaCache> caches = new ArrayList<>();
//        for (Caches c : Caches.values()) {
//            caches.add(new GuavaCache(c.name(), CacheBuilder.newBuilder().recordStats().expireAfterWrite(c.getTtl(), TimeUnit.SECONDS).maximumSize(c.getMaxSize()).build()));
//        }
//        manager.setCaches(caches);
//        return manager;
//    }


//    @Bean
//    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
//        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
//        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource ("ehcache.xml"));
//        ehCacheManagerFactoryBean.setCacheManagerName("messageCache");
//        ehCacheManagerFactoryBean.setShared(true);
//        return ehCacheManagerFactoryBean;
//    }
//
//}
//

/**
 * 定义cache名称、超时时长秒、最大个数
 * 每个cache缺省3600秒过期，最大个数1000
 */
//public enum Caches {
//    user(60, 2),
//    info(5),
//    role;
//
//    private int maxSize = DEFAULT_MAXSIZE;    //最大數量
//    private int ttl = DEFAULT_TTL;        //过期时间（秒）
//
//    Caches() {
//    }
//
//    Caches(int ttl) {
//        this.ttl = ttl;
//    }
//
//    Caches(int ttl, int maxSize) {
//        this.ttl = ttl;
//        this.maxSize = maxSize;
//    }
//
//    public int getMaxSize() {
//        return maxSize;
//    }
//
//    public void setMaxSize(int maxSize) {
//        this.maxSize = maxSize;
//    }
//
//    public int getTtl() {
//        return ttl;
//    }
//
//    public void setTtl(int ttl) {
//        this.ttl = ttl;
//    }
//}

//    /**
//     * 配置全局缓存参数，3600秒过期，最大个数1000
//     */
//    @Bean
//    public CacheManager cacheManager() {
//        GuavaCacheManager cacheManager = new GuavaCacheManager();
//        cacheManager.setCacheBuilder(CacheBuilder.newBuilder().expireAfterWrite(3600, TimeUnit.SECONDS).maximumSize(1000));
//        return cacheManager;
//    }
