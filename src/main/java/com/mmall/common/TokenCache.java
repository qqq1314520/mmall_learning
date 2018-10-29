package com.mmall.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 *  Token缓存
 *  TokenCache 是用来存放防止重复提交功能生成的 token的缓存。
 *  如果不设置则默认使用 session 来存放 token 值。
 *  但使用 session 会对集群带来影响（本项目不存在集群，是为了将来扩展做准备的），
 *  所以 可以让开发者来指定 cache 来存放 token（这里是localCache）。
 *  通常情况下可以使用一个统一的中心 cache 来做，例如 memcache、 redis。
 */
public class TokenCache {

    private static Logger logger = LoggerFactory.getLogger(TokenCache.class);

    //
    public static final String TOKEN_PREFIX = "token_";

    //声明一个静态的内存块，LRU算法(最小使用算法) 、guava的本地缓存
    //initialCapacity(1000):初始化内存块的大小为1000
    //maximumSize(10000)：内存块的最大为10000，当超过该值时，guava将使用LRU算法，来移除缓存项，即谁用的少移除谁
    //expireAfterAccess(12, TimeUnit.HOURS)：缓存的有效期为12小时
    private static LoadingCache<String,String> localCache = CacheBuilder.newBuilder().initialCapacity(1000).maximumSize(10000)
            .expireAfterAccess(12, TimeUnit.HOURS)
            .build(new CacheLoader<String, String>() {
                //默认的数据加载实现,当调用get取值的时候,如果key没有对应的值,就调用这个方法进行加载.
                @Override
                public String load(String s) throws Exception {
                    return "null";
                }
            });

    //不能少
    public static void setKey(String key,String value){
        localCache.put(key,value);
    }
    //不能少
    public static String getKey(String key){
        String value = null;
        try {
            value = localCache.get(key);
            if("null".equals(value)){
                return null;
            }
            return value;
        }catch (Exception e){
            logger.error("localCache get error",e);
        }
        return null;
    }
}
