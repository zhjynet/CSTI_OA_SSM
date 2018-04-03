package com.util;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjingyu
 */
public class RedisUtils {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("localhost",6379);
        Map test = new HashMap(16);
        int i = 0;
        try{
            long start = System.currentTimeMillis();
            while (true){
                long end = System.currentTimeMillis();
                if(end-start>=1000){
                    break;
                }
                i++;
                jedis.set("test"+i,i+"redis");
            }

        }finally {
            jedis.close();
        }
        System.out.println("redis每秒操作："+i+"次");
    }
}
