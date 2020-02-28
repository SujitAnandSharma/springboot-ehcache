package com.quppler.config;

import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;

@Configuration
@EnableCaching
public class APIConfig extends CachingConfigurerSupport {

    @Bean
    public net.sf.ehcache.CacheManager ehCacheManager() {
        CacheConfiguration thirtySecondCache = new CacheConfiguration();
        thirtySecondCache.setName("thirtySecondCache");
        thirtySecondCache.setMemoryStoreEvictionPolicy("LRU");
        thirtySecondCache.setMaxEntriesLocalHeap(1000);
        thirtySecondCache.setTimeToLiveSeconds(30);

        CacheConfiguration twentySecondCache = new CacheConfiguration();
        twentySecondCache.setName("twentySecondCache");
        twentySecondCache.setMemoryStoreEvictionPolicy("LRU");
        twentySecondCache.setMaxEntriesLocalHeap(1000);
        twentySecondCache.setTimeToLiveSeconds(20);

        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
        config.addCache(twentySecondCache);
        config.addCache(thirtySecondCache);

        return net.sf.ehcache.CacheManager.newInstance(config);
    }

    @Bean
    @Override
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheManager());
    }


}
